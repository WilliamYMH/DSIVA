package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.*;
import model.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		System.out.println("________________________________ ACA");
		
		String email = request.getParameter("email");
		String contraseña = request.getParameter("password");
		 
		Administrador administrador = new Administrador();
		Director director = new Director(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
		Integrante integrante = new Integrante();
		
		administrador.setEmail(email); 
		administrador.setPassword(contraseña);
		
		director.setEmail(email); 
		director.setPassword(contraseña);
		
		integrante.setEmail(email); 
		integrante.setPassword(contraseña);
		 
		AdministradorDao adminDao = new AdministradorDao();
		DirectorDao direcDao = new DirectorDao();
		IntegranteDao intDao = new IntegranteDao();
		 
		int adminValidate = adminDao.seEncuentra(administrador); //Calling authenticateUser function
		int directValidate = direcDao.seEncuentra(director); //Calling authenticateUser function
		int integrantValidate = intDao.seEncuentra(integrante); //Calling authenticateUser function
	
		if(adminValidate!=-1) {
			
			session.setAttribute("admin", email); 
			Administrador adm= adminDao.find(adminValidate);
			request.getSession().setAttribute("user", adm); 			
			request.getRequestDispatcher("/index_adm.jsp").forward(request, response);
			
		} else if(directValidate!=-1){
			session.setAttribute("director", email); 
			Director dir2=direcDao.find(directValidate);
			request.getSession().setAttribute("user", dir2);

			Grupoie gie=null;
			ArrayList<Grupodirector> arr=(ArrayList<Grupodirector>) new GrupodirectorDao().list();
			for (int i = 0; i < arr.size(); i++) {
				if (dir2.getIdDirector()==arr.get(i).getDirector().getIdDirector()) {
					gie=arr.get(i).getGrupoie();
					
					break;
				}
				
			}
			System.out.println(gie.getNombre()+"etse");
			
			request.getSession().setAttribute("lineasDeInvestigacion", gie.getLineainvesrigacions());
			
			ArrayList<Direccionpro> P = new ArrayList<>();
			ArrayList<Direccionpro> E = new ArrayList<>();
			ArrayList<Direccionpro> M = new ArrayList<>();
			ArrayList<Direccionpro> D = new ArrayList<>();

			

			if(gie.getDireccionpros()!=null)
			{
			
				for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Pregrado")) {
					P.add(gie.getDireccionpros().get(i));
				}
			}
				

				
			
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Especializacion")) {
					E.add(gie.getDireccionpros().get(i));
				}
			}
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Maestria")) {
					M.add(gie.getDireccionpros().get(i));
				}
			}
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Doctorado")) {
					D.add(gie.getDireccionpros().get(i));
				}
			}
			
			
			}
			request.getSession().setAttribute("direccionPregrado",P );	
			request.getSession().setAttribute("direccionEspecializacion",E );	
			request.getSession().setAttribute("direccionMaestria",M );
			request.getSession().setAttribute("direccionDoctorado",D );


			
			ArrayList<Proyecto> Dr = new ArrayList<>();
			ArrayList<Proyecto>  Pr = (ArrayList<Proyecto>) new ProyectoDao().list();
			if(Pr!=null)
			{
			for (int i = 0; i < Pr.size(); i++) {
				if (Pr.get(i).getLineainvesrigacion().getGrupoie().getIdGrupoIE()==gie.getIdGrupoIE()) {
					Dr.add(Pr.get(i));
				}
			}

			}
			request.getSession().setAttribute("proyectos",Dr );

			
			
			request.getSession().setAttribute("eventos",new GrupoieDao().find(gie.getIdGrupoIE()).getEventos() );
			
			request.getSession().setAttribute("otrasActividades",gie.getOtraactividads());
			
			request.getSession().setAttribute("grupoIE", gie);
			request.getRequestDispatcher("/index_director.jsp").forward(request, response);
			
		}else if(integrantValidate!=-1){
			session.setAttribute("integrante", email); 
			Integrante inte2=intDao.find(integrantValidate);
			Grupoie gie=null;
			request.getSession().setAttribute("user", inte2); 
			ArrayList<Grupointegrante> arr=(ArrayList<Grupointegrante>) new GrupointegranteDao().list();
			for (int i = 0; i < arr.size(); i++) {
				if (inte2.getIdIntegrante()==arr.get(i).getIntegrante().getIdIntegrante()) {
					gie=arr.get(i).getGrupoie();					
					break;
				}
				
			}
			
System.out.println(gie.getNombre()+"etse");
			
			request.getSession().setAttribute("lineasDeInvestigacion", gie.getLineainvesrigacions());
			
			ArrayList<Direccionpro> P = new ArrayList<>();
			ArrayList<Direccionpro> E = new ArrayList<>();
			ArrayList<Direccionpro> M = new ArrayList<>();
			ArrayList<Direccionpro> D = new ArrayList<>();

			if(gie.getDireccionpros()!=null)
			{
			
				for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Pregrado")) {
					P.add(gie.getDireccionpros().get(i));
				}
			}
				

				
			
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Especializacion")) {
					E.add(gie.getDireccionpros().get(i));
				}
			}
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Maestria")) {
					M.add(gie.getDireccionpros().get(i));
				}
			}
			
			for (int i = 0; i < gie.getDireccionpros().size(); i++) {
				if (gie.getDireccionpros().get(i).getTipoPro().equalsIgnoreCase("Doctorado")) {
					D.add(gie.getDireccionpros().get(i));
				}
			}
			
			
			}
			request.getSession().setAttribute("direccionPregrado",P );	
			request.getSession().setAttribute("direccionEspecializacion",E );	
			request.getSession().setAttribute("direccionMaestria",M );
			request.getSession().setAttribute("direccionDoctorado",D );

			
			
			
			
			
			
			ArrayList<Proyecto> Dr = new ArrayList<>();
			ArrayList<Proyecto>  Pr = (ArrayList<Proyecto>) new ProyectoDao().list();
			if(Pr!=null){
				for (int i = 0; i < Pr.size(); i++) {
					if (Pr.get(i).getLineainvesrigacion().getGrupoie().getIdGrupoIE()==gie.getIdGrupoIE()) {
						Dr.add(Pr.get(i));
					}
				}
			}
			
			request.getSession().setAttribute("proyectos",Dr );
			
			
			request.getSession().setAttribute("eventos",new GrupoieDao().find(gie.getIdGrupoIE()).getEventos() );
			
			request.getSession().setAttribute("otrasActividades",gie.getOtraactividads());
			
			request.getSession().setAttribute("grupoIE", gie);
			request.getRequestDispatcher("/index_integr.jsp").forward(request, response);
			
		}else{ 
			request.getSession().setAttribute("msgResultado", "Hay un error en las credenciales"); 
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
