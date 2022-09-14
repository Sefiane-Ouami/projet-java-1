<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
    <!------------------------------------------------------------------------------------------------------------------------------------------------------------------>
    <title>Liste des categories</title>
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
    <div class="container my-3">
        <div class="row">
            <h1 class="text-center my-5">Liste des categories</h1>
            <a href="categorieController?ajouterCategorie=true" class="btn btn-success d-block mb-4 bout"><i class="bi bi-credit-card-2-front"></i>Ajouter une categorie</a> 
		    <table class="table table-hover">
		        <thead>
		            <tr class="table-dark">
		            <th scope="col">Nom</th>
		            <th scope="col">Description</th>
		            <th scope="col" class="text-center">Action</th>
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach items = "${ categories }" var = "categorie">
						<tr class="table-active">
				            <th scope="row"><c:out value="${ categorie.nom }"/></th>
				            <td><c:out value="${ categorie.desc }"/></td>
				            <td class="d-flex justify-content-center">
				                <a href="categorieController?modifierCategorie=true&id=${categorie.id}" class="btn btn-warning mx-2">Editer</a> 
				                <a href="categorieController?supprimerCategorie=true&id=${categorie.id}" class="btn btn-danger">Supprimer</a> 
				            </td>
			            </tr>
					</c:forEach>
		        </tbody>
		    </table>
    	</div>
    </div>
</body>
</html>