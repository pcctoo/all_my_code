
package switchladder;

import java.util.Scanner;
public class Switchladder {
//switch statement and if else ladder example.

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        System.out.print("enter month [1-12] : ");
        int month = input.nextInt();
        System.out.print("enter day of the month [1-31]");
        int day = input.nextInt();
        System.out.printf("that is the %s of %s\n",getday(day) ,getmonth(month));
        
    }
    //the next part of coade gose through one by one and compairs the awnser with each line. the break makes it to where the code -
    // - stops running after it finds its match
    
    public static String getmonth(int month){
        String result = "unknown";
        switch (month){
            case 1:
                result  = "january";
                break;
            case 2:
                result = "febuary";
                break;
            case 3:
                result = "march";
                break;
            case 4:
                result = "april";
                break;
            case 5:
                result = "may";
                break;
            case 6:
                result = "june";
                break;
            case 7:
                result = "july";
                break;
            case 8:
                result = "sugust";
                break;
            case 9:
                result = "september";
                break;
            case 10:
                result = "october";
                break;
            case 11:
                result = "november";
                break;
            case 12: 
                result = "nevember";
                break;
                
                     
        }
    return result;
    }
   
    public static String getday(int day){
        String result;
        if (day != 11 && day %10==1){
            result = day + "st";
        } else if (day !=12 && day%10==3){
            result = day + "st";
        } else if (day !=13 && day%10==3){
            result = day + "rd";
        } else{
            result = day + "th";
        }
        return result;
    } 
}
