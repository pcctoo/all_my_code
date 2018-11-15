package masv;

import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author pccto
 */
public class ExternalSymbolTable {
    
     private final LinkedList<String> etab = new LinkedList<>();
    
    
    
    public boolean isSymbol(String symbol) {
        return etab.contains(symbol);
    }
    
    public void add(String symbol) {
        etab.addLast(symbol);
    }
    
    public int getMemoryRef(String symbol) {
        return etab.indexOf(symbol);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol Table:\n");
        Set<String> keys = (Set<String>)this.etab;//possible source of bugs
        for(String key : keys){
            sb.append(String.format("'\t%s': %d\n",key,getMemoryRef(key)));
        }
        return sb.toString();
    }
}
