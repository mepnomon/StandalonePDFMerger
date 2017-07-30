package com.eeu436.documentmerger;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument; 


/**
 * A utility program to merge PDF documents.
 * @author D,B. Dressler
 */
public class DocumentMerger {
    
    // Global variables
    ArrayList<PDDocument> documentList;
    ArrayList<String> documentNames;
    PDDocument outputDocument;
    String outputPath = null;
    
   
    /**
     * Zero parameter constructor
     */
    public DocumentMerger(){
        
        //instantiate output document
        outputDocument = new PDDocument();
        //stores documents
        documentList = new ArrayList<>();
        //store names of documents
        documentNames = new ArrayList<>();
        
    }
    
    
    /**
     * Sets the output path
     * @param outputPath takes a string
     */
    public void setOutputPath(String outputPath){
        
        System.out.println("Output to: " + outputPath);
        this.outputPath = outputPath;
    }
    
    /**
     * Utility method to that merges PDF files
     * @param filePath
     */
    public void addFilesToMerge(String filePath){
        
        //add to a new file
        File file = new File(filePath);
        try {
            // 
            PDDocument localDocument = PDDocument.load(file);
            // 
            documentList.add(localDocument);
            documentNames.add(filePath);
            // 
            System.out.println("Added PDF " + filePath);
        } catch (IOException ex) {
            
            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    /**
     * Counts the total pages to be merged.
     * @return the total number of pages to be merged
     */
    public int getTotalPages(){
        int retVal = 0;
        
        if(documentList.isEmpty()){
            return 0;
        }
        
        for(PDDocument d : documentList){
            retVal += d.getNumberOfPages();
        }
        //return number of pages
        return retVal;
    }
    
    /**
     * Merges supplied documents and saves them to file location.
     */
    public void outputMergedFile(){
        
        //PDFMergerUtility mergerUtil = new PDFMergerUtility();
        // 
        for(PDDocument d : documentList){ 
            // 
            for(int i = 0; i < d.getNumberOfPages(); i++){
               outputDocument.addPage(d.getPage(i));
           }
        }
        try {
            //write to file
            outputDocument.save(outputPath);
            //close writer
            outputDocument.close();
            
            // clear lists
            documentList.clear();
            documentNames.clear();
            System.out.println("Successfully written to: " + outputPath);
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Removes a file from the edocumentList.
     * @param index 
     */
    public void removeFileFromList(int index){
        
        documentList.remove(index);
        documentNames.remove(index);
        System.out.println("Deleted: " + index);
    }
    
    /**
     * Moves a file up in the list.
     * @param index 
     */
    public void moveFileUp(int index){
        //TODO: Add code
        System.out.println("Moves a file up.");
        System.out.println("implement");
    }
    
    /**
     * Moves a file down in the list.
     * @param index 
     */
    public void moveFileDown(int index){
        //TODO: Add Code
        System.out.println("Moves down.");
        System.out.println("Implement");
    }
    
    /**
     * Displays the list of documents.
     */
    public void displayDocumentList(){
        
        if(documentNames.isEmpty()){
            System.out.println("");
        }
        System.out.println("Printing file list:");
        // test whether empty
        for(String s : documentNames){
            System.out.println(s);
        }
    }
}
