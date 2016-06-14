package org.universe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.universe.mappers.StarMapper;
import org.universe.model.Star;

@Service("starService")
public class StarServiceImpl implements StarService {

	
	@Autowired
	private StarMapper starMapper;
	
	@Transactional
	public void insertStar(Star star) {
		starMapper.insertStar(star);
	}


	@Transactional
	public void updateStar(Star star) {
		starMapper.updateStar(star);
	}	
	
	public void deleteStar(Integer id) {
		starMapper.deleteStar(id);
	}	
	
	public boolean getStarByName(String name) {
		Star star = starMapper.getStarByName(name);
		if(star != null) {
			return true;
		}
		return false;
	}
	
	
	public Star getStarById(Integer id) {
		return starMapper.getStarById(id);
	}
	
	
	public List<Star> getStars() {
		List<Star> stars = starMapper.getStars();
		return stars;
	}

}
