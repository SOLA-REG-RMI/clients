/**
 * ******************************************************************************************
 * Copyright (C) 2014 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.clients.swing.ui.administrative;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.sola.clients.beans.administrative.BaUnitSearchResultBean;
import org.sola.clients.beans.administrative.BaUnitSearchResultListBean;
import org.sola.clients.swing.common.laf.LafManager;
import org.sola.clients.swing.common.tasks.SolaTask;
import org.sola.clients.swing.common.tasks.TaskManager;
import org.sola.clients.swing.ui.renderers.CellDelimitedListRenderer;
import org.sola.common.messaging.ClientMessage;
import org.sola.common.messaging.MessageUtility;

/**
 * Allows to search BA Units.
 */
public class BaUnitSearchPanel extends javax.swing.JPanel {

    public static final String SELECTED_BAUNIT_SEARCH_RESULT = "selectedBaUnitSearchResultOpen";

    /**
     * Default constructor.
     */
    public BaUnitSearchPanel() {
        initComponents();

        customieOpenButton(null);
        baUnitSearchResults.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(BaUnitSearchResultListBean.SELECTED_BAUNIT_SEARCH_RESULT_PROPERTY)) {
                    firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
                    customieOpenButton((BaUnitSearchResultBean) evt.getNewValue());
                }
            }
        });
    }

    private void customieOpenButton(BaUnitSearchResultBean searchResult) {
        btnOpenBaUnit.setEnabled(searchResult != null);
        menuOpenBaUnit.setEnabled(btnOpenBaUnit.isEnabled());
    }

    /**
     * Indicates whether open button is shown or not.
     */
    public boolean isShowOpenButton() {
        return btnOpenBaUnit.isVisible();
    }

    /**
     * Sets visibility of open button.
     */
    public void setShowOpenButton(boolean showPrintButton) {
        btnOpenBaUnit.setVisible(showPrintButton);
        menuOpenBaUnit.setVisible(showPrintButton);
        separator1.setVisible(showPrintButton);
    }

    /**
     * Returns selected search result.
     */
    public BaUnitSearchResultBean getSelectedSearchResult() {
        return baUnitSearchResults.getSelectedBaUnitSearchResult();
    }

    private void clearSearchResults(){
        baUnitSearchParams.setNameFirstPart(null);
        baUnitSearchParams.setNameLastPart(null);
        baUnitSearchParams.setOwnerName(null);
        baUnitSearchResults.getBaUnitSearchResults().clear();
        lblSearchResultCount.setText("0");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        baUnitSearchResults = new org.sola.clients.beans.administrative.BaUnitSearchResultListBean();
        baUnitSearchParams = new org.sola.clients.beans.administrative.BaUnitSearchParamsBean();
        popUpSearchResults = new javax.swing.JPopupMenu();
        menuOpenBaUnit = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNameFirstPart = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNameLastPart = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRightholder = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSearchResults = new org.sola.clients.swing.common.controls.JTableWithDefaultStyles();
        jToolBar1 = new javax.swing.JToolBar();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnOpenBaUnit = new javax.swing.JButton();
        separator1 = new javax.swing.JToolBar.Separator();
        lblSearchResult = new javax.swing.JLabel();
        lblSearchResultCount = new javax.swing.JLabel();

        popUpSearchResults.setName("popUpSearchResults"); // NOI18N

        menuOpenBaUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/folder-open-document.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sola/clients/swing/ui/administrative/Bundle"); // NOI18N
        menuOpenBaUnit.setText(bundle.getString("BaUnitSearchPanel.menuOpenBaUnit.text")); // NOI18N
        menuOpenBaUnit.setName("menuOpenBaUnit"); // NOI18N
        menuOpenBaUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenBaUnitActionPerformed(evt);
            }
        });
        popUpSearchResults.add(menuOpenBaUnit);

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(1, 4, 15, 0));

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(bundle.getString("BaUnitSearchPanel.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtNameFirstPart.setName("txtNameFirstPart"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, baUnitSearchParams, org.jdesktop.beansbinding.ELProperty.create("${nameFirstPart}"), txtNameFirstPart, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameFirstPart, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameFirstPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1);

        jPanel3.setName("jPanel3"); // NOI18N

        jLabel3.setText(bundle.getString("BaUnitSearchPanel.jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        txtNameLastPart.setName("txtNameLastPart"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, baUnitSearchParams, org.jdesktop.beansbinding.ELProperty.create("${nameLastPart}"), txtNameLastPart, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameLastPart, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameLastPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3);

        jPanel2.setName("jPanel2"); // NOI18N

        jLabel2.setText(bundle.getString("BaUnitSearchPanel.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtRightholder.setName("txtRightholder"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, baUnitSearchParams, org.jdesktop.beansbinding.ELProperty.create("${ownerName}"), txtRightholder, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRightholder, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRightholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2);

        jPanel5.setName("jPanel5"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tableSearchResults.setComponentPopupMenu(popUpSearchResults);
        tableSearchResults.setName("tableSearchResults"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${baUnitSearchResults}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, baUnitSearchResults, eLProperty, tableSearchResults);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nameFirstPart}"));
        columnBinding.setColumnName("Name First Part");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nameLastPart}"));
        columnBinding.setColumnName("Name Last Part");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rightholders}"));
        columnBinding.setColumnName("Rightholders");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${registrationStatus.displayValue}"));
        columnBinding.setColumnName("Registration Status.display Value");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, baUnitSearchResults, org.jdesktop.beansbinding.ELProperty.create("${selectedBaUnitSearchResult}"), tableSearchResults, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        tableSearchResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSearchResultsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSearchResults);
        if (tableSearchResults.getColumnModel().getColumnCount() > 0) {
            tableSearchResults.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("BaUnitSearchPanel.tableSearchResults.columnModel.title0")); // NOI18N
            tableSearchResults.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("BaUnitSearchPanel.tableSearchResults.columnModel.title1")); // NOI18N
            tableSearchResults.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("BaUnitSearchPanel.tableSearchResults.columnModel.title2")); // NOI18N
            tableSearchResults.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("BaUnitSearchPanel.tableSearchResults.columnModel.title3")); // NOI18N
            tableSearchResults.getColumnModel().getColumn(3).setCellRenderer(new CellDelimitedListRenderer("::::"));
            tableSearchResults.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("BaUnitSearchPanel.tableSearchResults.columnModel.title4")); // NOI18N
        }

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/search.png"))); // NOI18N
        btnSearch.setText(bundle.getString("BaUnitSearchPanel.btnSearch.text")); // NOI18N
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearch);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/eraser.png"))); // NOI18N
        btnClear.setText(bundle.getString("BaUnitSearchPanel.btnClear.text")); // NOI18N
        btnClear.setName(bundle.getString("BaUnitSearchPanel.btnClear.name")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClear);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jToolBar1.add(jSeparator1);

        btnOpenBaUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/folder-open-document.png"))); // NOI18N
        btnOpenBaUnit.setText(bundle.getString("BaUnitSearchPanel.btnOpenBaUnit.text")); // NOI18N
        btnOpenBaUnit.setFocusable(false);
        btnOpenBaUnit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOpenBaUnit.setName("btnOpenBaUnit"); // NOI18N
        btnOpenBaUnit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpenBaUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenBaUnitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpenBaUnit);

        separator1.setName("separator1"); // NOI18N
        jToolBar1.add(separator1);

        lblSearchResult.setText(bundle.getString("BaUnitSearchPanel.lblSearchResult.text")); // NOI18N
        lblSearchResult.setName("lblSearchResult"); // NOI18N
        jToolBar1.add(lblSearchResult);

        lblSearchResultCount.setFont(LafManager.getInstance().getLabFontBold());
        lblSearchResultCount.setText(bundle.getString("BaUnitSearchPanel.lblSearchResultCount.text")); // NOI18N
        lblSearchResultCount.setName("lblSearchResultCount"); // NOI18N
        jToolBar1.add(lblSearchResultCount);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    
    
     public void clickFind() {
        btnSearchActionPerformed(null);
    }
    
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SolaTask t = new SolaTask<Void, Void>() {

            @Override
            public Void doTask() {
                setMessage(MessageUtility.getLocalizedMessageText(ClientMessage.PROGRESS_MSG_PROPERTY_SEARCHING));
                baUnitSearchResults.search(baUnitSearchParams);
                return null;
            }

            @Override
            public void taskDone() {
                lblSearchResultCount.setText(Integer.toString(baUnitSearchResults.getBaUnitSearchResults().size()));
                if (baUnitSearchResults.getBaUnitSearchResults().size() < 1) {
                    MessageUtility.displayMessage(ClientMessage.SEARCH_NO_RESULTS);
                } else if (baUnitSearchResults.getBaUnitSearchResults().size() > 100) {
                    MessageUtility.displayMessage(ClientMessage.SEARCH_TOO_MANY_RESULTS, new String[]{"100"});
                }
            }
        };
        TaskManager.getInstance().runTask(t);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableSearchResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchResultsMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            openBaUnit();
        }
    }//GEN-LAST:event_tableSearchResultsMouseClicked

    private void btnOpenBaUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenBaUnitActionPerformed
        openBaUnit();
    }//GEN-LAST:event_btnOpenBaUnitActionPerformed

    private void menuOpenBaUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenBaUnitActionPerformed
        openBaUnit();
    }//GEN-LAST:event_menuOpenBaUnitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearSearchResults();
    }//GEN-LAST:event_btnClearActionPerformed

    private void openBaUnit() {
        if (baUnitSearchResults.getSelectedBaUnitSearchResult() != null) {
            firePropertyChange(SELECTED_BAUNIT_SEARCH_RESULT, null, baUnitSearchResults.getSelectedBaUnitSearchResult());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.sola.clients.beans.administrative.BaUnitSearchParamsBean baUnitSearchParams;
    private org.sola.clients.beans.administrative.BaUnitSearchResultListBean baUnitSearchResults;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnOpenBaUnit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblSearchResult;
    private javax.swing.JLabel lblSearchResultCount;
    private javax.swing.JMenuItem menuOpenBaUnit;
    private javax.swing.JPopupMenu popUpSearchResults;
    private javax.swing.JToolBar.Separator separator1;
    private org.sola.clients.swing.common.controls.JTableWithDefaultStyles tableSearchResults;
    private javax.swing.JTextField txtNameFirstPart;
    private javax.swing.JTextField txtNameLastPart;
    private javax.swing.JTextField txtRightholder;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
