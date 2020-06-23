package com.revature.boxes.dao;
import java.util.List;

import com.revature.boxes.models.Box;

public interface IBoxRepo {
	public Box addHero(Box hero);
	public List<Box> getAllHeros();
}
