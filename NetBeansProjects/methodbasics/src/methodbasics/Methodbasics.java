
package methodbasics;

import java.util.Scanner;

public class Methodbasics {

    public static void main(String[] args) {
 int langth, width;
   
    
       Scanner input = new Scanner (System.in);
    System.out.print("enter the langth: ");
    langth= input.nextInt();
      System.out.print("enter the width: ");
    width= input.nextInt();
    int area= recarea(langth, width);
    int per = rectperm (langth,width);
    System.out.printf("the area of the rectangle is : %d and the peramiter is: %d/n",area,per );
    
    
    }
    public static int recarea (int somelangth, int somewidth ){
    return somelangth * somewidth;
 
}
   public static int rectperm(int somelangth, int somewidth){
     return 2 * (somelangth + somewidth);  
   }
}
