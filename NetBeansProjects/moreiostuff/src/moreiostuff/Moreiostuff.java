package moreiostuff;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Moreiostuff {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("students.txt");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("tim", 3.123));
        students.add(new Student("dave", 4.000));
        students.add(new Student("bill", 3.540));
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fo);
        for (Student s : students) {
            output.writeObject(s);

        }
        output.close();
        fo.close();

        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fi);
        ArrayList<Student> students2 = new ArrayList<Student>();
        try {
            while (true) {
                Student s = (Student) input.readObject();
                students2.add(s);
            }
        } catch (EOFException ex) {

        }   for (Student s : students2){
    System.out.println(s);
}
    }
 

    
    


    
}

