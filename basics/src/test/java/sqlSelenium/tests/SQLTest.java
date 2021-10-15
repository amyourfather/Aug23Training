package sqlSelenium.tests;

import static org.junit.Assert.assertTrue;

import java.sql.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SQLTest {
		private static final String DB_URL = "jdbc:mysql://localhost/sakila?useSSL=false";
	    private static final String USER = "root";
	    private static final String PASS = "drse9520";
	    private Statement stmt = null;

	   @Before
	   public void beforeSetting() {
	      // Open a connection
	      try {
	    	    Class.forName("com.mysql.cj.jdbc.Driver");  
	    	  	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        this.stmt = conn.createStatement();
		        
	      } catch (Exception e) {
	         e.printStackTrace();
	      } 
	   }
	   
	   @Test
	   public void test1() throws SQLException {
		   String QUERY = "SELECT * FROM sakila.city\r\n"
			   		+ "order by city desc\r\n"
			   		+ "limit 10;";
		   ArrayList<String> expected = new ArrayList<String>();
		   expected.add("Ziguinchor");
		   expected.add("Zhoushan");
		   expected.add("Zhezqazghan");
		   expected.add("Zeleznogorsk");
		   expected.add("Zaria");
		   expected.add("Zapopan");
		   expected.add("Zaoyang");
		   expected.add("Zanzibar");
		   expected.add("Zalantun");
		   expected.add( "Yuzhou");
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<String> as = new ArrayList<String>();
	        // Extract data from result set
	        while (rs.next()) {
	        	// Retrieve by column name
	        	as.add(rs.getString("city"));
	        	//System.out.print("ID: " + rs.getString("city"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test2() throws SQLException {
		   String QUERY = "SELECT * FROM sakila.film\r\n"
		   		+ "where title like \"%AIRPLANE%\";";
		   ArrayList<Integer> expected = new ArrayList<Integer>();
		   expected.add(7);
		   expected.add(711);
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<Integer> as = new ArrayList<Integer>();
	        while (rs.next()) {
	        	as.add(rs.getInt("film_id"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test3() throws SQLException {
		   String QUERY = "SELECT amount FROM sakila.payment\r\n"
		   		+ "order by amount desc\r\n"
		   		+ "limit 1;";
		   ArrayList<Float> expected = new ArrayList<Float>();
		   expected.add((float) 11.99);
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<Float> as = new ArrayList<Float>();
	        while (rs.next()) {
	        	as.add(rs.getFloat("amount"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test4() throws SQLException {
		   String QUERY = "SELECT count(store_id) as StoreID1Count FROM sakila.customer\r\n"
		   		+ "where store_id = 1;";
		   ArrayList<Integer> expected = new ArrayList<Integer>();
		   expected.add(326);
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<Integer> as = new ArrayList<Integer>();
	        while (rs.next()) {
	        	as.add(rs.getInt("StoreID1Count"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test5() throws SQLException {
		   String QUERY = "SELECT * FROM sakila.customer\r\n"
		   		+ "where email = \"NANCY.THOMAS@sakilacustomer.org\";";
		   ArrayList<String> expected = new ArrayList<String>();
		   expected.add("NANCY.THOMAS@sakilacustomer.org");
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<String> as = new ArrayList<String>();
	        while (rs.next()) {
	        	as.add(rs.getString("email"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test6() throws SQLException {
		   String QUERY = "select a.film_info from actor_info as a\r\n"
		   		+ "where a.first_name = 'Bob' and a.last_name = 'Fawcett';";
		   ArrayList<String> expected = new ArrayList<String>();
		   expected.add("Action: DARN FORRESTER; Animation: DARES PLUTO, LAWLESS VISION, "
		   		+ "OSCAR GOLD; Children: CIRCUS YOUTH; Classics: DYNAMITE TARZAN; Comedy: "
		   		+ "CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; Documentary: "
		   		+ "ADAPTATION HOLES, PELICAN COMFORTS; Drama: JACKET FRISCO, SCORPION APOLLO; "
		   		+ "Family: HOMICIDE PEACH; Games: DAZED PUNK; Horror: ACE GOLDFINGER; "
		   		+ "Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; "
		   		+ "New: CHINATOWN GLADIATOR, JUMANJI BLADE, "
		   		+ "RUN PACIFIC; Sci-Fi: RAGING AIRPLANE; Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE");
		  
		   ResultSet rs = this.stmt.executeQuery(QUERY);
		   ArrayList<String> as = new ArrayList<String>();
	        while (rs.next()) {
	        	as.add(rs.getString("film_info"));
        }
	        assertTrue(expected.equals(as));
	   }
	   
	   @Test
	   public void test7() throws SQLException {
		   String QUERY = "SELECT * FROM sakila.customer\r\n"
			   		+ "where email = \"NANCY.THOMAS@sakilacustomer.org\";";
			   ArrayList<String> expected = new ArrayList<String>();
			   expected.add("NANCY.THOMAS@sakilacustomer.org");
			  
			   ResultSet rs = this.stmt.executeQuery(QUERY);
			   ArrayList<String> as = new ArrayList<String>();
		        while (rs.next()) {
		        	as.add(rs.getString("email"));
	        }
		        assertTrue(expected.equals(as));
	   }
	   
}
