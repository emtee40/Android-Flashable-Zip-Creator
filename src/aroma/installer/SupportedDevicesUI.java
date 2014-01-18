/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

/**
 *
 * @author Nikhil
 */
public class SupportedDevicesUI extends javax.swing.JFrame {

    /**
     * Creates new form SupportedDevicesUI
     */
    public SupportedDevicesUI() {
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

        CSD_panel = new javax.swing.JPanel();
        CSD_title = new javax.swing.JLabel();
        CSD_heading = new javax.swing.JLabel();
        CSD_note1 = new javax.swing.JLabel();
        CSD_note2 = new javax.swing.JLabel();
        CSD_continue = new javax.swing.JButton();
        CSD_cancel = new javax.swing.JButton();
        CSD_note3 = new javax.swing.JLabel();
        CSDScrollPanel = new javax.swing.JScrollPane();
        CSDList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CSD_title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CSD_title.setText("Select Your Device If it is listed in Currently Supported Devices");

        CSD_heading.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CSD_heading.setText("Currently Supported Devices");

        CSD_note1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note1.setText("Note : If You Select your device from following list, you dont need to add update-binary file explicitly. ");

        CSD_note2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note2.setText("However if you still add update-binary file, added file will override existing update-binary file.");

        CSD_continue.setText("Continue!");
        CSD_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_continueActionPerformed(evt);
            }
        });

        CSD_cancel.setText("Cancel");
        CSD_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_cancelActionPerformed(evt);
            }
        });

        CSD_note3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note3.setText("More Devices Will Be Added Soon...");

        CSDList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        CSDScrollPanel.setViewportView(CSDList);

        javax.swing.GroupLayout CSD_panelLayout = new javax.swing.GroupLayout(CSD_panel);
        CSD_panel.setLayout(CSD_panelLayout);
        CSD_panelLayout.setHorizontalGroup(
            CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CSD_panelLayout.createSequentialGroup()
                .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(CSD_note2))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(CSD_title))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(CSD_note1))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CSD_note3)
                            .addComponent(CSD_heading)))
                    .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(CSD_panelLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(CSDScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CSD_panelLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(CSD_continue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(CSD_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        CSD_panelLayout.setVerticalGroup(
            CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CSD_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(CSD_title)
                .addGap(18, 18, 18)
                .addComponent(CSD_note1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CSD_note2)
                .addGap(18, 18, 18)
                .addComponent(CSD_heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CSDScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CSD_note3)
                .addGap(39, 39, 39)
                .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CSD_continue)
                    .addComponent(CSD_cancel))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CSD_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSD_continueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSD_continueActionPerformed

    private void CSD_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSD_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSD_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(SupportedDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupportedDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupportedDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupportedDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupportedDevicesUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList CSDList;
    private javax.swing.JScrollPane CSDScrollPanel;
    private javax.swing.JButton CSD_cancel;
    private javax.swing.JButton CSD_continue;
    private javax.swing.JLabel CSD_heading;
    private javax.swing.JLabel CSD_note1;
    private javax.swing.JLabel CSD_note2;
    private javax.swing.JLabel CSD_note3;
    private javax.swing.JPanel CSD_panel;
    private javax.swing.JLabel CSD_title;
    // End of variables declaration//GEN-END:variables
}
