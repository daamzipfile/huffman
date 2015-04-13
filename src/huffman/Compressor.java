/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author RickyWahyudi
 */
public class Compressor {

    byte[] data;

    public int[] readData(String fileNama) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("C:/" + fileNama, "r");
        byte b;
        byte[] isi = new byte[(int) raf.length()];

        raf.read(isi, 0, (int) raf.length());
        data = isi;
        int[] array=new int[257];
        for(int i=1;i<257;i++){
            array[i]=0;
        }
        for(int i=0;i<data.length;i++){
            array[Byte.toUnsignedInt(data[i])]++;
        }
        int a=0;
        return array;
    }
    
    
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nama = sc.next();
        Compressor cs = new Compressor();
       
        Huffman man = new Huffman();
       Node root;
       
       root =man.getPohon(cs.GetAllLeaf(nama));
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
    
     public Node[] GetAllLeaf(String namaFile) throws IOException {
        
        ArrayList<Node> res = new ArrayList<Node>();
        int[] Count = this.readData(namaFile);
        for(int i=0;i<257;i++){
           if(Count[i] != 0){
               res.add(new Node(Count[i],true,Integer.toBinaryString(i)));
           }
    }
        Node[] array=(Node[])res.toArray();
    return  array;
    }

}
