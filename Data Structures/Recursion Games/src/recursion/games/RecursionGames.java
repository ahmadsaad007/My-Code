/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.games;

/**
 *
 * @author Ahmad Saad
 */
import java.util.*;
public class RecursionGames<E>{

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]){
        
        //int a[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of board: ");
        int n = sc.nextInt();
        Chess ob = new Chess();
        ob.setBoard(n);
        ob.solve(0);
        ob.print();
        
        
    }    
    
    
}
