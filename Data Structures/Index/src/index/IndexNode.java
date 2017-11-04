/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

/**
 *
 * @author Ahmad Saad
 */
import java.util.*;
public class IndexNode {
    
    String word;
    int frequency;
    List<Integer> list;
    IndexNode left;
    IndexNode right;

    public IndexNode(String word, int lineNum) {
        list = new ArrayList<Integer>();
        this.word = word;
        this.frequency = 1;
        list.add(lineNum);
        }
    public String toString(){
        return word + ", " + frequency + ", " + list;
    }
    
}
