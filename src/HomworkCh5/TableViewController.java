/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomworkCh5;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Extreme
 */
public class TableViewController implements Initializable {

    @FXML
    private TextField TextFeiledID;
    @FXML
    private TextField TextFeiledName;
    @FXML
    private TextField TextFeiledMajor;
    @FXML
    private TextField TextFeiledGrade;
    @FXML
    private TableColumn<Emp, Integer> tcID;
    @FXML
    private TableColumn<Emp, String> tcName;
    @FXML
    private TableColumn<Emp, String> tcMajor;
    @FXML
    private TableColumn<Emp, Double> tcGrade;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<Emp> TableView;
    Statement statement;
    @FXML
    private Button buttonShow;
    private EntityManagerFactory emf;
    @FXML
    private TableView<Emp> tableView;
    @FXML
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
       tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
       tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        this.emf = Persistence.createEntityManagerFactory("PR320202PU");
    }
    
    
    private void showSelectedEmployee() {
            EntityManager em = emf.createEntityManager();
        List<Emp> employees = em.createNamedQuery("Employee.findAll").getResultList();
        tableView.getItems().setAll(employees);
        em.close();
    }
   

    
    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
        Emp std = new Emp(Integer.parseInt(TextFeiledID.getText()), TextFeiledGrade.getText(),
                TextFeiledMajor.getText(),
                Double.parseDouble(TextFeiledGrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std);
        em.getTransaction().commit();
        em.close();
        tableView.getItems().clear();
        referachTable();
    }

  

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Delete from Student s where s.id= :id");
        query.setParameter("id", Integer.parseInt(TextFeiledID.getText()));
        query.executeUpdate();
        em.getTransaction().commit();
        tableView.getItems().clear();
        referachTable();
    }

    public void referachTable() {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("Chapter4PU");
        EntityManager em = emf.createEntityManager();
        List<Emp> std = em.createNamedQuery("Student.findall").getResultList();
        tableView.getItems().setAll(std);

    }

    private void showSelectedStudent() {
        Emp student = tableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            TextFeiledID.setText(String.valueOf(student.getId()));
            TextFeiledName.setText(student.getName());
            TextFeiledMajor.setText(student.getMajor());
            TextFeiledGrade.setText(String.valueOf(student.getGrade()));
        }

    }
    
@FXML
    private void buttonUpdateHandle(ActionEvent event) throws SQLException {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("update Student s set s.name= :name,s.major= :major,s.grade= :grade where s.id= :id");
        query.setParameter("id", Integer.parseInt(TextFeiledID.getText()))
                .setParameter("name", TextFeiledName.getText())
                .setParameter("major", TextFeiledMajor.getText())
                .setParameter("grade", Double.parseDouble(TextFeiledGrade.getText()));
        query.executeUpdate();
        em.getTransaction().commit();
        tableView.getItems().clear();
        referachTable();
    }




    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    
    
    private void resetControls(){
        TextFeiledID.setText("");
        TextFeiledName.setText("");
        TextFeiledMajor.setText("");
        TextFeiledGrade.setText("");
        TableView.getItems().clear();
    }
        

}
