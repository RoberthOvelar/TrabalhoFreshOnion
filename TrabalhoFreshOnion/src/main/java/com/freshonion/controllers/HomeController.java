package com.freshonion.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freshonion.repositories.ObraRepository;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HomeController() {
	    super();
	}
	
    private ObraRepository obraRep = new ObraRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("topFreshFilmes", obraRep.buscaTopFreshFilme(10));
	    request.setAttribute("topFreshSeries", obraRep.buscaTopFreshSerie(10));
	    request.setAttribute("topFreshLivros", obraRep.buscaTopFreshLivro(10));	    
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
