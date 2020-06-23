package com.revature.boxes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.boxes.models.Box;
import com.revature.boxes.web.ConnectionService;

public class BoxRepoDB implements IBoxRepo{

	@Override
	public Box addBox(Box box) {
		// 1. Insert one row with hero's single properties
		// 2. Insert one row per special move
		
		try {
			
			
			PreparedStatement boxStatement = ConnectionService.getConnection().prepareStatement("INSERT INTO boxes VALUES (?, ?)");
			boxStatement.setString(1, box.getBoxLoc());
			boxStatement.setDouble(2, box.getBoxWeight());
			boxStatement.executeUpdate();			
			
			return box;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Box> getAllBoxes() {
		
		List<Box> result = new ArrayList<Box>();
		
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM boxes;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Box tempBox = new Box();
				tempBox.setBoxLoc(rs.getString("boxLoc"));
				tempBox.setBoxWeight(rs.getDouble("boxWeight"));
				tempBox.setBoxID(rs.getInt("boxID"));
				if (!result.contains(tempBox)) {
					result.add(tempBox);
				}
				
			}
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void removeBox(int boxID) {
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.execute("DELETE FROM boxes WHERE boxid = '" + boxID + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Box not found.");
	}

}