package com.example.hms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Integer price;
	
	@Column
	@Enumerated
	private BookingStatus status;
	
	@ManyToOne
	private Suite suite;

	private Room(){}
	
	public Room(String description, Integer price, Suite suite) {
		super();
		this.description = description;
		this.price = price;
		this.suite = suite;
	}
	
	public Room(String name, String code, String description, Integer price, BookingStatus status, Suite suite) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		this.status = status;
		this.suite = suite;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}
	

}
