package com.eeu436.documentmerger;

/**
 * Test Harness for Document Merger
 * @author D.B. Dressler
 */
public class DocumentMergerTest {
    
    public static void main(String[] args){
        
        System.out.println("Testing Document Merger:\n\n");
        
        DocumentMerger merger = new DocumentMerger();
        String file1 = "C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\BSC_CS_Degree_DDressler.pdf";
        String file2 = "C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\Certificates Dorian Dressler.pdf";
        //String file3 = "C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\Page_9.pdf";
        //String file4 = "C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\Page_10.pdf";
        merger.addFilesToList(file1);
        merger.addFilesToList(file2);
        //merger.addFilesToMerge(file3);
        //merger.addFilesToMerge(file4);
        merger.setOutputPath("C:\\Users\\Mepnomon\\Desktop\\DocumentMerger\\DDressler_Diplomas.pdf");
        System.out.println("Total pages: " + merger.getTotalPages());
        merger.displayDocumentList();
        merger.mergeFile();
        System.out.println("Total pages after fileWrite: " + merger.getTotalPages());
    }   
}
