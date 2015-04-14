/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    int[] huffman;

    public int[] readData(String fileNama) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("C:/" + fileNama, "r");
        byte b;
        byte[] isi = new byte[(int) raf.length()];

        raf.read(isi, 0, (int) raf.length());
        data = isi;
        int[] array = new int[257];
        for (int i = 1; i < 257; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < data.length; i++) {
            
            array[(int)data[i]+128]++;
        }
        huffman = array;
        int a = 0;
        return array;
    }
    //udah nge ngompress tapi dikit banget
    public void write(ArrayList<String> index, String namaFile) {
            try {
                FileOutputStream oos = new FileOutputStream(namaFile+".mzip");
               
                String temp="";
                for(int i=0;i<data.length;i++){
                    
                 temp += index.get(data[i]+128);
                //  System.out.println(temp);
                 if(temp.length() > 8){
                     oos.write(Integer.parseInt(temp.substring(0, 8),2));
                     temp=temp.substring(9, temp.length());
                 }
                }
               
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nama = sc.next();
        Compressor cs = new Compressor();

        Huffman man = new Huffman();
        Node root;

        root = man.getPohon(cs.GetAllLeaf(nama));
        // tree ke binary form
        String Pohon = man.ByteTree(root);
        // string ke tree
        //root = man.StringtohuffmanTree(Pohon);
        //root ke index Compress
        // index1.get("nilai hex dalam int") nanti return string huffmannya
        ArrayList<String> index1 = man.IndexHuffmanComp(root);
        System.out.print(index1.get(65));

        //root ke index Compress
        // index2.get("nilai biner hufman dalam int") nanti return String asalnya
        ArrayList<String> index2 = man.IndexHuffmanComp(root);
        cs.write(index1, nama);
        /**
        Node[] X = new Node[10];
        Huffman man = new Huffman();
        for(int i=0;i<10;i++){
        
            X[i]= new Node(i+1,true,Integer.toBinaryString(i+1)); 
        }
        ArrayList<String> Z =man.IndexHuffmanComp(man.getPohon(X));
        for(int i=1 ;i<11;i++){
        
        System.out.println(Z.get(i));
        
        }
        */
    }

    public Node[] GetAllLeaf(String namaFile) throws IOException {

        ArrayList<Node> res = new ArrayList<Node>();
        int[] Count = this.readData(namaFile);
        for (int i = 0; i < 257; i++) {
            if (Count[i] != 0) {
                res.add(new Node(Count[i], true, Integer.toBinaryString(i)));
            }
        }
        Node[] array = new Node[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

}
