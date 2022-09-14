<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <!-------------------------------------------------------------- Editeur De text ---------------------------------------------------------------------------------------------------->
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"> </script>
        <!------------------------------------------------------------------------------------------------------------------------------------------------------------------>

    <title>Formulaire pour ajouter une categorie</title>
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
                    <a class="nav-link text-white active" aria-current="page" href="categorieController">Gestion des categories</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    <div class="container">
        <h1 class="text-center mt-5">Ajouter une nouvelle categorie</h1>
           <form method="post" action="categorieController?ajouterCategorie=true">
                  <div class="col-12">
                      <div class="form-group mb-4">
                          <label for="title">Titre</label>
                          <input type="text" id="nom" name="nom" class="form-control" placeholder="Nom de votre categorie">
                      </div>
                      </div> 
                        <div class="col-12 mb-4">
                            <div class="form-group">
                                <label for="content">Description</label>
                                <textarea name="description" id="description" style="resize:none;" cols="20" rows="5" class="form-control w-100" placeholder="Description de votre categorie"></textarea>
                            </div>
                            </div>
                            
                            <div class="d-flex justify-content-center mb-5">
                                <button type="submit"  class="btn btn-primary">
                                    Ajouter Categorie
                                </button>
                            </div>
           </form>
        </div>
</body>
</html>