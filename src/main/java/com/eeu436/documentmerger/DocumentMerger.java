package com.eeu436.documentmerger;

//imported packages
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument; 


/**
 * A utility program to merge PDF documents.
 * @author D.B. Dressler
 */
public class DocumentMerger {
    
    // Global variables
    private ArrayList<PDDocument> documentList;
    private ArrayList<String> documentNames;
    private PDDocument outputDocument;
    private String outputPath = null;
    String placeHolderText = "Your documents will appear in this list...";
    
   
    /**
     * Zero parameter constructor
     */
    public DocumentMerger(){
       
        //stores documents
        documentList = new ArrayList<>();
        //store names of documents
        documentNames = new ArrayList<>();
        
    }
    
    
    /**
     * Sets the output path for the merged document.
     * @param outputPath takes a string
     */
    public void setOutputPath(String outputPath){
        
        this.outputPath = outputPath;
    }
    
    /**
     * Counts the total pages to be merged.
     * @return the total number of pages to be merged
     */
    public int getTotalPages(){
        int retVal = 0;
        
        // if document lst is empty
        if(documentList.isEmpty()){
            return 0;
        }
        
        // Aggregate number of pages
        for(PDDocument d : documentList){
            retVal += d.getNumberOfPages();
        }
        
        // Return number of pages
        return retVal;
    }
    
    /**
     * Merges supplied documents and saves them to file location.
     */
    public void mergeFiles(){
         //instantiate output document
        outputDocument = new PDDocument();
        // Add documents to output document
        for(PDDocument d : documentList){ 
            // Aggregate pages
            for(int i = 0; i < d.getNumberOfPages(); i++){
                // Append page to output document
                outputDocument.addPage(d.getPage(i));
           }
        }
        try {
            // Check if file name is valid/unique
            boolean fileNameVerified = false;
            
            // Loops until unique file name found
            while(!fileNameVerified){
                File f = new File(outputPath);
                
                // Check if the file exists
                if(f.exists() && !f.isDirectory()) {
                    
                    // Grab original file name
                    outputPath = outputPath.substring(0, outputPath.length()-4);
                    // Append this
                    outputPath += "_new.pdf";
                    // Write to log window
                    System.out.println(outputPath);

                } else { // unique file name found
                    // End loop
                    fileNameVerified = true;
                }
            }
            // Write to file
            outputDocument.save(outputPath);
            
            // Close writer
            outputDocument.close();
            
            // Close all documents in list, PDFBox will flag error if not.
            for(PDDocument d : documentList){
                d.close();
            }
            
            // Clear lists
            documentList.clear();
            documentNames.clear();
       
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Add a PDF file to merge
     * @param filePath the file's path
     */
    public void addFilesToList(String filePath){
        //add to a new file
        File file = new File(filePath);
        try {
            // 
            PDDocument localDocument = PDDocument.load(file);
            // 
            documentList.add(localDocument);
            documentNames.add(filePath);
        } catch (IOException ex) {
            
            Logger.getLogger(DocumentMerger.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Removes a file from the edocumentList.
     * @param index 
     */
    public String removeFileFromList(int index){
        
        String retVal = documentNames.get(index);
        documentList.remove(index);
        documentNames.remove(index);
        return retVal;
    }
    
    /**
     * Get list of document names, used for GUI.
     * @return a list of documents to merge
     */
    public ArrayList<String> getList(){
       
        if(documentNames.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(placeHolderText);
            return temp;
        }
        
        return documentNames;
    }
    
    /**
     * Moves a file up in the list.
     * @param index 
     */
    public void moveFileUp(int index){
        //TODO: Add code
        if(index > 0){
            String name1 = documentNames.get(index);
            PDDocument doc1 = documentList.get(index); 
            String name2 = documentNames.get(index-1);
            PDDocument doc2 = documentList.get(index-1);
            documentNames.set(index-1, name1);
            documentList.set(index-1, doc1);
            documentNames.set(index, name2);
            documentList.set(index, doc2); 
        }
    }
    
    /**
     * Moves a file down in the list.
     * @param index 
     */
    public void moveFileDown(int index){        
        //TODO: Add Code
        // account for actual document List
        if(index < documentNames.size()){
            String name1 = documentNames.get(index);
            PDDocument doc1 = documentList.get(index); 
            String name2 = documentNames.get(index+1);
            PDDocument doc2 = documentList.get(index+1);
            documentNames.set(index+1, name1);
            documentList.set(index+1, doc1);
            documentNames.set(index, name2);
            documentList.set(index, doc2);
        }
    }
    
    /**
     * Displays the list of documents.
     */
    public void displayDocumentList(){
        
        // test whether empty
        for(String s : documentNames){
            System.out.println(s);
        }
    }
    
    /**
     * Get a document name at a specified index.
     * @param index the index
     * @return A document name.
     */
    public String getElementFromDocumentList(int index){
        
        // return document name at index
        return documentNames.get(index);
    }
    
    /**
     * Clears the files from memory.
     */
    public void clearLists(){
        
        documentNames.clear();
        documentList.clear();
    }
}
