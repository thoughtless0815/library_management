package library.displaymember;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member {
	private final SimpleStringProperty name;
	private final SimpleStringProperty id;
	private final SimpleStringProperty mobile;
	private final SimpleStringProperty email;
	private final SimpleBooleanProperty availability;

	public Member(String name, String id, String mobile, String email, Boolean availability) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleStringProperty(id);
		this.mobile = new SimpleStringProperty(mobile);
		this.email = new SimpleStringProperty(email);
		this.availability = new SimpleBooleanProperty(availability);
	}

	public String getName() {
		return name.get();
	}

	public String getId() {
		return id.get();
	}

	public String getMobile() {
		return mobile.get();
	}

	public String getEmail() {
		return email.get();
	}

	public boolean getAvailability() {
		return availability.get();
	}

	

}


