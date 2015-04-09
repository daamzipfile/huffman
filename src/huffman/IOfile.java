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
public class IOfile {
        String Url;
        public IOfile(String Url){
        
        
        
        
        }
    //Method untuk mendapatkan Leaf Untuk hufmman
    public Node[] GetAllLeaf(){
    //Dummy data
      Node [] test = new Node[4];
       for(int i=0 ;i<4;i++){
       test[i]=  new Node(i+1,true,Integer.toHexString(i+1));
       }
    return  test;
    }
    
    
    
}
