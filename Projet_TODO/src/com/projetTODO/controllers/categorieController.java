package com.projetTODO.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.projetTODO.models.Categorie;
import com.projetTODO.repository.CategorieRepository;

/**
 * Servlet implementation class categorieController
 */
public class categorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categorieController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieRepository tableCategories = new CategorieRepository();
		
		if(request.getParameter("ajouterCategorie") != null) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/formAjouterCategorie.jsp").forward(request, response);
		
		} else if(request.getParameter("modifierCategorie") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("categorie", tableCategories.getCategorie(id));
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/formModifierCategorie.jsp").forward(request, response);
		
		} else if(request.getParameter("supprimerCategorie") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			tableCategories.deleteCategorie(id);
			request.setAttribute("categories", tableCategories.recupererCategories());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeCategories.jsp").forward(request, response);
		    
		} else {
			
			request.setAttribute("categories", tableCategories.recupererCategories());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeCategories.jsp").forward(request, response);
		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categorie categorie = new Categorie();
		CategorieRepository tableCategories = new CategorieRepository();
		
		if(request.getParameter("ajouterCategorie") != null) {
			
			categorie.setNom(request.getParameter("nom"));
			categorie.setDesc(request.getParameter("description"));
			tableCategories.ajouterCategorie(categorie);
			
			request.setAttribute("categories", tableCategories.recupererCategories());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeCategories.jsp").forward(request, response);
		
		
		} else if(request.getParameter("modifierCategorie") != null) {
			
			categorie.setId(Integer.parseInt(request.getParameter("id")));
			categorie.setNom(request.getParameter("nom"));
			categorie.setDesc(request.getParameter("description"));
			tableCategories.modifierCategorie(categorie);
			
			request.setAttribute("categories", tableCategories.recupererCategories());
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeCategories.jsp").forward(request, response);
		
		}
	}
}
