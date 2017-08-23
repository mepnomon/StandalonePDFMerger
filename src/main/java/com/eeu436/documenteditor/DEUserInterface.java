/*
    Copyright 2017, D.B. Dressler

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package com.eeu436.documenteditor;

// imports
import com.eeu436.documentmerger.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.pdfbox.rendering.PageDrawer;

/**
 * User Interface for Document Merger
 * @author D.B. Dressler
 */
public class DEUserInterface extends javax.swing.JFrame {

    //Global variables
    private static DocumentMerger merger;
    private boolean mergeEnabled;
    private boolean removeEnabled;
    private final DefaultListModel DOCUMENT_PATHS;
    private final String LICENSE_LOC = "src\\main\\resources\\License\\LICENSE.txt";
    private ArrayList<String> notifications;
    /**
     * Creates new form DMUserInterface
     */
    public DEUserInterface() {
        //instantiate merger
        merger = new DocumentMerger();
        // Control variable for merger button
        mergeEnabled = false;
        // Control variable for remove button
        removeEnabled = false;
        // List of document paths
        DOCUMENT_PATHS = new DefaultListModel();
        
        notifications = new ArrayList<>();
        initComponents();
        // Set gui defaults
        setDefaults();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusPane = new javax.swing.JTextPane();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        moveUpButton = new javax.swing.JButton();
        moveDownButton = new javax.swing.JButton();
        mergeButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pageCountLabel = new javax.swing.JLabel();
        docCountLabel = new javax.swing.JLabel();
        previewPanel = new javax.swing.JPanel();
        canvasPrevButton = new javax.swing.JButton();
        canvasNextButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenu_btnAdd = new javax.swing.JMenuItem();
        fileMenu_mergeBtn = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fileMenu_exitBtn = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutMenu_showLicense = new javax.swing.JMenuItem();
        aboutMenu_aboutBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDFMerger v1.0 (c) 2017 D.B.Dressler");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("MainFrame"); // NOI18N
        setResizable(false);

        fileList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(fileList);

        jScrollPane2.setViewportView(statusPane);

        addButton.setText("Add...");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove...");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        moveUpButton.setText("Move up");
        moveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpButtonActionPerformed(evt);
            }
        });

        moveDownButton.setText("Move Down");
        moveDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownButtonActionPerformed(evt);
            }
        });

        mergeButton.setText("Merge PDFs");
        mergeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("# Pages:");

        jLabel1.setText("# Docs:");

        pageCountLabel.setText("jLabel4");

        docCountLabel.setText("jLabel3");

        javax.swing.GroupLayout previewPanelLayout = new javax.swing.GroupLayout(previewPanel);
        previewPanel.setLayout(previewPanelLayout);
        previewPanelLayout.setHorizontalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        previewPanelLayout.setVerticalGroup(
            previewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docCountLabel)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageCountLabel)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(previewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(previewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(pageCountLabel)
                    .addComponent(docCountLabel)))
        );

        canvasPrevButton.setText("<-");
        canvasPrevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canvasPrevButtonActionPerformed(evt);
            }
        });

        canvasNextButton.setText("->");
        canvasNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canvasNextButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        fileMenu_btnAdd.setText("Add File");
        fileMenu_btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenu_btnAddActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenu_btnAdd);

        fileMenu_mergeBtn.setText("Merge Files");
        fileMenu_mergeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenu_mergeBtnActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenu_mergeBtn);
        fileMenu.add(jSeparator1);

        fileMenu_exitBtn.setText("Exit");
        fileMenu_exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenu_exitBtnActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenu_exitBtn);

        jMenuBar1.add(fileMenu);

        aboutMenu.setText("About");

        aboutMenu_showLicense.setText("License");
        aboutMenu_showLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenu_showLicenseActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenu_showLicense);

        aboutMenu_aboutBtn.setText("About");
        aboutMenu_aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenu_aboutBtnActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenu_aboutBtn);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moveUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveDownButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addComponent(mergeButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(canvasPrevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(canvasNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(canvasPrevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvasNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(removeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveUpButton)
                    .addComponent(moveDownButton)
                    .addComponent(mergeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        getAccessibleContext().setAccessibleName("PDFMerger 0.8 (c) 2017 D.B.Dressler");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Set GUI defaults.
     */
    private void setDefaults(){
        
        // Disable remove button
        removeButton.setEnabled(removeEnabled);
        // Disable merge button
        mergeButton.setEnabled(mergeEnabled);
        //notifications.add("Click add and select a file.\nReady...");
        statusPane.setText("Click add and select a file.\nReady...");
        updateGUI();
    }
    
    /**
     * Updates the GUI.
     * Call this method after performing an operation.
     */
    private void updateGUI(){
        
        // Get list of documents in memory
        ArrayList<String> localDocumentList = merger.getList();
        // Clear the Paths displayed in GUI
        DOCUMENT_PATHS.clear();
        
        // Add all documents to GUI
        for(int i = 0; i < localDocumentList.size(); i++){
            DOCUMENT_PATHS.add(i, localDocumentList.get(i));
        }
        
        // Add to JLIst - actually displays in GUI
        fileList.setModel(DOCUMENT_PATHS);
        
        // Check if dummy file name present
        boolean isPlaceHolderText = true;
        if(!localDocumentList.get(0).equals(merger.PLACEHOLDER_TEXT)){
            isPlaceHolderText = false;
        }
        
        // Enable/Disable buttons
        //if 1 documents in list and it's not the placeholder
        if(DOCUMENT_PATHS.size() == 1 && !isPlaceHolderText){
            // Enable remove button
            removeEnabled = true;
            mergeEnabled = false;
        } else if(DOCUMENT_PATHS.size() > 1){ //more than 1 file present
            // Enable remove and merge
            removeEnabled = true;
            mergeEnabled = true;
            
        } else { // no files present
            // Disable buttons
            mergeEnabled = false;
            removeEnabled = false;  
        }
        
        // Enable/Disable buttons
        mergeButton.setEnabled(mergeEnabled);
        removeButton.setEnabled(removeEnabled);
        fileMenu_mergeBtn.setEnabled(mergeEnabled);
        // Display # of documents
        docCountLabel.setText(Integer.toString(merger.getDocumentCount()));
        // Display total # of pages
        pageCountLabel.setText(Integer.toString(merger.getTotalPages()));
        
    }
    
    /**
     * Moves a selected document down in the list.
     * @param evt 
     */
    private void moveDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownButtonActionPerformed
        
        if(fileList.getSelectedIndex() < DOCUMENT_PATHS.size()){
            merger.moveFileDown(fileList.getSelectedIndex());
            updateGUI();
        }
    }//GEN-LAST:event_moveDownButtonActionPerformed

    /**
     * Select and add files to merge.
     * @param evt 
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        addFunctionality();
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Performs functionality when remove button is pressed.
     * @param evt 
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        String filePath = null;
        int[] selectionList = fileList.getSelectedIndices();
        for(int i = 0; i < selectionList.length; i++){
            
            // Adjust location
            int loc = (selectionList[i] - i);
            // Remove
            filePath = merger.removeFileFromList(loc);
            // Prompt user
            statusPane.setText("File removed: " + filePath);
        }
        updateGUI();
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Merges PDFs into a single document, when pressed.
     * @param evt 
     */
    private void mergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeButtonActionPerformed
        
        mergeFunctionality();
    }//GEN-LAST:event_mergeButtonActionPerformed

    /**
     * Moves a selected element up in the List displaying selected files.
     * @param evt 
     */
    private void moveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpButtonActionPerformed
        
        // Check if within boundaries
        if(fileList.getSelectedIndex() > 0){
            merger.moveFileUp(fileList.getSelectedIndex());
            updateGUI();
        }
    }//GEN-LAST:event_moveUpButtonActionPerformed

    /**
     * Add a document via the file menu.
     * @param evt 
     */
    private void fileMenu_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenu_btnAddActionPerformed
        addFunctionality();
    }//GEN-LAST:event_fileMenu_btnAddActionPerformed

    /**
     * Exit button in Menu, exits program.
     * @param evt 
     */
    private void fileMenu_exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenu_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fileMenu_exitBtnActionPerformed

    /**
     * Merge button, via the file menu.
     * @param evt 
     */
    private void fileMenu_mergeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenu_mergeBtnActionPerformed
        mergeFunctionality();
    }//GEN-LAST:event_fileMenu_mergeBtnActionPerformed

    private void aboutMenu_aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenu_aboutBtnActionPerformed
        
        JOptionPane.showMessageDialog(null, "A utility program for merging pdfs. "
                + "\n(c) 2017 D.B. Dressler.", "About PDF Merger",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenu_aboutBtnActionPerformed

    private void aboutMenu_showLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenu_showLicenseActionPerformed
        File license = new File(LICENSE_LOC);
        try {
            java.awt.Desktop.getDesktop().edit(license);
        } catch (IOException ex) {
            Logger.getLogger(DEUserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aboutMenu_showLicenseActionPerformed

    private void canvasPrevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canvasPrevButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canvasPrevButtonActionPerformed

    private void canvasNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canvasNextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_canvasNextButtonActionPerformed

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
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DEUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DEUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DEUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DEUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DEUserInterface().setVisible(true);
            }
        });
    }
    
    /**
     * Previews a document
     */
    private void previewDocument(int docIndex){
        // The page to be displayed
        int page = 0;
        PageDrawer drawer;
        //PDFPagePanel foo;
        //drawer.
        //previewPanel.add();
        
    }
    
    /**
     * Adds Files.
     */
    private void addFunctionality(){
        String filePath = null;
        
        // File Chooser
        JFileChooser chooser = new JFileChooser();
        // Multi file selector
        chooser.setMultiSelectionEnabled(true);
        // Stores files to open
        File[] filesToOpen;
        int returnVal = chooser.showOpenDialog(null);
        
        // check if valid option in file chooser
        if (returnVal == JFileChooser.APPROVE_OPTION){
            filesToOpen = chooser.getSelectedFiles();
            
            for(int i = 0; i < filesToOpen.length; i++){
                filePath = filesToOpen[i].getAbsolutePath();
                File locFile = filesToOpen[i];
                // check if valid file 
                if(filePath.toLowerCase().substring(filePath.length()-3, 
                        filePath.length()).equals("pdf") && locFile.length() != 0){
                    
                    // add file 
                    merger.addFilesToList(filePath);
                    statusPane.setText("File added: " + filePath);
                } else { // not valid pdf
                    statusPane.setText("File must be PDF.");
                }
            }
         }
        // update list
        updateGUI();
    }
    
    /**
     * Merges files.
     */
    private void mergeFunctionality(){
        
        // Open file chooser dialog
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        // Get output path
        String outputPath = chooser.getSelectedFile().toString();
        
        // Check if user specified that file extension is .pdf
        if(!outputPath.toLowerCase().substring(outputPath.length()-3, 
                outputPath.length()).equals("pdf")){
            
            // Append .pdf to output file
            outputPath += ".pdf";
        }
        
        merger.setOutputPath(outputPath);// Set the output path
        merger.mergeFiles(); // Merge the files
        DOCUMENT_PATHS.clear(); // Clear documentList
        merger.clearLists(); // Clear merger lists
        statusPane.setText("File written to: " + outputPath); // Notify user
        updateGUI(); // Update gui
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenu_aboutBtn;
    private javax.swing.JMenuItem aboutMenu_showLicense;
    private javax.swing.JButton addButton;
    private javax.swing.JButton canvasNextButton;
    private javax.swing.JButton canvasPrevButton;
    private javax.swing.JLabel docCountLabel;
    private javax.swing.JList<String> fileList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileMenu_btnAdd;
    private javax.swing.JMenuItem fileMenu_exitBtn;
    private javax.swing.JMenuItem fileMenu_mergeBtn;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton mergeButton;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JLabel pageCountLabel;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextPane statusPane;
    // End of variables declaration//GEN-END:variables
}