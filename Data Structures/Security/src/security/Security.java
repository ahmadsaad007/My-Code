/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import java.net.URL;
import java.util.*;

/**
 *
 * @author Ahmad Saad
 */
public class Security {

    /**
     * @param args the command line arguments
     */
    
    public static List Khans(Graph<String,Integer> g){
        
        List<String> list = new LinkedList<>();//empty list
        Queue<String> set = new LinkedList<>();//set to contain vertices with no incoming edges
        
        for(String s : g.getVertices()){
            if(g.getInEdges(s).isEmpty()){
                set.offer(s);//starting vertice
            }
        }
       
        while(!set.isEmpty()){
            
            String n = set.poll();
            list.add(n);
            
            for(String m: g.getVertices()){
            
                if(g.findEdge(n, m) != null){
                    
                    g.removeEdge(g.findEdge(n, m));
                    if(g.getInEdges(m).isEmpty()){
                        set.offer(m);
                    }
                }
            }
        }
        return list;  
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //Read file from the internet
        try{
            
            Graph<String,Integer> g = new DirectedSparseGraph<String,Integer>();
            
            URL url = new URL("https://projecteuler.net/project/resources/p079_keylog.txt");
            Scanner sc = new Scanner(url.openStream());
            int i = 1;
            
            while(sc.hasNextLine()){
                
                String s = sc.nextLine();

                String s0 = "" + s.charAt(0);
                String s1 = "" + s.charAt(1);
                String s2 = "" + s.charAt(2);
                
                if(g.findEdge(s0, s1) == null){
                    g.addEdge(i, s0, s1);
                    i++;
                }
                if(g.findEdge(s1, s2) == null){
                    g.addEdge(i, s1, s2);
                    i++;
                }

            }
            System.out.println("graph: "+ g);
            System.out.println(" " + Khans(g));
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
    }
    
}
