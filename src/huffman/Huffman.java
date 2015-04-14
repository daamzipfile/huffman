/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author FIRMAN
 */
public class Huffman implements Comparator<Node> {

    private int Pointer;
    private ArrayList Indexhuffman;
    //Input Node semua leaf;
    //Output Root dari tree;

    public Node getPohon(Node[] leaf) {
        PriorityQueue que;
        que = new PriorityQueue(leaf.length, this);
        for (int i = 0; i < leaf.length; i++) {
            que.add(leaf[i]);
        }

        Node Root = null;
        Node temp = null;
        while (!que.isEmpty()) {
            Root = (Node) que.poll();
           // System.out.println(Root.getSize());
            if (!que.isEmpty()) {
                temp = (Node) que.poll();
               // System.out.println(Root.getSize() + " " + temp.getSize());
               // System.out.println(Root.isIsLeaf() + " " + temp.isIsLeaf());
                que.add(Root.Union(Root, temp));
            }
        }
        return Root;
    }
    //convert dari string  pohon ke binerpohon
    //kembalian Stringbiner 
    // input root dari pohon
    public String ByteTree(Node root) {
        String res = "0";
        res += ByteTreerec(root.getRight());
        res += ByteTreerec(root.getLeft());
        return res;
    }
// recusive ByteTree
    private String ByteTreerec(Node root) {
        
        if (root.isIsLeaf()) {
            String value;
        value = Integer.toBinaryString(Integer.parseInt(root.info(),16));
      //  System.out.println(value);
        String info="";
        for(int i=0;i<8-value.length();i++){
            info +='0';
        }
        info +=value;
            return "1" +info ;

        } else {

            return "0" + ByteTreerec(root.getRight())
                    + ByteTreerec(root.getLeft());
        }
    }

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getSize() <= o2.getSize()) {
            return -1;
        } else {
            return 1;
        }
    }
    //convert dari string biner pohon ke pohon
    //kembalian root dari pohon
    public Node StringtohuffmanTree(String bytePohon) {
 
        Pointer = 0;
        Node Root = StringtohuffmanTreerec(bytePohon);
        
        return Root;
    }
    //recusfie StringtohuffmanTree
    private Node StringtohuffmanTreerec(String bytePohon) {
        Pointer++;
        Node Root = new Node(false);
        if (bytePohon.length() > Pointer) {
            if (bytePohon.charAt(Pointer) == '1') {
               // System.out.println(Integer.parseInt(bytePohon.substring(Pointer + 1, Pointer + 9),2));
                Root.setRight(new Node(true, bytePohon.substring(Pointer + 1, Pointer + 9)));
                Pointer +=8;
            } else {

                Root.setRight(StringtohuffmanTreerec(bytePohon));

            }}
        
            Pointer++;
            if (bytePohon.charAt(Pointer) == '1') {
               // System.out.println(Integer.parseInt(bytePohon.substring(Pointer + 1, Pointer + 9),2));
                Root.setLeft(new Node(true, bytePohon.substring(Pointer + 1, Pointer + 9)));
                Pointer +=8;
            } else {

                Root.setLeft(StringtohuffmanTreerec(bytePohon));

            
        }

        return Root;

    }
    
    public ArrayList<String> IndexHuffmanComp(Node root){
            Indexhuffman =null;
            Indexhuffman = new ArrayList<String>();
           for(int i=0;i<257;i++){
           Indexhuffman.add(null);
           
           }
             IndexHuffmanrec( root.getRight(),"0");
            IndexHuffmanrec( root.getLeft(),"1");
    
    
            return Indexhuffman;
    
    
     
    
    }
    public ArrayList<String> IndexHuffmandeComp(Node root){
            Indexhuffman =null;
            Indexhuffman = new ArrayList<String>();
           for(int i=0;i<257;i++){
           Indexhuffman.add(null);
           
           }
             IndexHuffmanrec2( root.getRight(),"0");
            IndexHuffmanrec2( root.getLeft(),"1");
    
    
            return Indexhuffman;
    
    
     
    
    }
    
    
    
    
    private void IndexHuffmanrec(Node root,String Path){
        
        if(root.isIsLeaf()){
            
         Indexhuffman.set(Integer.parseInt(root.info(),2), Path );
        
        }else{
        
        IndexHuffmanrec( root.getRight(),  Path+"0");
        IndexHuffmanrec( root.getLeft(),  Path+"1");
        }
        
    }
        private void IndexHuffmanrec2(Node root,String Path){
        
        if(root.isIsLeaf()){
            
         Indexhuffman.set(Integer.parseInt(Path,2), root.info() );
        System.out.println(Path);
        }else{
        
        IndexHuffmanrec2( root.getRight(),  Path+"0");
        IndexHuffmanrec2( root.getLeft(),  Path+"1");
        }
        
    }
}
