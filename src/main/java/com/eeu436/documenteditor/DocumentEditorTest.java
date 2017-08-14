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
        String filePath = "src\\main\\resources\\testfiles\\China Visa Fees.pdf";
        // new editor
        DocumentEditor editor = new DocumentEditor();
        // add an item
        editor.addFilesToList(filePath);
        // list the items
        printList(editor);
        // Add multi-page document
        filePath = "src\\main\\resources\\testfiles\\scrypt.pdf";
        editor.addFilesToList(filePath);
        printList(editor);
        // Get the page count
        System.out.println("Pages: " + editor.getTotalPages());
        System.out.println("Docs: " + editor.getDocumentCount());
        // Remove a page from a file
        editor.removePageFromDocument(1, 2);
        // Get the page count
        System.out.println("Pages: " + editor.getTotalPages());
        System.out.println("Docs: " + editor.getDocumentCount());
        printList(editor);
        // add degree to the 2nd page of the document
        editor.insertPageToDocument(1, 2, editor.getDocumentFromDocumentList(0));
        System.out.println("Pages: " + editor.getTotalPages());
        System.out.println("Docs: " + editor.getDocumentCount());
        // needs a path
        editor.setOutputPath("src\\main\\resources\\testfiles\\output.pdf");
        editor.mergeFiles();
    }
    
    static void printList(DocumentEditor editor){
        for(String s : editor.getList()){
            System.out.println(s);
        }
    }
}
