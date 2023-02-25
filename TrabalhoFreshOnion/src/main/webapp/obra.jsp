<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.freshonion.entities.Filme, com.freshonion.entities.Obra"%>
    
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
            <section id="sinopse-section">
                <img id="banner" src="data:image/png;base64, ${obra.poster}" alt="">
                <div id="sinopse-container">
                    <h1 id="tittle"><c:out value ="${obra.nome}"/></h1>
                    <p id="sinopse">
                    		<c:out value ="${obra.sinopse}"/>
										</p>
                    <div id="info-score">
                        <p id="score"><span><fmt:formatNumber type="number" maxFractionDigits="1" value="${obra.notaAvaliacao}" /></span>/10</p> 
                        <p class="meter">ONION METER</p>
                        <a href="#comments" class="reviews">150 reviews</a>
                    </div>  
                </div>
            </section>
            <section id="info-section">
                <img id="player" src="<%= request.getContextPath() %>/imagens/random/trailerThumb.png" alt="">
                <div id="info-container">
                    <h2 id="info-tittle">Informações da obra<hr></h2>
                    <ul>
                   			<c:if test="${tipoObra == 'filme'}">                 
		                        <li><span class="bold">Ano lançamento: </span> <c:out value ="${obra.anoLancamento}"/></li>
		                        <li><span class="bold">Direção: </span><c:out value ="${obra.diretores}"/></li>
		                        <li><span class="bold">Roteiro: </span><c:out value ="${obra.roteiristas}"/></li>
		                        <li><span class="bold">Produção: </span> <c:out value ="${obra.produtores}"/></li>
		                        <li><span class="bold">Gênero: </span> <c:out value ="${obra.genero}"/></li>
                        </c:if>
                        <c:if test="${tipoObra == 'serie'}">                 
		                        <li><span class="bold">Ano lançamento:</span> <c:out value ="${obra.anoLancamento}"/></li>
		                        <c:if test="${obra.anoTermino == 0}">
		                        		<li><span class="bold">Ano termino:</span> ---- </li>
		                        </c:if>
		                        <c:if test="${obra.anoTermino != 0}">
		                        		<li><span class="bold">Ano termino:</span> <c:out value ="${obra.anoTermino}"/> </li>
		                        </c:if>
		                        <li><span class="bold">Direção: </span><c:out value ="${obra.diretores}"/></li>
		                        <li><span class="bold">Roteiro: </span><c:out value ="${obra.roteiristas}"/></li>
		                        <li><span class="bold">Produção: </span> <c:out value ="${obra.produtores}"/></li>
		                        <li><span class="bold">Gênero: </span> <c:out value ="${obra.genero}"/></li>
                        </c:if>
                        <c:if test="${tipoObra == 'livro'}">
                            <li><span class="bold">Direção: </span><c:out value ="${obra.escritores}"/></li>
		                        <li><span class="bold">Roteiro: </span><c:out value ="${obra.editora}"/></li>
		                        <li><span class="bold">Produção: </span> <c:out value ="${obra.numeroPag}"/></li>
		                        <li><span class="bold">Gênero: </span> <c:out value ="${obra.genero}"/></li>
                        </c:if>
                    </ul>
                </div>  
            </section>
            <div id="comments">
                <header id="header-comments">
                    <hr>
                    <h3 id="reviews-tittle">Críticas de <c:out value ="${obra.nome}"/></h3>
                </header>
                <div id="reviews-container">
                		<c:set var="show" value = "${true}"/>
                		<c:forEach var="critica" items="${criticas}">
                				<c:if test="${sessionScope.usuario.email == critica.usuario.email || sessionScope.usuario == null}">
                						<c:set var="show" value = "${false}"/>
                				</c:if>
           					</c:forEach>
             				<c:if test="${show == true && sessionScope.usuario != null}">
		                    <form action="comentar" class="my-review" id="form-review" method="post">
		                        <div class="header-my-review">
		                            <div class="header-my-review-left">
		                            		<input type="hidden" name="obraId" value="${obra.id}" />
		                            		<input type="hidden" name="obraTipo" value="${tipoObra}" />
		                                <img src="<%= request.getContextPath() %>/imagens/userProfileImages/userImage<c:out value ="${sessionScope.usuario.nome}"/>.jpg" class="user-review-img">
		                            </div>
		                            <div class="header-my-review-right">
		                                <input type="range" min="0" max="10" oninput="rangeInput(this)" value="0" step="0.5" id="slide-review" form="form-review" name="review-score">
		                                <p><span id="nota">--</span>/10</p>
		                            </div>
		                        </div>
		                        <div class="body-my-review">
		                            <textarea placeholder="Adicionar comentário..." rows="5" form="form-review" name="review"></textarea>
		                        </div>
		                        <div class="footer-my-review">
		                            <input type="submit" value="Postar review" id="btn-submit-review">
		                        </div>
		                    </form>
                   	</c:if>
                    <c:forEach var="critica" items="${criticas}">
	                    <div class="user-reviews">
	                        <div class="header-user-review">
	                            <div class="user-review-info">
	                                <img class="user-review-img" src="<%= request.getContextPath() %>/imagens/userProfileImages/userImage<c:out value ="${critica.usuario.nome}"/>.jpg" alt="">
	                                <div class="user-details">
	                                    <p class="user-name"><c:out value ="${critica.usuario.nome}"/></p>
	                                    <p class="review-date"><c:out value ="${critica.dataDePostagem}"/></p>
	                                </div>
	                            </div>
	                            <div class="review-score">
	                                <p class="review-score-text"><c:out value ="${critica.nota}"/>/10</p>
	                            </div>
	                        </div>
	                        <div class="body-user-review">
	                            <p class="text-user-review">
	                                <c:out value ="${critica.analise}"/>
	                            </p>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </div>
        </main>
        <script src="script.js"></script>
    </body>
</html>