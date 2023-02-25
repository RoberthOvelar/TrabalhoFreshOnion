package com.freshonion.controllers;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.freshonion.entities.Usuario;
import com.freshonion.repositories.UsuarioRepository;

@WebServlet(name ="/UserController", urlPatterns = {"/login", "/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UserController() {
        super();
    }

    private UsuarioRepository userRep = new UsuarioRepository();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	    if(action.equals("/login")) {
	        response.sendRedirect("login.jsp");
	    }else if(action.equals("/logout")) {
            efetuarLogout(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
	    String action = request.getServletPath();
        
        if(action.equals("/login")) {
            efetuarLogin(request, response);
        }
        else if(action.equals("/logout")) {
            System.out.println("Teste");
            efetuarLogout(request, response);
        }
	}
	
	protected void efetuarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
                   
        if(email != null && senha != null) {
            try {
                Usuario usuario = userRep.buscaUsuario(email);

                if(!usuario.getSenha().equals(senha)) throw new NoResultException("Email ou senha não conferem");
                
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/home");
            } catch (NoResultException  nre) {
                request.setAttribute("erroMensagem", "Email ou senha não conferem!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (NullPointerException e){
                request.setAttribute("erroMensagem", "Usuário não cadastrado!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        
    }
	
	protected void efetuarLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getSession().invalidate();
	    response.sendRedirect("home");
    }
}
