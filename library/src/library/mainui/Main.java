package library.mainui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.database.DatabaseHandler;
//import javafx.stage.StageStyle;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
			Scene sc = new Scene(root);
			//primaryStage.getStyle(StageStyle.DECORATED);
			primaryStage.setScene(sc);
			primaryStage.show();
			DatabaseHandler.getInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
