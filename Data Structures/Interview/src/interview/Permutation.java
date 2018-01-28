/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview;

import java.util.*;

/**
 *
 * @author Ahmad Saad
 */
public class Permutation {
    
    public boolean check(String s1, String s2){
       
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2)
            return false;
            else{
            for (int i = 0; i < l1; i++) {

                if(map1.containsKey(s1.charAt(i))){
                    int freq  = map1.get(s1.charAt(i));
                    map1.put(s1.charAt(i), freq+1);
                }
                else{
                    map1.put(s1.charAt(i), 1);
                }

                if(map2.containsKey(s2.charAt(i))){
                    int freq = map2.get(s2.charAt(i));
                    map2.put(s2.charAt(i), freq + 1);
                }
                else{
                    map2.put(s2.charAt(i), 1);
                }
            }
            for (char y : map1.keySet())
            {
                if (!map2.containsKey(y)) {
                    return false;
                }
            }
            for (char k : map2.keySet())
            {
                if (!map1.get(k).equals(map2.get(k))) {
                    return false;
                }
            } 
             
            return true;
        }
    }
}
