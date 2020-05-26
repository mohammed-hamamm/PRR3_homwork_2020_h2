/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homwork_Q2;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Observable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;             
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 

/**
 *
 * @author Educ
 */
public class  Q3    extends Application {
// LAB PROJECT
    Stage window;
    Scene Scene1, Scene2; 
    public Label Labe5;

    @Override
    public void start(Stage primaryStage) {
   primaryStage.setTitle("Temperature converter");
     Label bb = new Label("Enter Celsius temperature:");
     TextField textField = new TextField();
     RadioButton Button1  = new RadioButton("Fahrenheit");
      RadioButton Button2  = new RadioButton("Kelvin");
      ToggleGroup toggle= new ToggleGroup();
       Button1.setToggleGroup(toggle);
       Button2.setToggleGroup(toggle);
        Label labele2= new Label();
                         
       Button1.setOnMouseClicked((event) -> {
            String s = textField.getText();
            double celsius = Double.parseDouble(s);
            double fahrenheit2 = (celsius * 9 / 5 + 32);
            labele2.setText("New  Temperaturer  in  is : " +  fahrenheit2);
        });

        Button2.setOnMouseClicked((event) -> {
            String s = textField.getText();
            double celsius = Double.parseDouble(s);
            double kelvin2 = (celsius + 273.15);
            labele2.setText(" New Temperaturer in is :" + kelvin2);
        });
        VBox vv= new VBox(10,bb,textField,Button1,Button2,labele2);
       
        vv.setAlignment(Pos.CENTER);
        Scene cc = new Scene(vv,500,200);
        primaryStage.setScene(cc);
        primaryStage.show();
        
    }
        // Write event handling code here ...});

      
  
   
    

                            /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
 