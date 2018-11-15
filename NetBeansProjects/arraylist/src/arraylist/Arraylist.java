
package arraylist;

import java.util.ArrayList;

public class Arraylist {

    public static void main(String[] args) {
  
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(90);
        grades.add(34);
        grades.add(43);
        
        for(int i=0; i<grades.size();i++){
            System.out.printf("grade #%d == %d\n", i, grades.get(i));
        }
    }
    
}
