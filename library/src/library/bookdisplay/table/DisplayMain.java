package library.bookdisplay.table;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//System.out.println("gfg");
			Parent root = FXMLLoader.load(getClass().getResource("DisplayBook.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
