package org.universe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.universe.model.Discoverer;

public interface DiscovererService {


	public void addDiscoverer(Discoverer d);

	public void updateDiscoverer(Discoverer d); 

	public List<Discoverer> listDiscoverers(); 

	public Discoverer getDiscovererByName(String name); 

	public void deleteDiscoverer(String name);
	

}
