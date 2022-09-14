package com.projetTODO.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.projetTODO.models.Tache;
import com.projetTODO.repository.tacheRepository;

/**
 * Servlet implementation class tacheController
 */
public class tacheController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tacheController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tacheRepository tableTaches = new tacheRepository();
		
		if(request.getParameter("ajouterTache") != null) {

			request.setAttribute("categorieID", request.getParameter("categorieID"));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/formAjouterTache.jsp").forward(request, response);
		
		} else if(request.getParameter("modifierTache") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("tache", tableTaches.getTache(id));
			
			request.setAttribute("categorieID", request.getParameter("categorieID"));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/formModifierTache.jsp").forward(request, response);
		
		} else if(request.getParameter("supprimerTache") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			int categorieID = Integer.parseInt(request.getParameter("categorieID"));
			tableTaches.deleteTache(id);
			
			request.setAttribute("taches", tableTaches.recupererTaches(categorieID));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			request.setAttribute("categorieID", request.getParameter("categorieID"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeTaches.jsp").forward(request, response);
		    
		} else {

			int categorieID = Integer.parseInt(request.getParameter("categorieID"));
			
			request.setAttribute("taches", tableTaches.recupererTaches(categorieID));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			request.setAttribute("categorieID", request.getParameter("categorieID"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeTaches.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tache tache = new Tache();
		tacheRepository tableTaches = new tacheRepository();
		
		if(request.getParameter("ajouterTache") != null) {
			
			tache.setTitre(request.getParameter("titre"));
			tache.setCategorieID(Integer.parseInt(request.getParameter("categorieID")));
			tableTaches.ajouterTache(tache);
			
			request.setAttribute("taches", tableTaches.recupererTaches(Integer.parseInt(request.getParameter("categorieID"))));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			request.setAttribute("categorieID", request.getParameter("categorieID"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeTaches.jsp").forward(request, response);
		
		
		} else if(request.getParameter("modifierTache") != null) {

			tache.setId(Integer.parseInt(request.getParameter("id")));
			tache.setTitre(request.getParameter("titre"));
			tache.setCategorieID(Integer.parseInt(request.getParameter("categorieID")));
			tableTaches.modifierTache(tache);
			
			int categorieID = Integer.parseInt(request.getParameter("categorieID"));
			request.setAttribute("taches", tableTaches.recupererTaches(categorieID));
			request.setAttribute("categorieNom", request.getParameter("categorie"));
			request.setAttribute("categorieID", request.getParameter("categorieID"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeTaches.jsp").forward(request, response);
		
		}
	}

}