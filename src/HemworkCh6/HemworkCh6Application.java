package com.example.HemworkCh6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HemworkCh6Application extends Application{

	public static void main(String[] args) {
		//SpringApplication.run(HemworkCh6Application.class, args);
                launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TableView.fxml"));
        loader.setControllerFactory(SpringApplication.run(HemworkCh6Application.class)::getBean);
        Pane pane = loader.load();
        Scene sc = new Scene(pane);
        primaryStage.setTitle("HemworkCh6");
        primaryStage.setScene(sc);
        primaryStage.show();
        
        
    }

}
