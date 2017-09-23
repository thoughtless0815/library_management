package library.displaymember;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import library.bookdisplay.table.DisplayBookController.Book;
import library.database.DatabaseHandler;

public class DisplayMemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Member> tableView;

    @FXML
    private TableColumn<Member, String> nameCol;

    @FXML
    private TableColumn<Member, String> idCol;

    @FXML
    private TableColumn<Member, String> mobileCol;

    @FXML
    private TableColumn<Member, String> emailCol;

    @FXML
    private TableColumn<Member, Boolean> availCol;

    ObservableList<Member> list = FXCollections.observableArrayList();
    
    @FXML
    public void initialize() {
    	
    //	System.out.println("hello");
       initi();
   //	System.out.println("hello");

       loadData();

    }
    
    private void loadData() {
		// TODO Auto-generated method stub
		DatabaseHandler handler = DatabaseHandler.getInstance();
	
		ResultSet rs = handler.selectAllFromMember();
		try {
			while(rs.next()){
				String name = rs.getString("name");
				String id = rs.getString("id");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				Boolean isAvail = rs.getBoolean("isAvail");
				//String isAvail = rs.getString("isAvail");
				//String  isAvail = Boolean.toString() ;
				//System.out.println(isAvail);
				
				
				list.add(new Member(name, id, mobile, email, isAvail));				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println(list.get(0).getTitle());
		tableView.setItems(list);
		
		
		//tableView.getItems().setAll(list);
		//System.out.println("is true");
		
	}

	private void initi() {
		// TODO Auto-generated method stub
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		availCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
	}

    
    
}
