/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeu436.documenteditor;

/**
 * Test Harness for document editor
 * @author D.B. Dressler
 */
public class DocumentEditorTest {
    
   /**
    * Main entry point for program.
    * @param args 
    */
    public static void main(String[] args){
        
        // file paths
        String filePath = "C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\BSC_CS_Degree_DDressler.pdf";
        // new editor
        DocumentEditor editor = new DocumentEditor();
        // add an item
        editor.addFilesToList(filePath);
        // list the items
        for(String s : editor.getList()){
            System.out.println(s);
        }
    }
}
