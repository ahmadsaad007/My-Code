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
import java.util.HashSet;
import java.util.List;

public class Duplicates {
    public void removeDuplicates(List list){
        
        HashSet set = new HashSet();
        for(int i = 0; i < list.size(); i++){
            set.add(list.get(i));
        }
        System.out.println(set);
    }
}
