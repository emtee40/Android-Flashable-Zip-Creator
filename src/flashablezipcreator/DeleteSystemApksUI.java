/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator;

/**
 *
 * @author Nikhil
 */
public class DeleteSystemApksUI extends javax.swing.JFrame {

    /**
     * Creates new form DeleteSystemApksUI
     */
    public DeleteSystemApksUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DSAPanel = new javax.swing.JPanel();
        DSA_headingPanel = new javax.swing.JPanel();
        lblDSAHeading = new javax.swing.JLabel();
        lbl_deleteSystemTitle = new javax.swing.JLabel();
        lbl_deleteFileName = new javax.swing.JLabel();
        deleteApkName = new javax.swing.JTextField();
        lbl_deleteSystemExtension = new javax.swing.JLabel();
        deleteSystemScrollPane = new javax.swing.JScrollPane();
        deleteSystemFileList = new javax.swing.JList();
        btnAddDeleteFile = new javax.swing.JButton();
        btnRemoveDeleteFile = new javax.swing.JButton();
        btnResetDeleteFile = new javax.swing.JButton();
        btnDoneDeleteFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DSA_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblDSAHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblDSAHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblDSAHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSAHeading.setText("Remove Unwanted Apps");

        javax.swing.GroupLayout DSA_headingPanelLayout = new javax.swing.GroupLayout(DSA_headingPanel);
        DSA_headingPanel.setLayout(DSA_headingPanelLayout);
        DSA_headingPanelLayout.setHorizontalGroup(
            DSA_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DSA_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDSAHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        DSA_headingPanelLayout.setVerticalGroup(
            DSA_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DSA_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDSAHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_deleteSystemTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemTitle.setText("Enter Exact Name of apk file which you want to delete from system");

        lbl_deleteFileName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteFileName.setText("Enter File Name : ");

        deleteApkName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_deleteSystemExtension.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemExtension.setText(".apk");

        deleteSystemFileList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteSystemFileList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        deleteSystemFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                deleteSystemFileListValueChanged(evt);
            }
        });
        deleteSystemScrollPane.setViewportView(deleteSystemFileList);

        btnAddDeleteFile.setText("Add");
        btnAddDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeleteFileActionPerformed(evt);
            }
        });

        btnRemoveDeleteFile.setText("Remove");
        btnRemoveDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDeleteFileActionPerformed(evt);
            }
        });

        btnResetDeleteFile.setText("Reset");
        btnResetDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDeleteFileActionPerformed(evt);
            }
        });

        btnDoneDeleteFile.setText("Done!");
        btnDoneDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneDeleteFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DSAPanelLayout = new javax.swing.GroupLayout(DSAPanel);
        DSAPanel.setLayout(DSAPanelLayout);
        DSAPanelLayout.setHorizontalGroup(
            DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DSAPanelLayout.createSequentialGroup()
                .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DSAPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DSAPanelLayout.createSequentialGroup()
                                .addComponent(deleteSystemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_deleteSystemTitle)
                            .addGroup(DSAPanelLayout.createSequentialGroup()
                                .addComponent(lbl_deleteFileName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_deleteSystemExtension))))
                    .addGroup(DSAPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DSA_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DSAPanelLayout.setVerticalGroup(
            DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DSAPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DSA_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_deleteSystemTitle)
                .addGap(18, 18, 18)
                .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_deleteFileName)
                    .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deleteSystemExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DSAPanelLayout.createSequentialGroup()
                        .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteSystemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DSAPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DSAPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteSystemFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_deleteSystemFileListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteSystemFileListValueChanged

    private void btnAddDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDeleteFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDeleteFileActionPerformed

    private void btnRemoveDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDeleteFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveDeleteFileActionPerformed

    private void btnResetDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDeleteFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetDeleteFileActionPerformed

    private void btnDoneDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneDeleteFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoneDeleteFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteSystemApksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteSystemApksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteSystemApksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteSystemApksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteSystemApksUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CZ_headingPanel;
    private javax.swing.JPanel DSAPanel;
    private javax.swing.JPanel DSA_headingPanel;
    private javax.swing.JButton btnAddDeleteFile;
    private javax.swing.JButton btnDoneDeleteFile;
    private javax.swing.JButton btnRemoveDeleteFile;
    private javax.swing.JButton btnResetDeleteFile;
    private javax.swing.JTextField deleteApkName;
    private javax.swing.JList deleteSystemFileList;
    private javax.swing.JScrollPane deleteSystemScrollPane;
    private javax.swing.JLabel lblCZHeading1;
    private javax.swing.JLabel lblDSAHeading;
    private javax.swing.JLabel lbl_deleteFileName;
    private javax.swing.JLabel lbl_deleteSystemExtension;
    private javax.swing.JLabel lbl_deleteSystemTitle;
    // End of variables declaration//GEN-END:variables
}
