package com.revature.boxes.dao;

import java.util.List;

import com.revature.boxes.models.Item;

public interface IItemRepo {
	public Item addItem(Item item);
	public List<Item> getAllItems();
	public void deleteItem(int itemID);
}
