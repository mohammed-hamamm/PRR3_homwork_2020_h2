/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomworkCh5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Extreme
 */
@Entity
public class Emp {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Integer id;
    private  String name;
    private String major;
    private Double grade;

    public Emp() {
        
    }

    public Emp(Integer id, String name, String major, Double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id,name,major,grade);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    
    
    
    
}
