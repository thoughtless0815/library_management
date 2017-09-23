package library.mainui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.addmember.MemberMain;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addMemBtn;

    @FXML
    private Button addBookBtn;

    @FXML
    private Button memTableBtn;

    @FXML
    private Button bookTableBtn;

    @FXML
    private Button settingBtn;

    @FXML
    void loadBook(ActionEvent event) {
    	//new MemberMain();
    	loadWindow("/library/addbook/addBook.fxml", "Add Books To Database");
    	
    	//System.out.println("dd");

    }

    @FXML
    void loadMem(ActionEvent event) {
    //	test();
    	loadWindow("/library/addmember/AddMember.fxml", "Add member to database");
    }

    @FXML
    void settings(ActionEvent event) {

    }

    @FXML
    void viewBook(ActionEvent event) {
    	loadWindow("/library/bookdisplay/table/DisplayBook.fxml", "All books");
    }

    @FXML
    void viewMem(ActionEvent event) {
    	loadWindow("/library/displaymember/DisplayMem.fxml", "All members");
    }

   
    
//    void test(){
//    	try {
//			// BorderPane root = new BorderPane();
//			Parent root = FXMLLoader.load(getClass().getResource("/library/src/library/addmember/AddMember.fxml"));
//			
//			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			Stage primaryStage = new Stage(StageStyle.DECORATED);
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
//    
 
    void loadWindow( String path, String title){
    	try {
			Parent root  = FXMLLoader.load(getClass().getResource(path));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

