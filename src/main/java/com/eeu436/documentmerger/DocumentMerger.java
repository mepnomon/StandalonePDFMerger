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
package com.eeu436.documentmerger;

//imported packages
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.preflight.PreflightDocument;
import org.apache.pdfbox.preflight.ValidationResult;
import org.apache.pdfbox.preflight.parser.PreflightParser;



/**
 * A utility program to merge PDF documents.
 * @author D.B. Dressler
 */
public class DocumentMerger {
    
    // Global variables
    private final ArrayList<PDDocument> DOCUMENT_LIST;
    private final ArrayList<String> DOCUMENT_NAMES;
    private PDDocument outputDocument;
    private String outputPath = null;
    final String PLACEHOLDER_TEXT = "Your documents will appear in this list...";
    
   
    /**
     * Constructs a new DocumentMerger.
     */
    public DocumentMerger(){
        // Stores actual documents
        DOCUMENT_LIST = new ArrayList<>();
        // Stores names of documents
        DOCUMENT_NAMES = new ArrayList<>();
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
        
        // If document lst is empty
        if(DOCUMENT_LIST.isEmpty()){
            return 0;
        }
        
        // Aggregate number of pages
        for(PDDocument d : DOCUMENT_LIST){
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
        for(PDDocument d : DOCUMENT_LIST){ 
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
                // Create temp file
                File f = new File(outputPath);
                
                // Check if the file exists
                if(f.exists() && !f.isDirectory()) {
                    
                    // File name without file extension
                    outputPath = outputPath.substring(0, outputPath.length()-4);
                    // Append this
                    outputPath += "_new.pdf";
                } else { // unique file name found
                    // End loop
                    fileNameVerified = true;
                }
            }
            
            // Write to file
            outputDocument.save(outputPath);
            // Close document
            //outputDocument.close();
            // Close all documents in list, PDFBox will flag error if not.
            for(PDDocument d : DOCUMENT_LIST){
                d.close();
            }
            
            // Clear lists
            DOCUMENT_LIST.clear();
            DOCUMENT_NAMES.clear();
       
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Adds a PDF file to the list containing PDFs to merge.
     * @param filePath the file's path
     */
    public void addFilesToList(String filePath){
        
        // Assign retrieved file
        File file = new File(filePath);
        try {
            // Create PDDocument from file
            PDDocument localDocument = PDDocument.load(file);
            // Add to lists
            DOCUMENT_LIST.add(localDocument);
            DOCUMENT_NAMES.add(filePath);
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Removes a file from the list of documents.
     * @param index 
     * @return deleted file's name.
     */
    public String removeFileFromList(int index){
        
        String retVal = DOCUMENT_NAMES.get(index);
        PDDocument temp = DOCUMENT_LIST.get(index);
        try {
            temp.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
        }
        DOCUMENT_LIST.remove(index);
        DOCUMENT_NAMES.remove(index);
        return retVal;
    }
    
    /**
     * Get list of document names, used for GUI.
     * @return a list of documents to merge
     */
    public ArrayList<String> getList(){
       
        // If no documents in list, return placeholder
        if(DOCUMENT_NAMES.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(PLACEHOLDER_TEXT);
            return temp;
        }
        // Return the list of filepaths
        return DOCUMENT_NAMES;
    }
    
    /**
     * Moves a file up in the list.
     * @param index 
     */
    public void moveFileUp(int index){
        
        // Ensure that that index is not 0
        if(index > 0){
            String name1 = DOCUMENT_NAMES.get(index);
            PDDocument doc1 = DOCUMENT_LIST.get(index); 
            String name2 = DOCUMENT_NAMES.get(index-1);
            PDDocument doc2 = DOCUMENT_LIST.get(index-1);
            DOCUMENT_NAMES.set(index-1, name1);
            DOCUMENT_LIST.set(index-1, doc1);
            DOCUMENT_NAMES.set(index, name2);
            DOCUMENT_LIST.set(index, doc2); 
        }
    }
    
    /**
     * Moves a file down in the list.
     * @param index 
     */
    public void moveFileDown(int index){        

        // Ensure that index is not out of bounds
        if(index < DOCUMENT_NAMES.size()){
            String name1 = DOCUMENT_NAMES.get(index);
            PDDocument doc1 = DOCUMENT_LIST.get(index); 
            String name2 = DOCUMENT_NAMES.get(index+1);
            PDDocument doc2 = DOCUMENT_LIST.get(index+1);
            DOCUMENT_NAMES.set(index+1, name1);
            DOCUMENT_LIST.set(index+1, doc1);
            DOCUMENT_NAMES.set(index, name2);
            DOCUMENT_LIST.set(index, doc2);
        }
    }
    
    /**
     * Displays the list of documents.
     */
    public void displayDocumentList(){
        for(String s : DOCUMENT_NAMES){
            System.out.println(s);
        }
    }
    
    /**
     * Get a document name at a specified index.
     * @param index the index
     * @return A document name.
     */
    public String getDocumentNameFromList(int index){
        // return document name at index
        return DOCUMENT_NAMES.get(index);
    }
    
    /**
     * Replace an existing document with a new document
     * @param index the document's index
     * @param newDoc the new document to be inserted
     */
    public void setDocumentInList(int index, PDDocument newDoc){
        
//        try {
//            // Close old document
//            DOCUMENT_LIST.get(index).close();
//        } catch (IOException ex) {
//            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // Add new document
        DOCUMENT_LIST.set(index, newDoc);
    }
    
    /**
     * Get a document from the list
     * @param index the index number
     * @return a PDDocument
     */
    public PDDocument getDocumentFromDocumentList(int index){
        
        return DOCUMENT_LIST.get(index);
    }
    
    /**
     * Clears the files from memory.
     */
    public void clearLists(){
        
        DOCUMENT_NAMES.clear();
        DOCUMENT_LIST.clear();
    }
    
    /**
     * Number of documents present.
     * @return the number of documents.
     */
    public int getDocumentCount(){
        return DOCUMENT_NAMES.size();
    }
      
    //ISO 19005 VALIDATION tools... not necessary
    /**
     * Uses PDFBox PreFlight to check if PDF is compliant with
     * ISO-19005í
     * @param filePath
     * @return if pdf is ISO 19005 compliant.
     */
    public boolean isValidPDF(String filePath){
       Optional<ValidationResult> validationResult = 
               getValidationResult(filePath);
       
       if(!validationResult.isPresent()){
           return false;
       }
       
       ValidationResult result = validationResult.get();
       if(result.isValid()){
           return true;
       }
       return false;
    }
    
    /**
     * Gets a validation result
     * @param filePath
     * @return the validation result.
     */
    private Optional<ValidationResult> getValidationResult(String filePath){
        if(Objects.isNull(filePath)){
            throw new NullPointerException("filename shouldn't be null");
        }
        
        File preflightFile = new File(filePath);
        PreflightParser parser;
        try {
            parser = new PreflightParser(preflightFile);
            parser.setLenient(true);
            parser.parse();
            try(PreflightDocument document = parser.getPreflightDocument()){
                document.validate();
                ValidationResult result = document.getResult();
                return Optional.of(result);
            } catch (IOException ex) {
                Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
