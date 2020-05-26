/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homwork_Q2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class JavaApplication2 extends Application{

    public TextArea textAreaFileContent;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MenuBar bar=new MenuBar();
        Menu menuFile=new Menu("_File");
        MenuItem item1=new MenuItem("_Open");
        MenuItem item2=new MenuItem("_Close");
        MenuItem item3=new MenuItem("E_xit");
        menuFile.getItems().addAll(item1,item2,item3);
        Menu menuFile2=new Menu("_Edit");
        MenuItem item4=new MenuItem("Co_lor");
        MenuItem item5=new MenuItem("_Close");
        MenuItem item6=new MenuItem("E_xit");
        menuFile2.getItems().addAll(item4,item5,item6);
        bar.getMenus().addAll(menuFile,menuFile2);
        
      textAreaFileContent=new TextArea("ssssssssssssssssssssssssss");
        
        HBox hbox=new HBox(bar);
        VBox vbox=new VBox(10,hbox,textAreaFileContent);
        
        EventHandler1 eventhandler=new EventHandler1();
        item1.setOnAction(eventhandler);
        item2.setOnAction(eventhandler);
        item3.setOnAction(eventhandler);
        
        
        
        Scene scene=new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
  
    private class EventHandler1 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            String menu=((MenuItem)event.getSource()).getText();
            switch(menu)
            {
                case "_Open":
                    FileChooser fo=new FileChooser();
                    fo.setInitialDirectory(new File("."));
                    File file=fo.showOpenDialog(null);
                    textAreaFileContent.setText("");
                    textAreaFileContent.setWrapText(true);
            {
                try {
                    Scanner s=new Scanner(file);
                    while(s.hasNext())
                    {
                        textAreaFileContent.appendText((s.nextLine()));
                        
                    }
                        
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case "_Close":
                   // System.exit(0);
                break;
                
                case "E_xit":
                    System.exit(0);
                break;
                case "Co_lor":
                    
                    Dialog<String> dialogcolor=new TextInputDialog();
                    dialogcolor.setTitle("Color Selection");
                    dialogcolor.setHeaderText("select color");
                    String color=dialogcolor.showAndWait().get();
                    textAreaFileContent.setStyle("-fx-text-fill"+color+";");
                break;
             
                
                 
            }
        }
        
       
    }

}
