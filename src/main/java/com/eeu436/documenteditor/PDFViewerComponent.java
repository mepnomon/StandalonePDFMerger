package com.eeu436.documenteditor;

import java.awt.Dimension;
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
    boolean documentLoaded = false;
        
    /**
     * Constructs a PDFViewerComponent with parameters
     * @param aDocument 
     */
    public PDFViewerComponent(PDDocument aDocument){
        documentLoaded = true;
        aRenderer = new PDFRenderer(aDocument);
        pageNum = 0;
    }
    
    /**
     * Constructs a PDFViewer Component.
     */
    public PDFViewerComponent(){
        pageNum = 0;
    }
    
    /**
     * Set the document to be viewed.
     * @param aDocument 
     */
    public void setDocumentToView(PDDocument aDocument){
        documentLoaded = true;
        aRenderer = new PDFRenderer(aDocument);
    }
   
    /**
     * Sets the page to be viewed.
     * @param pageNum 
     */
    public void setPageToView(int pageNum){
        this.pageNum = pageNum;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(135, 180);
    }
    
    /**
     * Paint Component override.
     * @param g graphics engine
     */
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g; //downcasting
        if(documentLoaded){
            try {
                aRenderer.renderPageToGraphics(pageNum, g2, .25f);
                //aRenderer.renderPageToGraphics(pageNum, g2, TOP_ALIGNMENT);
            } catch (IOException ex) {
                Logger.getLogger(PDFViewerComponent.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        } else {
            
            g2.drawString("Select a document.", 0, 0);
        }
    }   
}
