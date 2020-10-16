package com.example.recipes.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String flavour;

	private String type;

	private int noIngred;

	public Recipes() { // REQUIRED
		super();
	}

	public Recipes(String name, String flavour, String type, int noIngred) {
		super();
		this.name = name;
		this.flavour = flavour;
		this.type = type;
		this.noIngred = noIngred;

	}

	@Override
	public String toString() {
		return "Recipes [name=" + name + ", type=" + type + ", noIngred=" + noIngred + ", flavour=" + flavour + "]";

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoIngred() {
		return noIngred;
	}

	public void setNoIngred(int noIngred) {
		this.noIngred = noIngred;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Recipes other = (Recipes) obj;
//		if (flavour != other.flavour)
//			return false;
//		if (type != other.type)
//			return false;
//		if (flavour == null) {
//			if (other.flavour != null)
//				return false;
//		} else if (!flavour.equals(other.flavour))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

}