package controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

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
		
		
	
		if(adminValidate!=-1) {
			
			session.setAttribute("admin", email); 
			Administrador adm= adminDao.find(adminValidate);
			request.getSession().setAttribute("user", adm); 			
			request.getRequestDispatcher("/indx_administrador.jsp").forward(request, response);
			
		} else{
			int directValidate = direcDao.seEncuentra(director); //Calling authenticateUser function
			if(directValidate!=-1){
				
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
			
			
			request.getSession().setAttribute("lineasDeInvestigacion", gie.getLineainvesrigacions());
			request.getSession().setAttribute("direccionProyectos", gie.getDireccionpros());
			
			List<Grupointegrante> listIntegrantes=(List<Grupointegrante>)new GrupointegranteDao().list();
			ArrayList<Integrante> integrantes = new ArrayList<>();
			for(Grupointegrante i: listIntegrantes){
				if(i.getGrupoie().getNombre().equals(gie.getNombre())){
					integrantes.add(i.getIntegrante());
				}
			}
			request.getSession().setAttribute("integrantes", integrantes); 	


			
			ArrayList<Proyecto> Dr = new ArrayList<>();
			ArrayList<Proyecto>  Pr = (ArrayList<Proyecto>) new ProyectoDao().list();
			ArrayList<Producto> productos = new ArrayList<>();
			if(Pr!=null)
			{
			for (int i = 0; i < Pr.size(); i++) {
				if (Pr.get(i).getLineainvesrigacion().getGrupoie().getIdGrupoIE()==gie.getIdGrupoIE()) {
					Dr.add(Pr.get(i));
					productos.addAll(Pr.get(i).getProductos());
				}
			}

			}
			List<Otraactividad> otrasActivididades =  gie.getOtraactividads();
			for(int i=0;i<otrasActivididades.size();i++){
				productos.addAll(otrasActivididades.get(i).getProductos());
			}
			request.getSession().setAttribute("proyectos",Dr);
			request.getSession().setAttribute("productos", productos);
			
						
			request.getSession().setAttribute("eventos",gie.getEventos());
			
			request.getSession().setAttribute("otrasActividades",gie.getOtraactividads());
			
			request.getSession().setAttribute("grupoIE", gie);
			
			 response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
			 response.setDateHeader("Expires", 0);
			request.getSession().setAttribute("pageJS", "historial_informes_dir_integr.jsp");
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/indx_director.jsp");
			
		}else{
			int integrantValidate = intDao.seEncuentra(integrante); //Calling authenticateUser function
			 if(integrantValidate!=-1){
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
				
	//System.out.println(gie.getNombre()+"etse");			
				request.getSession().setAttribute("lineasDeInvestigacion", gie.getLineainvesrigacions());
				request.getSession().setAttribute("direccionProyectos", gie.getDireccionpros());
				ArrayList<Proyecto> Dr = new ArrayList<>();
				ArrayList<Proyecto>  Pr = (ArrayList<Proyecto>) new ProyectoDao().list();
				ArrayList<Producto> productos = new ArrayList<>();
				if(Pr!=null)
				{
				for (int i = 0; i < Pr.size(); i++) {
					if (Pr.get(i).getLineainvesrigacion().getGrupoie().getIdGrupoIE()==gie.getIdGrupoIE()) {
						Dr.add(Pr.get(i));
						productos.addAll(Pr.get(i).getProductos());
					}
				}

				}
				List<Otraactividad> otrasActivididades =  gie.getOtraactividads();
				for(int i=0;i<otrasActivididades.size();i++){
					productos.addAll(otrasActivididades.get(i).getProductos());
				}
				request.getSession().setAttribute("proyectos",Dr);
				request.getSession().setAttribute("productos", productos);
				
							
				request.getSession().setAttribute("eventos",gie.getEventos());
				
				request.getSession().setAttribute("otrasActividades",gie.getOtraactividads());
				
				request.getSession().setAttribute("grupoIE", gie);
				
				 response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
				 response.setDateHeader("Expires", 0);
				request.getSession().setAttribute("pageJS", "historial_informes_dir_integr.jsp");
				
				//request.getRequestDispatcher("/indx_integrante.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/indx_integrante.jsp");
			}
			 else{ 
				request.getSession().setAttribute( "errorCredenciales", 1); 
				//request.getRequestDispatcher("/login.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			 }
			
		}
		
	}
	}

}
