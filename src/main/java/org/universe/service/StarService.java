package org.universe.service;

import java.util.List;

import org.universe.model.Star;

public interface StarService {
	
	void insertStar(Star star);
	void updateStar(Star star);
	void deleteStar(Integer id);
	boolean getStarByName(String name);
	Star getStarById(Integer id);
	List<Star> getStars(); 
}
