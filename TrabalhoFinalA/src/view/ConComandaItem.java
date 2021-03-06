/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleComanda;
import control.ControleItemComanda;
import javax.swing.JOptionPane;
import model.ItemComanda;

/**
 *
 * @author aluno
 */
public class ConComandaItem extends javax.swing.JDialog {

    /**
     * Creates new form ConComandaItem
     */
    public ConComandaItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregar();
    }

    public void carregar() {
        for (ItemComanda ic : controleComanda.getComanda().getItens()) {
            model.adicionarItem(ic);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        btRemover = new javax.swing.JButton();
        btMudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Itens de uma Comanda");

        tbItens.setModel(model);
        jScrollPane1.setViewportView(tbItens);

        btRemover.setText("Remover Item");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btMudar.setText("Mudar Quantidade");
        btMudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMudarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMudar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMudar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        if (tbItens.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir o registro?") == 0) {
                ItemComanda item = controle.selecionar(model.getItem(tbItens.getSelectedRow()).getId());
                if (controle.excluir(item)) {
                    model.removerItem(tbItens.getSelectedRow());
                    JOptionPane.showMessageDialog(this, controle.getMsg());
                } else {
                    JOptionPane.showMessageDialog(this, controle.getMsg());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um registro! >:(");
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btMudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMudarActionPerformed
        if (tbItens.getSelectedRow() >= 0) {
            CadItemComanda cadItemcomanda = new CadItemComanda(null, true);
            cadItemcomanda.carregarCampos(model.getItem(tbItens.getSelectedRow()));
            controle.setItem(model.getItem(tbItens.getSelectedRow()));
            cadItemcomanda.setVisible(true);
            model.atualizarItem(tbItens.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um registro! >:(");
        }
    }//GEN-LAST:event_btMudarActionPerformed

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
            java.util.logging.Logger.getLogger(ConComandaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConComandaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConComandaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConComandaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConComandaItem dialog = new ConComandaItem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private ModelComandaItem model = new ModelComandaItem();
    private ControleItemComanda controle = ControleItemComanda.getInstancia();
    private ControleComanda controleComanda = ControleComanda.getInstancia();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMudar;
    private javax.swing.JButton btRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbItens;
    // End of variables declaration//GEN-END:variables
}
