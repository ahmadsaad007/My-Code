
package recursion.games;

/**
 *
 * @author Ahmad Saad
 */
import java.util.*;

public class TowersOfHanoi {
    /*idea taken from: www.sanfoundry.com/ */
    public static Stack<Integer>[] peg = new Stack[4];//using stack array
    public static int N;//number for disks
    
    public static void fill(int n){
        for(int i= n; i>0; i--){
            peg[1].push(i);
        }
        N = n;
        System.out.println("OriginL Stack:");
        print(peg[1]);
        //Hanoi(n,1,2,3);
        
    }
 
    public static void Hanoi(int n, int pg1, int pg2, int pg3){
      
        if(n>=1){
            
            Hanoi(n-1,pg1, pg3, pg2);
            int d = peg[pg1].pop();
            peg[pg3].push(d);
            System.out.println("Move: \nFirst stack:");
            print(peg[1]);
            System.out.println("\nSecond stack:");
            print(peg[2]);
            System.out.println("\nThird stack:");
            print(peg[3]);
            
            Hanoi(n-1, pg2, pg1, pg3);

        }
        
    }
    public static void print(Stack a){
        Stack<Integer> c = a;
        //System.out.println("\n");
        for(int i = 0; i < c.size(); i++){
            System.out.print(c.get(i)+">>");
        }
        System.out.println("");
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of discs you want: ");
        int n = sc.nextInt();
        //TowersOfHanoi obj = new TowersOfHanoi();
        peg[1] = new Stack<Integer>();
        peg[2] = new Stack<Integer>();
        peg[3] = new Stack<Integer>();
        fill(n);
        
        Hanoi(n, 1, 2, 3);
    }
}

