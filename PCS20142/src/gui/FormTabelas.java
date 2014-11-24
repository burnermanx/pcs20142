/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.DAOCampeonato;
import dominio.Jogo;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.table.DefaultTableModel;
import servicos.ServicoClassificacaoEquipes;
import servicos.ServicoImportacaoEquipes;
import servicos.ServicoImportacaoResultados;
import servicos.ServicoListagemJogos;

/**
 *
 * @author Luiz Paulo
 */
public class FormTabelas extends javax.swing.JFrame {
    //private Curso curso = new LeitorXML().lerXML();
    DAOCampeonato daoCampeonato = new DAOCampeonato();
    ServicoClassificacaoEquipes servicoClassificacao;
    ServicoImportacaoEquipes importacaoEquipes;
    ServicoImportacaoResultados importacaoResultados;
    ServicoListagemJogos servicoJogos; 
    List<String[]> classificacaoGeral;
    
    
    /**
     * Creates new form Tabelas
     */
    public FormTabelas() {
        initComponents();
        servicoClassificacao = new ServicoClassificacaoEquipes(daoCampeonato.getCampeonato());
        importacaoEquipes = new ServicoImportacaoEquipes(daoCampeonato);
        if (!daoCampeonato.fileExists()) {
            importacaoEquipes.importarEquipes("Equipes.txt");
        }
        importacaoResultados = new ServicoImportacaoResultados(daoCampeonato);
        servicoJogos = new ServicoListagemJogos(daoCampeonato.getCampeonato());

        
        atualizaClassificacaoGeral();
    }
    
    public void atualizaClassificacaoGeral() {
        limpaClassificacaoGeral();
        classificacaoGeral = servicoClassificacao.obterClassificacaoGeral();
        for (String[] linha : classificacaoGeral) {
            ((DefaultTableModel) this.tabelaGeral.getModel()).addRow(linha);
        }
        int rodada = daoCampeonato.getCampeonato().obterUltimaRodada();
        txtNumRodada.setText(String.valueOf(rodada));
        
        atualizaComboBox();
        
    }
    
    public void atualizaComboBox() {
        int rodada = daoCampeonato.getCampeonato().obterUltimaRodada();
        MutableComboBoxModel model = (MutableComboBoxModel) comboRodada.getModel();
        if (model.getSize() == 0) {
            for (int i = 1; i <= rodada; i++) {
                model.insertElementAt(i, i-1);
            }       
        } else {
            if (model.getElementAt(rodada-1) == null)
                model.insertElementAt(rodada, rodada-1);        
        }
    }
    
    public void limpaClassificacaoGeral() {
        DefaultTableModel model = (DefaultTableModel) this.tabelaGeral.getModel();
        model.setRowCount(0);
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
        jLabel4 = new javax.swing.JLabel();
        txtNumRodada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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
                "Posição", "Indicador", "Equipe", "PG", "J", "V", "E", "D", "GP", "GC", "SG", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGeral.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaGeral);
        if (tabelaGeral.getColumnModel().getColumnCount() > 0) {
            tabelaGeral.getColumnModel().getColumn(0).setResizable(false);
        }

        jTabbedPane1.addTab("Classificação geral", jScrollPane3);

        jLabel2.setText("Rodada:");

