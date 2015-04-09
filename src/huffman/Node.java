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
public class Node {
    
        private int Size;
        private boolean isLeaf;
        private Node Parent;
        private String info;
        private int pathToparent;
        private Node left;
        private Node right;

    public String info() {
        if(isLeaf){
        return info;
        }else{
        return "-1";
        }
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Node isParent() {
        return Parent;
    }

    public int getSize() {
        return Size;
    }

    public int isPathToparent() {
        if(!Parent.equals(this)){
        return pathToparent;}
        else{
        return -1;
        }
    }

    public boolean isIsLeaf() {
        return isLeaf;
    }
    //Constructure untuk buat leaf
    public Node(int Size, boolean isLeaf, String info) {
        this.Size = Size;
        this.isLeaf = isLeaf;
        this.Parent = this;
        this.info = info;
    }
    //Constructure untuk buat inner Node
    public Node(int Size, boolean isLeaf,Node right,Node left) {
        this.Size = Size;
        this.isLeaf = isLeaf;
        this.Parent = this;
        this.right=right;
        this.left=left;
        
    }
    //constructure untuk iner Node dari binerstring ke pohon
    public Node(boolean isLeaf){
    this.isLeaf = isLeaf;
    //constructure untuk leaf dari binerstring ke pohon
    }public Node(boolean isLeaf,String info){
    this.isLeaf = isLeaf;
    this.info = info;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    //untuk Union 2 Node ke sebuah parent baru dengan total size anaknya
    public Node Union(Node A,Node B){
        if(A.Parent.equals(this) && B.Parent.equals(B)){
            Node res;
            if(A.Size < B.Size){
                
                A.pathToparent = 1;
                B.pathToparent = 0;
                 res = new Node(A.Size+B.Size,false,A,B);
            }else if(A.Size == B.Size){
                if(!    A.isIsLeaf()){
                A.pathToparent = 1;
                B.pathToparent = 0;
                 res = new Node(A.Size+B.Size,false,A,B);
                }else{
                A.pathToparent = 0;
                B.pathToparent = 1;
                 res = new Node(A.Size+B.Size,false,B,A);
                }
            
            }
            else
            {
                A.pathToparent = 0;
                B.pathToparent = 1;
                 res = new Node(A.Size+B.Size,false,B,A);
            }
            
            A.Parent = res;
            B.Parent = res;
            return res; 
       }
    
    return null;
    }
    
        
        
}
