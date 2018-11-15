package rotormachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RotorMachine {

    private String filename;
    private int firstShift;
    private int firstKey;
    private int secondShift;
    private int secondKey;
    private ArrayList<Character> buffer;
    private ArrayList<Integer> coprimes;

    public RotorMachine(String filename, int firstShift, int firstKey, int secondShift, int secondKey) {
        buffer = new ArrayList<>();
        coprimes = new ArrayList<>();
        coprimes.add(3);
        coprimes.add(5);
        coprimes.add(7);
        coprimes.add(11);
        coprimes.add(17);
        coprimes.add(19);
        coprimes.add(23);
        this.filename = filename;
        this.firstShift = firstShift;
        this.firstKey = coprimes.get(firstKey % 7);
        this.secondShift = secondShift;
        this.secondKey = coprimes.get(secondKey % 7);
    }

    private void RSAEncryption() {

    }

    private void readFile() {
        try {
            java.io.FileReader reader = new FileReader(filename);

            int cin = reader.read();
            while (cin != -1) {
                buffer.add((char) cin);
                cin = reader.read();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file: " + filename);
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error in reading from file: " + filename);
            System.exit(1);

        }

    }

    private void encrypt() {
        int index = 0;
        System.out.println("Encrypting...");
        while (index < buffer.size()) {
            char c = buffer.get(index);
            int ascii = (int) c;
            if (65 <= ascii && ascii <= 90) {
                ascii = ascii + (firstKey * firstShift) % 26;
                if (ascii > 90) {
                    ascii = ascii - 26;
                }
                ascii = ascii + (secondKey * secondShift) % 26;
                if (ascii > 90) {
                    ascii = ascii - 26;
                }
                c = (char) ascii;
                buffer.set(index, c);
                index++;

            } else if (97 <= ascii && ascii <= 122) {
                ascii = ascii + (firstKey * firstShift) % 26;
                if (ascii > 122) {
                    ascii = ascii - 26;
                }
                ascii = ascii + (secondKey * secondShift) % 26;
                if (ascii > 122) {
                    ascii = ascii - 26;
                }
                c = (char) ascii;
                buffer.set(index, c);
                index++;

            } else {
                index++;
            }
        }
    }

    private void decrypt() {
        int index = 0;
        System.out.println("\n Decrypting...");
        while (index < buffer.size()) {
            char c = buffer.get(index);
            int ascii = (int) c;
            if (65 <= ascii && ascii <= 90) {
                ascii = ascii - (firstKey * firstShift) % 26;
                if (ascii < 65) {
                    ascii = ascii + 26;
                }
                ascii = ascii - (secondKey * secondShift) % 26;
                if (ascii < 65) {
                    ascii = ascii + 26;
                }
                c = (char) ascii;
                buffer.set(index, c);
                index++;

            } else if (97 <= ascii && ascii <= 122) {
                ascii = ascii - (firstKey * firstShift) % 26;
                if (ascii < 97) {
                    ascii = ascii + 26;
                }
                ascii = ascii - (secondKey * secondShift) % 26;
                if (ascii < 97) {
                    ascii = ascii + 26;
                }
                c = (char) ascii;
                buffer.set(index, c);
                index++;

            } else {
                index++;
            }
        }
    }

    private void output() {
        int index = 0;
        while (index < buffer.size()) {
            System.out.print(buffer.get(index));
            index++;
        }
    }

    public static void main(String[] args) {
        RotorMachine rotorMachine = null;
// Prompt user for a file and shift values
        if (args.length == 0) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter file name: ");
            String filename = input.next();
            File file = new File(filename);
            if (!file.exists()) {
                System.err.println("Invalid file: " + filename);
                System.exit(0);
            }
            System.out.println("Enter the first shift factor: ");
            int firstShift = input.nextInt();
            System.out.println("Enter the first key: ");
            int firstKey = input.nextInt();
            System.out.println("Enter the second shift factor: ");
            int secondShift = input.nextInt();
            System.out.println("Enter the second key: ");
            int secondKey = input.nextInt();
            rotorMachine = new RotorMachine(filename, firstShift, firstKey, secondShift, secondKey);

        } else if (args.length == 2) {
            File file = new File(args[0]);
            if (!file.exists()) {
                System.exit(1);
            }
            rotorMachine = new RotorMachine(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        }
// Read the file
        rotorMachine.readFile();
// Encrypt the file
        rotorMachine.encrypt();
// Output the file
        rotorMachine.output();
        Scanner reader = new Scanner(System.in);
        System.out.println("    ");
        System.out.println("If you would like to decrypt this file, input \"0\". Otherwise, input \"1\".");
        int n = reader.nextInt();
        if (n == 0) {
            rotorMachine.decrypt();
            rotorMachine.output();
        } else {
            System.exit(0);
        }

    }

}
