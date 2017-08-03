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
    private ArrayList<PDDocument> documentList;
    private ArrayList<String> documentNames;
    private PDDocument outputDocument;
    private String outputPath = null;
    final String PLACEHOLDER_TEXT = "Your documents will appear in this list...";
    
   
    /**
     * Constructs a new DocumentMerger.
     */
    public DocumentMerger(){
        // Stores actual documents
        documentList = new ArrayList<>();
        // Stores names of documents
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
        
        // If document lst is empty
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
            documentList.add(localDocument);
            documentNames.add(filePath);
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
        
        String retVal = documentNames.get(index);
        PDDocument temp = documentList.get(index);
        try {
            temp.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentMerger.class.getName()).log(Level.SEVERE, null, ex);
        }
        documentList.remove(index);
        documentNames.remove(index);
        return retVal;
    }
    
    /**
     * Get list of document names, used for GUI.
     * @return a list of documents to merge
     */
    public ArrayList<String> getList(){
       
        // If no documents in list, return placeholder
        if(documentNames.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(PLACEHOLDER_TEXT);
            return temp;
        }
        // Return the list of filepaths
        return documentNames;
    }
    
    /**
     * Moves a file up in the list.
     * @param index 
     */
    public void moveFileUp(int index){
        
        // Ensure that that index is not 0
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

        // Ensure that index is not out of bounds
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
    
    /**
     * Number of documents present.
     * @return the number of documents.
     */
    public int getDocumentCount(){
        return documentNames.size();
    }
      
    //ISO 19005 VALIDATION tools... not necessary
    /**
     * Uses PDFBox PreFlight to check if PDF is compliant with
     * ISO-19005
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
        
        try{
            File preflightFile = new File(filePath);
            PreflightParser parser = new PreflightParser(preflightFile);
            parser.setLenient(true);
            parser.parse();
            try(PreflightDocument document = parser.getPreflightDocument()){
                document.validate();
                ValidationResult result = document.getResult();
                return Optional.of(result);
            }
        } catch(IOException ex){
            System.out.println("Error no file");
            return Optional.empty();
        }
    }
}
