<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:if test="${sessionScope.usuario.admin != true}">
<c:redirect url = "/home" />    
</c:if>
    
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
                            <li class="dropdown-li"><a href="<%= request.getContextPath() %>/nova-obra.jsp"><i class="fa-sharp fa-solid fa-folder-plus"></i>Adicionar obras</a></li>
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
            <form action="adicionar-obra" id="production-form" method="post" enctype="multipart/form-data">
                <section class="form-desc-container form-section">
                    <div class="form-header">
                        <h2>Descrição</h2>
                    </div>
                    <div class="form-body">
                        <div class="image-area">
                            <label class="image-area-label" for="banner-input">
                                <img src="<%= request.getContextPath() %>/imagens/random/inputPoster.png" id="banner-image-input">
                                <input type="file" name="poster" id="banner-input" accept="image/*">
                            </label>
                        </div>
                        <div class="input-area">
                            <label for="tittle-input" class="input-label">
                                <p>Nome da obra:</p>
                                <input type="text" name="nome" id="tittle-input" class="input-text" required>
                            </label>
                            <label for="sinopse-input" class="input-label" id="sinopse-label">
                                <p>Sinopse:</p>
                                <textarea rows="6" form="production-form" name="sinopse" class="input-text" id="sinopse-input" required ></textarea>
                            </label>
                            <label for="genre-input" class="input-label">
                                <p>Gênero:</p>
                                <input type="text" name="genero" id="genre-input" class="input-text" required>
                            </label>
                            <label for="year-input" class="input-label">
                                <p>Ano de lançamento:</p>
                                <input type="number" name="ano_lancamento" min="1900" max="2022" step="1" class="input-text" id="year-input" required>
                            </label>
                            <label for="linguage-input" class="input-label">
                                <p>Idioma:</p>
                                <input type="text" name="idioma" id="linguage-input" class="input-text" required >
                            </label>
                        </div>
                    </div>
                </section>
                <section class="form-type-container">
                    <div class="form-header">
                        <h2>Tipo da obra</h2>
                    </div>
                    <div class="form-body">
                        <div class="combo-area">
                            <select name="production-type" id="combo-type" class="gerenic-combo">
                                <option value="filme">Filme</option>
                                <option value="serie">Série</option>
                                <option value="livro">Livro</option>
                            </select>
                        </div>
                        <div class="input-area">
                            <label for="director-input" class="input-label" id="director-label">
                                <p>Direção:</p>
                                <input type="text" name="direcao" id="director-input" class="input-text">
                            </label>
                            <label for="writer-input" class="input-label" id="writer-label">
                                <p>Escritor:</p>
                                <input type="text" name="escritor" id="writer-input" class="input-text">
                            </label>
                            <label for="screenwriter-input" class="input-label" id="screenwriter-label">
                                <p>Roteiro:</p>
                                <input type="text" name="roteiro" id="screenwriter-input" class="input-text">
                            </label>
                            <label for="publisher-input" class="input-label" id="publisher-label">
                                <p>Editora:</p>
                                <input type="text" name="editora" id="publisher-input" class="input-text">
                            </label>
                            <label for="pages-input" class="input-label" id="pages-label">
                                <p>Nº de páginas:</p>
                                <input type="number" name="numPaginas" step="1" class="input-text" id="pages-input">
                            </label>
                            <label for="production-input" class="input-label" id="production-label">
                                <p>Produção:</p>
                                <input type="text" name="producao" id="production-input" class="input-text">
                            </label>
                            <label for="end-year-input" class="input-label" id="end-year-label">
                                <p>Ano de termino:</p>
                                <input type="number" name="anoTermino" min="1900" max="2022" step="1" class="input-text" id="end-year-input">
                            </label>
                        </div>
                    </div>
                </section>
                <section class="submit-container">
                    <div class="form-header"></div>
                    <input type="submit" value="Adicionar obra" id="add-button">
                </section>
            </form>
        </main>
        <script src="script.js"></script>
    </body>
</html>