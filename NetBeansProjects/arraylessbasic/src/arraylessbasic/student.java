
package arraylessbasic;


public class student {
    public String _name;
    private int _grade;
    public student(String name, int grade){
        this._grade = grade;
        this._name = name;
    }
    public String name(){
        return this._name;
    }
    public int grade() {
        return this._grade;
    }
}
