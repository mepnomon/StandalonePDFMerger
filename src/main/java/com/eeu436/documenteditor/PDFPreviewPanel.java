package com.eeu436.documenteditor;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author D.B. Dressler
 */
public class PDFPreviewPanel extends JPanel {
    
    private static PDFPreviewPanel instance;
    PDFViewerComponent pdfComponent;
    String filePath = "src\\main\\resources\\testfiles\\scrypt.pdf";
    File aFile = new File(filePath);
    PDDocument test;
    
    /**
     * Constructs a PDF previewpanel
     */
    public PDFPreviewPanel(){;
        // Initialize the Viewer component
        pdfComponent = new PDFViewerComponent();
        try {
            test = PDDocument.load(aFile);
        } catch (IOException ex) {
            Logger.getLogger(PDFPreviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Initialize panel constraints
        initPanel();
    }
    
    /**
     * Initializes the panel
     */
    private void initPanel(){
        setSize(130,200);
        System.out.println(getSize());
        //setBackground(Color.red);
        //pdfComponent.setVisible(true);
        setOpaque(true);
        pdfComponent.setSize(130, 200);
        pdfComponent.setDocumentToView(test);
        System.out.println("PDFCOMP " + pdfComponent.getSize());
        add(pdfComponent);
        //TODO set layout
        setVisible(true);
    }

    /**
     * Sets the panel contents visible.
     */
    public void setPanelVisible(){
        repaint();
    }
    
    /**
     * Sets the document to view.
     * @param aDocument 
     */
    public void setDocumentToView(PDDocument aDocument){
        pdfComponent.setDocumentToView(aDocument);
        pdfComponent.repaint();
    }
    
    /**
     * Toggles the page to view.
     * @param pageNum 
     */
    public void setPageToView(int pageNum){
        // Set page number in component
        pdfComponent.setPageToView(pageNum);
        // Repaint
        pdfComponent.repaint();
    }
}
