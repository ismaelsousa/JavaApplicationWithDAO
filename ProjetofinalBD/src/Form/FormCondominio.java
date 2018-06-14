/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Beans.Condominio;
import Beans.Locador;
import Dao.DAOCondominio;
import Dao.DAOLocador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ismae
 */
public class FormCondominio extends javax.swing.JFrame {

    /**
     * Creates new form FormCondominio
     */
    public FormCondominio() {
        initComponents();
        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterScrollPane = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        idLocadorLabel = new javax.swing.JLabel();
        idLocadorField = new javax.swing.JTextField();
        ruaField = new javax.swing.JTextField();
        ruaLabel = new javax.swing.JLabel();
        numeroLabel = new javax.swing.JLabel();
        numeroField = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id condominio", "id Locador", "Rua", "Numero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterScrollPane.setViewportView(JTable);

        idLocadorLabel.setText("Id Locador:");

        ruaLabel.setText("Rua:");

        numeroLabel.setText("Numero:");

        newButton.setText("Cadastrar");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Excluir");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Alterar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLocadorLabel)
                            .addComponent(ruaLabel)
                            .addComponent(numeroLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(idLocadorField, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(ruaField, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(numeroField, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLocadorLabel)
                    .addComponent(idLocadorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLabel)
                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        if (!this.idLocadorField.getText().equals("") && !this.ruaField.getText().equals("") && !this.numeroField.getText().equals("")) {

            Locador l = new Locador();
            l.setId(Integer.parseInt(this.idLocadorField.getText()));

            Condominio c = new Condominio();
            DAOCondominio dao = new DAOCondominio();
            c.setLocador(l);
            c.setRua(this.ruaField.getText());
            c.setNumero(Integer.parseInt(this.numeroField.getText()));
            dao.save(c);
            this.idLocadorField.setText("");
            this.ruaField.setText("");
            this.numeroField.setText("");
            readJTable();
             JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor preencher todos os campos para realizar o cadastro");
        }
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (this.JTable.getSelectedRow() != -1) {
            Condominio c = new Condominio();
            //vai pegar o valor da linha selecionada
            c.setId((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0));

            DAOCondominio dao = new DAOCondominio();
            dao.delete(c);
            readJTable();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        if (this.JTable.getSelectedRow() != -1) {
            Locador l = new Locador();
            Condominio c = new Condominio();
            //vai pegar o valor da linha selecionada
            l.setId((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 1));
            c.setLocador(l);
            c.setId((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0));
            c.setRua(this.JTable.getValueAt(this.JTable.getSelectedRow(), 2).toString());
            c.setNumero((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0));
            DAOCondominio dao = new DAOCondominio();
            
            dao.updateCondominio(c);
            readJTable();
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FormCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCondominio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idLocadorField;
    private javax.swing.JLabel idLocadorLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField numeroField;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField ruaField;
    private javax.swing.JLabel ruaLabel;
    // End of variables declaration//GEN-END:variables

    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTable.getModel();
        modelo.setNumRows(0);
        DAOCondominio dao = new DAOCondominio();
        for (Condominio condominio : dao.findAll()) {
            modelo.addRow(new Object[]{
                condominio.getId(),
                condominio.getLocador().getId(),
                condominio.getRua(),
                condominio.getNumero(),});
        }
    }
}