/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.DAOCampeonato;
import javax.swing.table.DefaultTableModel;
import servicos.ServicoImportacaoEquipes;
import servicos.ServicoImportacaoResultados;

/**
 *
 * @author Luiz Paulo
 */
public class FormTabelas extends javax.swing.JFrame {

    
    

    /**
     * Creates new form Tabelas
     */
    public FormTabelas() {
        initComponents();
        DAOCampeonato daoCampeonato = new DAOCampeonato();
        ServicoImportacaoEquipes importacaoEquipes = new ServicoImportacaoEquipes(daoCampeonato);
        if (!daoCampeonato.fileExists()) 
            importacaoEquipes.importarEquipes("Equipes.txt"); //Trocar depois para dialog de inserção do arquivo Equipes
        ServicoImportacaoResultados importacaoResultados = new ServicoImportacaoResultados(daoCampeonato);
        importacaoResultados.importarResultados("Rodada1.txt");
        importacaoResultados.importarResultados("Rodada2.txt");
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoImportar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaGeral = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaRodadas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboRodada = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Forte", 0, 40)); // NOI18N
        jLabel1.setText("Campeonato Brasileiro");

        botaoImportar.setText("Importar rodada");
        botaoImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImportarActionPerformed(evt);
            }
        });

        tabelaGeral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Posição", "Indicador", "Equipe", "PG", "J", "V", "D", "GM", "GS", "SG", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaGeral);
        if (tabelaGeral.getColumnModel().getColumnCount() > 0) {
            tabelaGeral.getColumnModel().getColumn(0).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(1).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(2).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(3).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(4).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(5).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(6).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(7).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(8).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(9).setResizable(false);
            tabelaGeral.getColumnModel().getColumn(10).setResizable(false);
        }

        jTabbedPane1.addTab("Classificação geral", jScrollPane3);

        tabelaRodadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Posição", "Indicador", "Equipe", "PG", "J", "V", "D", "GM", "GS", "SG", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRodadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabelaRodadas);
        if (tabelaRodadas.getColumnModel().getColumnCount() > 0) {
            tabelaRodadas.getColumnModel().getColumn(0).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(1).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(2).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(3).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(4).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(5).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(6).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(7).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(8).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(9).setResizable(false);
            tabelaRodadas.getColumnModel().getColumn(10).setResizable(false);
        }

        jTabbedPane1.addTab("Rodadas", jScrollPane4);

        jLabel2.setText("Rodada:");

        comboRodada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoImportar)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoImportar)
                            .addComponent(jLabel2)
                            .addComponent(comboRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoImportarActionPerformed

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
            java.util.logging.Logger.getLogger(FormTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTabelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTabelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoImportar;
    private javax.swing.JComboBox comboRodada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaGeral;
    private javax.swing.JTable tabelaRodadas;
    // End of variables declaration//GEN-END:variables
}
