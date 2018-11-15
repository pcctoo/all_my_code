
package studentarrays;

import java.util.ArrayList;


public class Studentarrays {


    public static void main(String[] args) {
    ArrayList<Integer> grades = new ArrayList<>();
    grades.add(90);
    grades.add(70);
    grades.add(85);
         grades.remove(1);
    for(int i=0; i<grades.size();i++){
        System.out.printf("grade #%d == %d\n", i, grades.get(i));
    }
   
    }

}
