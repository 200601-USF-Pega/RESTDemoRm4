package com.revature.boxes.dao;
import java.util.List;

import com.revature.boxes.models.Box;

public interface IBoxRepo {
	public Box addBox(Box box);
	public List<Box> getAllBoxes();
	public void removeBox(int boxID);
}
