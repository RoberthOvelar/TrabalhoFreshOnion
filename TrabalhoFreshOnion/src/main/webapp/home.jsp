<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.freshonion.entities.Filme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
        <script src="iconsLib.js"></script>
        <link rel="icon" href="<%= request.getContextPath() %>/imagens/icons/onionIcon.png">
        <link rel="stylesheet" href="style.css">
        <title>Fresh Onion</title>
    </head>
    <body>
        <nav>
            <a id="logo" href="<%= request.getContextPath() %>/home">
                <img src="<%= request.getContextPath() %>/imagens/icons/logoB.png" alt="">
            </a>
            <div class="search-box">
                <input type="text" name="" id="search-text" placeholder="Pesquisar">
                <button id="search-btn">
                    <img src="<%= request.getContextPath() %>/imagens/icons/searchIcon.svg" alt="">
                </button>
            </div>
            <div class="nav-right">
                <ul id="nav-list">
                    <li><a href="">Inicio</a></li>
                    <li><a href="">Categorias</a></li>
                    <li><a href="">Novos</a></li>
                    <li><a href="">Ajuda</a></li>
                </ul>
                <c:if test="${sessionScope.usuario != null}">
                <div class="dropdown">
                    <button id="user-btn" onclick="toggleDropdown()">
                        <img id="user-img" src="<%= request.getContextPath() %>/imagens/userProfileImages/userImage<c:out value ="${sessionScope.usuario.nome}"/>.jpg" alt="">
                    </button>
                    <div class="dropdown-content">
                        <ul>
                            <li class="dropdown-li"><a href=""><i class="fa-sharp fa-solid fa-user"></i>Meu perfil</a></li>
                            <c:if test="${sessionScope.usuario.admin == true}">
                            <li class="dropdown-li"><a href="<%= request.getContextPath() %>/nova-obra"><i class="fa-sharp fa-solid fa-folder-plus"></i>Adicionar obras</a></li>
                            </c:if>
                            <li class="dropdown-li"><a href=""><i class="fa-solid fa-star"></i>Favoritos</a></li>
                            <li class="dropdown-li"><a href=""><i class="fa-sharp fa-solid fa-gear"></i>Configurações</a></li>
                            <li class="dropdown-li"><a href="logout"><i class="fa-solid fa-right-from-bracket"></i>Sair</a></li>
                        </ul>
                    </div>
                </div> 
                </c:if>
                <c:if test="${sessionScope.usuario == null}">
               	<a href="login" id="btn-login">Log In</a>
               	</c:if>
            </div>
        </nav>
        <main class="container-main">
            <div class="carousel-section">
                <div id="top-movie-tittle" class="carousel-tittle">
                    <h3>Top Fresh Filmes</h3>
                </div>
                <div class="carousel-container">
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-previous"><i class="fa-solid fa-chevron-left"></i></button>
                    <div class="carousel-card-itens">
                        <div class="carousel-slider">
                        	<c:forEach var="topFilmes" items="${topFreshFilmes}">
                            <div class="carousel-card trend-carousel-card">
                               <a href="obra?obraTipo=filme&obraId=${topFilmes.id}">
                                   <div class="carousel-card-content">
                                       <div class="card-shadow"></div>
                                       <img src="data:image/png;base64, ${topFilmes.poster}" alt="" class="carousel-card-img">
                                       <div class="carousel-card-score">
                                           <img src="<%= request.getContextPath() %>/imagens/icons/onionIcon.png" alt="" class="score-onion-icon">
                                           <p class="card-score"><fmt:formatNumber type="number" maxFractionDigits="1" value="${topFilmes.notaAvaliacao}" /></p>
                                       </div>
                                   </div>                            
                                   <p class="carousel-card-tittle"><c:out value ="${topFilmes.nome}"/></p>
                               </a>
                            </div>
                          </c:forEach>
                        </div>
                    </div>
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-next"><i class="fa-solid fa-chevron-right"></i></button>
                </div>
            </div>
            <div class="carousel-section">
                <h3 id="top-series-tittle" class="carousel-tittle">
                	Top Fresh Séries
                </h3>
                <div class="carousel-container">
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-previous"><i class="fa-solid fa-chevron-left"></i></button>
                    <div class="carousel-card-itens">
                        <div class="carousel-slider">
                        	<c:forEach var="topSeries" items="${topFreshSeries}">
                            <div class="carousel-card trend-carousel-card">
                               <a href="obra?obraTipo=serie&obraId=${topSeries.id}">
                                   <div class="carousel-card-content">
                                       <div class="card-shadow"></div>
                                       <img src="data:image/png;base64, ${topSeries.poster}" alt="" class="carousel-card-img">
                                       <div class="carousel-card-score">
                                           <img src="<%= request.getContextPath() %>/imagens/icons/onionIcon.png" alt="" class="score-onion-icon">
                                           <p class="card-score"><fmt:formatNumber type="number" maxFractionDigits="1" value="${topSeries.notaAvaliacao}" /></p>
                                       </div>
                                   </div>                            
                                   <p class="carousel-card-tittle"><c:out value ="${topSeries.nome}"/></p>
                               </a>
                            </div>
                          </c:forEach>
                        </div>
                    </div>
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-next"><i class="fa-solid fa-chevron-right"></i></button>
                </div>
            </div>
            <div class="carousel-section">
                <h3 id="top-books-tittle" class="carousel-tittle">
                	Top Fresh Livros
                </h3>
            </div>
            <div class="carousel-container">
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-previous"><i class="fa-solid fa-chevron-left"></i></button>
                    <div class="carousel-card-itens">
                        <div class="carousel-slider">
                        	<c:forEach var="topLivros" items="${topFreshLivros}">
                            <div class="carousel-card trend-carousel-card">
                               <a href="obra?obraTipo=livro&obraId=${topLivros.id}">
                                   <div class="carousel-card-content">
                                       <div class="card-shadow"></div>
                                       <img src="data:image/png;base64, ${topLivros.poster}" alt="" class="carousel-card-img">
                                       <div class="carousel-card-score">
                                           <img src="<%= request.getContextPath() %>/imagens/icons/onionIcon.png" alt="" class="score-onion-icon">
                                           <p class="card-score"><fmt:formatNumber type="number" maxFractionDigits="1" value="${topLivros.notaAvaliacao}" /></p>
                                       </div>
                                   </div>                            
                                   <p class="carousel-card-tittle"><c:out value ="${topLivros.nome}"/></p>
                               </a>
                            </div>
                          </c:forEach>
                        </div>
                    </div>
                    <button class="carousel-btn" onclick="carouselAction(this)" id="carousel-btn-next"><i class="fa-solid fa-chevron-right"></i></button>
                </div>
        </main>
        <script src="script.js"></script>
    </body>
</html>