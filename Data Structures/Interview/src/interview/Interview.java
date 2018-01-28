/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview;

/**
 *
 * @author Ahmad Saad
 */
import java.util.*;

public class Interview {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        StackedQueue q = new StackedQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        //q.dequeue();
        q.dequeue();
        q.dequeue();        
        q.print();
        
        
        //checking if two strings are permutations of each other
        
        Permutation p = new Permutation();
        System.out.println(p.check("cat","tac"));
        
        //Removal of dulicates from a linked list
        
        List list = new LinkedList();
        list.add("Saad");
        list.add("Tommy");
        list.add("Luke");
        list.add("Eric");
        list.add("Saad");
        list.add("Luke");
        
        Duplicates d = new Duplicates();
        d.removeDuplicates(list);
        
        //getting the largest smallest value in a binary tree
        BinaryTree<String> tree = new BinaryTree<String>();
	tree.add("4");
	tree.add("1");
	tree.add("2");
	tree.add("7");
	tree.add("5");
	tree.add("3");
	
        System.out.println(tree.largestSmallest());
    }
    
}
