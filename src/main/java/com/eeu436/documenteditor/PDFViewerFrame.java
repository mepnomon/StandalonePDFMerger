package com.eeu436.documenteditor;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author D.B. Dressler
 */
public class PDFViewerFrame extends JFrame {
    PDFViewerComponent pdfComponent;
    
    /**
     * Constructs a new frame
     */
    public PDFViewerFrame(){
        
    }
    
    /**
     * Initialize a frame
     */
    public void initFrame(){
       setSize(600,800);
       pdfComponent = new PDFViewerComponent();
       add(pdfComponent);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setBackground(Color.WHITE);
       setTitle("Viewer");
       setVisible(true);
    }
    
    /**
     * Set the document to view
     * @param aDocument the document
     */
    public void setDocumentToView(PDDocument aDocument){
        // Pass document into component
        pdfComponent.setDocumentToView(aDocument);
    }
    
    /**
     * Load a pdf file.
     * @param filePath 
     */
    public void loadFile(String filePath){
        //pdfComponent = new PDFViewerComponent();
        File aFile = new File(filePath);
        try {
            PDDocument aDocument = PDDocument.load(aFile);
            pdfComponent.setDocumentToView(aDocument);
            pdfComponent.repaint();
        } catch (IOException ex) {
            Logger.getLogger(PDFViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Set the page to be viewed.
     * @param pageNum the page number.
     */
    public void setPageToView(int pageNum){
        // Set page number in component
        pdfComponent.setPageToView(pageNum);
        // Repaint
        pdfComponent.repaint();
    }
    
    /**
     * Main entry point for viewer
     * @param args 
     */
    public static void main(String[] args){
        
        PDFViewerFrame frame = new PDFViewerFrame();
        String filePath = "src\\main\\resources\\testfiles\\scrypt.pdf";
        // Invoke
        frame.initFrame();
        frame.loadFile(filePath);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PDFViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setPageToView(3);
    }
    
}
