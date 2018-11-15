
package mathexample;

import java.util.Scanner;

public class MathExample {

    public static void main(String[] args) {
 //circumference and area of a circle
 Scanner input = new Scanner (System.in);
 System.out.print("enter Circle Radius : ");
 double radius = input.nextDouble();
 // 2*pi*radius
 double circ = 2 * Math.PI * radius;
  double area = Math.PI * radius * radius;
 System.out.printf("the radius of the circle is : %f and the area is: %f /n ", circ, area);

    }
    
}
