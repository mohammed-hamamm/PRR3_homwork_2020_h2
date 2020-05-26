/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StreamsApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Extreme
 */
public class ListViewpanController implements Initializable {
    @FXML
    private ListView<?> ListView;
    @FXML
    private Button ButtonShow;
    @FXML
    private Button ButtonRest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ButtonShowHandle(ActionEvent event) {
    }

    @FXML
    private void ButtonRestHandle(ActionEvent event) {
    }
    
}
