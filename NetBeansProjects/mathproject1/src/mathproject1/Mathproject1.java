
package mathproject1;

import acm.program.GraphicsProgram;
import svu.csc213.Dialog;
import java.util.LinkedList;


/**
 *
 * @author pccto
 */
public class Mathproject1 extends GraphicsProgram {
  
    LinkedList<Integer> n = new LinkedList<>();
    
    public void run(){
        
    Dialog.showMessage(this, "can i have some posative intergers please?.");
    for(int i=0; i<=10; ++i) {
    int dec = Dialog.getInteger(this, "Enter a posative integer. if it is not a posaive interger. your program will shut down. ");
    if (dec < 0) {
            System.exit(0);

        }
    n.add(dec);
    }
    test();
    Dialog.showMessage(this, "the highest is: " + test());
    System.exit(0);
    }
    
    public int test(){
    int testPoint = 0;
        
    for(int i=0; i<=9; ++i) {
    int first = n.get(i);
    int sec = n.get(i+1);
    if(first>sec){
    if(first>testPoint){
    testPoint = first;
   }
   } else if (sec>first){
   if(sec>testPoint){
   testPoint = sec;
   }
   }
   }
   return testPoint;
   }
    
    
    


    public static void main(String[] args) {
       new Mathproject1().start();
    }

  
}



