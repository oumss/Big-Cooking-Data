package business;

import java.util.ArrayList;

import persistance.IngredientPersistance;

public class Ingredient {

	private int poids;
	private int alim_grp_code;
	private int alim_ssgrp_code;
	private int alim_ssssgrp_code;
	private String alim_nom_fr;
	private int id_ingredient;
	
	public Ingredient() {
		
	}
	public Ingredient(int poids, int alim_grp_code, int alim_ssgrp_code, int alim_ssssgrp_code,
			String alim_nom_fr, int id_ingredient) {
		super();
		this.poids = poids;
		this.alim_grp_code = alim_grp_code;
		this.alim_ssgrp_code = alim_ssgrp_code;
		this.alim_ssssgrp_code = alim_ssssgrp_code;
		this.alim_nom_fr = alim_nom_fr;
		this.id_ingredient = id_ingredient;
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


	public int getPoids() {
		return poids;
	}

	public void setPoids(int quantity) {
		this.poids = quantity;
	}

	public String toString() {
		return "Ingredient [poids=" + poids + ", alim_grp_code=" + alim_grp_code + ", alim_ssgrp_code="
				+ alim_ssgrp_code + ", alim_ssssgrp_code=" + alim_ssssgrp_code + ", alim_nom_fr=" + alim_nom_fr
				+ ", id_ingredient=" + "id_ingredient" + "\n";
	}
	
	public void associateIngredient() {
		IngredientPersistance ip = new IngredientPersistance();
		Ingredient ingredient = new Ingredient(this.poids, this.alim_grp_code, this.alim_ssgrp_code, this.alim_ssssgrp_code,
			this.alim_nom_fr, this.id_ingredient);
		ArrayList<Ingredient> ingChoice = ip.readIngredientWithLike(ingredient);
		double current = 0;
		double percentage;
		
		for(Ingredient z : ingChoice) {
			percentage = StringSimilarity.similarity(ingredient.getAlim_nom_fr() , z.getAlim_nom_fr());
			if ( current <= (percentage) )  {     
				current = percentage;
				this.setAlim_grp_code(z.getAlim_grp_code());
				this.setAlim_nom_fr(z.getAlim_nom_fr());
				this.setAlim_ssgrp_code(z.getAlim_ssgrp_code());
				this.setAlim_ssssgrp_code(z.getAlim_ssssgrp_code());
				this.setId_ingredient(z.getId_ingredient());
				this.setPoids(z.getPoids());
			}
		}

		
	}

	

}
