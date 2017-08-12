package com.eeu436.documenteditor;
//imports
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
        
    }
    
    
    /**
     * Removes a page from a document.
     * @param pageNum 
     */
    public void removePageFromDocument(int pageNum){
        //TODO: write code
    }
    
    /**
     * Inserts a page or multiple pages into a document
     * @param splitIndex
     * @param insertPages
     */
    public void insertPageToDocument(int splitIndex, PDDocument insertPages){
        //TODO: write code
    }
    
    /**
     *
     * @param splitIndex
     */
    public void splitDocument(int splitIndex){
        //TODO: write code   
    }
    
    /**
     * Convert a .docx to a pdf
     */
    public void convertDocumentToPDF(){
        //TODO: write code   
    }
    
    /**
     * Previews a document.
     */
    public void previewMergedDocument(){
        //TODO: write code   
        //just for testing
        int element = 0;
        super.getDocumentNameFromList(element);
        
        /**
         * local class
         */
        class ShowPanel extends JPanel{
             
        }
    }
}
