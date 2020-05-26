/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp_;

/**
 *
 * @author Educ
 */
public class ItStudent extends Student{

    public ItStudent(int id, String name, String major, double grade) {
        super(id, name, major, grade);
    }
     
     
    public static double grade(double mid , double project , double finall){
        return mid*30 + project *30 + finall*40;
    }
    
}
