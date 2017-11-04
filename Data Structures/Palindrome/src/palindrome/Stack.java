/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author Ahmad Saad
 */
/*
 * Implement a reference based stack
 */
public class Stack<E> {
	
	private Node<E> top;

	public Stack() {
		this.top =null;
	}
	
	
	/*
	 * places element on the top of the stack
	 */
	public void push(E element){
            Node<E> temp = new Node<>(element);
            temp.next = top;
            top = temp;
	}
	
	/*
	 * remove the top node and return its contents
	 */
	public E pop(){
		
                E retval= top.item;
                top = top.next;
		return retval;
        }
	
	/*
	 * Look at the top element of the Stack and return it, without removing
	 */
	public E peek(){
		return top.item; //replace
	}
	
	public boolean empty(){
            return(top== null);
        }
}
