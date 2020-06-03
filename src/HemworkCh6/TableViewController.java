/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.HemworkCh6;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Emp;

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
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/unviersty", "root", "");
            this.statement = connection.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        TableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedEmployee());
    }

    private void showSelectedEmployee() {
        Emp employee = TableView.getSelectionModel().getSelectedItem();
        if (employee != null) {
            TextFeiledID.setText(String.valueOf(employee.getId()));
            TextFeiledName.setText(employee.getName());
            TextFeiledMajor.setText(employee.getMajor());
            TextFeiledGrade.setText(String.valueOf(employee.getGrade()));
        }
    }
    ResultSet rs = null;

    public TableViewController() {
    }

     @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("Select * From student");
        while (rs.next()) {
            Emp employee = new Emp();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setMajor(rs.getString("major"));
            employee.setGrade(rs.getDouble("grade"));
            TableView.getItems().add(employee);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
    Integer id = Integer.parseInt(TextFeiledID.getText());
        String name = TextFeiledName.getText();
        String major = TextFeiledMajor.getText();
        Double grade = Double.parseDouble(TextFeiledGrade.getText());
        String sql = "Insert Into student values(" + id + ",'" +name + "','" 
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
   
   
   
    }
    

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception{
        
       Integer id = Integer.parseInt(TextFeiledID.getText());
        String name = TextFeiledName.getText();
        String major = TextFeiledMajor.getText();
        Double grade = Double.parseDouble(TextFeiledGrade.getText());
        String sql = "Update student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception{
    
          Integer id = Integer.parseInt(TextFeiledID.getText());
        String name = TextFeiledName.getText();
        String major = TextFeiledMajor.getText();
        Double grade = Double.parseDouble(TextFeiledGrade.getText());
        String sql = "delete from student where id=" +id;
        this.statement.executeUpdate(sql);
       
        
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
