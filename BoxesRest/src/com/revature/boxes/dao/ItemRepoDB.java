package com.revature.boxes.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.boxes.web.ConnectionService;

public class ItemRepoDB implements IItemRepo {

	@Override
	public Item addItem(Item item) {
		try {

			PreparedStatement itemStatement = ConnectionService.getConnection()
					.prepareStatement("INSERT INTO items VALUES (?, ?, ?, ?)");
			itemStatement.setString(1, item.getName());
			itemStatement.setString(2, item.getDescription());
			itemStatement.setDouble(3,  item.getWeight());
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
		// TODO Auto-generated method stub
		return null;
	}

}
