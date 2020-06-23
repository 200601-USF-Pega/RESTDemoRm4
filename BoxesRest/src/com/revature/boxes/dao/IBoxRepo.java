package com.revature.boxes.dao;
import java.util.List;

import com.revature.boxes.models.Box;

public interface IBoxRepo {
	public Box addBox(Box hero);
	public List<Box> getAllBoxes();
	public boolean removeBox(Box box);
}
