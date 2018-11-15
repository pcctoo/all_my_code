package NsideddiceRun;

public class NsideddiceRun {

    public static void main(String[] args) {
        die d12 = new die(12);
        die d6 = new die(6);
        die d20 = new die(20);
        System.out.printf("rolling %d sidded die : %d\n", d6.getsides(), d6.roll());
        System.out.printf("rolling %d sidded die : %d\n", d12.getsides(), d12.roll());
        System.out.printf("rolling %d sidded die : %d\n", d20.getsides(), d20.roll());

    }
}
