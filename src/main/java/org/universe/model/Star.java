package org.universe.model;



public class Star {
	
	public Star() {
	}
	
	public Star(String name) {
		this.name = name;
	}
	
	private Integer id;
	
	private String name;

	private String altitude;
	private String longitude;
	
	private String clazz;
	private String discoverer;
	
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDiscoverer() {
		return discoverer;
	}
	public void setDiscoverer(String discoverer) {
		this.discoverer = discoverer;
	}


	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
