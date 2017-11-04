/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josephus;

/**
 *
 * @author Ahmad Saad
 */
import java.util.Iterator;
public class CircularLinkedList<E> implements Iterable<E> {

	// Your variables
	Node<E> head;
	Node<E> tail;
	int size;  // BE SURE TO KEEP TRACK OF THE SIZE
        
// implement this constructor
	public CircularLinkedList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index ) {
            if(index < 0 || index >= size){
                throw new ArrayIndexOutOfBoundsException(index);
            }
            Node<E> current = head;
            for(int i = 0;i<index; i++){
                current = current.next;
            }
            return current;
	}

	// attach a node to the end of the list
	public boolean add(E item) {
		this.add(size,item);
		return false;

	}

	// Cases to handle
	// out of bounds
	// adding to empty list
	// adding to front
	// adding to "end"
	// adding anywhere else
	// REMEMBER TO INCREMENT THE SIZE
	public void add(int index, E item){

            if(index<0||index>size){
                throw new ArrayIndexOutOfBoundsException(index);
            }
            Node<E> temp = new Node<E>(item);
            if(size == 0 ){
                head = temp;
                tail = temp;
                tail.next = head;
            }
            else if(index == 0){
                temp.next = head;
                tail.next = temp;
                head = temp;
            }
            else if(index == size){
                temp.next = head;
                tail.next = temp;
                tail = temp;
            }
            else{
                Node<E> nd = getNode(index-1);
                temp.next = nd.next;
                nd.next = temp;
            }
            tail.next = head;
            size++;
	}
        
	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing 
	// removing any other node
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) {
            E retval = null;
            if(index<0 || index>=size){
                throw new ArrayIndexOutOfBoundsException(index);
            }
            if(size == 1){
                retval = head.item;
                head = null;
                tail = null;
            }
            else if(index == 0){
                retval = head.item;
                head = head.next;
                tail.next = head;
            }
            else if(index == size-1){
                Node<E> node = getNode(index-1);
                retval= tail.item;
                node.next = head;
                tail = node;
            }
            else{
                Node<E> nd =  getNode(index -1);
		retval = nd.next.item;
		nd.next = nd.next.next;
            }
            size--;
            return retval;
	}
	
	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.getElement().toString();
			
		}
		else{
                    do{
			result.append(current.getElement());
			result.append(" ==> ");
                    	current = current.next;
                    } while(current != head);
		}
                return result.toString();
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}

	// provided code
	// read the comments to figure out how this works and see how to use it
	// you should not have to change this
	// change at your own risk!
	private class ListIterator<E> implements Iterator<E>{
		
		Node<E> nextItem;
		Node<E> prev;
		int index;
		
		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
                    nextItem = (Node<E>) head;
                    index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
                    return size != 0;
		}
		
		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
                    prev =  nextItem;
                    nextItem = nextItem.next;
                    index =  (index + 1) % size;
                    return prev.getElement();
		}
		
		// removed the last node was visted by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
                                
			} else{ 
				target = index - 1;
				index--;
                                
			}
                        
			CircularLinkedList.this.remove(target); //calls the above clas
            }
		
	}
    // Solve the problem in the main method
    // The answer of n = 13,  k = 2 is 
    // the 11th person in the ring (index 10)
    public static void main(String[] args){
    CircularLinkedList<Integer> ints = new CircularLinkedList<Integer>();
        int n = 100;
        int k = 7;
        for (int i = 1; i < n+1; i++) {
            ints.add(i);
        }
        
        Iterator<Integer> iter = ints.iterator();
            //System.out.println(ints);
           
       
        while(iter.hasNext()&&ints.size>1){
            for(int i=0;i< k ;i++){
                iter.next();
                if(ints.size == 1){
                    break;
                }
                if(i==k - 1){
                    iter.remove();
                    System.out.println(ints.toString()); 
                }
            }
        }
    }
}