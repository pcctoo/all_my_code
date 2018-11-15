
package varscope;


public class Varscope {

    public static void main(String[] args) {
String name = "patrick";
        sayhi(name);
        name = "cat";
 sayhi(name);
    }
    public static void sayhi(String name){
        name= "killer";
        System.out.printf("hi, %s \n", name);
        name = "same";
    }
}
