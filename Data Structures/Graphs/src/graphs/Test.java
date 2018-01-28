/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

/**
 *
 * @author Ahmad Saad
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
        g.addEdge("Edge-B", 2, 3);
        // Let's see what we have. Note the nice output from the
    // SparseMultigraph<V,E> toString() method
      System.out.println("The graph g = " + g.toString());
    }
    
}
