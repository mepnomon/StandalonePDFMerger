package com.eeu436.documenteditor;

import java.awt.Component;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author D.B. Dressler
 */
public class PDFPreviewPanel extends JPanel {
    
    private static PDFPreviewPanel instance;
    PDFViewerComponent pdfComponent;
    
    /**
     * Constructs a PDF previewpanel
     */
    protected PDFPreviewPanel(){;
        // Initialize the Viewer component
        pdfComponent = new PDFViewerComponent();
        // Initialize panel constraints
        initPanel();
    }
    
    /**
     * Initializes the panel
     */
    private void initPanel(){
        setSize(135,180);
        setOpaque(true);
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
    
    /**
     * 
     * @return 
     */
    public static PDFPreviewPanel getInstance(){
        
        if(instance == null) {
            instance = new PDFPreviewPanel();
        }
      return instance;
    }
}
