/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dogbreeds.app;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author 1663m
 */
public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    private java.awt.CardLayout xpathCardLayout;
    private javax.swing.JPanel  xpathCardPanel;
    private javax.swing.JLabel  xpathTituloLabel;
    private int currentXPathCard = 0;

    private static final String[] XPATH_LABELS = {
        "Por Nome", "Por Porte", "Por Peso (kg)", "Por Características",
        "Por Origem [+ Porte]", "Por Cor", "Por Grupo",
        "Por Esperança de Vida (mín.)", "Maior Esperança de Vida",
        "Sem Dados de Peso", "Por Altura (cm)", "3 Critérios"
    };


    public MainFrame() {
        initComponents();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {
                "Ver ficheiros XML", "Validar DTD/XSD",
                "─── DADOS ───",
                "Adicionar raça", "Eliminar raça", "Editar detalhes",
                "─── PESQUISAS XPath ───",
                "Por Nome", "Por Porte", "Por Peso",
                "Por Características", "Por Origem", "Por Cor",
                "Por Grupo", "Por Esperança de Vida",
                "Maior Esperança de Vida", "Sem Dados de Peso",
                "Por Altura", "3 Critérios",
                "─── OUTPUTS ───",
                "Galeria HTML (XSLT)", "XML por Tamanho (XSLT)",
                "XML Detalhes (XSLT)", "HTML Detalhes (XSLT)",
                "Ranking por Vida (XQuery)", "Raças por Grupo (XQuery)",
                "Estatísticas (XQuery)"
            };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jList1.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                String txt = value.toString();
                if (txt.startsWith("───")) {
                    setBackground(new java.awt.Color(220, 220, 220));
                    setForeground(new java.awt.Color(90, 90, 90));
                    setFont(getFont().deriveFont(java.awt.Font.BOLD, 11f));
                    setEnabled(false);
                } else {
                    if (!isSelected) {
                        setBackground(java.awt.Color.WHITE);
                        setForeground(java.awt.Color.BLACK);
                    }
                    setFont(getFont().deriveFont(java.awt.Font.PLAIN, 12f));
                }
                setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 4));
                return this;
            }
        });

        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                tratarSelecaoMenu(jList1.getSelectedIndex());
            }
        });

        configurarPainelXPath();
        configurarPainelXSLT();
        configurarPainelXQuery();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSair = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeRaca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonVerRacas = new javax.swing.JButton();
        jButtonVerDetalhes = new javax.swing.JButton();
        jButtonAddRaca = new javax.swing.JButton();
        jTextFieldRacaAdd = new javax.swing.JTextField();
        jTextFieldRacaRemove = new javax.swing.JTextField();
        jButtonRemoveRaca = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonValidarRacasdtd = new javax.swing.JButton();
        jButtonvalidarDetalhesdtd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonvalidarRacasxsd = new javax.swing.JButton();
        jButtonvalidarDetalhesxsd = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonHTMLfotos = new javax.swing.JButton();
        jButtonDetalhesxslt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButtonHTMLdetalhes = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButtonRankingVida = new javax.swing.JButton();
        jButtonRacasGrupo = new javax.swing.JButton();
        jButtonEstatisticasGerais = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaXQuery = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Ver ficheiros XML", "Validar DTD/XSD", "─── DADOS ───", "Adicionar raça", "Eliminar raça", "Editar detalhes", "─── PESQUISAS XPath ───", "Por Nome", "Por Porte", "Por Peso", "Por Características", "Por Origem", "Por Cor", "Por Grupo", "Por Esperança de Vida", "Maior Esperança de Vida", "Sem Dados de Peso", "Por Altura", "3 Critérios", "─── OUTPUTS ───", "Galeria HTML (XSLT)", "XML por Tamanho (XSLT)", "XML Detalhes (XSLT)", "HTML Detalhes (XSLT)", "Ranking por Vida (XQuery)", "Raças por Grupo (XQuery)", "Estatísticas (XQuery)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jLabel1.setText("Nome da raça:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(this::btnPesquisarActionPerformed);

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane2.setViewportView(txtResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(163, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Resultados", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Formulário", jPanel2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jButtonVerRacas.setText("Racas.xml");
        jButtonVerRacas.addActionListener(this::jButtonVerRacasActionPerformed);

        jButtonVerDetalhes.setText("Detalhes.xml");
        jButtonVerDetalhes.addActionListener(this::jButtonVerDetalhesActionPerformed);

        jButtonAddRaca.setText("Adicionar Raça");
        jButtonAddRaca.addActionListener(this::jButtonAddRacaActionPerformed);

        jButtonRemoveRaca.setText("Remover Raça");
        jButtonRemoveRaca.addActionListener(this::jButtonRemoveRacaActionPerformed);

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(this::jButtonEditarActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldRacaRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jTextFieldRacaAdd))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRemoveRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonVerRacas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonVerDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addGap(116, 116, 116))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRacaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddRaca))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRacaRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoveRaca))
                        .addGap(124, 124, 124)
                        .addComponent(jButtonEditar)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonVerRacas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerDetalhes)))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("XML Viewer", jPanel4);

        jButtonValidarRacasdtd.setText("Validar Racas.xml");
        jButtonValidarRacasdtd.addActionListener(this::jButtonValidarRacasdtdActionPerformed);

        jButtonvalidarDetalhesdtd.setText("Validar Detalhes.xml");
        jButtonvalidarDetalhesdtd.addActionListener(this::jButtonvalidarDetalhesdtdActionPerformed);

        jLabel2.setText("         Validações DTD");

        jLabel3.setText("  Validações XSD  ");

        jButtonvalidarRacasxsd.setText("Validar Racas.xml");
        jButtonvalidarRacasxsd.addActionListener(this::jButtonvalidarRacasxsdActionPerformed);

        jButtonvalidarDetalhesxsd.setText("Validar Detalhes.xml");
        jButtonvalidarDetalhesxsd.addActionListener(this::jButtonvalidarDetalhesxsdActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonValidarRacasdtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonvalidarDetalhesdtd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonvalidarDetalhesxsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonvalidarRacasxsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValidarRacasdtd)
                    .addComponent(jButtonvalidarRacasxsd))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonvalidarDetalhesdtd)
                    .addComponent(jButtonvalidarDetalhesxsd))
                .addContainerGap(430, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Validações", jPanel5);

        jButtonHTMLfotos.setText("Gerar HTML de cães e fotos");
        jButtonHTMLfotos.addActionListener(this::jButtonHTMLfotosActionPerformed);

        jButtonDetalhesxslt.setText("Gerar XML com detalhes de uma raça");
        jButtonDetalhesxslt.addActionListener(this::jButtonDetalhesxsltActionPerformed);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jButtonHTMLdetalhes.setText("Gerar HTML com detalhes de uma raça");
        jButtonHTMLdetalhes.addActionListener(this::jButtonHTMLdetalhesActionPerformed);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonHTMLfotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDetalhesxslt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHTMLdetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonHTMLfotos)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonDetalhesxslt)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonHTMLdetalhes))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("XSLT", jPanel6);

        jButtonRankingVida.setText("Ranking por Esperança de Vida");

        jButtonRacasGrupo.setText("Raças por Grupo");

        jButtonEstatisticasGerais.setText("Estatísticas Gerais");

        jTextAreaXQuery.setColumns(20);
        jTextAreaXQuery.setRows(5);
        jTextAreaXQuery.setEditable(false);
        jScrollPane5.setViewportView(jTextAreaXQuery);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRankingVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRacasGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEstatisticasGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButtonRankingVida)
                .addGap(30, 30, 30)
                .addComponent(jButtonRacasGrupo)
                .addGap(30, 30, 30)
                .addComponent(jButtonEstatisticasGerais)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("XQuery", jPanel7);

        jSplitPane1.setRightComponent(jTabbedPane1);

        jButtonSair.setText("Sair");
        jButtonSair.setBackground(new java.awt.Color(200, 50, 50));
        jButtonSair.setForeground(java.awt.Color.WHITE);
        jButtonSair.setOpaque(true);
        jButtonSair.addActionListener(this::jButtonSairActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButtonSair))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonvalidarDetalhesxsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonvalidarDetalhesxsdActionPerformed
        try {
            int res = validarXML.validarDocumentoXSD("detalhes.xml", "detalhesXSD.xsd");
            if(res == 1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro detalhes.xml é VÁLIDO por XSD", "Sucesso XSD", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if(res == -1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro detalhes.xml é INVÁLIDO por XSD", "Erro XSD", javax.swing.JOptionPane.ERROR_MESSAGE);
            if(res == 0)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiros detalhes.xml ou detalhesXSD.xsd em falta", "Falta Ficheiro", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro técnico: " + ex.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonvalidarDetalhesxsdActionPerformed

    private void jButtonvalidarRacasxsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonvalidarRacasxsdActionPerformed
        try {
            int res = validarXML.validarDocumentoXSD("racas.xml", "racasXSD.xsd");
            if(res == 1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro racas.xml é VÁLIDO por XSD", "Sucesso XSD", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if(res == -1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro racas.xml é INVÁLIDO por XSD", "Erro XSD", javax.swing.JOptionPane.ERROR_MESSAGE);
            if(res == 0)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiros racas.xml ou racasXSD.xsd em falta", "Falta Ficheiro", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro técnico: " + ex.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonvalidarRacasxsdActionPerformed

    private void jButtonvalidarDetalhesdtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonvalidarDetalhesdtdActionPerformed
        try {
            int res = validarXML.validarDocumentoDTD("detalhes.xml", "detalhesDTD.dtd");
            if(res == 1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro detalhes.xml é VÁLIDO por DTD", "Sucesso DTD", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if(res == -1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro detalhes.xml é INVÁLIDO por DTD", "Erro DTD", javax.swing.JOptionPane.ERROR_MESSAGE);
            if(res == 0)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiros detalhes.xml ou detalhesDTD.dtd em falta", "Falta Ficheiro", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro técnico: " + ex.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonvalidarDetalhesdtdActionPerformed

    private void jButtonValidarRacasdtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarRacasdtdActionPerformed
        try {
            int res = validarXML.validarDocumentoDTD("racas.xml", "racasDTD.dtd");
            if(res == 1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro racas.xml é VÁLIDO por DTD", "Sucesso DTD", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if(res == -1)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiro racas.xml é INVÁLIDO por DTD", "Erro DTD", javax.swing.JOptionPane.ERROR_MESSAGE);
            if(res == 0)
            javax.swing.JOptionPane.showMessageDialog(this, "Ficheiros racas.xml ou racasDTD.dtd em falta", "Falta Ficheiro", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro técnico: " + ex.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonValidarRacasdtdActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            String nomeRaca = javax.swing.JOptionPane.showInputDialog(this, "Qual é o nome da raça que queres editar?", "Editar Raça", javax.swing.JOptionPane.QUESTION_MESSAGE);

            if (nomeRaca != null && !nomeRaca.trim().isEmpty()) {

                org.jdom2.Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
                String idRaca = null;
                for (Element breed : docRacas.getRootElement().getChildren("breed")) {
                    if (breed.getAttributeValue("nome").equalsIgnoreCase(nomeRaca.trim())) {
                        idRaca = breed.getChildText("id");
                        break;
                    }
                }

                if (idRaca == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Raça não encontrada no ficheiro racas.xml!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String[] opcoes = {"Grupo", "Cuidados com o Pelo", "Nível de Exercício", "Cores", "País de Origem", "Esperança de Vida"};
                String escolha = (String) javax.swing.JOptionPane.showInputDialog(this, "O que queres alterar no " + nomeRaca + "?", "Escolher Atributo", javax.swing.JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha != null) {
                    String novoValor = javax.swing.JOptionPane.showInputDialog(this, "Escreve o novo valor para '" + escolha + "':");

                    if (novoValor != null && !novoValor.trim().isEmpty()) {

                        org.jdom2.Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");

                        switch (escolha) {
                            case "Grupo":
                            docDetalhes = ModeloXML.alteraGrupo(idRaca, novoValor.trim(), docDetalhes);
                            break;
                            case "Cuidados com o Pelo":
                            docDetalhes = ModeloXML.alteraCuidadosPelo(idRaca, novoValor.trim(), docDetalhes);
                            break;
                            case "Nível de Exercício":
                            docDetalhes = ModeloXML.alteraNivelExercicio(idRaca, novoValor.trim(), docDetalhes);
                            break;
                            case "Cores":
                            docDetalhes = ModeloXML.alteraCores(idRaca, novoValor.trim(), docDetalhes);
                            break;
                            case "País de Origem":
                            docDetalhes = ModeloXML.alteraPaisOrigem(idRaca, novoValor.trim(), docDetalhes);
                            break;
                            case "Esperança de Vida":
                            docDetalhes = ModeloXML.alteraEsperancaVida(idRaca, novoValor.trim(), docDetalhes);
                            break;
                        }
                        XMLJDomFunctions.escreverDocumentoParaFicheiro(docDetalhes, "detalhes.xml");
                        javax.swing.JOptionPane.showMessageDialog(this,
                            escolha + " alterado com sucesso!",
                            "Editar Raça",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao editar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRemoveRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveRacaActionPerformed
        String raca = jTextFieldRacaRemove.getText().trim();

        if (raca.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Escreve o nome da raça a remover!", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
            Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");

            String idRemovido = ModeloXML.removeRaca(raca, docRacas);

            if (idRemovido != null) {
                docDetalhes = ModeloXML.removeDetalhes(idRemovido, docDetalhes);

                XMLJDomFunctions.escreverDocumentoParaFicheiro(docRacas, "racas.xml");
                XMLJDomFunctions.escreverDocumentoParaFicheiro(docDetalhes, "detalhes.xml");

                javax.swing.JOptionPane.showMessageDialog(this,
                    "Raça removida",
                    "Remover Raça",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

                jTextFieldRacaRemove.setText(""); // Limpa a caixa

            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Raça não existe no ficheiro",
                    "Remover Raça",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao remover: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoveRacaActionPerformed

    private void jButtonAddRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRacaActionPerformed
        String nomeRaca = jTextFieldRacaAdd.getText().trim();
        String urlPrincipal = "https://www.royalkennelclub.com/search/breeds-a-to-z/";

        boolean sucesso = DogBreedsApp.criaEGuardaCao(nomeRaca, urlPrincipal);

        if (sucesso) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "A raça " + nomeRaca + " foi extraída e guardada nos ficheiros XML.",
                "Adicionar Raça",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

            jTextFieldRacaAdd.setText(""); // Limpa o campo

        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Raça já existe no ficheiro ou erro na ligação.",
                "Adicionar Raça",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddRacaActionPerformed

    private void jButtonVerDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetalhesActionPerformed
        try {
            Document doc = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");

            if (doc != null) {
                String txt = XMLJDomFunctions.escreverDocumentoString(doc);
                jTextArea1.setText(txt);
                jTextArea1.setCaretPosition(0); // Volta ao topo
            } else {
                jTextArea1.setText("O ficheiro detalhes.xml ainda não existe!");
            }
        } catch (Exception e) {
            jTextArea1.setText("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonVerDetalhesActionPerformed

    private void jButtonVerRacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerRacasActionPerformed
        // TODO add your handling code here:
        try {
            Document doc = XMLJDomFunctions.lerDocumentoXML("racas.xml");

            if (doc != null) {
                String txt = XMLJDomFunctions.escreverDocumentoString(doc);
                jTextArea1.setText(txt);
                jTextArea1.setCaretPosition(0); // Volta ao topo
            } else {
                jTextArea1.setText("O ficheiro racas.xml ainda não existe!");
            }
        } catch (Exception e) {
            jTextArea1.setText("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonVerRacasActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String cao = txtNomeRaca.getText().trim();
        if (cao.isEmpty()) {
            txtResultados.setText("Por favor introduz o nome de uma raça.");
            return;
        }

        txtResultados.setText("A pesquisar dados para: " + cao + "...\n");

        try {
            String urlPrincipal = "https://www.royalkennelclub.com/search/breeds-a-to-z/";

            String linkCao = RoyalKennelWrapper.obtem_link_raca(cao, urlPrincipal);
            String tagline = "Sem tagline.";
            if (linkCao != null) {
                tagline = RoyalKennelWrapper.obtem_tagline(linkCao);
            }

            String grupo = RoyalKennelWrapper.obtem_grupo(cao, urlPrincipal);
            String foto = RoyalKennelWrapper.obtem_foto(cao, urlPrincipal);
            String tamanho = RoyalKennelWrapper.obtem_tamanho(cao, urlPrincipal);
            String exercicio = RoyalKennelWrapper.obtem_exercicio(cao, urlPrincipal);
            String grooming = RoyalKennelWrapper.obtem_grooming(cao, urlPrincipal);
            String pelo = RoyalKennelWrapper.obtem_tamanho_pelo(cao, urlPrincipal);
            int vida = RoyalKennelWrapper.obtem_esperanca_vida(cao, urlPrincipal);
            String origem = WikiWrapperER.obtem_origem(cao);
            String pesoMacho = WikiWrapperER.obtem_pesoMacho(cao);
            String pesoFemea = WikiWrapperER.obtem_pesoFemea(cao);
            String alturaMacho = WikiWrapperER.obtem_alturaMacho(cao);
            String alturaFemea = WikiWrapperER.obtem_alturaFemea(cao);
            String alturaGeral=WikiWrapperER.obtem_alturaGeral(cao);
            String pesoGeral=WikiWrapperER.obtem_pesoGeral(cao);

            StringBuilder sb = new StringBuilder();
            sb.append("=== ").append(cao.toUpperCase()).append(" ===\n\n");
            sb.append("\"").append(tagline).append("\"\n\n");
            sb.append("Grupo:            ").append(grupo).append("\n");
            sb.append("Tamanho:          ").append(tamanho).append("\n");
            sb.append("Exercício:        ").append(exercicio).append("\n");
            sb.append("Grooming:         ").append(grooming).append("\n");
            sb.append("Tamanho pelo:     ").append(pelo).append("\n");
            sb.append("Esperança vida:   ").append(vida).append(" anos\n");
            sb.append("Foto URL:         ").append(foto).append("\n\n");
            sb.append("--- Wikipedia ---\n");
            sb.append("País de origem:   ").append(origem).append("\n");
            sb.append("Peso macho:       ").append(pesoMacho).append("\n");
            sb.append("Peso fêmea:       ").append(pesoFemea).append("\n");
            sb.append("Altura macho:     ").append(alturaMacho).append("\n");
            sb.append("Altura fêmea:     ").append(alturaFemea).append("\n");
            sb.append("Altura Geral: ").append(alturaGeral).append("\n");
            sb.append("Peso Geral: ").append(pesoGeral).append("\n");
            txtResultados.setText(sb.toString());

        } catch (Exception e) {
            txtResultados.setText("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jButtonHTMLfotosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Document doc = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (doc == null) {
                jTextArea2.setText("detalhes.xml não encontrado!");
                return;
            }
            JDOMFunctions_XSLT.transformaDocumento2("detalhes.xml", "caesEfotosXSLT.xsl", "caesEfotosXSLT.html");

            jTextArea2.setText("Ficheiro 'caesEfotosXSLT.html' gerado com sucesso!\nA abrir a galeria no teu browser...");

            // ABRIR NO BROWSER
            java.awt.Desktop.getDesktop().browse(new java.io.File("caesEfotosXSLT.html").toURI());

        } catch (Exception e) {
            jTextArea2.setText("Erro: " + e.getMessage());
        }
    }

    private void jButtonDetalhesxsltActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nomeRaca = javax.swing.JOptionPane.showInputDialog(this, "Nome da raça:", "XML Detalhes de Raça", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (nomeRaca == null || nomeRaca.trim().isEmpty()) {
                return;
            }

            Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
            Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (docDetalhes == null || docRacas == null) {
                jTextArea2.setText("Ficheiros XML não encontrados!");
                return;
            }

            String idRaca = null;
            for (Element breed : docRacas.getRootElement().getChildren("breed")) {
                if (breed.getAttributeValue("nome").equalsIgnoreCase(nomeRaca.trim())) {
                    idRaca = breed.getChildText("id");
                    break;
                }
            }
            if (idRaca == null) {
                jTextArea2.setText("Raça '" + nomeRaca + "' não encontrada!");
                return;
            }

            Element raizFiltrada = new org.jdom2.Element("detalhes");
            Document docFiltrado = new org.jdom2.Document(raizFiltrada);
            for (org.jdom2.Element bd : docDetalhes.getRootElement().getChildren("breedDetail")) {
                if (idRaca.equals(bd.getChildText("breedId"))) {
                    raizFiltrada.addContent((org.jdom2.Element) bd.clone());
                    break;
                }
            }

            String nomeFicheiroSaida = "resultado_detalhes_" + nomeRaca.replace(" ", "_") + ".xml";
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docFiltrado, "detalhes_da_raca_pesquisada.xml");
            JDOMFunctions_XSLT.transformaDocumento2("detalhes_da_raca_pesquisada.xml", "raca_detalhes.xsl", nomeFicheiroSaida);

            Document docGerado = XMLJDomFunctions.lerDocumentoXML(nomeFicheiroSaida);
            if (docGerado != null) {
                jTextArea2.setText(XMLJDomFunctions.escreverDocumentoString(docGerado));
                jTextArea2.setCaretPosition(0);
            }

        } catch (Exception e) {
            jTextArea2.setText("Erro: " + e.getMessage());
        }
    }

    private void jButtonHTMLdetalhesActionPerformed(java.awt.event.ActionEvent evt) {
       try {
            String nomeRaca = javax.swing.JOptionPane.showInputDialog(this, "Nome da raça:", "HTML Detalhes de Raça", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (nomeRaca == null || nomeRaca.trim().isEmpty()) return;
            
            Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
            Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (docDetalhes == null || docRacas == null) { jTextArea2.setText("Ficheiros XML não encontrados!"); return; }
            
            String idRaca = null;
            for (Element breed : docRacas.getRootElement().getChildren("breed")) {
                if (breed.getAttributeValue("nome").equalsIgnoreCase(nomeRaca.trim())) {
                    idRaca = breed.getChildText("id");
                    break;
                }
            }
            if (idRaca == null) { jTextArea2.setText("Raça '" + nomeRaca + "' não encontrada!"); return; }
            
            Element raizFiltrada = new Element("detalhes");
            Document docFiltrado = new Document(raizFiltrada);
            for (org.jdom2.Element bd : docDetalhes.getRootElement().getChildren("breedDetail")) {
                if (idRaca.equals(bd.getChildText("breedId"))) {
                    raizFiltrada.addContent((Element) bd.clone());
                    break;
                }
            }
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docFiltrado, "detalhes_da_raca_pesquisada.xml");
            JDOMFunctions_XSLT.transformaDocumento2("detalhes_da_raca_pesquisada.xml", "raca_html_detalhes.xsl", "raca_html_detalhes.html");
            
            jTextArea2.setText("HTML 'raca_html_detalhes.html' gerado com sucesso!\nA abrir no teu browser...");
            
            java.awt.Desktop.getDesktop().browse(new java.io.File("raca_html_detalhes.html").toURI());
            
        } catch (Exception e) {
            jTextArea2.setText("Erro: " + e.getMessage());
        }
    }

    private String lerFicheiro(String nomeFicheiro) {
        StringBuilder sb = new StringBuilder();
        try (java.util.Scanner scanner = new java.util.Scanner(
                new java.io.FileInputStream(nomeFicheiro), "UTF-8")) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
        } catch (java.io.FileNotFoundException ex) {
            return "Ficheiro não encontrado: " + nomeFicheiro;
        }
        return sb.toString();
    }

    private void tratarSelecaoMenu(int index) {
        
        switch (index) {
            case 0:
                jTabbedPane1.setSelectedComponent(jPanel4); break;
            case 1:
                jTabbedPane1.setSelectedComponent(jPanel5); break;
            case 2: case 6: case 19:
                break; // separadores — ignorar
            case 3: case 4: case 5:
                jTabbedPane1.setSelectedComponent(jPanel4); break;
            case 7: case 8: case 9: case 10: case 11: case 12:
            case 13: case 14: case 15: case 16: case 17: case 18:
                jTabbedPane1.setSelectedComponent(jPanel2);
                int cardIdx = index - 7; // 0 a 11
                currentXPathCard = cardIdx;
                if (xpathCardLayout != null && xpathCardPanel != null) {
                    xpathCardLayout.show(xpathCardPanel, String.valueOf(cardIdx));
                }
                if (xpathTituloLabel != null) {
                    xpathTituloLabel.setText("Pesquisa: " + XPATH_LABELS[cardIdx]);
                }
                break;
            case 20:
                jTabbedPane1.setSelectedComponent(jPanel6);
                jButtonHTMLfotosActionPerformed(null);
                break;
            case 21:
                jTabbedPane1.setSelectedComponent(jPanel6);
                try {
                    JDOMFunctions_XSLT.transformaDocumento2("detalhes.xml", "por_tamanho.xsl", "racas_por_tamanho.xml");
                    jTextArea2.setText("Ficheiro 'racas_por_tamanho.xml' gerado com sucesso!");
                    javax.swing.JOptionPane.showMessageDialog(this, "XML por tamanho gerado!", "XSLT", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) { jTextArea2.setText("Erro: " + ex.getMessage()); }
                break;
            case 22:
                jTabbedPane1.setSelectedComponent(jPanel6);
                jButtonDetalhesxsltActionPerformed(null);
                break;
            case 23:
                jTabbedPane1.setSelectedComponent(jPanel6);
                jButtonHTMLdetalhesActionPerformed(null);
                break;
            case 24: case 25: case 26:
                jTabbedPane1.setSelectedComponent(jPanel7);
                break;
        }
    }

    private void configurarPainelXPath() {
        jTabbedPane1.setTitleAt(1, "Pesquisas XPath");

        jPanel2.removeAll();
        jPanel2.setLayout(new java.awt.BorderLayout(5, 5));

        javax.swing.JPanel northPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        northPanel.setBackground(new java.awt.Color(240, 240, 245));
        xpathTituloLabel = new javax.swing.JLabel("Pesquisa: " + XPATH_LABELS[0]);
        xpathTituloLabel.setFont(xpathTituloLabel.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        javax.swing.JButton btnPesquisarXPath = new javax.swing.JButton("🔍 Pesquisar");
        btnPesquisarXPath.setFont(btnPesquisarXPath.getFont().deriveFont(java.awt.Font.BOLD));
        northPanel.add(xpathTituloLabel);
        northPanel.add(javax.swing.Box.createHorizontalStrut(20));
        northPanel.add(btnPesquisarXPath);

        xpathCardLayout = new java.awt.CardLayout();
        xpathCardPanel = new javax.swing.JPanel(xpathCardLayout);
        java.awt.CardLayout cardLayout = xpathCardLayout;
        javax.swing.JPanel cardPanel = xpathCardPanel;

        javax.swing.JPanel cardNome = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardNome.add(new javax.swing.JLabel("Nome da raça:"));
        javax.swing.JTextField txtNome = new javax.swing.JTextField(20);
        cardNome.add(txtNome);

        javax.swing.JPanel cardPorte = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardPorte.add(new javax.swing.JLabel("Porte:"));
        String[] portes = {"Small", "Medium", "Large", "Giant"};
        try {
            org.jdom2.Document d = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (d != null) {
                java.util.Set<String> set = new java.util.TreeSet<>();
                for (org.jdom2.Element e : d.getRootElement().getChildren("breedDetail")) {
                    String v = e.getChildText("porte");
                    if (v != null && !v.isEmpty()) set.add(v);
                }
                if (!set.isEmpty()) portes = set.toArray(new String[0]);
            }
        } catch (Exception ex) { /* use defaults */ }
        javax.swing.JComboBox<String> cmbPorte = new javax.swing.JComboBox<>(portes);
        cardPorte.add(cmbPorte);

        javax.swing.JPanel cardPeso = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardPeso.add(new javax.swing.JLabel("Peso mín. (kg):"));
        javax.swing.JTextField txtPesoMin = new javax.swing.JTextField(6);
        cardPeso.add(txtPesoMin);
        cardPeso.add(new javax.swing.JLabel("Peso máx. (kg):"));
        javax.swing.JTextField txtPesoMax = new javax.swing.JTextField(6);
        cardPeso.add(txtPesoMax);

        javax.swing.JPanel cardCarac = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardCarac.add(new javax.swing.JLabel("Cuidados Pelo:"));
        String[] pelos = {"Once a week or less", "Once a week", "More than once a week", "Every day"};
        try {
            org.jdom2.Document d = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (d != null) {
                java.util.Set<String> set = new java.util.TreeSet<>();
                for (org.jdom2.Element e : d.getRootElement().getChildren("breedDetail")) {
                    String v = e.getChildText("cuidadosPelo");
                    if (v != null && !v.isEmpty()) set.add(v);
                }
                if (!set.isEmpty()) pelos = set.toArray(new String[0]);
            }
        } catch (Exception ex) { /* use defaults */ }
        javax.swing.JComboBox<String> cmbPelo = new javax.swing.JComboBox<>(pelos);
        cardCarac.add(cmbPelo);
        cardCarac.add(new javax.swing.JLabel("Exercício:"));
        String[] exercicios = {"Up to 1 hour per day", "More than 2 hours per day", "1 to 2 hours per day"};
        try {
            org.jdom2.Document d = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (d != null) {
                java.util.Set<String> set = new java.util.TreeSet<>();
                for (org.jdom2.Element e : d.getRootElement().getChildren("breedDetail")) {
                    String v = e.getChildText("nivelExercicio");
                    if (v != null && !v.isEmpty()) set.add(v);
                }
                if (!set.isEmpty()) exercicios = set.toArray(new String[0]);
            }
        } catch (Exception ex) { /* use defaults */ }
        javax.swing.JComboBox<String> cmbExercicio = new javax.swing.JComboBox<>(exercicios);
        cardCarac.add(cmbExercicio);

        javax.swing.JPanel cardOrigem = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardOrigem.add(new javax.swing.JLabel("País de Origem:"));
        javax.swing.JTextField txtOrigem = new javax.swing.JTextField(15);
        cardOrigem.add(txtOrigem);
        cardOrigem.add(new javax.swing.JLabel("Porte (opcional):"));
        String[] portesOrig = {"(todos)", "Small", "Medium", "Large", "Giant"};
        javax.swing.JComboBox<String> cmbPorteOrig = new javax.swing.JComboBox<>(portesOrig);
        cardOrigem.add(cmbPorteOrig);

        javax.swing.JPanel cardCor = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardCor.add(new javax.swing.JLabel("Cor:"));
        javax.swing.JTextField txtCor = new javax.swing.JTextField(15);
        cardCor.add(txtCor);

        javax.swing.JPanel cardGrupo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardGrupo.add(new javax.swing.JLabel("Grupo:"));
        String[] grupos = {"Toy", "Herding", "Working", "Hound", "Sporting", "Terrier", "Non-Sporting"};
        try {
            org.jdom2.Document d = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
            if (d != null) {
                java.util.Set<String> set = new java.util.TreeSet<>();
                for (org.jdom2.Element e : d.getRootElement().getChildren("breedDetail")) {
                    String v = e.getChildText("grupo");
                    if (v != null && !v.isEmpty()) set.add(v);
                }
                if (!set.isEmpty()) grupos = set.toArray(new String[0]);
            }
        } catch (Exception ex) { /* use defaults */ }
        javax.swing.JComboBox<String> cmbGrupo = new javax.swing.JComboBox<>(grupos);
        cardGrupo.add(cmbGrupo);

        javax.swing.JPanel cardVida = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardVida.add(new javax.swing.JLabel("Esperança mínima (anos):"));
        javax.swing.JTextField txtVidaMin = new javax.swing.JTextField(6);
        cardVida.add(txtVidaMin);

        javax.swing.JPanel cardMaiorVida = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardMaiorVida.add(new javax.swing.JLabel("Mostra a raça com maior esperança de vida"));

        javax.swing.JPanel cardSemPeso = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardSemPeso.add(new javax.swing.JLabel("Lista raças sem dados de peso"));

        javax.swing.JPanel cardAltura = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        cardAltura.add(new javax.swing.JLabel("Altura mín. (cm):"));
        javax.swing.JTextField txtAlturaMin = new javax.swing.JTextField(6);
        cardAltura.add(txtAlturaMin);
        cardAltura.add(new javax.swing.JLabel("Altura máx. (cm):"));
        javax.swing.JTextField txtAlturaMax = new javax.swing.JTextField(6);
        cardAltura.add(txtAlturaMax);

        javax.swing.JPanel card3Crit = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        card3Crit.add(new javax.swing.JLabel("Pelo:"));
        javax.swing.JComboBox<String> cmbPelo3 = new javax.swing.JComboBox<>(pelos);
        card3Crit.add(cmbPelo3);
        card3Crit.add(new javax.swing.JLabel("Exercício:"));
        javax.swing.JComboBox<String> cmbExerc3 = new javax.swing.JComboBox<>(exercicios);
        card3Crit.add(cmbExerc3);
        card3Crit.add(new javax.swing.JLabel("País:"));
        javax.swing.JTextField txtPais3 = new javax.swing.JTextField(10);
        card3Crit.add(txtPais3);

        cardPanel.add(cardNome,      "0");
        cardPanel.add(cardPorte,     "1");
        cardPanel.add(cardPeso,      "2");
        cardPanel.add(cardCarac,     "3");
        cardPanel.add(cardOrigem,    "4");
        cardPanel.add(cardCor,       "5");
        cardPanel.add(cardGrupo,     "6");
        cardPanel.add(cardVida,      "7");
        cardPanel.add(cardMaiorVida, "8");
        cardPanel.add(cardSemPeso,   "9");
        cardPanel.add(cardAltura,    "10");
        cardPanel.add(card3Crit,     "11");
        cardLayout.show(cardPanel, "0");

        javax.swing.JTextArea txtResultadosXPath = new javax.swing.JTextArea();
        txtResultadosXPath.setEditable(false);
        txtResultadosXPath.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scrollResultados = new javax.swing.JScrollPane(txtResultadosXPath);
        scrollResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        javax.swing.JSplitPane splitXPath = new javax.swing.JSplitPane(
            javax.swing.JSplitPane.VERTICAL_SPLIT, cardPanel, scrollResultados);
        splitXPath.setDividerLocation(80);
        splitXPath.setResizeWeight(0.15);

        btnPesquisarXPath.addActionListener(e -> {
            int sel = currentXPathCard;
            try {
                org.jdom2.Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");
                org.jdom2.Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
                if (docDetalhes == null || docRacas == null) {
                    txtResultadosXPath.setText("Ficheiros XML não encontrados!");
                    return;
                }
                String resultado = null;
                switch (sel) {
                    case 0:
                        resultado = XPathSearches.pesquisarPorNome(txtNome.getText().trim(), docDetalhes, docRacas);
                        break;
                    case 1:
                        resultado = XPathSearches.pesquisarPorPorte((String) cmbPorte.getSelectedItem(), docDetalhes, docRacas);
                        break;
                    case 2:
                        try {
                            double pMin = Double.parseDouble(txtPesoMin.getText().trim());
                            double pMax = Double.parseDouble(txtPesoMax.getText().trim());
                            resultado = XPathSearches.pesquisarPorPeso(pMin, pMax, docDetalhes, docRacas);
                        } catch (NumberFormatException nfe) {
                            txtResultadosXPath.setText("Introduz valores numéricos para o peso.");
                            return;
                        }
                        break;
                    case 3:
                        resultado = XPathSearches.pesquisarPorCaracteristica(
                            "cuidadosPelo", (String) cmbPelo.getSelectedItem(), docDetalhes, docRacas);
                        break;
                    case 4:
                        String porteOrig = (String) cmbPorteOrig.getSelectedItem();
                        if ("(todos)".equals(porteOrig)) porteOrig = null;
                        resultado = XPathSearches.pesquisarPorOrigem(txtOrigem.getText().trim(), porteOrig, docDetalhes, docRacas);
                        break;
                    case 5:
                        resultado = XPathSearches.pesquisarPorCor(txtCor.getText().trim(), docDetalhes, docRacas);
                        break;
                    case 6:
                        resultado = XPathSearches.pesquisarPorGrupo((String) cmbGrupo.getSelectedItem(), docDetalhes, docRacas);
                        break;
                    case 7:
                        try {
                            int vidaMin = Integer.parseInt(txtVidaMin.getText().trim());
                            resultado = XPathSearches.pesquisarPorEsperancaVida(vidaMin, docDetalhes, docRacas);
                        } catch (NumberFormatException nfe) {
                            txtResultadosXPath.setText("Introduz um número inteiro.");
                            return;
                        }
                        break;
                    case 8:
                        resultado = XPathSearches.pesquisarMaiorEsperancaVida(docDetalhes, docRacas);
                        break;
                    case 9:
                        resultado = XPathSearches.pesquisarSemDadosPeso(docDetalhes, docRacas);
                        break;
                    case 10:
                        try {
                            double aMin = Double.parseDouble(txtAlturaMin.getText().trim());
                            double aMax = Double.parseDouble(txtAlturaMax.getText().trim());
                            resultado = XPathSearches.pesquisarPorAltura(aMin, aMax, docDetalhes, docRacas);
                        } catch (NumberFormatException nfe) {
                            txtResultadosXPath.setText("Introduz valores numéricos para a altura.");
                            return;
                        }
                        break;
                    case 11:
                        resultado = XPathSearches.pesquisarCombinado3(
                            (String) cmbPelo3.getSelectedItem(),
                            (String) cmbExerc3.getSelectedItem(),
                            txtPais3.getText().trim(),
                            docDetalhes, docRacas);
                        break;
                }
                if (resultado == null || resultado.trim().isEmpty()) {
                    txtResultadosXPath.setText("Nenhum resultado encontrado.");
                } else {
                    txtResultadosXPath.setText("=== " + XPATH_LABELS[sel] + " ===\n\n" + resultado);
                    txtResultadosXPath.setCaretPosition(0);
                }
            } catch (Exception ex) {
                txtResultadosXPath.setText("Erro na pesquisa: " + ex.getMessage());
            }
        });

        jPanel2.add(northPanel, java.awt.BorderLayout.NORTH);
        jPanel2.add(splitXPath, java.awt.BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void configurarPainelXSLT() {
        jPanel6.removeAll();
        jPanel6.setLayout(new java.awt.BorderLayout(5, 5));

        javax.swing.JPanel btnPanel = new javax.swing.JPanel();
        btnPanel.setLayout(new javax.swing.BoxLayout(btnPanel, javax.swing.BoxLayout.Y_AXIS));
        btnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 15, 20, 15));

        javax.swing.JButton btnGaleriaHTML    = new javax.swing.JButton("Galeria HTML (XSLT)");
        javax.swing.JButton btnXMLtamanho    = new javax.swing.JButton("XML por Tamanho (XSLT)");
        javax.swing.JButton btnXMLdetalhes   = new javax.swing.JButton("XML Detalhes de Raça (XSLT)");
        javax.swing.JButton btnHTMLdetalhes2 = new javax.swing.JButton("HTML Detalhes de Raça (XSLT)");

        java.awt.Dimension btnSize = new java.awt.Dimension(260, 36);
        for (javax.swing.JButton b : new javax.swing.JButton[]{btnGaleriaHTML, btnXMLtamanho, btnXMLdetalhes, btnHTMLdetalhes2}) {
            b.setMaximumSize(btnSize);
            b.setPreferredSize(btnSize);
            b.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            btnPanel.add(b);
            btnPanel.add(javax.swing.Box.createVerticalStrut(10));
        }

        jTextArea2.setEditable(false);
        jScrollPane4.setViewportView(jTextArea2);

        btnGaleriaHTML.addActionListener(e -> jButtonHTMLfotosActionPerformed(e));
        btnXMLtamanho.addActionListener(e -> {
            try {
                JDOMFunctions_XSLT.transformaDocumento2("detalhes.xml", "por_tamanho.xsl", "racas_por_tamanho.xml");
                
                Document docFinal = XMLJDomFunctions.lerDocumentoXML("racas_por_tamanho.xml");
                if (docFinal != null) {
                    jTextArea2.setText(XMLJDomFunctions.escreverDocumentoString(docFinal));
                    jTextArea2.setCaretPosition(0);
                }
                
                javax.swing.JOptionPane.showMessageDialog(this, "XML por tamanho gerado com sucesso!", "XSLT", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                jTextArea2.setText("Erro: " + ex.getMessage());
            }
        });
        btnXMLdetalhes.addActionListener(e -> jButtonDetalhesxsltActionPerformed(e));
        btnHTMLdetalhes2.addActionListener(e -> jButtonHTMLdetalhesActionPerformed(e));

        jPanel6.add(btnPanel, java.awt.BorderLayout.WEST);
        jPanel6.add(jScrollPane4, java.awt.BorderLayout.CENTER);
        jPanel6.revalidate();
        jPanel6.repaint();
    }

    private void configurarPainelXQuery() {
        jPanel7.removeAll();
        jPanel7.setLayout(new java.awt.BorderLayout(5, 5));

        javax.swing.JPanel btnPanel = new javax.swing.JPanel();
        btnPanel.setLayout(new javax.swing.BoxLayout(btnPanel, javax.swing.BoxLayout.Y_AXIS));
        btnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 20, 20, 20));

        javax.swing.JButton btnRanking = new javax.swing.JButton("Ranking por Esperança de Vida");
        javax.swing.JButton btnGrupos = new javax.swing.JButton("Raças por Grupo");
        javax.swing.JButton btnEstat = new javax.swing.JButton("Estatísticas Gerais");

        java.awt.Dimension btnSize = new java.awt.Dimension(250, 35);
        for (javax.swing.JButton b : new javax.swing.JButton[]{btnRanking, btnGrupos, btnEstat}) {
            b.setMaximumSize(btnSize);
            b.setPreferredSize(btnSize);
            b.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            btnPanel.add(b);
            btnPanel.add(javax.swing.Box.createVerticalStrut(12));
        }

        javax.swing.JTextArea txtXQueryResult = new javax.swing.JTextArea();
        txtXQueryResult.setEditable(false);
        txtXQueryResult.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scrollXQuery = new javax.swing.JScrollPane(txtXQueryResult);

        btnRanking.addActionListener(e -> {
            try {
                SaxonFunctions_XQuery.xQueryToText("ranking_vida.txt", "ranking_vida.xql");
                String r = lerFicheiro("ranking_vida.txt");
                txtXQueryResult.setText(r);
                txtXQueryResult.setCaretPosition(0);
                javax.swing.JOptionPane.showMessageDialog(this, "Query feita com sucesso... ficheiro TXT criado!", "XQuery", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (java.io.FileNotFoundException ex) {
                txtXQueryResult.setText("Erro: ficheiro .xql não encontrado em: " + System.getProperty("user.dir"));
            } catch (Exception ex) {
                txtXQueryResult.setText("Erro: " + ex.getMessage());
            }
        });
        btnGrupos.addActionListener(e -> {
            try {
                SaxonFunctions_XQuery.xQueryToText("grupos_racas.txt", "grupos_racas.xql");
                String r = lerFicheiro("grupos_racas.txt");
                txtXQueryResult.setText(r);
                txtXQueryResult.setCaretPosition(0);
                javax.swing.JOptionPane.showMessageDialog(this, "Query feita com sucesso... ficheiro TXT criado!", "XQuery", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                txtXQueryResult.setText("Erro: " + ex.getMessage());
            }
        });
        btnEstat.addActionListener(e -> {
            try {
                SaxonFunctions_XQuery.xQueryToText("estatisticas.txt", "estatisticas.xql");
                String r = lerFicheiro("estatisticas.txt");
                txtXQueryResult.setText(r);
                txtXQueryResult.setCaretPosition(0);
                javax.swing.JOptionPane.showMessageDialog(this, "Query feita com sucesso... ficheiro TXT criado!", "XQuery", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                txtXQueryResult.setText("Erro: " + ex.getMessage());
            }
        });

        jPanel7.add(btnPanel, java.awt.BorderLayout.WEST);
        jPanel7.add(scrollXQuery, java.awt.BorderLayout.CENTER);
        jPanel7.revalidate();
        jPanel7.repaint();
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmacao = javax.swing.JOptionPane.showConfirmDialog(this,
                "Tens a certeza que queres sair?", "Sair",
                javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirmacao == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButtonAddRaca;
    private javax.swing.JButton jButtonDetalhesxslt;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEstatisticasGerais;
    private javax.swing.JButton jButtonHTMLdetalhes;
    private javax.swing.JButton jButtonHTMLfotos;
    private javax.swing.JButton jButtonRacasGrupo;
    private javax.swing.JButton jButtonRankingVida;
    private javax.swing.JButton jButtonRemoveRaca;
    private javax.swing.JButton jButtonValidarRacasdtd;
    private javax.swing.JButton jButtonVerDetalhes;
    private javax.swing.JButton jButtonVerRacas;
    private javax.swing.JButton jButtonvalidarDetalhesdtd;
    private javax.swing.JButton jButtonvalidarDetalhesxsd;
    private javax.swing.JButton jButtonvalidarRacasxsd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaXQuery;
    private javax.swing.JTextField jTextFieldRacaAdd;
    private javax.swing.JTextField jTextFieldRacaRemove;
    private javax.swing.JTextField txtNomeRaca;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables
}
