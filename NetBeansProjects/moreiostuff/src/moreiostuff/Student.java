
package moreiostuff;

import java.io.Serializable;//makes you able to read and make a file with this.


class Student implements Serializable {
    private String Name;
    
    private double Gpa;
    public Student (String name, double gpa) {
        this.Name = name;
        this.Gpa= gpa;
    }
    public String getName(){
        
    return this.Name;
    }
    public String setName (String newName) {
        return (this.Name = newName);
    }
    public double getGpa(){
        return this.Gpa;
    }
    public double setGpa(double newGpa){
        return (this.Gpa=newGpa);
    }
    @Override
    public String toString(){
        return String.format("%s\t%f",this.Name, this.Gpa);
    }
}
