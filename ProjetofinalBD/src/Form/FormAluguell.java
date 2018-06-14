/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Beans.Aluguel;
import Beans.Apartamento;
import Beans.Contrato;
import Beans.Locador;
import Dao.DAOAluguel;
import Dao.DAOLocador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ismae
 */
public class FormAluguell extends javax.swing.JFrame {

    /**
     * Creates new form FormAluguell
     */
    public FormAluguell() {
        initComponents();
        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTable.getModel();
        modelo.setNumRows(0);
        DAOAluguel dao = new DAOAluguel();
        for (Aluguel aluguel : dao.findAll()) {
            modelo.addRow(new Object[]{
                aluguel.getId(),
                aluguel.getApartamento().getId(),
                aluguel.getContrato().getId(),});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        idApartamentoLabel = new javax.swing.JLabel();
        idApartamentoField = new javax.swing.JTextField();
        idContratoLabel = new javax.swing.JLabel();
        idContratoField = new javax.swing.JTextField();
        cadastrar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "id apartamento", "id contrato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTable);

        idApartamentoLabel.setText("Id Apartamento:");

        idApartamentoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idApartamentoFieldActionPerformed(evt);
            }
        });

        idContratoLabel.setText("Id Contrato:");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idApartamentoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(idApartamentoField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idContratoLabel)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(idContratoField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Alterar)
                                .addGap(110, 110, 110)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idApartamentoLabel)
                    .addComponent(idApartamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idContratoLabel)
                    .addComponent(idContratoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Alterar)
                    .addComponent(Excluir)
                    .addComponent(cadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idApartamentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idApartamentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idApartamentoFieldActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        // TODO add your handling code here:
        if (!this.idApartamentoField.getText().equals("") && !this.idContratoField.getText().equals("")) {
            Apartamento ap = new Apartamento();
            Contrato contrato = new Contrato();
            Aluguel alu = new Aluguel();

            ap.setId(Integer.parseInt(this.idApartamentoField.getText()));
            contrato.setId(Integer.parseInt(this.idContratoField.getText()));
            alu.setApartamento(ap);
            alu.setContrato(contrato);
            
            DAOAluguel dao = new DAOAluguel();
            dao.save(alu);
            idApartamentoField.setText("");
            idContratoField.setText("");
            readJTable();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Por favor preencher todos os campos para realizar o cadastro");
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        // TODO add your handling code here:
        if (this.JTable.getSelectedRow() != -1) {
           Aluguel alu = new Aluguel();
            //vai pegar o valor da linha selecionada 
            alu.setId((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0));
            
            DAOAluguel dao = new DAOAluguel();
            dao.delete(alu);
            readJTable();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        // TODO add your handling code here:
          if (this.JTable.getSelectedRow() != -1) {
             Aluguel alu = new Aluguel();
             Contrato cont = new Contrato();
             Apartamento ap = new Apartamento();
             
            //vai pegar o valor da linha selecionada 
            alu.setId((int) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0));
            cont.setId((Integer.parseInt(this.JTable.getValueAt(this.JTable.getSelectedRow(), 1).toString())));
            ap.setId((Integer.parseInt(this.JTable.getValueAt(this.JTable.getSelectedRow(), 2).toString())));
            
            alu.setApartamento(ap);
            alu.setContrato(cont);

            DAOAluguel dao = new DAOAluguel();
            dao.update(alu);
            readJTable();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        }
    }//GEN-LAST:event_AlterarActionPerformed

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
            java.util.logging.Logger.getLogger(FormAluguell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAluguell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAluguell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAluguell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAluguell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Excluir;
    private javax.swing.JTable JTable;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField idApartamentoField;
    private javax.swing.JLabel idApartamentoLabel;
    private javax.swing.JTextField idContratoField;
    private javax.swing.JLabel idContratoLabel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}