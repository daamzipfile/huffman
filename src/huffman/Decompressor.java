/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author RickyWahyudi
 */
public class Decompressor {
    
    public void readFile(String filename) throws FileNotFoundException, IOException{
        String outputFileName =filename+".mzip";
        RandomAccessFile raf = new RandomAccessFile(outputFileName, "rw");
        byte [] document = new byte [ ( int) raf.length ()] ;
        raf.readFully(document);
        
    }
}
