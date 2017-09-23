package library.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	private static DatabaseHandler handler = null; 
	
	final private String dbName = "bookdata.db";
	final private String url = "jdbc:sqlite:db_file/" + dbName;
	final private String tableName = "Books";
	Connection conn = null;
	private static Statement stmt = null;

	private DatabaseHandler() {
		// TODO Auto-generated constructor stub
		// DatabaseHandler dbHandler = new DatabaseHandler();
		createNewDatabase();
		//createBookTable();
		//createMemberTable();
		
	}
	
	public static DatabaseHandler getInstance(){
		if(handler == null){
			handler = new DatabaseHandler(); 
		}
		return handler;
		
	}

	public void createMemberTable() {
		// TODO Auto-generated method stub
		String tableName = "Member";
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" + "	id text PRIMARY KEY,\n"
				+ "	name text NOT NULL,\n" + "	mobile text NOT NULL, \n" + "email text, \n"
				+ "isAvail boolean default 1 \n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			// System.out.println("Table created sucessfully.");
			// System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
	}
	
	public void insertToMember(String id, String name, String mobile, String email) {
		String tableName = "Member";
		String sql = "INSERT INTO " + tableName + " (id,name,mobile,email) VALUES(?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mobile);
			pstmt.setString(4, email);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet selectAllFromMember() {
		String tableName = "Member";
		String sql = "SELECT * FROM " + tableName + "";

		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	private Connection connect() {
		// SQLite connection string

		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void createNewDatabase() {

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createBookTable() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" + "	id text PRIMARY KEY,\n"
				+ "	title text NOT NULL,\n" + "	author text NOT NULL, \n" + "publisher text, \n"
				+ "isAvail boolean by default true \n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			// System.out.println("Table created sucessfully.");
			// System.out.println(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert(String id, String title, String author, String publisher) {
		String sql = "INSERT INTO " + tableName + " (id,title,author,publisher) VALUES(?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet selectAll() {
		String sql = "SELECT * FROM " + tableName + "";

		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
