/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeu436.documentmerger;

import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * User Interface for Document Merger
 * @author D.B. Dressler
 */
public class DMUserInterface extends javax.swing.JFrame {

    //Global variables
    private static DocumentMerger merger;
    private boolean mergeEnabled;
    private boolean removeEnabled;
    private DefaultListModel documentPaths;
    private File file;
    
    /**
     * Creates new form DMUserInterface
     */
    public DMUserInterface() {
        //instantiate merger
        merger = new DocumentMerger();
        // Control variable for merger button
        mergeEnabled = false;
        // Control variable for remove button
        removeEnabled = false;
        // List of document paths
        documentPaths = new DefaultListModel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDFMerger 0.9 (beta) (c) 2017 D.B.Dressler");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docCountLabel)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageCountLabel)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(pageCountLabel)
                    .addComponent(docCountLabel)))
        );

        fileMenu.setText("File");

        jMenu3.setText("jMenu3");
        fileMenu.add(jMenu3);

        jMenuBar1.add(fileMenu);

        aboutMenu.setText("About");

        jMenu4.setText("jMenu4");
        aboutMenu.add(jMenu4);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(moveDownButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addComponent(mergeButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(removeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        documentPaths.clear();
        
        // Add all documents to GUI
        for(int i = 0; i < localDocumentList.size(); i++){
            documentPaths.add(i, localDocumentList.get(i));
        }
        
        // Add to JLIst - actually displays in GUI
        fileList.setModel(documentPaths);
        
        // Check if dummy file name present
        boolean isPlaceHolderText = true;
        if(!localDocumentList.get(0).equals(merger.placeHolderText)){
            isPlaceHolderText = false;
        }
        
        // Enable/Disable buttons
        //if 1 documents in list and it's not the dummy
        if(documentPaths.size() == 1 && !isPlaceHolderText){
            // Enable remove button
            removeEnabled = true;
            mergeEnabled = false;
        } else if(documentPaths.size() > 1){ //more than 1 file present
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
        
        if(fileList.getSelectedIndex() < documentPaths.size()){
            merger.moveFileDown(fileList.getSelectedIndex());
            updateGUI();
        }
    }//GEN-LAST:event_moveDownButtonActionPerformed

    /**
     * Select and add files to merge.
     * @param evt 
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String filePath = "";
        
        // File Chooser
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(jMenu3);
         if (returnVal == JFileChooser.APPROVE_OPTION){
            
            
            file = chooser.getSelectedFile();
            filePath = file.getAbsolutePath();
            //check if compliant with ISO 19005 \\ nonsense
//            if(!merger.isValidPDF(filePath)){
//                statusPane.setText(filePath + " is not a valid .pdf file.");
//            } else {
//                merger.addFilesToList(filePath);
//                statusPane.setText("File added: " + filePath);
//            }
            //statusPane.setText("Adding: " + filePath);
            if(!filePath.toLowerCase().substring(filePath.length()-3, 
                filePath.length()).equals("pdf") || file.length() == 0){
                statusPane.setText("File must be PDF.");
            // throw an error here
            } else {
                merger.addFilesToList(filePath);
                statusPane.setText("File added: " + filePath);
            }
         }
        // update list
        updateGUI();
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Performs functionality when remove button is pressed.
     * @param evt 
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        // Remove from List
        String filePath = merger.removeFileFromList(fileList.getSelectedIndex());
        // Inform user
        statusPane.setText("File removed: " + filePath);
        updateGUI();
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Merges PDFs into a single document, when pressed.
     * @param evt 
     */
    private void mergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeButtonActionPerformed
        
        // Open file chooser dialog
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(jMenu3);
        // Get file path
        String outputPath = chooser.getSelectedFile().toString();
        // Check if user specified that file extension is .pdf
        if(!outputPath.toLowerCase().substring(outputPath.length()-3, outputPath.length()).equals("pdf")){
            // Append .pdf to output file
            outputPath += ".pdf";
        }
        
        // Set the output path
        merger.setOutputPath(outputPath);
        // Merge the files
        merger.mergeFiles();
        // Clear documentList
        documentPaths.clear();
        // Clear merger lists
        merger.clearLists();
        // Notify user
        statusPane.setText("File written to: " + outputPath);
        // Update gui
        updateGUI();
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
            java.util.logging.Logger.getLogger(DMUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DMUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DMUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DMUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DMUserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel docCountLabel;
    private javax.swing.JList<String> fileList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mergeButton;
    private javax.swing.JButton moveDownButton;
    private javax.swing.JButton moveUpButton;
    private javax.swing.JLabel pageCountLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextPane statusPane;
    // End of variables declaration//GEN-END:variables
}
