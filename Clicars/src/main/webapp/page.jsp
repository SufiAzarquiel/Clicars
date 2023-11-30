<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Clicars</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- CSS -->
    <link href="css/style.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>

<body>
    <div class="container shadow">
    	<nav class="row navbar navbar-expand-sm navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="Controller?op=inicio">
                	<img alt="logo" src="img/logo.png">
                </a>
                <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mx-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="Controller?op=vamarca&marca=0">Todos</a>
                        </li>
                        <c:forEach items="${marcas}" var="marca">
	                        <li class="nav-item">
	                            <a class="nav-link text-primary" href="Controller?op=vamarca&marca=${marca.id}">${marca.nombre}</a>
	                        </li>
                        </c:forEach>
                        <li class="nav-item dropdown ms-5">
                            <a class="nav-link dropdown-toggle text-primary" href="#" id="dropdownId" data-bs-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Ordenado por</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=null">Sin orden</a>
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=nombre">Nombre</a>
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=modelo">Modelo</a>
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=anio">Año</a>
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=km">Kilometros</a>
                                <a class="dropdown-item text-primary" href="Controller?op=vaorden&orden=cv">Caballos</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <main>
            <div class="row justify-content-center">
            <c:forEach items="${coches}" var="coche">
            
                <div class="col-lg-4 col-md-6 my-3 d-flex">
                    <div class="card border-dark flex-fill">
                        <img class="card-img-top" src="${coche.foto}" alt="Coche">
                        <div class="card-body position-relative bg-dark pt-xl">
                            <div class="row text-white">
                                <div class="col-9">
                                    <p>${coche.nombre}</p>
                                </div>
                                <div class="col-3 text-end text-danger">
                                    <p>${coche.precioantes}&euro;</p>
                                </div>
                            </div>
                            <div class="row text-white">
                                <div class="col-9">
                                    <p>${coche.modelo}</p>
                                </div>
                                <div class="col-3 text-end text-success">
                                    <p>${coche.precio}&euro;</p>
                                </div>
                            </div>
                            <div class="row text-white">
                                <div class="col">
                                    <p class="my-0">${coche.anio}|${coche.km}|${coche.cv}</p>
                                </div>
                            </div>
                            <span class="position-absolute top-1 end-1 text-white">
                                <span class="h1">
                                    ${coche.likes}
                                </span>
                                <a href="Controller?op=addlike&id=${coche.id}&likes=${coche.likes}&fav=${coche.fav}">
                                	<i class="fa fa-thumbs-o-up fa-3x" aria-hidden="true"></i>
                                </a>
                            </span>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </main>
        <div class="bg-light row text-center p-3">
            <p class="text-primary h1 m-0">Sufi - S2DAM - Clicars</p>
        </div>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous">
        </script>
</body>

</html>