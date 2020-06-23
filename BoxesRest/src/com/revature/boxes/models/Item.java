package com.revature.boxes.models;

import java.io.Serializable;

//POJO
public class Item implements Serializable {
	private int itemID;
	private String itemName;
	private String itemDesc;
	private int itemWeight;
	private Box box;

	public Item() {

	}
	
	//from db
	public Item(int itemID, String itemName, String itemDesc, int itemWeight, Box box) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemWeight = itemWeight;
		this.box = box;
	}
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

	public int getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	//create
	public Item(String itemName, String itemDesc, int itemWeight) {
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemWeight = itemWeight;
	}
}
