/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author FIRMAN
 */
public class IOfile {
        
        private final  InputStream inputStream;

    public IOfile(String Url) throws FileNotFoundException {
        this.inputStream = new FileInputStream(Url);
    }
         
      // note cara in ke lambatan cari cara lain riki  
       private  int[] HexStream() throws IOException{
        long streamPtr=0;
       // int buat naro  hitungan 
        int []Ptr =new int[256];
        for(int i=0;i<256;i++){
           Ptr[i] = 0;
    }
        while (inputStream.available() > 0) { 
           
               Ptr[inputStream.read()]++;               
    }
            return Ptr;
       }

    //Method untuk mendapatkan Leaf Untuk hufmman
    public Node[] GetAllLeaf() throws IOException {
        ArrayList<Node> res = new ArrayList<Node>();
        int[] Count = HexStream();
        for(int i=0;i<256;i++){
           if(Count[i] != 0){
               res.add(new Node(Count[i],true,Integer.toBinaryString(i)));
           }
    }
    return  (Node[])res.toArray();
    }
    
    
    
}
