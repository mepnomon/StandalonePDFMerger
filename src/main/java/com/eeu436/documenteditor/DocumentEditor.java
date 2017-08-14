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

// Imports
import com.eeu436.documentmerger.DocumentMerger;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * A class to preview and edit documents.
 * Inherits functionality from Document Merger class.
 * @author D.B. Dressler
 */
public class DocumentEditor extends DocumentMerger {
    
    
    /**
     * Constructs a new DocumentEditor
     */
    public DocumentEditor(){
        
        // super call not necessary, 0 param
    }
    
    
    /**
     * Removes a page from a document.
     * @param docIndex identifies the document
     * @param pageNum page to be removed
     */
    public void removePageFromDocument(int docIndex ,int pageNum){

        // get the document
        PDDocument tempDoc = super.getDocumentFromDocumentList(docIndex);
        
        // If only 1 page in document
        if(tempDoc.getNumberOfPages() == 1){
            // Remove the document
            super.removeFileFromList(docIndex);
        
        } else { // If more than 1 page
            
            // Remove specific page
            tempDoc.removePage(pageNum);
            
            // Return altered document to list
            super.setDocumentInList(docIndex, tempDoc);
        }
        
        try {
            // Close the temp document
            tempDoc.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Inserts a page or multiple pages into a document
     * @param docIndex identifies the document
     * @param addIndex location the new page will be added to
     * @param insertDoc the page/pages to be inserted
     */
    public void insertPageToDocument(int docIndex, int addIndex, PDDocument insertDoc){
       
        // TODO: write code
        // Retrieve main file
        PDDocument mainDoc = super.getDocumentFromDocumentList(docIndex);
        PDDocument temp = new PDDocument();
        int newDocSize = mainDoc.getNumberOfPages() + insertDoc.getNumberOfPages();
            
        int j = 0, k = 0;
        // Normal case
        for(int i = 0; i < newDocSize; i++){
            
            if(i >= addIndex && i < addIndex+insertDoc.getNumberOfPages()){
                temp.addPage(insertDoc.getPage(k));
                k++;
            } else {
                temp.addPage(mainDoc.getPage(j));
                j++;
            }
        }
        super.setDocumentInList(docIndex, temp);
    }
    
    /**
     *
     * @param docIndex
     * @param splitIndex
     */
    public void splitDocument(int docIndex, int splitIndex){
        
        // TODO: write code
        // get document
        // split document at index
        // store 1st document at old position
        // store 2nd document at old position +1
    }
    
    public void rotatePage(){
        
    }
    
    public void rotateDocument(){
        
    }
    
    /**
     * Convert a .docx to a pdf
     */
    public void convertDocumentToPDF(){
        // TODO: write code   
    }
  
    /**
     * Previews a document.
     */
    public void previewMergedDocument(){
        // TODO: write code   
        // just for testing
        int element = 0;
        super.getDocumentNameFromList(element);
        
        /**
         * local class
         */
        class ShowPanel extends JPanel{
             
        }
    }
}
