/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1.guessing.game;

import java.util.*;

public class Assignment1GuessingGame {

    
    public static void main(String[] args) {
        // TODO code application logic here
      
        ArrayList <Integer> list = new ArrayList<Integer>(); //creating arraylist
        ArrayList<Guess> guesses = new ArrayList<Guess>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Here is a sequence of numbers that follow the rule: "+"\n"+ 
                "2 4 6");
        for(int i = 0; ; i++){ 
            //an infinite loop which breaks when the conditions are met
        System.out.println("Enter a sequence of three numbers separated by space"
                + "or else type 'answer' to guess the rule or 'previous' to "
                + "get the previous guesses ");
        
        String choice = sc.nextLine(); //to get the input from the user
        
        if(choice.equalsIgnoreCase("answer")){
        
            System.out.println("Guess the rule: ");
            String rule = sc.nextLine();
            System.out.println("The correct rule is: Every proceeding number is"
                    + " 2 larger than the previous number");
            break; //exit the loop if the user enters 'answer'
        }
        
        else if(choice.equalsIgnoreCase("previous")&& i!= 0){
            System.out.println(guesses);//printing the previous guesses
            
        }
           
        else{
            try{
                String numbers[] = choice.split(" ");
                int integers[] = new int[numbers.length];

                for(i=0; i<numbers.length;i++){
                    integers[i] = Integer.parseInt(numbers[i]);/*parsing the 
                    string and storing it into an integer array*/
                }
                boolean f;/*boolean value to denote whether the sequence follows
                the rule or not. Results in true if it follows and false if it doesn't*/
                if(integers[0]!=(integers[1]-2)&&(integers[0]!=integers[2]-4)){
                    System.out.println("No it does not follow the rule");
                    f = false;
                }
                else{
                    System.out.println("Yes! It follows the rule");
                    f = true;
                }

                Guess g = new Guess(integers[0],integers[1], integers[2], f);
                guesses.add(g);
            }
            catch(Exception e){
                System.err.println("You made an error!");
            }
        }
        
           
      }
    }
    
}
