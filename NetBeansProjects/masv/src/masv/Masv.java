package masv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the assembler
 *
 * @author pccto
 */
public class Masv {

    private ArrayList<String> source = new ArrayList<>();
    private String filename;
    private SymbolTable stab = new SymbolTable();
    private ExternalSymbolTable etab = new ExternalSymbolTable();
    private boolean mob = false;
    private BOOutputStream bout;

    public Masv(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter input file name, or hit ENTER to quit.");
            filename = new Scanner(System.in).nextLine();
        } else {
            filename = args[0];
        }
        if (filename.contains(".mas")) {
            filename = filename.substring(0, filename.indexOf("."));
        }
        if (filename.length() == 0) {
            System.exit(0);
        }
        File infile = new File(filename + ".mas");
        if (!infile.exists() || !infile.canRead()) {
            System.out.println("ERROR Cannot open input file" + filename + ".mas");
            System.exit(1);
        }
    }

    public void assemble() {
        System.out.println(filename);
        try (BufferedReader input = new BufferedReader(new FileReader(filename + ".mas"))) {
            String line;
            while ((line = input.readLine()) != null) {
                source.add(line);
            }
            pass1();
            pass2();
        }
        //this catch is what is stopping it
        catch (FileNotFoundException ex) {
            System.out.println("ERROR Cannot open input file " + filename + ".mas");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("ERROR Cannot open input file " + filename + ".mas");
            System.exit(1);
        }
    }

    void pass1() {
        int sourceLineCount = 0;
        int memAddr = 0;
        for (String sourceline : source) {
            if (sourceline.contains(";")) {
                ++sourceLineCount;
                sourceline = sourceline.substring(0, sourceline.indexOf(";"));
            }
            sourceline = sourceline.trim();
            if (sourceline.contains("extern") || sourceline.contains("public")) {
                mob = true;
            }
            if (!sourceline.isEmpty()) {
                System.out.println(sourceline);

                if (sourceline.contains(":")) {
                    String label = sourceline.substring(0, sourceline.indexOf(":")).trim();
                    sourceline = sourceline.substring(sourceline.indexOf(";") + 1).trim();
                    stab.add(label, memAddr);
                    System.out.println(sourceline);
                }
                String token;
                if (sourceline.contains(" ")) {
                    token = sourceline.substring(0, sourceline.indexOf(" ")).trim();
                    sourceline = sourceline.substring(sourceline.indexOf(" ") + 1);
                } else {
                    token = sourceline;
                }
                if (OpcodeTable.isNmeumonic(token)) {
                    memAddr++;
                } else if (token.equals("dw")) {
                    if (sourceline.startsWith("\'")) {
                        String str = sourceline.trim();
                        if (!str.endsWith("\'")) {
                            System.err.println("Unterminated string on line " + sourceLineCount);
                            System.exit(1);
                        }
                        int strLen = getEscapedStringLength(str);
                        if (strLen < 0) {
                            System.out.println("Illegal escape character in string on line " + sourceLineCount);
                            System.exit(1);
                        }
                        memAddr += strLen;
                    } else if (sourceline.startsWith("\"")) {
                        String str = sourceline.trim();
                        if (!str.endsWith("\"")) {
                            System.out.println("Unterminated string on line " + sourceLineCount);
                        }
                        int strLen = getEscapedStringLength(str);
                        if (strLen < 0) {
                            System.out.println("Illegal escape character in string on line " + sourceLineCount);
                            System.exit(1);
                        }
                    } else if (isInteger(sourceline)) {

                    } else if (sourceline.contains("dup")) {
                        String s = sourceline.trim();
                        String[] arr = s.split(" ");
                        ArrayList list = null;
                        for (int i = 0; i <= arr.length - 1; ++i) {
                            if (!"".equals(arr[i])) {
                                list.add(i);
                            }
                        }
                        if (list.size() > 1) {
                            if (list.size() > 3) {
                                System.out.println("ERROR: Invalid input on line " + sourceLineCount + ":" + sourceline);
                            } else if (list.indexOf("dup") != 1) {
                                System.out.println("ERROR: Invalid input on line " + sourceLineCount + ":" + sourceline);
                            } else if (!isInteger((String) list.get(2))) {
                                System.out.println("ERROR: Invalid input on line " + sourceLineCount + ":" + sourceline);
                            } else if (list.get(0) == ("0")) {
                                System.out.println("ERROR: Invalid input on line " + sourceLineCount + ":" + sourceline);
                            } else {
                                ++memAddr;
                            }
                        } else {
                            System.err.println("Unrecognized token " + token + "on line " + sourceLineCount);
                            System.exit(1);
                        }
                    }
                }

            }
        }
        System.out.println(stab);
    }

    void pass2() {
        String fn;
        if (mob == true) {
            fn = filename + ".mob";
        } else {
            fn = filename + ".mac";
        }
        try {
            bout = new BOOutputStream(new FileOutputStream(fn));
        } catch (IOException io) {
            System.out.println("ERROR");
            System.exit(1);
        }

        //Loop until no more input
        for (String sourceline : source) {

            sourceline = sourceline.trim();
            String token;
            if (sourceline.contains(" ")) {
                token = sourceline.substring(0, sourceline.indexOf(" ")).trim();
                sourceline = sourceline.substring(sourceline.indexOf(" ") + 1);
            } else {
                token = sourceline;
            }

            if (OpcodeTable.isNmeumonic(token)) {

                int mword = OpcodeTable.getOpcode(token);
                mword += stab.getMemoryRef(token);
                try {
                    
                    bout.write(mword);
                } catch (IOException io) {
                    System.out.println("ERROR");
                    System.exit(1);
                }

            }
            if (stab.isSymbol(sourceline)) {

                stab.getMemoryRef(sourceline);

            } 
            else {
                try {
                    bout.write(sourceline);
                } catch (IOException io) {
                    System.out.println("ERROR");
                    System.exit(1);
                }
            }
            if (OpcodeTable.isNmeumonic(token)) {
             
                  short opc = OpcodeTable.getOpcode(token);
                  if(isInteger(sourceline)){
                      int srcln = Integer.parseInt(sourceline);
                      opc += srcln;
                      try {
                          bout.write(opc);
                      } catch(IOException io){
                          
                      } 
                  } else if(stab.isSymbol(sourceline)){
                      int srcln = OpcodeTable.getOpcode(sourceline);
                      opc += srcln;
                      try {
                          bout.write(opc);
                      } catch(IOException io){
                          
                      }
                  }
                  
               
            } else {

                try {
                bout.write(sourceline);
            } catch (IOException io){
                
            }   

        }
        try {
            bout.close();
        } catch (IOException io) {

        }

        if (mob) {
            System.out.println("Input file = " + filename + ".mas");
            System.out.println("Input file = " + filename + ".mob");
        } else {
            System.out.println("Input file = " + filename + ".mas");
            System.out.println("Input file = " + filename + ".mac");
        }
    }
    }

    public boolean isInteger(String str) {
        return str.matches("[0-9]+");
    }

    public int getEscapedStringLength(String s) {
        int strLen = 0;
        for (int i = 1; i < s.length() - 2; ++i) {
            if (s.charAt(i) != '\\') {
                ++strLen;
            } else {
                if (!"nrt".contains(s.subSequence(i + 1, i + 2))) {
                    return -1;
                }
            }
        }
        return strLen;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Masv(args).assemble();
    }

}
