package masv;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author pccto
 */
public class SymbolTable {
    
    private final Map<String, Integer> stab = new TreeMap<>();
    
    
    
    public boolean isSymbol(String symbol) {
        return stab.containsKey(symbol);
    }
    
    public void add(String symbol, int memref) {
        stab.put(symbol, memref);
    }
    
    public int getMemoryRef(String symbol) {
        return stab.get(symbol);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol Table:\n");
        Set<String> keys = (Set<String>)this.stab.keySet();
        for(String key : keys){
            sb.append(String.format("'\t%s': %d\n",key,getMemoryRef(key)));
        }
        return sb.toString();
    }
    
}
