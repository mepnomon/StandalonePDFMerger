package com.eeu436.documenteditor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.PageDrawer;
/**
 *
 * @author D.B. Dressler
 */
public class PDFViewerComponent extends JComponent{
    
    // Global variables
    PageDrawer drawer;
    PDFRenderer aRenderer;
    PDPage aPage;
    int pageNum;

        
    /**
     * Constructs a PDFViewerComponent with parameters
     * @param aDocument 
     */
    public PDFViewerComponent(PDDocument aDocument){
        pageNum = 0;
    }
    
    public PDFViewerComponent(){
        pageNum = 0;
    }
    
    /**
     * 
     * @param aDocument 
     */
    public void setDocumentToView(PDDocument aDocument){
        aRenderer = new PDFRenderer(aDocument);
    }
   
    /**
     * 
     * @param pageNum 
     */
    public void setPageToView(int pageNum){
        this.pageNum = pageNum;
    }
    

    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g; //downcasting
        
        // Check if document is loaded

   
        try {
            aRenderer.renderPageToGraphics(0, g2);
        } catch (IOException ex) {
            Logger.getLogger(PDFViewerComponent.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }
    
    
}
