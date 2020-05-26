/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StreamsApp;

/**
 *
 * @author Extreme
 */
public class Employee {
    private Integer id;
    private  String name;
    private String departement;
    private Double salary;

    public Employee(Integer id, String name, String departement, Double salary) {
        this.id = id;
        this.name = name;
        this.departement = departement;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id,name,departement,salary);
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

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    
    
    
    
}
