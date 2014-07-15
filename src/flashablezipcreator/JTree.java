/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.ProjectTreeBuilder;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.Operations.TreeOperations;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class JTree extends JFrame implements TreeSelectionListener {

    /**
     * Creates new form JTreeDemo
     */
    DefaultTreeModel model;
    TreeOperations to = new TreeOperations();
    
    public JTree() throws IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws IOException {

        textField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        

        //tree configurations
        tree = ProjectTreeBuilder.buildTree();
        model = ProjectTreeBuilder.buildModel();
        jScrollPane1 = ProjectTreeBuilder.buildScrollPane();
        tree.addTreeSelectionListener(this);

        //to expand all the rows
        to.expandDirectories(tree);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        addButton.setText(">");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("<");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField)
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();        
        node.addChild(new FileNode(textField.getText(), (GroupNode) node), model);
        to.expandDirectories(tree);
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();        
        node.removeChild(node, model);
        to.expandDirectories(tree);
    }

    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField textField;
    private javax.swing.JTree tree;

    @Override
    public void valueChanged(TreeSelectionEvent tse) {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        //JOptionPane.showMessageDialog(this, "You have selected: " + node);
    }
}
