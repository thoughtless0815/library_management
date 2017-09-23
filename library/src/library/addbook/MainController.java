package library.addbook;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import library.database.DatabaseHandler;

public class MainController {
	@FXML
    private AnchorPane rootPane;
	
    @FXML
    private JFXTextField title;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField author;

    @FXML
    private JFXTextField publisher;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;
    
    DatabaseHandler dbHandler;
    @FXML
    void addBook(ActionEvent event) {
    	dbHandler =  DatabaseHandler.getInstance();
    	String bookId = id.getText();
    	String bookTitle = title.getText();
    	String bookAuthor = author.getText();
    	String bookPublisher = publisher.getText();
    	
    	if(bookId.isEmpty() || bookTitle.isEmpty() || bookAuthor.isEmpty() || bookPublisher.isEmpty()){
    		Alert alrt = new Alert(Alert.AlertType.ERROR);
    		alrt.show();
    		return;
    		//JOptionPane.showMessageDialog(null, "Please enter correctly");
    	}else{
    		dbHandler.insert(bookId, bookTitle, bookAuthor, bookPublisher);
    		JOptionPane.showMessageDialog(null, "Success");
    	}    	
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
    	stage.close();
    }

}

