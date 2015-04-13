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
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author RickyWahyudi
 */
public class Compressor {

    byte[] data;

    public void readData(String fileNama) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("C:/" + fileNama, "r");
        byte b;
        byte[] isi = new byte[(int) raf.length()];

        raf.read(isi, 0, (int) raf.length());
        data = isi;
    }
    public String getByte(){
        int a=data.length;
        String hasil="";
        for(int i=0;i<a;i++){
            hasil=hasil+data[a]+" ";
        }
        return hasil;
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nama = sc.next();
        Compressor cs = new Compressor();
        cs.readData(nama);
        System.out.print(cs.getByte());
    }

}
