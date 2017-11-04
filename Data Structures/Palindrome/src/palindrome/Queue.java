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
public class Queue<E> {
	
	private Node<E> front;
	private Node<E> back;

	public Queue() {
		this.front = null;
		this.back  = null;
	}
	
	
	/*
	 * places element in the back of the Queue
	 */
	public void enqueue(E element){
		Node<E> n = new Node<>(element);
                
                if(empty()){
                    back = n;
                    front = n;
                }
                else{
                    back.next = n;
                    back = n;
                }
	}
	
	/*
	 * remove the front node of the queue and return it
	 */
	public E dequeue(){
            E retval = front.item;
            if(front.next == null){ 
                back = null;
                front = null;
            }
            else
                front = front.next;
            return retval;
        }
	
	/*
	 * Look at the front of the queue and return it, without removing
	 */
	public E peek(){
		
		return front.item; 
	}
	
	public boolean empty(){
            return(front == null);
	}

}
