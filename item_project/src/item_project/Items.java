package item_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Items {

	private String name = " "; 
	private int quantity = 0; 
	private double price = 0.0;
	

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Items getItemById(int id, Connection conn) throws SQLException
	{
	
		Items item = null;
		String ById = "SELECT * FROM ITEM_TABLE "
				+ "Where item_id = ?";
		PreparedStatement stmt = conn.prepareStatement(ById);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		
		
		if(result != null ) {
			
			item.setName(result.getString(2));
			item.setPrice(result.getDouble(3));
			item.setQuantity(result.getInt(4));
			
			
		}
		
		 return item;
		
		
	}
	
	
	public static List<Items> getItemsCostingGreaterThan(double price, Connection conn) throws SQLException {
		
		List<Items> item = new ArrayList<Items>();
	
		String ById = "SELECT * FROM ITEM_TABLE "
				+ " Where item_price > ? ";
		
		PreparedStatement stmt = conn.prepareStatement(ById);
		stmt.setDouble(1, price);
		ResultSet result = stmt.executeQuery();
		
		
		while(result != null && result.next() ) {
			
			Items local = new Items();
			local.setName(result.getString(2));
			local.setQuantity(result.getInt(3));
			local.setPrice(result.getDouble(4));
			
			item.add(local);
		}
		
		return item;
	}
	
	
	public static List<Items> getItemsInStock(Connection conn) throws SQLException {
		
		
		List<Items> item = new ArrayList<Items>();	
		String ALL = "SELECT * FROM item_table "
				+ " WHERE item_quantity_in_stock > 0";	
		
		
		PreparedStatement stmt = conn.prepareStatement(ALL);
		ResultSet result = stmt.executeQuery();
		
		
		while(result != null && result.next() ) {
			
			Items local = new Items();
			local.setName(result.getString(2));
			local.setPrice(result.getDouble(3));
			local.setQuantity(result.getInt(4));
			
			item.add(local);
		}
		
		return item;
	}
	
}
