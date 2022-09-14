package com.projetTODO.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetTODO.models.Tache;

public class tacheRepository {
	
private Connection connexion;
private PreparedStatement pst;
	
	//Methode pour recuperer la liste des taches de catgorie de la base de donnees
	
	  public List<Tache> recupererTaches(int categorieID) {
		List<Tache> taches = new ArrayList<Tache>();
		Statement statement = null;
		ResultSet resultat = null;
		
		//Fonction pour faire le chargement du Driver et la connexion a la bd
		 loadDataBase();
		
		try {
			statement = connexion.createStatement();
			

	        // Prepare Statement
			 PreparedStatement pstmt = connexion.prepareStatement("SELECT id,titre FROM tache where categorieID = ?");
			 pstmt.setInt(1, categorieID);
			 resultat = pstmt.executeQuery();
			
			//Recuperation des donnees
			while(resultat.next()) {
				int id = resultat.getInt("id");
				String titre = resultat.getString("titre");
				
				Tache tache = new Tache();
			
				tache.setTitre(titre);
				tache.setId(id);
				
				taches.add(tache);
			}
			
		} catch(SQLException e) {
		} finally {
			//Fermeture de la connexion
			try {
				if(resultat != null) {
					resultat.close();
				}
					
				if(pst != null) {
					statement.close();
				}
				if(connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		
		return taches;
	}
	  
	  public Tache getTache(int idTache) {
			Tache tache = new Tache();
			Statement statement = null;
			ResultSet resultat = null;
			
			//Fonction pour faire le chargement du Driver et la connexion a la bd
			loadDataBase();
			
			try {
				statement = connexion.createStatement();
				
				//Execution de la requete
				PreparedStatement pstmt = connexion.prepareStatement("SELECT id, titre, categorieID FROM tache where id = ?");
				pstmt.setInt(1, idTache);
				resultat = pstmt.executeQuery();
				
				//Recuperation des donnees
				while(resultat.next()) {
					int id = resultat.getInt("id");
					String titre = resultat.getString("titre");
					int categorieID = resultat.getInt("categorieID");
					
					tache.setId(id);
					tache.setTitre(titre);
					tache.setCategorieID(categorieID);
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
			
			return tache;
		}
	
	//Methode pour ajouter une tache a la base de donnees
	public void ajouterTache(Tache tache) {
		loadDataBase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO tache(titre, categorieID) VALUES(?, ?) ");
			preparedStatement.setString(1, tache.getTitre());
			preparedStatement.setInt(2, tache.getCategorieID());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierTache(Tache tache) {
		loadDataBase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE tache SET titre = ?, categorieID = ? WHERE id = ? ");
			preparedStatement.setString(1, tache.getTitre());
			preparedStatement.setInt(2, tache.getCategorieID());
			preparedStatement.setInt(3, tache.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	  
	//Methode pour supprimer une tache de la base de donnees
	public void deleteTache(int id) {
		loadDataBase();
		PreparedStatement pstmt;
		try {
			pstmt = connexion.prepareStatement("Delete FROM tache where id = ?");
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
