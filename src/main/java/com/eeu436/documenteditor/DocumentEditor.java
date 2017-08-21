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

        // Get the document
        PDDocument tempDoc = super.getDocumentFromDocumentList(docIndex);
        
        // If only 1 page in document
        if(tempDoc.getNumberOfPages() == 1){
            // Remove the document
            super.removeFileFromList(docIndex);
        
        } else { // If more than 1 page
            
            // Remove specific page
            tempDoc.removePage(pageNum);   
            // Return altered document to list
            super.setDocumentInDocumentList(docIndex, tempDoc);
        }
    }
    
    /**
     * Inserts a page or multiple pages into a document
     * @param docIndex identifies the document
     * @param addIndex location the new page will be added to
     * @param insertDoc the page/pages to be inserted
     */
    public void insertPageToDocument(int docIndex, int addIndex, PDDocument insertDoc){
       
        // Retrieve main file
        PDDocument mainDoc = super.getDocumentFromDocumentList(docIndex);
        // Calculate new Document size
        int newDocSize = mainDoc.getNumberOfPages() + insertDoc.getNumberOfPages();
        
        // Initialize control variables
        int j = 0, k = 0;
        // Declare new document
        PDDocument temp = new PDDocument();
        // Traverse entire document
        for(int i = 0; i < newDocSize; i++){
            
            // If positions match insert document's
            if(i >= addIndex && i < addIndex+insertDoc.getNumberOfPages()){
                // insert new document
                temp.addPage(insertDoc.getPage(k));
                k++;
            } else { // insert orginal document
                temp.addPage(mainDoc.getPage(j));
                j++;
            }
        }
        // Store document
        super.setDocumentInDocumentList(docIndex, temp);
    }
    
    /**
     * Splits a document.
     * @param docIndex position of the document
     * @param splitIndex page the document is to be split on
     */
    public void splitDocument(int docIndex, int splitIndex){
        
        // TODO: write code
        PDDocument mainDocument = super.getDocumentFromDocumentList(docIndex);
        PDDocument firstDocument = new PDDocument();
        PDDocument secondDocument = new PDDocument();
        
        // ensure index > 0 < document size
        
        // Traverse all pages
        for(int i = 0; i < mainDocument.getNumberOfPages(); i++){
            
            if(i < splitIndex){ // add to first document
                firstDocument.addPage(mainDocument.getPage(i));
            } else { // add to second document
                secondDocument.addPage(mainDocument.getPage(i));
            }
        }
        
        String title = super.getDocumentNameFromList(docIndex);
        title = title.substring(0, title.length() - 4);
        System.out.println("Title: " + title);
        
        // Enumerte split documents
        int splitCount = 0;
        // do some string manipulation here
        
        // Add split documents to end of document list
        super.addDocumentToDocumentList(firstDocument);
        super.addDocumentNameInList(title + "_split_" + splitCount);
        ++splitCount;
        super.addDocumentToDocumentList(secondDocument);
        super.addDocumentNameInList(title  + "_split_" + splitCount);
    }
    
    /**
     * Rotates a single page in a document.
     * @param docIndex the document's location
     * @param pageIndex the page
     * @param rotateDeg the degrees to rotate (clockwise)
     */
    public void rotatePage(int docIndex, int pageIndex, int rotateDeg){
        
        super.getDocumentFromDocumentList(docIndex).getPage(pageIndex)
                .setRotation(rotateDeg);
    }
    
    /**
     * Rotates all pages of a document.
     * @param docIndex the document's location
     * @param rotateDeg the degrees to rotate (clockwise)
     */
    public void rotateDocument(int docIndex,int rotateDeg){
        
        int docSize = super.getDocumentFromDocumentList(docIndex).getNumberOfPages();
    
        for(int i = 0; i < docSize; i++){
            super.getDocumentFromDocumentList(docIndex).getPage(i)
                .setRotation(rotateDeg);
        }
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
