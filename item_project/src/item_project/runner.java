package item_project;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class runner extends Items{
	
	public static void main(String [] args ) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "james", "password");

		List<Items> items = new ArrayList<Items>();	
		
//		items = getItemsInStock(conn);
		items = getItemsCostingGreaterThan(1.49, conn);	
		for (Items i : items) {
			
			System.out.println(i.getName());
			System.out.println("$" + i.getPrice());
			System.out.println(i.getQuantity());
			
		}
	}

}
