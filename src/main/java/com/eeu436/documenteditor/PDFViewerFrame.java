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
       setSize(300,300);
       add(pdfComponent);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setBackground(Color.CYAN);
       setTitle("Viewer");
       setVisible(true);
    }
    
    public void setDocumentToView(PDDocument aDocument){
        pdfComponent.setDocumentToView(aDocument);
    }
    
    public void loadFile(String filePath){
        pdfComponent = new PDFViewerComponent();
        File aFile = new File(filePath);
        try {
            PDDocument aDocument = PDDocument.load(aFile);
            pdfComponent.setDocumentToView(aDocument);
        } catch (IOException ex) {
            Logger.getLogger(PDFViewerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        
        PDFViewerFrame frame = new PDFViewerFrame();
        String filePath = "src\\main\\resources\\testfiles\\scrypt.pdf";
        frame.loadFile(filePath);
        frame.initFrame();
        // Invoke
        
        
    }
    
}
