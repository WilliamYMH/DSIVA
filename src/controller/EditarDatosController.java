package controller;

import java.io.IOException;     
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
@WebServlet("/EditarDatosController")
public class EditarDatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarDatosController() {
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
		String contraseña = request.getParameter("contraseña");
		
		if(email!=""){
			
			if(Director.class.equals(request.getSession().getAttribute("user").getClass())){
				
				Director dr=(Director)request.getSession().getAttribute("user");
				DirectorDao dirDao=new DirectorDao();
				dr.setEmail(email);
				dirDao.update(dr);
				
			}else if(Integrante.class.equals(request.getSession().getAttribute("user").getClass())){
				Integrante integ=(Integrante)request.getSession().getAttribute("user");
				IntegranteDao integDao = new IntegranteDao();
				integ.setEmail(email);
				integDao.update(integ);
				
			}else if(Administrador.class.equals(request.getSession().getAttribute("user").getClass())){
				Administrador adm=(Administrador)request.getSession().getAttribute("user");
				AdministradorDao admDao= new AdministradorDao();
				adm.setEmail(email);
				admDao.update(adm);
			}
		}
		
if(contraseña!=""){
			
			if(Director.class.equals(request.getSession().getAttribute("user").getClass())){
				
				Director dr=(Director)request.getSession().getAttribute("user");
				DirectorDao dirDao=new DirectorDao();
				dr.setPassword(contraseña);
				System.out.println("APELLIDO:"+dr.getApellido());
				dirDao.update(dr);
				
			}else if(Integrante.class.equals(request.getSession().getAttribute("user").getClass())){
				Integrante integ=(Integrante)request.getSession().getAttribute("user");
				IntegranteDao integDao = new IntegranteDao();
				integ.setPassword(contraseña);
				integDao.update(integ);
				
			}else if(Administrador.class.equals(request.getSession().getAttribute("user").getClass())){
				Administrador adm=(Administrador)request.getSession().getAttribute("user");
				AdministradorDao admDao= new AdministradorDao();
				adm.setPassword(contraseña);
				admDao.update(adm);
			}
		}




if(Director.class.equals((request.getSession().getAttribute("user").getClass()))){
	
	request.getSession().setAttribute("pageJS", "ajustes_dir.jsp");
	request.getSession().setAttribute("datosActualizados", 1);
	//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
	response.sendRedirect(request.getContextPath() + "/indx_director.jsp");

}else if(Integrante.class.equals(request.getSession().getAttribute("user").getClass())){
	
	//request.getRequestDispatcher("/indx_integrante.jsp").forward(request, response);
	response.sendRedirect(request.getContextPath() + "/indx_integrante.jsp");
	
}else if(Administrador.class.equals(request.getSession().getAttribute("user").getClass())){
	
	//request.getRequestDispatcher("/indx_administrador.jsp").forward(request, response);
	response.sendRedirect(request.getContextPath() + "/indx_administrador.jsp");

}
	
	
		 
	}
}


