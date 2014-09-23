/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import static flashablezipcreator.AFZC.Protocols.p;
import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.DiskOperations.ReadZip;
import flashablezipcreator.Operations.TreeOperations;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Import {

    static ReadZip rz;
    static TreeOperations to;
    static String exisingUpdaterScript = "";
    static ArrayList<String> repeatList = null;
    static String fileName = "";
    static int zipType;

    public static void fromZip(String path, ProjectItemNode rootNode, int type, DefaultTreeModel model) throws IOException, ParserConfigurationException, TransformerException, SAXException {
        repeatList = new ArrayList<>();//this will handle files with same name but different location.
        zipType = Identify.scanZip(path);//this will automatically detect zip type.
        
        boolean containsDeleteXml = false;
        boolean containsCustomXml = false;
        boolean containsDataXml = false;
        
        Xml.initialize();
        
        rz = new ReadZip(path);
        to = new TreeOperations(rootNode);
        
        for (Enumeration<? extends ZipEntry> e = rz.zf.entries(); e.hasMoreElements();) {
            
            ZipEntry ze = e.nextElement();
            String name = ze.getName();
            InputStream in = rz.zf.getInputStream(ze);
            
            if (name.endsWith("/")) {
                continue;
            } else if (Project.getTempFilesList().contains(name)) {
                continue;
            }
            
            p("\ncurrent file " + name + "\n");
            
            String filePath = name;
            String projectName = Identify.getProjectName(name);
            int projectType = zipType;//this has to be same as zip type.
            String groupName = Identify.getGroupName(filePath);
            int groupType = Identify.getGroupType(filePath);
            boolean hasSubGroup = Identify.hasSubGroup(filePath);
            String subGroupName = Identify.getSubGroupName(groupName, filePath);
            int subGroupType = groupType; //Groups that have subGroups have same type.
            String fileName = (new File(filePath)).getName();
            FileNode file = null;

            if (hasSubGroup) {
                file = addFileToTree(fileName, subGroupName, subGroupType, groupName, groupType, projectName, projectType, rootNode, model);
                if (subGroupType == SubGroupNode.TYPE_CUSTOM) {
                    Xml.addFileDataToSubGroup(file);
                }
            } else {
                if (projectType == ProjectNode.PROJECT_ROM || projectType == ProjectNode.PROJECT_GAPPS) {
                    if (filePath.contains("META-INF/com/google/android/update-binary")) {
                        if (to.getProjectNode(projectName, projectType) == null) {
                            to.addChildTo(rootNode, projectName, projectType, model);
                        }
                        to.getProjectNode(projectName, projectType).update_binary = rz.getBytesFromFile(in);
                        continue;
                    } else if (filePath.contains("META-INF/com/google/android/updater-binary-installer")) {
                        if (to.getProjectNode(projectName, projectType) == null) {
                            to.addChildTo(rootNode, projectName, projectType, model);
                        }
                        to.getProjectNode(projectName, projectType).update_binary_installer = rz.getBytesFromFile(in);
                        continue;
                    } else if (filePath.contains("META-INF/com/google/android/updater-script")) {
                        if (to.getProjectNode(projectName, projectType) == null) {
                            to.addChildTo(rootNode, projectName, projectType, model);
                        }
                        to.getProjectNode(projectName, projectType).updater_script += rz.getStringFromFile(in);
                        continue;
                    } else if (filePath.contains("META-INF/com/google/android/aroma")) {
                        continue;
                    }
                } else if (projectType == ProjectNode.PROJECT_AROMA || projectType == ProjectNode.PROJECT_NORMAL) {
                    if (filePath.startsWith("META-INF")) {
                        continue;
                    }
                }
                if (name.equals(Xml.custom_path)) {
                    Xml.originalData = rz.getStringFromFile(in);
                    containsCustomXml = true;
                    continue;
                } else if (name.equals(Xml.delete_path)) {
                    Xml.deleteData = rz.getStringFromFile(in);
                    containsDeleteXml = true;
                    continue;
                } else if (name.equals(Xml.data_path)) {
                    Xml.fileData = rz.getStringFromFile(in);
                    containsDataXml = true;
                    continue;
                }
                file = addFileToTree(fileName, groupName, groupType, projectName, projectType, rootNode, model);
                if (groupType == GroupNode.GROUP_OTHER) {
                    file.fileZipPath = filePath;
                } else if (groupType == GroupNode.GROUP_CUSTOM) {
                    Xml.addFileDataToGroup(file);
                }
            }
            file.fileSourcePath = file.fileDestPath;
            rz.writeFileFromZip(in, file.fileSourcePath);
        }
        
        Xml.terminate();
        
        if (containsCustomXml) {
            Xml.parseXml(GroupNode.GROUP_CUSTOM, rootNode, model);//this sets values of custom group/subGroup
        }
        if (containsDeleteXml) {
            Xml.parseXml(GroupNode.GROUP_DELETE_FILES, rootNode, model);//this creates new file objects of delete group
        }
        if (containsDataXml) {
            Xml.parseXml(0, rootNode, model);
        }
        JOptionPane.showMessageDialog(null, "Successfully Imported");
    }

    public static FileNode addFileToTree(String fileName, String subGroupName, int subGroupType, String groupName, int groupType, String projectName, int projectType,
            ProjectItemNode rootNode, DefaultTreeModel model) {
        if (to.getProjectNode(projectName, projectType) == null) {
            to.addChildTo(rootNode, projectName, projectType, model);
            System.out.println("Added project " + projectName + " project type " + projectType);
        }
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
        }
        if (to.getSubGroupNode(subGroupName, groupType, groupName, projectName) == null) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), subGroupName, subGroupType, model);
        }
        if (subGroupType == SubGroupNode.TYPE_CUSTOM) {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
        return to.getFileNode(fileName, subGroupName, groupName, projectName);
    }

    public static FileNode addFileToTree(String fileName, String groupName, int groupType, String projectName, int projectType, ProjectItemNode rootNode, DefaultTreeModel model) {
        if (to.getProjectNode(projectName, projectType) == null) {
            to.addChildTo(rootNode, projectName, projectType, model);
            System.out.println("Added project " + projectName + " project type " + projectType);
        }
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
        }
        if (to.getFileNode(fileName, groupName, projectName) != null) {
            if (groupType == GroupNode.GROUP_OTHER) {
                fileName += "_1";
                fileName = getUniqueName(fileName);
            }
        }
        if (groupType == GroupNode.GROUP_CUSTOM) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
        return to.getFileNode(fileName, groupName, projectName);
    }

    /*files with same name and located at multiple places are unique inspite of having same name.
     this is to prevent them from skipping.*/
    public static String getUniqueName(String fileName) {
        if (repeatList.contains(fileName)) {
            fileName += "_1";
            return getUniqueName(fileName);
        } else {
            repeatList.add(fileName);
            return fileName;
        }
    }
}
