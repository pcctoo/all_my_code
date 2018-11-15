package akstest;

/**
 * @author pccto
 */
public class AksTest {
private static final long[] num = new long[67];
public static void main(String[] args) {
        for (int n = 0; n < 10; n++) {
        covar(n);
        printing(n);}
        System.out.print("Primes:");
        for (int n = 1; n < num.length; n++)
        if (isPrime(n))
        System.out.printf(" %d", n);
  System.out.println();}
    static void covar(int n) {
        num[0] = 1;
        for (int i = 0; i < n; num[0] = -num[0], i++) {
        num[1 + i] = 1;
        for (int j = i; j > 0; j--)
        num[j] = num[j - 1] - num[j];}}
    static boolean isPrime(int n) {
        covar(n);
        num[0]++;
        num[n]--;
        int i = n;
        while (i-- != 0 && num[i] % n == 0)
        continue;
        return i < 0;}
    static void printing(int n) {
        System.out.print("(x-1)^" + n + " =");
        for (int i = n; i >= 0; i--) {
        System.out.print(" + " + num[i] + "x^" + i);}
        System.out.println();}}
