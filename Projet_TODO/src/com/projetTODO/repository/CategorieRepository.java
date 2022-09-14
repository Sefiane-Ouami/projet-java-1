package com.projetTODO.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetTODO.models.Categorie;

public class CategorieRepository {
private Connection connexion;
	
	//Methode pour recuperer la liste des noms des categories de la base de donnees
	
	public List<Categorie> recupererCategories() {
		List<Categorie> categories = new ArrayList<Categorie>();
		Statement statement = null;
		ResultSet resultat = null;
		
		//Fonction pour faire le chargement du Driver et la connexion a la bd
		loadDataBase();
		
		try {
			statement = connexion.createStatement();
			
			//Execution de la requete
			resultat = statement.executeQuery("SELECT id, nom, description FROM categories;");
			
			//Recuperation des donnees
			while(resultat.next()) {
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String description = resultat.getString("description");
				
				Categorie categorie = new Categorie();
				categorie.setId(id);
				categorie.setNom(nom);
				categorie.setDesc(description);
				
				categories.add(categorie);
			}
			
		} catch(SQLException e) {
		} finally {
			//Fermeture de la connexion
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		
		return categories;
	}
	
	public Categorie getCategorie(int idCategorie) {
		Categorie categorie = new Categorie();
		Statement statement = null;
		ResultSet resultat = null;
		
		//Fonction pour faire le chargement du Driver et la connexion a la bd
		loadDataBase();
		
		try {
			statement = connexion.createStatement();
			
			//Execution de la requete
			PreparedStatement pstmt = connexion.prepareStatement("SELECT id, nom, description FROM categories where id = ?");
			pstmt.setInt(1, idCategorie);
			resultat = pstmt.executeQuery();
			
			//Recuperation des donnees
			while(resultat.next()) {
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String description = resultat.getString("description");
				
				categorie.setId(id);
				categorie.setNom(nom);
				categorie.setDesc(description);
			}
			
		} catch(SQLException e) {
		} finally {
			//Fermeture de la connexion
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		
		return categorie;
	}
	
	//Methode pour ajouter une categorie a la base de donnees
	public void ajouterCategorie(Categorie categorie) {
		loadDataBase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO categories(nom, description) VALUES(?, ?) ");
			preparedStatement.setString(1, categorie.getNom());
			preparedStatement.setString(2, categorie.getDesc());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierCategorie(Categorie categorie) {
		loadDataBase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE categories SET nom = ?, description = ? WHERE id = ? ");
			preparedStatement.setString(1, categorie.getNom());
			preparedStatement.setString(2, categorie.getDesc());
			preparedStatement.setInt(3, categorie.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Methode pour supprimer une categorie de la base de donnees
	public void deleteCategorie(int id) {
		loadDataBase();
		PreparedStatement pstmt;
		try {
			pstmt = connexion.prepareStatement("Delete FROM categories where id = ?");
			pstmt.setInt(1, id);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//La methode loadDatabase
	public void loadDataBase() {
		//Chargement du Driver 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
		}
		
		//Connexion a la base de donnees
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
