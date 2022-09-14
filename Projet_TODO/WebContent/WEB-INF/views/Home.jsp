<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Required meta tags --> 
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Page d'accueil</title>
		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/style.css">
	<style>
        nav{
            background-color: darkblue !important;
            color: #FFFFFF;
        }
    </style>	
	</head>
	<body data-spy="scroll" data-target=".navbar" data-offset="50">
		<nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
              <a class="navbar-brand text-white" href="homeController">TodoList</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                  <li>
                  	<a class="nav-link text-white" aria-current="page" href="homeController">Accueil</a>
                  </li>
                  
	                <li class="nav-item">
	                  <a class="nav-link text-white" aria-current="page" href="categorieController">Gestion des categories  </a>
	                </li>
                 
                </ul>
              </div>
            </div>
          </nav>
		<div class="page-body-wrapper my-5">
			<h2 class="header text-center my-3"> TodoList categories</h2>
            <div class="container">
	             <div class="row">
	                <c:forEach items="${ categories }" var="categorie" varStatus="status">
	                    <div class="col-md-4 my-2" >
	                        <div class="card" style="width: 100%;">
	                            <div class="card-body">
	                              <h5 class="card-title"><c:out value="${ categorie.nom }" /></h5>
	                              <p class="card-text"><c:out value="${ categorie.desc }" /></p>
	                              <a href="tacheController?categorieID=${categorie.id}&categorie=${categorie.nom}" class="card-link">consulter les taches</a>
	                            </div>
	                          </div>
	                    </div>
	                  </c:forEach>
	               </div>
            </div>
			
		</div>
	</body>
</html>