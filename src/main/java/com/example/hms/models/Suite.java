package com.example.hms.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Suite {
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String code;

	@Column(unique = true)
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String longDesc;
	
	@OneToMany
	private List<Room> rooms;
	
	private Suite() {}

	public Suite(String code, String name, String description, String longDesc) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.longDesc = longDesc;
	}

	public Suite(String code, String description, String longDesc, List<Room> rooms) {
		this.code = code;
		this.description = description;
		this.longDesc = longDesc;
		this.rooms = rooms;
	}

	public Suite(String code, String description, String name) {
		this.code = code;
		this.description = description;
		this.name = name;
	}

	public Suite(String description, String longDesc) {
		this.description = description;
		this.longDesc = longDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	

}
