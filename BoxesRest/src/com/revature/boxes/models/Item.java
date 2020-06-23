package com.revature.boxes.models;

import java.io.Serializable;

//POJO
public class Item implements Serializable {
	private int itemID;
	private String itemName;
	private String itemDesc;
	private double itemWeight;
	private int boxID;
	
	//when item is removed from box it is gone 
	//we do not have items without boxes
	
	//we have to look in a box to know its items ... else add box id to the item pojo

	public Item() {

	}
	
	//from db
	public Item(int itemID, String itemName, String itemDesc, double itemWeight, int boxID) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemWeight = itemWeight;
		this.boxID = boxID;
	}
	
	//create
	//box must be created because we need boxID from db to set it to a box
	
	public Item(String itemName, String itemDesc, double itemWeight, int boxID) {
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemWeight = itemWeight;
	}
	
	//item from db has boxID
	//box from db has no empty item list //always a join 
	//assign to box from db
	
	//never set box id.. because it must be initialized with a box
//	public void setBoxID(int boxID) {
//		this.boxID = boxID;
//	}
	
	public int getBoxID() {
		return boxID;
	}
	
	//remove from box
//	public void removeFromBox() {
//		this.boxID = (Integer) null;
//	}
	
	
	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(double itemWeight) {
		this.itemWeight = itemWeight;
	}
}