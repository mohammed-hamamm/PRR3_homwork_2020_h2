/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StreamsApp;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Extreme
 */
public class TextAreaPaneController implements Initializable {
    @FXML
    private TextArea TextArea;
    @FXML
    private Button ButtonShow;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonShowHandle(ActionEvent event) {
        int [] ar ={3,17,1,12,4,9,21,50};
        TextArea.setText("sorted : ");
         IntStream.of(ar)
                 .sorted()
                 .forEach(v-> TextArea.appendText(v+" "));
                 
      TextArea.appendText("\n flitred : ");
     
      Stream.of(3,17,1,12,4,9,21,50)
              .filter(v->v%2 ==0)
              .forEach(v-> TextArea.appendText(v+" "));
           
        TextArea.appendText("\n sum : ");
      
        int sum=
        IntStream.rangeClosed(21, 30)
                 .filter(v->v%2 ==0)
                .reduce(0,(a,b)->a+b);
        
        TextArea.appendText(sum +"");
        
           TextArea.appendText("\n avg : ");

       
        
        Double  [] ar2 = {1.1,5.5,7.7,11.11,20.20,6.6};
        
         double avg=
        Arrays.stream(ar2)
                .mapToDouble(v->(double) v)
                .average().getAsDouble();
        
        TextArea.appendText(avg+"");
        
          TextArea.appendText("\n find Any :");
        
          TextArea.appendText(
        Stream
                .of("Ahmed","Ali","Mona","moustafa","Huda")
                .filter(s-> s.length()>3)
                .findAny()
                .get()
          );
          TextArea.appendText("\nGrouping: \n");
          
          Stream
                  .of("Programming needs open mined and programming thinking",
                 "Programming Programming needs needs and needs expeience")
                  .flatMap(s->Stream.of(s.split("[\\s]")))
                 .collect(Collectors.groupingBy(String::toString))
                  .forEach((s,list)->TextArea.appendText(s+": "+list+"\n")); 
          
          
           TextArea.appendText("\nCounting: \n");
          
          Stream
                  .of("Programming needs open mined and programming thinking",
                 "Programming Programming needs needs and needs expeience")
                  .flatMap(s->Stream.of(s.split("[\\s]")))
                 .collect(Collectors.groupingBy(String::toString,Collectors.counting()))
                  .forEach((s,c)->TextArea.appendText(s+": "+c+"\n")); 
          
          Employee []  employee ={
              new Employee(1, "Ahmed", "IT", 1201.9),
               new Employee(2, "Sami", "sales", 2222.9),
                new Employee(3, "Huda", "IT", 872.9),
                 new Employee(7, "Ali", "mam", 88.9),
                  new Employee(4, "Hani", "sales", 555.9),
              
              
          };
          
          
          List<Employee> listEmp  = Arrays.asList(employee);
           
           TextArea.appendText("\nSorted Employee : \n");
          
          
          
          listEmp.stream().filter(e->e.getSalary()>=1100)
                  .forEach(e->TextArea.appendText(e+"\n"));
          
          
          
          }
                  
          
    }
   
