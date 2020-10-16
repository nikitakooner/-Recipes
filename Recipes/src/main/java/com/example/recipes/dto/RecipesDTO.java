package com.example.recipes.dto;

public class RecipesDTO {

	private Long id;

	private String name;

	private String type;

	private String flavour;
	
	private int noIngred;

	public RecipesDTO(Long id, String name, String type, String flavour,int noIngred) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.flavour = flavour;
		this.noIngred = noIngred; 
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public int getNoIngred() {
		return noIngred;
	}


	public void setNoIngred(int noIngred) {
		this.noIngred = noIngred;
	}

	

}
