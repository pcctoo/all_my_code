/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonetoadarray;

/**
 *
 * @author pccto
 */
 class data{
    public String _name;
public String _address;
public String _location;
public String _img;
public data(String name, String address, String location, String img ){
    this._address = address;
    this._img = img;
    this._location = location;
    this._name = name;
            
}
    public String name(){
        return this._name;
    }
        public String address(){
        return this._address;
    }
            public String img(){
        return this._img;
    }
                public String location(){
        return this._location;
    }

public class Phonetoadarray {



data[] data= new data[10];
        student[] students = new student[4];
        for(int i =0; i<students.length;i++){
            System.out.printf("enter student grade then name for student #%d   ",i);
            grade = input.nextInt();
            name = input.nextLine();
            students[i] = new student(name, grade);
            
        }
        System.out.printf("#\tname\tgrades\n");
        System.out.printf("-\t--------------\n");


 for (int i = 0; i < data.length; i++) {
    
            System.out.printf("%d\t%s\t%d\n", i, data[i].name(), data[i].location());
}
}
            public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
