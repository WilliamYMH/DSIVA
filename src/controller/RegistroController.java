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
import negocio.Solicitud;
import negocio.Departamento;
import negocio.Director;
import negocio.Facultad;
import negocio.Grupodirector;
import model.GrupoieDao;
import model.SolicitudDao;
import model.DepartamentoDao;
import model.DirectorDao;
import model.FacultadDao;
import model.GenericDao;
import model.GrupodirectorDao;


/**
 * Servlet implementation class EquipoController
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroController() {
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
		
		
		
		
	
		/*
		ArrayList<Departamento> rtDepartamentos=(ArrayList<Departamento>) depDao.listarC(f);
		for (int i = 0; i < rtDepartamentos.size(); i++) {
			System.out.println(rtDepartamentos.get(i));
		}
		//String email = request.getParameter("email");
		
		request.getSession().setAttribute("listaDepart", rtDepartamentos);*/
	String nombre = request.getParameter("nombreGrupo");
		int departamento = Integer.parseInt(request.getParameter("departamento"));
		String nombreDirector=request.getParameter("nombre_director");
		String apellidoDirector=request.getParameter("apellido_director");
		String cedula=request.getParameter("cedula");
		String email=request.getParameter("email_director");
		String contraseña=request.getParameter("password");
		System.out.println(nombre);
		System.out.println(nombreDirector);
		System.out.println(apellidoDirector);
		
		Grupoie grupo = new Grupoie();
		DepartamentoDao depDao = new DepartamentoDao();
		
	
		
		
		// System.out.println("cedula: "+cedula);
		Departamento dep=(Departamento)depDao.find(departamento);
		grupo.setDepartamento(dep);
		grupo.setNombre(nombre);
		
		Director dir = new Director();
		dir.setNombre(nombreDirector);
		dir.setApellido(apellidoDirector);
		dir.setEmail(email);
		dir.setIdentificacion(cedula);
		dir.setPassword(contraseña);	
		
		GrupodirectorDao grDirectorDao = new GrupodirectorDao();
		Grupodirector grDirector= new Grupodirector();
		grDirector.setFechaRegistro(new Date());
		grDirector.setDirector(dir);
		grDirector.setGrupoie(grupo);
		dir.addGrupodirector(grDirector);
		
		
		
		/*SolicitudDao sDao = new SolicitudDao();
		Solicitud sol= new Solicitud();
		sol.setDirector(dir);
		sol.setFechaSolicitud(new Date());*/
		
		PrintWriter out = response.getWriter();

 
		
		
		GenericDao gr = new GrupoieDao();
		GenericDao dr = new DirectorDao();
		
		gr.insert(grupo);
		dr.insert(dir);
		grDirectorDao.insert(grDirector);
		//sDao.insert(sol);
		HttpSession session = request.getSession();
		session.setAttribute("director", dir);
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

		/*response.getWriter().append("<br/>Nombre: ").append(nombre);
		response.getWriter().append("<br/>Presidente: ").append(presidente);*/

	}

}
