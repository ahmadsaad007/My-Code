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
public class Node<E> {

    E item;
    Node<E> left;
    Node<E> right;
	
    public Node(E item){
	this.item = item;
    }
	
    public String toString() {
    	return item.toString();
    }
}