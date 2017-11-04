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
import java.util.*;
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        Stack st = new Stack();
        Queue que = new Queue();
        String rev = ""; //stores all palindromes in reverse order
        
        for(int a =0 ; ; a++){
           //infinite loop which terminates only when the user inputs quit
            System.out.println("Enter a String you want to check for palindrome"+
                    " or else enter quit to quit");
            String s = sc.nextLine();
            String s2 = s; // preserving the original string by creating a replica
            s = s.toLowerCase();//converting the string to lower case
            
            if(s.equals("quit")){
                System.out.println("You printed quit. All palindromes entered are "+ rev); //printing all palindromes in reverse order
                System.exit(0);
            }
            
            s = s.replaceAll("[^a-zA-Z]", "");//removing punctuations
            s = s.replaceAll(" ", "");//removing white spaces
            
            
            for(int j=0; j< s.length(); j++){
                    
                    st.push(s.charAt(j)); //adding to stack
                    que.enqueue(s.charAt(j)); //adding to queue
            }
            
            boolean k = false; 
            for(int i = 0; i < s.length(); i++){
                while(!st.empty()){
                    Object obj1 = st.pop(); //top item in stack
                    Object obj2 = que.dequeue(); //first item in queue
                    
                    if(!obj2.equals(obj1)){
                        k = false;
                    }
                    else{
                        k = true;
                    }
                } 
            }
            
            if(k){  
                rev = s2 + ", " + rev;
                System.out.println(s2 +" is a Palindrome");
            }
            else
                System.out.println( s2 + " is NOT a Palindrome");
        }   
    }
}