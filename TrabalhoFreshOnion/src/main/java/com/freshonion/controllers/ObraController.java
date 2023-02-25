package com.freshonion.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.freshonion.entities.Critica;
import com.freshonion.entities.Filme;
import com.freshonion.entities.Livro;
import com.freshonion.entities.Obra;
import com.freshonion.entities.Serie;
import com.freshonion.entities.Usuario;
import com.freshonion.repositories.ObraRepository;

@WebServlet(name ="/ObraController", urlPatterns = {"/nova-obra", "/adicionar-obra", "/obra", "/comentar"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ObraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ObraRepository obraRep = new ObraRepository();
	//private UsuarioRepository usuarioRep = new UsuarioRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
	    String action = request.getServletPath();
        
        if(action.equals("/nova-obra")) {
            response.sendRedirect("nova-obra.jsp");
        }else if(action.equals("/obra")) {
            carregarObra(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
	    
	    String action = request.getServletPath();
        
        if(action.equals("/adicionar-obra")) {
            adicionarObra(request, response);
        }else if(action.equals("/comentar")) {
            postarCritica(request, response);
        }
        
	}
	
	protected void adicionarObra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Part poster = request.getPart("poster");
        String posterString = Base64.getEncoder().encodeToString(IOUtils.toByteArray(poster.getInputStream()));
        
        String nome = request.getParameter("nome");
        String sinopse = request.getParameter("sinopse");
        String generos = request.getParameter("genero");
        int anoLancamento = Integer.parseInt(request.getParameter("ano_lancamento"));
        String idioma = request.getParameter("idioma");
        String tipo = request.getParameter("production-type");
        
        if(tipo.equals("filme")) {
            String direcao = request.getParameter("direcao");
            String roteiro = request.getParameter("roteiro");
            String producao = request.getParameter("producao");
            
            Filme filme = new Filme(posterString, nome, sinopse, generos, anoLancamento, idioma, direcao, roteiro, producao);
            
            obraRep.adicionaFilme(filme);
            response.sendRedirect("home");
        }else if(tipo.equals("serie")) {
            String direcao = request.getParameter("direcao");
            String roteiro = request.getParameter("roteiro");
            String producao = request.getParameter("producao");
            int anoTermino = 0;
            if(!request.getParameter("anoTermino").equals("")) {
                anoTermino = Integer.parseInt(request.getParameter("anoTermino"));
            }

            Serie serie = new Serie(posterString, nome, sinopse, generos, anoLancamento, idioma, direcao, roteiro, producao, anoTermino);
            
            obraRep.adicionaSerie(serie);
            response.sendRedirect("home");
        }else if(tipo.equals("livro")) {
            String escritor = request.getParameter("escritor");
            String editora = request.getParameter("editora");
            String numPaginas = request.getParameter("numPaginas");
            
            Livro livro = new Livro(posterString, nome, sinopse, generos, anoLancamento, idioma, escritor, editora, numPaginas);
            
            obraRep.adicionaLivro(livro);
            response.sendRedirect("home");
        }
        
	}
	
	protected void carregarObra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String obraTipo = request.getParameter("obraTipo");
	    int obraId = Integer.parseInt(request.getParameter("obraId"));
	    
	    

	    if(obraTipo.equals("filme")) {
	        request.setAttribute("tipoObra", obraTipo);
	        request.setAttribute("obra", obraRep.buscaFilmeId(obraId));
	        request.setAttribute("criticas", obraRep.buscaFilmeId(obraId).getCriticas());
	        request.getRequestDispatcher("obra.jsp").forward(request, response);
	    }
	    else if(obraTipo.equals("serie")) {
	        request.setAttribute("tipoObra", obraTipo);
            request.setAttribute("obra", obraRep.buscaSerieId(obraId));
            request.setAttribute("criticas", obraRep.buscaSerieId(obraId).getCriticas());
            request.getRequestDispatcher("obra.jsp").forward(request, response);
	    }
	    else if(obraTipo.equals("livro")) {
	        request.setAttribute("tipoObra", obraTipo);
            request.setAttribute("obra", obraRep.buscaLivroId(obraId));
            request.setAttribute("criticas", obraRep.buscaLivroId(obraId).getCriticas());
            request.getRequestDispatcher("obra.jsp").forward(request, response);
	    }
	}
	protected void postarCritica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int obraId = Integer.parseInt(request.getParameter("obraId"));
	    String obraTipo = request.getParameter("obraTipo");
	    Float nota = Float.parseFloat(request.getParameter("review-score"));
	    String criticaTexto = request.getParameter("review");
	    
        Obra obra = obraRep.buscaObraId(obraId);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Date data = new Date(System.currentTimeMillis());
        Critica critica = new Critica(nota, criticaTexto, data, usuario);
        
        obra.getCriticas().add(critica);

        obraRep.atualizaObra(obra);
        
        response.sendRedirect("obra?obraTipo="+obraTipo+"&obraId="+Integer.toString(obraId)+"#comments");
	}
}
