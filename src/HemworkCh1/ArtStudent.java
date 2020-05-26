/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HemworkCh1;

/**
 *
 * @author Educ
 */
public class ArtStudent extends Student {

    public ArtStudent(int id, String name, String major, double grade) {
        super(id, name, major, grade);
    }
         

     public static double grade(double mid,double project,double finall){
        return mid*40 + project *10 + finall*50;
    }
}
