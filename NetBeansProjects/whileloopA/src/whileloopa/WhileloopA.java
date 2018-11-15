package whileloopa;

public class WhileloopA {

    public static void main(String[] args) {
        int max = 9;
        int i = 0;
        System.out.println("counting up . . . . ");
        while (i <= max) {
            System.out.printf("%d ", i);
            i++;
        }
        System.out.println();
        i = max;
        System.out.println("counting down . . .");
        while (i>= 0) {
            System.out.printf("%d ", i);
            i--;
        }
        System.out.println();
    }

}
