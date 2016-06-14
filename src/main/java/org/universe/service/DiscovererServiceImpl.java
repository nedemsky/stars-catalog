package org.universe.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.universe.mappers.DiscovererMapper;
import org.universe.model.Discoverer;

@Service("discovererService")
public class DiscovererServiceImpl implements DiscovererService {
	
		@Autowired
		private DiscovererMapper discovererMapper;



		@Transactional
		public void addDiscoverer(Discoverer d) {
			discovererMapper.addDiscoverer(d);
		}

		@Transactional
		public void updateDiscoverer(Discoverer d) {
			discovererMapper.updateDiscoverer(d);
		}

		public List<Discoverer> listDiscoverers() {
			List<Discoverer> discoverers = discovererMapper.listDiscoverers();
			return discoverers;
		}

		@Transactional
		public Discoverer getDiscovererByName(String name) {
			return discovererMapper.getDiscovererByName(name);
		}

		@Transactional
		public void deleteDiscoverer(String name) {
			this.discovererMapper.deleteDiscoverer(name);
		}

}
