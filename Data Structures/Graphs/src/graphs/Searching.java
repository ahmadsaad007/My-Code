

package graphs;
/**
 *
 * @author Ahmad Saad
 */

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import java.util.*;

public class Searching {
    
    public static List<Edge> edge;
    
    public static <String,E> List<String> BFS(Graph<String,E> g, String start){
        
        List<String> visitOrder = new ArrayList<String>();
        Set<String>  seen = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        seen.add(start);
        queue.offer(start);
        while(!queue.isEmpty()) {
            String current = queue.poll();
            for(String neighbor : g.getNeighbors(current)) {
                if(!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            visitOrder.add(current);
        }
        return visitOrder;
    }

    public static <String,E> List<String> DFS(Graph<String,E> g, String start){
       
        Stack<String> stack =  new Stack<>();
        List<String> visitOrder = new ArrayList<>();
        Set<String>  seen = new HashSet<>();
        
        seen.add(start);
        stack.push(start);
        
        while(!stack.isEmpty()){
            String current = stack.pop();
            for(String neighbor : g.getNeighbors(current)) {
                if(!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.add(neighbor);
                }
            }
            visitOrder.add(current);
        }
        return visitOrder;
    }
    
    public static void Dijkstra(Graph<String,Edge> g, String start){
        
        Set<String> S = new HashSet<>();//computes shortest distance to
        Set<String> VS = new HashSet<>();//vertices still needed to process
        
        Map<String,Double> distance=  new HashMap<>();//contains shortest distance possible
        Map<String,String> pred=  new HashMap<>();// the predecessor node
        
        S.add(start);
        VS.addAll(g.getVertices());
        VS.remove(start);
        
           
        for(String i: VS){
            
            if(g.findEdge(start, i)!= null)
                distance.put(i, g.findEdge(start, i).weight);
            else{
                distance.put(i, Double.MAX_VALUE);
            }
            pred.put(i, start);
        }
        
        while(!VS.isEmpty()){
            //getting the vertex with the smallest distance
            double minU = Double.POSITIVE_INFINITY;
            String minV = null ;
            for (String i: VS) {
                if(minU > distance.get(i)){
                    minU = distance.get(i);
                    minV = i;
                }
            }
            
            S.add(minV);
            VS.remove(minV);
            
            for(String i: g.getNeighbors(minV)){
                
                if(VS.contains(i)){
                    
                    if((distance.get(minV)+ g.findEdge(minV, i).weight)<distance.get(i)){
                        distance.replace(i, distance.get(i), (distance.get(minV)+ g.findEdge(minV, i).weight));
                        pred.replace(i, minV);
                    }
                }
            }
        }
        
        for(String i: distance.keySet()){
            System.out.println("Vertice " + i + " distance " + distance.get(i)+ " predecesor " + pred.get(i));
        }        
    }
    
    public static void main(String[] args) {
        
        // TODO Auto-generated method stub
        Graph<String,Integer> g = new DirectedSparseGraph<String,Integer>();

        g.addEdge(1, "S", "A");
        g.addEdge(2, "S", "B");
        g.addEdge(3, "S", "C");
        g.addEdge(4, "S", "X");
        g.addEdge(5, "X", "Y");
        g.addEdge(6, "A", "D");
        g.addEdge(7, "D", "B");
        g.addEdge(8, "B", "E");
        g.addEdge(9, "E", "G");
        g.addEdge(10, "C", "F");

        System.out.println("BFS " + BFS(g, "S"));
        System.out.println("DFS "+ DFS(g, "S"));
        
        Graph<String, Edge>  g2 = new DirectedSparseGraph<>();
        
        g2.addEdge(new Edge(2), "S", "A");
        g2.addEdge(new Edge(13), "S", "B");
        g2.addEdge(new Edge(6), "S", "C");
        g2.addEdge(new Edge(2), "S", "X");
        g2.addEdge(new Edge(7), "X", "Y");
        g2.addEdge(new Edge(1), "A", "D");
        g2.addEdge(new Edge(5), "D", "B");
        g2.addEdge(new Edge(4), "B", "E");
        g2.addEdge(new Edge(9), "E", "G");
        g2.addEdge(new Edge(3), "C", "F");
        //System.out.println(g2.findEdge("S", "A"));
        
        Dijkstra(g2, "S");
        
    }  
}
