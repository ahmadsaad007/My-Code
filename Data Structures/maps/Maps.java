/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

/**
 *
 * @author Ahmad Saad
 */
import java.util.*;
import java.io.*;

public class Maps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> linemap = new HashMap<>();
        
        
        List<Integer> list1 = new ArrayList<>();
        
        String file = "C:\\Users\\Ahmad Saad\\Documents\\NetBeansProjects\\Index\\pg100.txt";
        try{
          
            Scanner sc = new Scanner(new File(file));
            int lineNum = 0;
            
            while(sc.hasNextLine()){
                
                String line = sc.nextLine();
                //System.out.println(line);
        
                String []words = line.split("\\s+"); 
                lineNum++;
                
                for(String word : words){
                    word = word.replaceAll("[^a-zA-Z]","");
                    
                    if(map.containsKey(word)){
                        int frequence = map.get(word);
                        map.put(word, frequence + 1);
                        linemap.get(word).add(lineNum);
                    }
                    else{
                        map.put(word, 1);
                        List<Integer> list2 = new ArrayList<>();
                        list2.add(lineNum);
                        linemap.put(word, list2);
                        
                    }
                    
                }
            }
            sc.close();            
        }
        catch(FileNotFoundException e){
            System.out.println("Error 404: File Not Found");
        }
        List<String> list = new ArrayList<>(map.keySet());
        for(String s : list){
            System.out.println(s + ", " + map.get(s) + ", " + linemap.get(s));
        }
        
        //System.out.println(map.get("asd") + ", " + linemap.get("asd"));
    }
    
}
