/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author FIRMAN
 */
public class Controler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       // cara bikin Pohon
       Huffman man = new Huffman();
       Node root;
       IOfile IO = new IOfile("C:\\Users\\FIRMAN\\Desktop\\2.mp4");
       // bikin tree
       root =man.getPohon(IO.GetAllLeaf());
       // tree ke binary form
       String Pohon = man.ByteTree(root);
       // string ke tree
       root = man.StringtohuffmanTree(Pohon);
       //root ke index Compress
       // index1.get("nilai hex dalam int") nanti return string huffmannya
       ArrayList<String> index1 = man.IndexHuffmanComp(root);
       
       //root ke index Compress
       // index2.get("nilai biner hufman dalam int") nanti return String asalnya
       ArrayList<String> index2 = man.IndexHuffmanComp(root);
       
       
    }
    
}
