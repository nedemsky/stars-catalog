package org.universe.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.universe.model.Discoverer;


public interface DiscovererMapper {
	
	@Insert("INSERT INTO discoverer VALUES (#{name}) ")
	@Options(useGeneratedKeys=true, keyProperty="name", flushCache=true, keyColumn="name")
	public void addDiscoverer(Discoverer discoverer);
	
	
	@Update("UPDATE discoverer SET name=#{name}")
	@Options(useGeneratedKeys=true, keyProperty="name", flushCache=true, keyColumn="name")
	public void updateDiscoverer(Discoverer discoverer);
	
	
	@Delete("DELETE FROM discoverer WHERE name=#{name}")
	void deleteDiscoverer(String name);
	
		
	@Select("SELECT NAME as name FROM discoverer WHERE name=#{name}")
	public Discoverer getDiscovererByName(String name);
	
	
	@Select("SELECT NAME as name FROM discoverer")
	public List<Discoverer> listDiscoverers();
}
