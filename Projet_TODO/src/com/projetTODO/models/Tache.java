package com.projetTODO.models;

public class Tache {
	private int id;
	private String titre;
	private int categorieID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getCategorieID() {
		return categorieID;
	}
	public void setCategorieID(int categorieID) {
		this.categorieID = categorieID;
	}
}
