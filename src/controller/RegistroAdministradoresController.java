package controller;

import java.io.IOException;    
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.Grupoie;
import negocio.Grupointegrante;
import negocio.Integrante;
import negocio.Solicitud;
import negocio.Administrador;
import negocio.Departamento;
import negocio.Director;
import negocio.Facultad;
import negocio.Grupodirector;
import model.GrupoieDao;
import model.GrupointegranteDao;
import model.IntegranteDao;
import model.SolicitudDao;
import model.AdministradorDao;
import model.DepartamentoDao;
import model.DirectorDao;
import model.FacultadDao;
import model.GenericDao;
import model.GrupodirectorDao;


/**
 * Servlet implementation class EquipoController
 */
@WebServlet("/RegistroAdministradoresController")
public class RegistroAdministradoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroAdministradoresController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		String nombre = request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String cedula=request.getParameter("cedula");
		String email=request.getParameter("email");
		String contraseña=request.getParameter("contraseña");
				
		Administrador adm=new Administrador();
		adm.setNombre(nombre);
		adm.setEmail(email);
		adm.setApellido(apellido);
		adm.setIdentificacion(cedula);
		adm.setPassword(contraseña);
		
		AdministradorDao intdDao=new AdministradorDao();
		intdDao.insert(adm);
		
		
		//request.getSession().setAttribute("integrantes", intdDao.list()); 	
		
		
		PrintWriter out = response.getWriter();	
		request.getRequestDispatcher("/index_adm.jsp").forward(request, response);
		/*response.getWriter().append("<br/>Nombre: ").append(nombre);
		response.getWriter().append("<br/>Presidente: ").append(presidente);*/

	}

}