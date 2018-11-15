
package searchthatcrap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Searchthatcrap {

  
    
    public static void main(String[] args) {
 Random generator = new Random();
 int found =-1;
 
 ArrayList<Integer> numbers = new ArrayList<>();
 for(int i=0;i<20;i++){
     numbers.add(generator.nextInt(100)+1);
 }
 System.out.println("unsorted");
 printNumbers(numbers);
 found = find(numbers,50);
 System.out.printf("the number %d was %sfound\n", 50, found<0 ? "not ": "");
 Collections.sort(numbers, new intcomp());
  System.out.println("sorted");
 printNumbers(numbers);
 
 found = Collections.binarySearch(numbers, 69, new intcomp());
 System.out.printf("the number %d was %sfound\n", 69, found<0 ? "not ": "");
    }
   
    
    public static void printNumbers (ArrayList<Integer> nums){
        for(int i=0; i< nums.size(); i++){
            System.out.printf("%d ",nums.get(i));
            
        
        }
        System.out.println();
        
    }
    public static int find (ArrayList<Integer> a, Integer target){
     int found = -1;
     for(int i=0; i<a.size();i++){
         if (a.get(i)==target){
             found = i;
             break;
         }
     }
        return found;
    }
    public static ArrayList<Integer> sort( ArrayList<Integer> a) {
        boolean swaped = false;
        int tmp =0;
        for(int i=0;i<a.size();i++){
            swaped = false;
            for(int j=a.size()-1;j>i;j--){
                if (a.get(j)< a.get(j-1)){
                    tmp = a.get(j);
                    a.set(j, a.get(j-1));
                    a.set(j-1, tmp);
                    swaped = true;
                    
                }
            }
            
        }
        return null;
    }
}

 