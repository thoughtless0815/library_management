package library.bookdisplay.table;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.database.DatabaseHandler;
import javafx.scene.control.TableColumn;

public class DisplayBookController implements Initializable {
	@FXML
	private TableView<Book> tableView;
	@FXML
	private TableColumn<Book, String> titleColumn;
	@FXML
	private TableColumn<Book, String> idColumn;
	@FXML
	private TableColumn<Book, String> authorColumn;
	@FXML
	private TableColumn<Book, String> publisherColumn;
	@FXML
	private TableColumn<Book, Boolean> availabilityColumn;

	private ObservableList<Book> list = FXCollections.observableArrayList();
	
	/*@FXML
	public void initialize() {
		
		
		System.out.println("hello");
		
		
		

	}*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		initi();
		loadData();
		
	}

	private void loadData() {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		DatabaseHandler handler = DatabaseHandler.getInstance();
	
		ResultSet rs = handler.selectAll();
		try {
			while(rs.next()){
				String title = rs.getString("title");
				String id = rs.getString("id");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				Boolean isAvail = rs.getBoolean("isAvail");
				//String  isAvail = Boolean.toString() ;
				//System.out.println(title+" "+id+" "+isAvail);
				
				
				list.add(new Book(title, id, author, publisher, isAvail));
				
				
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
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
	}

	public static class Book {
		private final SimpleStringProperty title;
		private final SimpleStringProperty id;
		private final SimpleStringProperty author;
		private final SimpleStringProperty publisher;
		private final SimpleBooleanProperty availability;

		private Book(String title, String id, String author, String publisher, Boolean availability) {
			this.title = new SimpleStringProperty(title);
			this.id = new SimpleStringProperty(id);
			this.author = new SimpleStringProperty(author);
			this.publisher = new SimpleStringProperty(publisher);
			this.availability = new SimpleBooleanProperty(availability);
		}

		public String getTitle() {
			return title.get();
		}

		public String getId() {
			return id.get();
		}

		public String getAuthor() {
			return author.get();
		}

		public String getPublisher() {
			return publisher.get();
		}

		public Boolean getAvailability() {
			return availability.get();
		}

	}

	

}
