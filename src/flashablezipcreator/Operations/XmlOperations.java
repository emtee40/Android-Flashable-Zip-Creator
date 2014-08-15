/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class XmlOperations {

    DocumentBuilderFactory documentFactory;
    DocumentBuilder documentBuilder;
    static Document document = null;
    public Element root;
    public Element rootGroup;
    public Element rootSubGroup;

    public void createXML() throws ParserConfigurationException {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        root = document.createElement("Root");
        document.appendChild(root);
        rootGroup = document.createElement("GroupData");
        addGroupNode(root, rootGroup);
        rootSubGroup = document.createElement("SubGroupData");
        addSubGroupNode(root, rootSubGroup);
    }

    public void addGroupNode(Element root, Element group) {
        root.appendChild(group);
    }

    public void addSubGroupNode(Element root, Element subGroup) {
        root.appendChild(subGroup);
    }

    public void addFileNode(FileNode fileNode, Element parent) {
        Element file = document.createElement("FileData");
        parent.appendChild(file);
        Attr attribute = document.createAttribute("name");
        attribute.setValue(fileNode.title);
        file.setAttributeNode(attribute);
        document.getDocumentElement().normalize();
        switch (fileNode.parent.type) {
            case ProjectItemNode.NODE_GROUP:
                addChildNode("ProjectName", fileNode.parent.parent.title, file);
                addChildNode("ProjectType", ((ProjectNode) fileNode.parent.parent).projectType + "", file);
                addChildNode("GroupName", fileNode.parent.title, file);
                addChildNode("GroupType", ((GroupNode) fileNode.parent).groupType + "", file);
                addChildNode("InstallLocation", fileNode.installLocation, file);
                addChildNode("Permissions", fileNode.filePermission, file);
                addChildNode("ZipPath", fileNode.fileZipPath, file);
                break;
            case ProjectItemNode.NODE_SUBGROUP:
                addChildNode("ProjectName", fileNode.parent.parent.parent.title, file);
                addChildNode("ProjectType", ((ProjectNode) fileNode.parent.parent.parent).projectType + "", file);
                addChildNode("GroupName", fileNode.parent.parent.title, file);
                addChildNode("GroupType", ((GroupNode) fileNode.parent.parent).groupType + "", file);
                addChildNode("SubGroupName", fileNode.parent.title, file);
                addChildNode("SubGroupType", ((SubGroupNode) fileNode.parent).subGroupType + "", file);
                addChildNode("InstallLocation", fileNode.installLocation, file);
                addChildNode("Permissions", fileNode.filePermission, file);
                addChildNode("ZipPath", fileNode.fileZipPath, file);
                break;
        }
    }

    public void addChildNode(String childName, String childValue, Element parent) {
        Element child = document.createElement(childName);
        child.appendChild(document.createTextNode(childValue));
        parent.appendChild(child);
    }

    public String getXML() throws TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.getBuffer().toString();
    }

    public void writeXML(String path) throws TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(document), new StreamResult(new File(path)));
        JOptionPane.showMessageDialog(null, "File saved to specified path");
    }

    public void parseGeneratedXML(ProjectItemNode rootNode, String generated, String original) throws ParserConfigurationException, SAXException, IOException {
        TreeOperations to = new TreeOperations(rootNode);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document genDoc = dBuilder.parse(new InputSource(new StringReader(generated)));
        NodeList fileList = genDoc.getElementsByTagName("FileData");
        for (int j = 0; j < fileList.getLength(); j++) {
            Node fileNode = fileList.item(j);
            if (fileNode.getParentNode().getNodeName().equals("GroupData")) {
                if (fileNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) fileNode;
                    FileNode file = to.getFileNode(element.getAttribute("name"),
                            element.getElementsByTagName("GroupName").item(0).getTextContent(),
                            element.getElementsByTagName("ProjectName").item(0).getTextContent());
                    parseOriginalXML(file, original);
                }
            } else if (fileNode.getParentNode().getNodeName().equals("SubGroupData")) {
                if (fileNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) fileNode;
                    FileNode file = to.getFileNode(element.getAttribute("name"),
                            element.getElementsByTagName("SubGroupName").item(0).getTextContent(),
                            element.getElementsByTagName("GroupName").item(0).getTextContent(),
                            element.getElementsByTagName("ProjectName").item(0).getTextContent());
                    parseOriginalXML(file, original);
                }
            }
        }
    }

    public void parseOriginalXML(FileNode file, String original) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new StringReader(original)));
        NodeList fileList = doc.getElementsByTagName("FileData");
        for (int j = 0; j < fileList.getLength(); j++) {
            Node fileNode = fileList.item(j);
            if (file.title.equals(((Element) fileNode).getAttribute("name"))) {
                setFileValues(file, (Element) fileNode);
            }
        }
    }

    public void setFileValues(FileNode file, Element fileNode) {
        switch (file.parent.type) {
            case ProjectItemNode.NODE_GROUP:
                if (fileNode.getParentNode().getNodeName().equals("GroupData")
                        && fileNode.getElementsByTagName("GroupName").item(0).getTextContent().equals(file.parent.title)
                        && fileNode.getElementsByTagName("GroupType").item(0).getTextContent().equals(((GroupNode) file.parent).groupType + "")
                        && fileNode.getElementsByTagName("ProjectName").item(0).getTextContent().equals(file.parent.parent.title)
                        && fileNode.getElementsByTagName("ProjectType").item(0).getTextContent().equals(((ProjectNode) file.parent.parent).projectType + "")) {
                    file.installLocation = fileNode.getElementsByTagName("InstallLocation").item(0).getTextContent();
                    file.filePermission = fileNode.getElementsByTagName("Permissions").item(0).getTextContent();
                }
                break;
            case ProjectItemNode.NODE_SUBGROUP:
                if (fileNode.getParentNode().getNodeName().equals("SubGroupData")
                        && fileNode.getElementsByTagName("SubGroupName").item(0).getTextContent().equals(file.parent.title)
                        && fileNode.getElementsByTagName("SubGroupType").item(0).getTextContent().equals(((SubGroupNode) file.parent).subGroupType + "")
                        && fileNode.getElementsByTagName("GroupName").item(0).getTextContent().equals(file.parent.parent.title)
                        && fileNode.getElementsByTagName("GroupType").item(0).getTextContent().equals(((GroupNode) file.parent.parent).groupType + "")
                        && fileNode.getElementsByTagName("ProjectName").item(0).getTextContent().equals(file.parent.parent.parent.title)
                        && fileNode.getElementsByTagName("ProjectType").item(0).getTextContent().equals(((ProjectNode) file.parent.parent.parent).projectType + "")) {
                    file.installLocation = fileNode.getElementsByTagName("InstallLocation").item(0).getTextContent();
                    file.filePermission = fileNode.getElementsByTagName("Permissions").item(0).getTextContent();
                }
                break;
        }
    }
}
