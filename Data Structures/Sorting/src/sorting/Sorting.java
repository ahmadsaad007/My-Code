/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Ahmad Saad
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sorting {
    /**
     * @param args the command line arguments
     */
    List <Integer> list;
    
    public Sorting(List list){
        
        this.list = list;
    }
    public long insertionSort(){
               
        int compar = 0;
        int ex = 0;
        long InTime  = System.nanoTime();
        for(int i = 1; i < list.size(); i++){
            
            int value = (int) list.get(i);
            
            while(i>0 && ((int) list.get(i-1)> value)){
            
                list.set(i, (int) list.get(i-1));
                i--;
                ex++;
            }
            
            list.set(i, value);
            compar++;
        }
        
        
        System.out.println("Number of comparisons performed: " + compar + " Number of exchanges performed: " + ex);
        System.out.println("Sorted list "+ list);
        long totalTime = System.nanoTime() - InTime;
        return totalTime;
        
    }

    public long quickSort(int i, int j){
        //used the ppt slides for reference
        long InTime  = System.nanoTime();
        int compar = 0; int ex = 0;
        
        int low = i, high =j;
        int pivot = list.get((low+high)/2);
        
        while(low <= high){
            
            while(list.get(low) < pivot){
                low++;
                compar++;
            }
            while(list.get(high) > pivot){
                high--;
                compar++;
            }
            if(low <= high){
                int temp = list.get(low);
                list.set(low, list.get(high));
                list.set(high, temp);
                low++;
                high--;
                ex++;
            }
            if(i < high){
                return quickSort(i,high);
                }
            if(low < j){
                return quickSort(low, j);
            }
        }
        
        System.out.println("Number of comparisons performed: " + compar + " Number of exchanges performed: " + ex);
        System.out.println("Sorted list "+ list);
        
        long totalTime = System.nanoTime() - InTime;
        return totalTime;
    }

    public long shellSort(){
        //used the book for reference
        int compar = 0;
        int ex = 0;
        long InTime  = System.nanoTime();
        
        
        int n = list.size();
 
     
        for (int gap = list.size()/2; gap > 0; gap /= 2){
        
            for (int i = gap; i < n; i += 1)
            {
                int j;
                int temp = list.get(i);
                
                for (j = i; j >= gap && list.get(j - gap) > temp; j -= gap){
                    list.set(j, list.get(j - gap));
                    //compar++;
                    ex++;
                }
                compar++;
                list.set(j, temp);
            }
        }
        System.out.println("Number of comparisons performed: " + compar + " Number of exchanges performed: " + ex);
        System.out.println("Sorted list "+ list);
        long totalTime = System.nanoTime() - InTime;
        return totalTime;
    }    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Random rand = new Random();
        
        List<Integer> li = new ArrayList<>();
        label:
        for(int i = 0; i < 10; i++){
            
            li.add(rand.nextInt(100));
            
        }
        
        Sorting sort = new Sorting(li);
        
        long in10 = sort.insertionSort();
        long qs10 = sort.quickSort(0, li.size()-1);
        long sh10 = sort.shellSort();
        
        li.removeAll(li);
        for(int i = 0; i < 100; i++){
            
            li.add(rand.nextInt(1000));
            
        }
        
        long in100 = sort.insertionSort();
        long qs100 = sort.quickSort(0, li.size()-1);
        long sh100 = sort.shellSort();
        
        li.removeAll(li);
        for(int i = 0; i < 1000; i++){
            
            li.add(rand.nextInt(10000));    
        }
        
        long in1000 = sort.insertionSort();
        long qs1000 = sort.quickSort(0, li.size()-1);
        long sh1000 = sort.shellSort();
        
        li.removeAll(li);
        for(int i = 0; i < 1000; i++){
            
            li.add(rand.nextInt(10000));    
        }
        
        long in10000 = sort.insertionSort();
        long qs10000 = sort.quickSort(0, li.size()-1);
        long sh10000 = sort.shellSort();

        li.removeAll(li);
        for(int i = 0; i < 1000; i++){
            
            li.add(rand.nextInt(10000));    
        }
        
        long in100000 = sort.insertionSort();
        long qs100000 = sort.quickSort(0, li.size()-1);
        long sh100000 = sort.shellSort();

        FileWriter writer = new FileWriter("Runtime.csv");

        writer.append("Sort");
        writer.append(",");
        writer.append("Input-100");
        writer.append(",");
        writer.append("Input-1000");
        writer.append(",");
        writer.append("Input-10000");
        
        writer.append(",");
        writer.append("Input-100000");
        writer.append("\n");
        
        writer.append("Insertion");
        writer.append(",");
        writer.append(in100 + "");
        writer.append(",");
        writer.append(in1000 + "");
        writer.append(",");
        writer.append(in10000 + "");
        writer.append(",");
        writer.append("" + in100000);
        writer.append('\n');
        
        writer.append("Quick");
        writer.append(",");
        writer.append("" + qs100);
        writer.append(",");
        writer.append("" + qs1000);
        writer.append(",");
        writer.append("" + qs10000);
        writer.append(",");
        writer.append("" + qs10000);
        writer.append("\n");

        writer.append("Shell");
        writer.append(",");
        writer.append("" + sh100);
        writer.append(",");
        writer.append("" + sh1000);
        writer.append(",");
        writer.append("" + sh10000);
        writer.append(",");
        writer.append("" + qs100000);
        writer.append("\n");        
        
        writer.flush();
        writer.close();
    }

}
