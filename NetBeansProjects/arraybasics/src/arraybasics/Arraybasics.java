
package arraybasics;

/**
 * grade = g
 * name = n
 * index 0 = g 77 n tom
 * 1 = g84 n ed
 * 2 = g80 n joe
 * 3 = g96 n bob
 */
public class Arraybasics {


    public static void main(String[] args) {
  int [] grades = new int[4];
  grades[0] = 77;
  grades[1] = 84;
  grades[2] = 80;
  grades[3] = 96;
  
  String[]  name = new String[] {"tom" , "ed" , "joe" , "bob"};
  double sum = 0.0;
  System.out.printf("#\tname\tgrades\n");
  System.out.printf("-\t--------------\n");
  
  for(int i=0;i<grades.length;i++){
         System.out.printf("%d\t%s\t%d\n", i, name[i], grades[i]);
         sum += grades[i];
         
    }
  double average = sum / grades.length;
  System.out.printf("class average %f\n",average);
    }
    
}
