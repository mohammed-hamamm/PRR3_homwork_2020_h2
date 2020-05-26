/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HemworkCh1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Educ
 */
public class StudentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Student students[] = new Student[5];
        students[0] = new ItStudent(1, "mo", "m1", ItStudent.grade(25, 25, 35));
        students[1] = new ItStudent(2, "ha", "m2", ItStudent.grade(29, 28, 36));
        students[2] = new ArtStudent(3, "ma", "m3", ArtStudent.grade(30, 8, 40));
        students[3] = new ArtStudent(4, "d", "m4", ArtStudent.grade(37, 10, 35));

         
        for (int j = 0; j < students.length; j++) {
            for (int i = 0; i < students.length - 1; i++) {
                if (students[i + 1].getGrade() > students[i].getGrade()) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                }

            }
        }


File file = new File("Student.txt");
        FileWriter fw = new FileWriter(file);
       PrintWriter pw = new PrintWriter(fw);
        Iterable<Student> std = null;
        for (Student student : std) {
            pw.println(student);
        }
       pw.close();
       fw.close();






        
    }

}
