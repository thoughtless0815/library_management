package library.addmember;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import library.database.DatabaseHandler;

public class MemberController {
	@FXML
	private AnchorPane rootPane;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField name;

	@FXML
	private JFXTextField id;

	@FXML
	private JFXTextField mobile;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXButton saveButton;

	@FXML
	private JFXButton cancelButton;

	private DatabaseHandler dbHandler;

	@FXML
	public void addMember(ActionEvent event) {
		String mname = name.getText();
		String mid = id.getText();
		String mphn = mobile.getText();
		String mail = email.getText();

		dbHandler = DatabaseHandler.getInstance();


		if (mname.isEmpty() || mid.isEmpty() || mphn.isEmpty() || mail.isEmpty()) {
			Alert alrt = new Alert(Alert.AlertType.ERROR);
			alrt.show();
			return;
		} else {

			dbHandler.createMemberTable();
			dbHandler.insertToMember(mid, mname, mphn, mail);
			JOptionPane.showMessageDialog(null, "Success");
			name.setText("");
			id.setText("");
			mobile.setText("");
			email.setText("");
		}

	}

	@FXML
	public void cancel(ActionEvent event) {
		Stage stage = (Stage) rootPane.getScene().getWindow();
		stage.close();

	}

}
