/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.io.*;
import java.util.*;

/**
 *
 * @author Ahmad Saad
 */
public class IndexTree {
    /**
     */
    public static IndexNode root;

    public IndexTree() {
        this.root = null;
    }

    public void add(String word, int lineNumber){
        this.root = add(this.root, word, lineNumber);
    }
    private IndexNode add(IndexNode root, String word, int lineNumber){
        
        if(root == null){
            return new IndexNode(word, lineNumber);
        }
        
        else if(word.compareTo(root.word)==0){
            root.frequency++;
            root.list.add(lineNumber);
            return root;
        }
        
        else if(word.compareTo(root.word)<0){
            root.left = add(root.left, word, lineNumber);
            return root;
        }
        
        else{
            root.right = add(root.right, word, lineNumber);
            return root;
        }
    }
    public boolean contains(String word){
        return contains(this.root, word); 
    }
    private boolean contains(IndexNode root, String word){
        if(root==null) {
            return false;
	}
	if(word.compareTo(root.word) == 0) {
            return true;
	} else if(word.compareTo(root.word) < 0) {
            return contains(root.left, word);
	} else {
            return contains(root.right, word);
	}
    }
    public void delete(String word){
        this.root = delete(this.root, word);
    }
    
    private IndexNode delete(IndexNode root, String word){
        
        if(root == null)
            return null;
        
        if(word.compareTo(root.word)< 0){
            root.left = delete(root.left, word);
            return root;
        }
        
        else if(word.compareTo(root.word) > 0){
            root.right = delete(root.right, word);
            return root;
        }
        
        else{
        
            if(root.left == null && root.right == null)
                return null;
            
            else if(root.left == null && root.right != null)
                return root.right;
            
            else if(root.left != null & root.right == null)
                return root.left;
            
            else{
                
                if(root.left.right == null){
                    IndexNode pred = root.left;
                    pred.right = root.right;
                    return pred;
                }
            
                else{        
                    IndexNode parent = root.left;
                    IndexNode pred = parent.right;
                    
                    while(pred.right != null){
                        pred = pred.right;
                        parent = parent.right;
                    }
                    
                    root.word = pred.word;
                    root.frequency = pred.frequency;
                    root.list = pred.list;
                    parent.right = pred.left;
                    return root;
                }
            }
        }
    }
    public void printIndex(){
        printIndex(this.root);
    }
    private void printIndex(IndexNode root){
        if(root == null)
            return;
        printIndex(root.left);
        System.out.printf("%s", root);
        System.out.println("");
        printIndex(root.right);
    }
    
    public static void main(String[] args) {
        
        IndexTree ob = new IndexTree();
        
        int lineNum = 0;
        String file = "C:\\Users\\Ahmad Saad\\Documents\\NetBeansProjects\\Index\\pg100.txt";
        try{
          
            Scanner sc = new Scanner(new File(file));
            while(sc.hasNextLine()){
                
                String line = sc.nextLine();
                //System.out.println(line);
                lineNum++;
                String []words = line.split("\\s+"); 
                for(String word : words){
                    word = word.replaceAll("[^a-zA-Z]","");
                    //System.out.println(word);
                    ob.add(word,lineNum);
                }
            }
            sc.close();            
        }
        catch(FileNotFoundException e){
            System.out.println("Error 404: File Not Found");
        }
        
        ob.printIndex();
        //Prints it in the form:  word, frequency, list of line numbers
        ob.delete("to");
        ob.delete("thy");
        ob.delete("yonder");
        ob.printIndex();
        ob.contains("shall");
    }    
}
