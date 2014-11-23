/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.DAOCampeonato;
import java.io.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import servicos.ServicoClassificacaoEquipes;
import servicos.ServicoImportacaoEquipes;
import servicos.ServicoImportacaoResultados;

/**
 *
 * @author Luiz Paulo
 */
public class FormTabelas extends javax.swing.JFrame {
    //private Curso curso = new LeitorXML().lerXML();
    /**
     * Creates new form Tabelas
     */
    public FormTabelas() {
        initComponents();
        List<String[]> classificacao;
        DAOCampeonato daoCampeonato = new DAOCampeonato();
        ServicoClassificacaoEquipes servicoClassificacao = new ServicoClassificacaoEquipes(daoCampeonato.getCampeonato());
        ServicoImportacaoEquipes importacaoEquipes = new ServicoImportacaoEquipes(daoCampeonato);
        if (!daoCampeonato.fileExists()) {
            importacaoEquipes.importarEquipes("Equipes.txt"); //Trocar depois para dialog de inserção do arquivo Equipes
        }
        ServicoImportacaoResultados importacaoResultados = new ServicoImportacaoResultados(daoCampeonato);
        importacaoResultados.importarResultados("Rodada1.txt");
        importacaoResultados.importarResultados("Rodada2.txt");
        
        classificacao = servicoClassificacao.obterClassificacaoGeral();
        for (String[] linha : classificacao) {
            ((DefaultTableModel) this.tabelaGeral.getModel()).addRow(linha);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoImportar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaGeral = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboRodada = new javax.swing.JComboBox();
        txtMandanteJogo1 = new javax.swing.JLabel();
        txtScoreJogo1 = new javax.swing.JLabel();
        txtVisitanteJogo1 = new javax.swing.JLabel();
        txtMandanteJogo2 = new javax.swing.JLabel();
        txtScoreJogo2 = new javax.swing.JLabel();
        txtVisitanteJogo2 = new javax.swing.JLabel();
        txtMandanteJogo3 = new javax.swing.JLabel();
        txtScoreJogo3 = new javax.swing.JLabel();
        txtVisitanteJogo3 = new javax.swing.JLabel();
        txtMandanteJogo4 = new javax.swing.JLabel();
        txtScoreJogo4 = new javax.swing.JLabel();
        txtVisitanteJogo4 = new javax.swing.JLabel();
        txtMandanteJogo5 = new javax.swing.JLabel();
        txtScoreJogo5 = new javax.swing.JLabel();
        txtVisitanteJogo5 = new javax.swing.JLabel();
        txtMandanteJogo6 = new javax.swing.JLabel();
        txtScoreJogo6 = new javax.swing.JLabel();
        txtVisitanteJogo6 = new javax.swing.JLabel();
        txtMandanteJogo7 = new javax.swing.JLabel();
        txtScoreJogo7 = new javax.swing.JLabel();
        txtVisitanteJogo7 = new javax.swing.JLabel();
        txtMandanteJogo8 = new javax.swing.JLabel();
        txtScoreJogo8 = new javax.swing.JLabel();
        txtVisitanteJogo8 = new javax.swing.JLabel();
        txtMandanteJogo9 = new javax.swing.JLabel();
        txtScoreJogo9 = new javax.swing.JLabel();
        txtVisitanteJogo9 = new javax.swing.JLabel();
        txtMandanteJogo10 = new javax.swing.JLabel();
        txtScoreJogo10 = new javax.swing.JLabel();
        txtVisitanteJogo10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel2.setText("Rodada:");

        comboRodada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" }));

        txtMandanteJogo1.setText("Internacional");

        txtScoreJogo1.setText("0x0");

        txtVisitanteJogo1.setText("Internacional");

        txtMandanteJogo2.setText("Internacional");

        txtScoreJogo2.setText("0x0");

        txtVisitanteJogo2.setText("Internacional");

        txtMandanteJogo3.setText("Internacional");

        txtScoreJogo3.setText("0x0");

        txtVisitanteJogo3.setText("Internacional");

        txtMandanteJogo4.setText("Internacional");

        txtScoreJogo4.setText("0x0");

        txtVisitanteJogo4.setText("Internacional");

        txtMandanteJogo5.setText("Internacional");

        txtScoreJogo5.setText("0x0");

        txtVisitanteJogo5.setText("Internacional");

        txtMandanteJogo6.setText("Internacional");

        txtScoreJogo6.setText("0x0");

        txtVisitanteJogo6.setText("Internacional");

        txtMandanteJogo7.setText("Internacional");

        txtScoreJogo7.setText("0x0");

        txtVisitanteJogo7.setText("Internacional");

        txtMandanteJogo8.setText("Internacional");

        txtScoreJogo8.setText("0x0");

        txtVisitanteJogo8.setText("Internacional");

        txtMandanteJogo9.setText("Internacional");

        txtScoreJogo9.setText("0x0");

        txtVisitanteJogo9.setText("Internacional");

        txtMandanteJogo10.setText("Internacional");

        txtScoreJogo10.setText("0x0");

        txtVisitanteJogo10.setText("Internacional");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMandanteJogo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreJogo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVisitanteJogo4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMandanteJogo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtScoreJogo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVisitanteJogo5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMandanteJogo1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtScoreJogo1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo1)
                                    .addGap(45, 45, 45)
                                    .addComponent(txtMandanteJogo6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo6))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo2))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo3)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo8))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo7))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo9))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMandanteJogo10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtScoreJogo10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVisitanteJogo10))))))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo6)
                        .addComponent(txtScoreJogo6)
                        .addComponent(txtVisitanteJogo6))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo1)
                        .addComponent(txtScoreJogo1)
                        .addComponent(txtVisitanteJogo1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo7)
                        .addComponent(txtScoreJogo7)
                        .addComponent(txtVisitanteJogo7))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo2)
                        .addComponent(txtScoreJogo2)
                        .addComponent(txtVisitanteJogo2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo8)
                        .addComponent(txtScoreJogo8)
                        .addComponent(txtVisitanteJogo8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo3)
                        .addComponent(txtScoreJogo3)
                        .addComponent(txtVisitanteJogo3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo9)
                        .addComponent(txtScoreJogo9)
                        .addComponent(txtVisitanteJogo9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo4)
                        .addComponent(txtScoreJogo4)
                        .addComponent(txtVisitanteJogo4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo10)
                        .addComponent(txtScoreJogo10)
                        .addComponent(txtVisitanteJogo10))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo5)
                        .addComponent(txtScoreJogo5)
                        .addComponent(txtVisitanteJogo5)))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rodadas", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoImportar)
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoImportar)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

