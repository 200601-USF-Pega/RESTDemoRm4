package com.revature.boxes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.boxes.models.Box;
import com.revature.boxes.web.ConnectionService;

public class ItemRepoDB implements IItemRepo {

	@Override
	public Item addItem(Item item) {
		try {

			PreparedStatement itemStatement = ConnectionService.getConnection()
					.prepareStatement("INSERT INTO items VALUES (?, ?, ?, ?)");
			itemStatement.setString(1, item.getName());
			itemStatement.setString(2, item.getDescription());
			itemStatement.setDouble(3, item.getWeight());
			itemStatement.setInt(4, item.getBoxID());
			itemStatement.executeUpdate();

			return item;

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> result = new ArrayList<Item>();

		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM items;");

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Item tempItem = new Item();
				tempItem.setID(rs.getInt("itemID"));
				tempItem.setName(rs.getString("itemName"));
				tempItem.setDescription(rs.getString("itemDesc"));
				tempItem.setWeight(rs.getDouble("itemWeight"));
				tempItem.setBoxID(rs.getInt("boxID"));
				if (!result.contains(tempItem)) {
					result.add(tempItem);
				}

			}

			return result;

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
	
	public void deleteItem(int itemID) {
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.execute("DELETE FROM items WHERE itemID = '" + itemID + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Item not found.");
	}

}
