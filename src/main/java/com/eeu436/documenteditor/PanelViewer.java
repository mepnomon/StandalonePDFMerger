/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeu436.documenteditor;

import javax.swing.JFrame;

/**
 *
 * @author me
 * 
 */
public class PanelViewer extends JFrame {
    
    PDFPreviewPanel panel;
    public PanelViewer(){
        panel = new PDFPreviewPanel();
        setSize(200,200);
        System.out.println(getSize());
        add(panel);
        System.out.println(panel.getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        PanelViewer viewer = new PanelViewer();
        
    }
}
