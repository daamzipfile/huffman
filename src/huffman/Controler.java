/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

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
    public static void main(String[] args) {
        String Url="";
        IOfile IO = new IOfile(Url);
        Huffman man = new Huffman();  
        /** System.out.print(man.ByteTree(
                            man.getPohon(
                                 IO.GetAllLeaf()
                            ))); **/
        Node root =man.StringtohuffmanTree(
                        man.ByteTree(
                            man.getPohon(
                                 IO.GetAllLeaf()
                            )));
        System.out.println(man.IndexHuffmanComp(root).get(1));
        System.out.println(man.IndexHuffmanComp(root).get(2));
        System.out.println(man.IndexHuffmanComp(root).get(3));
        System.out.println(man.IndexHuffmanComp(root).get(4));
        System.out.println(man.IndexHuffmandeComp(root).get(Integer.parseInt("0",2)));
        System.out.println(man.IndexHuffmandeComp(root).get(Integer.parseInt("100",2)));
        System.out.println(man.IndexHuffmandeComp(root).get(Integer.parseInt("101",2)));
        System.out.println(man.IndexHuffmandeComp(root).get(Integer.parseInt("11",2)));
        
    }
    
}
