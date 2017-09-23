package library.database;

public class Main {
	 
	public static void main(String[] args) {
		DatabaseHandler dbHandler = DatabaseHandler.getInstance();
		dbHandler.createNewDatabase();
		//dbHandler.createNewTable();
		//dbHandler.selectAll();
		dbHandler.createMemberTable();
	}

}
