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
	public Box addHero(Box hero) {
		// 1. Insert one row with hero's single properties
		// 2. Insert one row per special move
		
		try {
			
			
			PreparedStatement heroStatement = ConnectionService.getConnection().prepareStatement("INSERT INTO heroes VALUES (?, ?, ?)");
			heroStatement.setString(1, hero.getName());
			heroStatement.setInt(2, hero.getHealthLevel());
			heroStatement.setInt(3, hero.isAlive()?1:0);
			heroStatement.executeUpdate();
			
			for (String move : hero.getSpecialMove()) {
				Statement moveStatement = ConnectionService.getConnection().createStatement();
				moveStatement.executeUpdate("INSERT INTO herospecialmoves (heroName, specialMove) VALUES ('"
						+ hero.getName() + "', '" + move + "');");
			}
			
			return hero;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Box> getAllHeros() {
		
		List<Box> result = new ArrayList<Box>();
		Map<String, ArrayList<String>> specialMoves = new HashMap<String, ArrayList<String>>();
		
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT h.*, hs.specialMove " + 
					"FROM heroes AS h " + 
					"LEFT JOIN herospecialmoves AS hs " + 
					"ON h.name = hs.heroname;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Box h = new Box();
				h.setName(rs.getString("name"));
				h.setHealthLevel(rs.getInt("healthLevel"));
				h.setAlive(rs.getInt("isAlive") == 1);
				if (!result.contains(h)) {
					result.add(h);
				}
				
				ArrayList<String> al = specialMoves.get(rs.getString("name"));
				if (al == null) {
					specialMoves.put(rs.getString("name"), new ArrayList<String>());
				}
				specialMoves.get(rs.getString("name")).add(rs.getString("specialmove"));
			}
			
			for (Box hero : result) {
				ArrayList<String> moves = specialMoves.get(hero.getName());
				if (moves != null) {
					hero.setSpecialMove(moves.toArray(new String[moves.size()]));
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
