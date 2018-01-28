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

public class StackedQueue<E> {
    Stack<E> a;
    Stack<E> b;

    public StackedQueue() {
        this.a = new Stack();
        this.b = new Stack(); //acts as queue
    }
    
    public void enqueue(E s){
        
        a.add(s);
            
    }
    public E dequeue(){
         if(b.isEmpty()){
             while(!a.isEmpty()){
                 b.add(a.pop());
             }
        }       
        return b.pop();
    }
    public void print(){
        
        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i)+", ");
        }
        for (int i = 0; i < a.size(); i++) {
            if(i!= a.size()-1)
                System.out.print(a.get(i)+ ", ");
            else
                System.out.println(a.get(i));
        }
        System.out.println("");
    }
}
