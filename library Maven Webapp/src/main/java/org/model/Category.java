package org.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Integer pid;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String name, String description, Integer pid) {
		this.name = name;
		this.description = description;
		this.pid = pid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:" + name + "description:" + description + "pid" + pid;
	}
}