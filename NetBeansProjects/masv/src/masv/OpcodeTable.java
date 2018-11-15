package masv;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author pccto
 */
public class OpcodeTable {

    private static final Map<String, Short> optable;
    private static final Map<String, Integer> assemblyform;

    static {
        optable = new TreeMap<>();
        optable.put("ld", (short) 0x0000);
        optable.put("st", (short) 0x1000);
        optable.put("add", (short) 0x2000);
        optable.put("sub", (short) 0x3000);
        optable.put("ldr", (short) 0x4000);
        optable.put("str", (short) 0x5000);
        optable.put("addr", (short) 0x6000);
        optable.put("subr", (short) 0x7000);
        optable.put("ldc", (short) 0x8000);
        optable.put("ja", (short) 0x9000);
        optable.put("jzop", (short) 0xA000);
        optable.put("jn", (short) 0xB000);
        optable.put("jz", (short) 0xC000);
        optable.put("jnz", (short) 0xD000);
        optable.put("call", (short) 0xE000);
        optable.put("ret", (short) 0xF000);
        optable.put("ldi", (short) 0xF100);
        optable.put("sti", (short) 0xF200);
        optable.put("push", (short) 0xF300);
        optable.put("pop", (short) 0xF400);
        optable.put("aloc", (short) 0xF500);
        optable.put("dloc", (short) 0xF600);
        optable.put("swap", (short) 0xF700);
        optable.put("uout", (short) 0xFFF5);
        optable.put("sin", (short) 0xFFF6);
        optable.put("sout", (short) 0xFFF7);
        optable.put("hin", (short) 0xFFF8);
        optable.put("hout", (short) 0xFFF9);
        optable.put("ain", (short) 0xFFFA);
        optable.put("aout", (short) 0xFFFB);
        optable.put("din", (short) 0xFFFC);
        optable.put("dout", (short) 0xFFFD);
        optable.put("bkpt", (short) 0xFFFE);
        optable.put("halt", (short) 0xFFFF);
    }

    static {
        assemblyform = new TreeMap<>();
        assemblyform.put("ld", 2);
        assemblyform.put("st", 2);
        assemblyform.put("add", 2);
        assemblyform.put("sub", 2);
        assemblyform.put("ldr", 2);
        assemblyform.put("str", 2);
        assemblyform.put("addr", 2);
        assemblyform.put("subr", 2);
        assemblyform.put("ldc", 2);
        assemblyform.put("ja", 2);
        assemblyform.put("jzop", 2);
        assemblyform.put("jn", 2);
        assemblyform.put("jz", 2);
        assemblyform.put("jnz", 2);
        assemblyform.put("call", 1);
        assemblyform.put("ret", 1);
        assemblyform.put("ldi", 1);
        assemblyform.put("sti", 1);
        assemblyform.put("push", 1);
        assemblyform.put("pop", 1);
        assemblyform.put("aloc", 2);
        assemblyform.put("dloc", 2);
        assemblyform.put("swap", 1);
        assemblyform.put("uout", 1);
        assemblyform.put("sin", 1);
        assemblyform.put("sout", 1);
        assemblyform.put("hin", 1);
        assemblyform.put("hout", 1);
        assemblyform.put("ain", 1);
        assemblyform.put("aout", 1);
        assemblyform.put("din", 1);
        assemblyform.put("dout", 1);
        assemblyform.put("bkpt", 1);
        assemblyform.put("halt", 1);
    }

    //define an inner class in the opcode table, new, pass in the short, pass in the values to associate with the
    public static boolean isNmeumonic(String s) {
        return optable.containsKey(s.toLowerCase());
    }

    public static short getOpcode(String s) {
        return optable.get(s.toLowerCase());
    }

    public static boolean isAssemblyForm(String s) {
        int i = countWords(s);
        int j = assemblyform.get(s.toLowerCase());
        return j == i;
    }

    public static int countWords(String s) {
        int wordcount = 0;
        String[] string = s.split("");
        for (int i = 0; i <= string.length-1; i++) {
            if (!" ".equals(string[i])) {
                if (i != 0) {
                    if (" ".equals(string[i - 1])) {
                        wordcount++;
                    } 
                } else if (i==0){
                    wordcount++;
                }
            }
        }
        return wordcount;
    }

   
}

      
