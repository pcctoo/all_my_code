package masv;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author pccto
 */
public class BOOutputStream extends OutputStream {
    
    private final OutputStream out;
    private final OS theOS;
    
    public enum OS {
        LINUX, OSX, MSDOS;
    }
    
    public BOOutputStream(OutputStream out) {
        this(out, OS.MSDOS);
    }
    
    public BOOutputStream(OutputStream out, OS os){
        this.out = out;
        this.theOS = os;
    }
    
    public void write(byte b) throws IOException {
        byte[] ba = new byte[1];
        ba[0] = b;
        out.write(ba);
    }
    
    @Override
    public void write(int i) throws IOException {
        byte[] ba = new byte[2];
        if(theOS==OS.MSDOS){
            ba[0] = (byte) i;
            ba[1] = (byte)(i>>8);
        } else {
            ba[0] = (byte)(i>>8);
            ba[1] = (byte) i;
        }
        out.write(ba);
    }
    
    public void write(int [] i) throws IOException {
        for(int v: i) {
            write(v);
        }
    }
    
    public void write(String s) throws IOException {
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            write((byte)c);
        }
    }
    
}