//        JFileChooser chooser = new JFileChooser();
//        int returnVal = chooser.showOpenDialog(this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = chooser.getSelectedFile();
//            try {
//                curso = new LeitorTXT(curso).readFile(file);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(FormTabelas.class.getName()).log(Level.SEVERE, null, ex);
//            }


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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaGeral;
    private javax.swing.JLabel txtMandanteJogo1;
    private javax.swing.JLabel txtMandanteJogo10;
    private javax.swing.JLabel txtMandanteJogo2;
    private javax.swing.JLabel txtMandanteJogo3;
    private javax.swing.JLabel txtMandanteJogo4;
    private javax.swing.JLabel txtMandanteJogo5;
    private javax.swing.JLabel txtMandanteJogo6;
    private javax.swing.JLabel txtMandanteJogo7;
    private javax.swing.JLabel txtMandanteJogo8;
    private javax.swing.JLabel txtMandanteJogo9;
    private javax.swing.JLabel txtScoreJogo1;
    private javax.swing.JLabel txtScoreJogo10;
    private javax.swing.JLabel txtScoreJogo2;
    private javax.swing.JLabel txtScoreJogo3;
    private javax.swing.JLabel txtScoreJogo4;
    private javax.swing.JLabel txtScoreJogo5;
    private javax.swing.JLabel txtScoreJogo6;
    private javax.swing.JLabel txtScoreJogo7;
    private javax.swing.JLabel txtScoreJogo8;
    private javax.swing.JLabel txtScoreJogo9;
    private javax.swing.JLabel txtVisitanteJogo1;
    private javax.swing.JLabel txtVisitanteJogo10;
    private javax.swing.JLabel txtVisitanteJogo2;
    private javax.swing.JLabel txtVisitanteJogo3;
    private javax.swing.JLabel txtVisitanteJogo4;
    private javax.swing.JLabel txtVisitanteJogo5;
    private javax.swing.JLabel txtVisitanteJogo6;
    private javax.swing.JLabel txtVisitanteJogo7;
    private javax.swing.JLabel txtVisitanteJogo8;
    private javax.swing.JLabel txtVisitanteJogo9;
    // End of variables declaration//GEN-END:variables
}
