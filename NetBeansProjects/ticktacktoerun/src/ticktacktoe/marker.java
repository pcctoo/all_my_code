package ticktacktoe;

public enum marker {
    X('x'), O('o'), E(' ');
   
private char ch;

marker(char ch) {
this.ch = ch;

}
@Override
public String toString() {
    return String.format("%c",this,ch);
}

}
