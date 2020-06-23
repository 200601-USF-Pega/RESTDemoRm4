package com.revature.boxes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.boxes.models.Box;
import com.revature.boxes.web.ConnectionService;

public class BoxRepoDB implements IBoxRepo{

	@Override
	public Box addBox(Box box) {
		// 1. Insert one row with hero's single properties
		// 2. Insert one row per special move
		
		try {
			
			
			PreparedStatement boxStatement = ConnectionService.getConnection().prepareStatement("INSERT INTO boxes VALUES (?, ?)");
			boxStatement.setString(1, box.getLocation());
			boxStatement.setInt(2, box.getWeight());
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
				tempBox.setLocation(rs.getString("boxLoc"));
				tempBox.setWeight(rs.getDouble("boxWeight"));
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

}
