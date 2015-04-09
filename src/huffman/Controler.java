/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

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
        
    }
    
}
