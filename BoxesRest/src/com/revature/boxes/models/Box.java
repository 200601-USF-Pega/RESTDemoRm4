package com.revature.boxes.models;

import java.io.Serializable;
import java.util.ArrayList;

//POJO
public class Box implements Serializable {
	private int boxID;
	private String boxLoc;
	private int boxWeight;
	private ArrayList<Item> items;

	public Box() {

	}
	
	//from db join
	public Box(int boxID, String boxLoc, int boxWeight, ArrayList<Item> items) {
		this.boxID = boxID;
		this.boxLoc = boxLoc;
		this.boxWeight = boxWeight;
		this.items = items;
	}
	
	//from db no join
	public Box(int boxID, String boxLoc, int boxWeight) {
		this.boxID = boxID;
		this.boxLoc = boxLoc;
		this.boxWeight = boxWeight;
	}
	
	//create
	public Box(String boxLoc, int boxWeight) {
		this.boxLoc = boxLoc;
		this.boxWeight = boxWeight;
	}

	public int getBoxID() {
		return boxID;
	}

	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}

	public String getBoxLoc() {
		return boxLoc;
	}

	public void setBoxLoc(String boxLoc) {
		this.boxLoc = boxLoc;
	}

	public int getBoxWeight() {
		return boxWeight;
	}

	public void setBoxWeight(int boxWeight) {
		this.boxWeight = boxWeight;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void setItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(String itemName) {
		this.items.removeIf(item -> item.getItemName().equals(itemName));
	}
	
	
}