        comboRodada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboRodadaItemStateChanged(evt);
            }
        });

        txtMandanteJogo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo1.setText("MANDANTE");

        txtScoreJogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo1.setText("0x0");

        txtVisitanteJogo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo1.setText("VISITANTE");

        txtMandanteJogo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo2.setText("MANDANTE");

        txtScoreJogo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo2.setText("0x0");

        txtVisitanteJogo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo2.setText("VISITANTE");

        txtMandanteJogo3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo3.setText("MANDANTE");

        txtScoreJogo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo3.setText("0x0");

        txtVisitanteJogo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo3.setText("VISITANTE");

        txtMandanteJogo4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo4.setText("MANDANTE");

        txtScoreJogo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo4.setText("0x0");

        txtVisitanteJogo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo4.setText("VISITANTE");

        txtMandanteJogo5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo5.setText("MANDANTE");

        txtScoreJogo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo5.setText("0x0");

        txtVisitanteJogo5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo5.setText("VISITANTE");

        txtMandanteJogo6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo6.setText("MANDANTE");

        txtScoreJogo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo6.setText("0x0");

        txtVisitanteJogo6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo6.setText("VISITANTE");

        txtMandanteJogo7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo7.setText("MANDANTE");

        txtScoreJogo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo7.setText("0x0");

        txtVisitanteJogo7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo7.setText("VISITANTE");

        txtMandanteJogo8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo8.setText("MANDANTE");

        txtScoreJogo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo8.setText("0x0");

        txtVisitanteJogo8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo8.setText("VISITANTE");

        txtMandanteJogo9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo9.setText("MANDANTE");

        txtScoreJogo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo9.setText("0x0");

        txtVisitanteJogo9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo9.setText("VISITANTE");

        txtMandanteJogo10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMandanteJogo10.setText("MANDANTE");

        txtScoreJogo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtScoreJogo10.setText("0x0");

        txtVisitanteJogo10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtVisitanteJogo10.setText("VISITANTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMandanteJogo5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtMandanteJogo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMandanteJogo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMandanteJogo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMandanteJogo4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtScoreJogo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVisitanteJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtScoreJogo2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVisitanteJogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtScoreJogo3)
                                    .addComponent(txtScoreJogo4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVisitanteJogo4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtVisitanteJogo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtScoreJogo5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVisitanteJogo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtMandanteJogo10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtScoreJogo10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVisitanteJogo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtMandanteJogo6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtScoreJogo6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVisitanteJogo6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtMandanteJogo9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtScoreJogo9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVisitanteJogo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtMandanteJogo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtScoreJogo8))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtMandanteJogo7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtScoreJogo7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtVisitanteJogo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtVisitanteJogo8, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))))
                                .addGap(458, 458, 458))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboRodada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395))))
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
                    .addComponent(txtMandanteJogo7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(txtMandanteJogo9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVisitanteJogo9)
                        .addComponent(txtScoreJogo9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo4)
                        .addComponent(txtScoreJogo4)
                        .addComponent(txtVisitanteJogo4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMandanteJogo10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVisitanteJogo10)
                        .addComponent(txtScoreJogo10))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMandanteJogo5)
                        .addComponent(txtScoreJogo5)
                        .addComponent(txtVisitanteJogo5)))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rodadas", jPanel2);

        jLabel4.setText("Rodada:");

        txtNumRodada.setText("0");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumRodada)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoImportar)
                        .addComponent(jLabel4)
                        .addComponent(txtNumRodada))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImportarActionPerformed

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                if (importacaoResultados.verificarArquivo(file)) {
                    importacaoResultados.importarResultados(file);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Insira o arquivo correspondente a rodada " + String.valueOf(daoCampeonato.getCampeonato().obterUltimaRodada()+1) + " ou qualquer rodada passada.", "Arquivo inválido", JOptionPane.WARNING_MESSAGE);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormTabelas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        atualizaClassificacaoGeral();

    }//GEN-LAST:event_botaoImportarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(1);
    }//GEN-LAST:event_formWindowClosed

    private void comboRodadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboRodadaItemStateChanged
        List<Jogo> jogos;
        int rodada = (Integer) evt.getItem();
        String[] timeMandante = new String[10];
        String[] timeVisitante = new String[10];
        String[] score = new String[10];
        jogos = servicoJogos.obterJogos(rodada);
        int i=0;
        for (Jogo jogo : jogos) {
            timeMandante[i] = jogo.getEquipeMandante().getNome();
            timeVisitante[i] = jogo.getEquipeVisitante().getNome();
            String stringScore = String.valueOf(jogo.getScoreMandante()) + "x" + String.valueOf(jogo.getScoreVisitante());
            score[i] = stringScore;
            i++;
        }
        txtMandanteJogo1.setText(timeMandante[0]);
        txtVisitanteJogo1.setText(timeVisitante[0]);
        txtScoreJogo1.setText(score[0]);
        
        txtMandanteJogo2.setText(timeMandante[1]);
        txtVisitanteJogo2.setText(timeVisitante[1]);
        txtScoreJogo2.setText(score[1]);
        
        txtMandanteJogo3.setText(timeMandante[2]);
        txtVisitanteJogo3.setText(timeVisitante[2]);
        txtScoreJogo3.setText(score[2]);
        
        txtMandanteJogo4.setText(timeMandante[3]);
        txtVisitanteJogo4.setText(timeVisitante[3]);
        txtScoreJogo4.setText(score[3]);
        
        txtMandanteJogo5.setText(timeMandante[4]);
        txtVisitanteJogo5.setText(timeVisitante[4]);
        txtScoreJogo5.setText(score[4]);
        
        txtMandanteJogo6.setText(timeMandante[5]);
        txtVisitanteJogo6.setText(timeVisitante[5]);
        txtScoreJogo6.setText(score[5]);
        
        txtMandanteJogo7.setText(timeMandante[6]);
        txtVisitanteJogo7.setText(timeVisitante[6]);
        txtScoreJogo7.setText(score[6]);
        
        txtMandanteJogo8.setText(timeMandante[7]);
        txtVisitanteJogo8.setText(timeVisitante[7]);
        txtScoreJogo8.setText(score[7]);
        
        txtMandanteJogo9.setText(timeMandante[8]);
        txtVisitanteJogo9.setText(timeVisitante[8]);
        txtScoreJogo9.setText(score[8]);
        
        txtMandanteJogo10.setText(timeMandante[9]);
        txtVisitanteJogo10.setText(timeVisitante[9]);
        txtScoreJogo10.setText(score[9]);
    }//GEN-LAST:event_comboRodadaItemStateChanged

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
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel txtNumRodada;
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
