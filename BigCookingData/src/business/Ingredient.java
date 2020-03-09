package business;

public class Ingredient {

	private int id;
	private String name;
	private int poids;
	private int alim_grp_code;
	private int alim_ssgrp_code;
	private int alim_ssssgrp_code;
	private String alim_nom_fr;
	private int id_ingredient;
	private Unit unit;
	
	public Ingredient() {
		
	}
	public Ingredient(int id, String name, int poids, int alim_grp_code, int alim_ssgrp_code, int alim_ssssgrp_code,
			String alim_nom_fr, int id_ingredient, Unit unit) {
		super();
		this.id = id;
		this.name = name;
		this.poids = poids;
		this.alim_grp_code = alim_grp_code;
		this.alim_ssgrp_code = alim_ssgrp_code;
		this.alim_ssssgrp_code = alim_ssssgrp_code;
		this.alim_nom_fr = alim_nom_fr;
		this.id_ingredient = id_ingredient;
		this.unit = unit;
	}

	public int getAlim_grp_code() {
		return alim_grp_code;
	}

	public void setAlim_grp_code(int alim_grp_code) {
		this.alim_grp_code = alim_grp_code;
	}

	public int getAlim_ssgrp_code() {
		return alim_ssgrp_code;
	}

	public void setAlim_ssgrp_code(int alim_ssgrp_code) {
		this.alim_ssgrp_code = alim_ssgrp_code;
	}

	public int getAlim_ssssgrp_code() {
		return alim_ssssgrp_code;
	}

	public void setAlim_ssssgrp_code(int alim_ssssgrp_code) {
		this.alim_ssssgrp_code = alim_ssssgrp_code;
	}

	public String getAlim_nom_fr() {
		return alim_nom_fr;
	}

	public void setAlim_nom_fr(String alim_nom_fr) {
		this.alim_nom_fr = alim_nom_fr;
	}

	public int getId_ingredient() {
		return id_ingredient;
	}

	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient = id_ingredient;
	}

	public enum Unit {
		kG, mG, G, cL, mL, L, U, cac, cas
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int quantity) {
		this.poids = quantity;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
