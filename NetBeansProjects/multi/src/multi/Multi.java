
package multi;
import java.util.Scanner;
public class Multi {

    public static void main(String[] args) {
 
 Scanner input = new Scanner(System.in);
 System.out.print("enter the number you want multiples of : ");
 int multiof = input.nextInt();
 
 int maxmult = multiof;
 
 for (int i =1; i<=maxmult;i++){
 int answer = i *multiof;
 System.out.printf("%d * %d == %d\n", i, multiof, answer);
 }
    }
    
}
