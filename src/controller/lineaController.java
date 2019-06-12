package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GrupoieDao;
import model.LineainvesrigacionDao;
import negocio.Grupoie;
import negocio.Lineainvesrigacion;

/**
 * Servlet implementation class lineaController
 */
@WebServlet("/lineaController")
public class lineaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lineaController() {
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
		HttpSession session = request.getSession(true);
		String tipoPost = request.getParameter("tipoPostLinea");
		if (tipoPost.equals("add")) {
			String nombreLinea = request.getParameter("nombreLinea");
			String lider = request.getParameter("lider");
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			LineainvesrigacionDao lDao = new LineainvesrigacionDao();
			Lineainvesrigacion linea = new Lineainvesrigacion();
			linea.setLiderLinea(lider);
			linea.setLineaInvesrigacion(nombreLinea);
			Date date = new Date();

			//System.out.println(aux.getNombre());
			linea.setFecha(date);

			linea.setGrupoie(aux);
			aux.addLineainvesrigacion(linea);
			lDao.insert(linea);
			
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			request.getSession().setAttribute("grupoIE", aux);
			// System.out.println(aux.getLineainvesrigacions().size()+" -
			// TAMANIO LINEAS");
			request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
			request.getSession().setAttribute("lineaActualizada", 1);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
			response.setDateHeader("Expires", 0);
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else if (tipoPost.equals("update1")) {
			
			int idLinea = Integer.parseInt(request.getParameter("linea_invest"));
			LineainvesrigacionDao lineaDao = new LineainvesrigacionDao();
			Lineainvesrigacion linea = lineaDao.find(idLinea);
			request.getSession().setAttribute("lineaUpdate", linea);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}else if (tipoPost.equals("update2")) {
			String nombreLinea = request.getParameter("nombreLinea");
			String lider = request.getParameter("lider");
			
			Lineainvesrigacion linea=(Lineainvesrigacion)request.getSession().getAttribute("lineaUpdate");
			LineainvesrigacionDao lineaDao=new LineainvesrigacionDao();
			linea.setLineaInvesrigacion(nombreLinea);
			linea.setLiderLinea(lider);
			lineaDao.update(linea);
			request.getSession().setAttribute("lineaUpdate", null);
			 
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			 request.getSession().setAttribute("lineaActualizada", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else{
			Lineainvesrigacion linea=(Lineainvesrigacion)request.getSession().getAttribute("lineaUpdate");
			LineainvesrigacionDao lineaDao=new LineainvesrigacionDao();
			lineaDao.delete(linea);
			
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			aux.removeLineainvesrigacion(linea);
			request.getSession().setAttribute("lineaUpdate", null);
			
			request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
			request.getSession().setAttribute("grupoIE", aux);	
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			 request.getSession().setAttribute("lineaActualizada", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}
		
		
		// request.getRequestDispatcher("/plan_de_accion_act.jsp").forward(request,
		// response);
	}

}
