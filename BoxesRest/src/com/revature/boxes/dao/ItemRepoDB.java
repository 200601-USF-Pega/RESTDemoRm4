package com.revature.boxes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.boxes.models.Item;
import com.revature.boxes.web.ConnectionService;

public class ItemRepoDB implements IItemRepo {

	@Override
	public Item addItem(Item item) {
		try {

			PreparedStatement itemStatement = ConnectionService.getConnection()
					.prepareStatement("INSERT INTO items (itemName, itemDesc, itemWeight, boxID) VALUES (?, ?, ?, ?)");
			itemStatement.setString(1, item.getItemName());
			itemStatement.setString(2, item.getItemDesc());
			itemStatement.setDouble(3, item.getItemWeight());
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
				Item tempItem = new Item(rs.getInt("itemID"), rs.getString("itemName"),
						rs.getString("itemDesc"), rs.getDouble("itemWeight"), rs.getInt("boxID"));
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
