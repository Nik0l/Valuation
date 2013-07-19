package AAR;

import java.sql.*;

public class SQLiteJDBC
{
	public static String name;
	public static Connection c;
    public static Statement stmt;
  public static void main( String args[] )
  {
	  name = "somename2";
	  createTable(name);
	  insert(name);
	  select(name);
  }
  
  public static void createTable(String name) {
	    c = null;
	    stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE " + name +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " AGE            INT     NOT NULL, " + 
	                   " ADDRESS        CHAR(50), " + 
	                   " SALARY         REAL)"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
  }
  
  public static void insert(String name) {
	    c = null;
	    stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "INSERT INTO " + name + " (ID,NAME,AGE,ADDRESS,SALARY) " +
	                   "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO " + name + " (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO " + name + " (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	      stmt.executeUpdate(sql);

	      sql = "INSERT INTO " + name + " (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	      stmt.executeUpdate(sql);

	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	  }
  public static void select(String name) {
	    c = null;
	    stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	  }
  public static void update(String name) {
	    c = null;
	    stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "UPDATE " + name + " set SALARY = 25000.00 where ID=1;";
	      stmt.executeUpdate(sql);
	      c.commit();
	      ResultSet();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
  }
  public static void delete(String name) {
	    c = null;
	    stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "DELETE from " + name + " where ID=2;";
	      stmt.executeUpdate(sql);
	      c.commit();
	      ResultSet();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
  }
  
  public static String insertPos(int ID, String Name, int Age, String Address, float Salary) throws SQLException {
	  String sql = "INSERT INTO " + name + " (ID,NAME,AGE,ADDRESS,SALARY) " +
	               "VALUES (" + ID +"," + Name + "," + Age + "," + Address + "," + Salary + " );"; 
	  stmt.executeUpdate(sql);
	  return sql;  
  }
  
  public static void printoutPos(int id, String Name, int age, String address, float salary) {
      System.out.println( "ID = " + id );
      System.out.println( "NAME = " + Name );
      System.out.println( "AGE = " + age );
      System.out.println( "ADDRESS = " + address );
      System.out.println( "SALARY = " + salary );
      System.out.println();
  }
  
  public static void ResultSet() throws SQLException {
      ResultSet rs = stmt.executeQuery( "SELECT * FROM " + name + ";" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  Name = rs.getString("name");
         int age  = rs.getInt("age");
         String  address = rs.getString("address");
         float salary = rs.getFloat("salary");
         printoutPos(id, Name, age, address, salary);
      }
      rs.close();
  }
}