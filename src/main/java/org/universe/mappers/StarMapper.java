package org.universe.mappers;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.universe.model.Star;


	


public interface StarMapper {
	
	@Insert("INSERT INTO star(name, altitude, longitude,"
			+ "clazz, discoverer) VALUES"
			+ "(#{name},#{altitude}, #{longitude}, "
			+ "#{clazz}, #{discoverer})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertStar(Star star);
	
	
	@Update("UPDATE star SET "
			+ "name=#{name},altitude=#{altitude}, longitude=#{longitude}, "
			+ "clazz=#{clazz}, discoverer=#{discoverer}")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void updateStar(Star star);
	
	
	@Delete("DELETE FROM star WHERE id =#{id} and clazz!='G'")
	void deleteStar(Integer id);
	
		
	@Select("SELECT Id as Id, NAME as name, altitude as altitude, "
			+ "longitude as longitude, clazz as clazz, "
			+ "discoverer as discoverer "
			+ "FROM star WHERE name = #{name}")
	public Star getStarByName(String name);
	
	@Select("SELECT Id as Id, NAME as name, altitude as altitude, "
			+ "longitude as longitude, clazz as clazz, "
			+ "discoverer as discoverer "
			+ "FROM star WHERE id = #{id}")
	public Star getStarById(Integer id);

	
	@Select("SELECT ID as id, NAME as name, altitude as altitude, "
			+ "longitude as longitude, clazz as clazz, "
			+ "discoverer as discoverer FROM star ")
	public List<Star> getStars();
	
	



}
