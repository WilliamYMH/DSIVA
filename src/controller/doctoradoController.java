package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DireccionproDao;
import model.GrupoieDao;
import model.OtraactividadDao;
import negocio.Direccionpro;
import negocio.Grupoie;
import negocio.Otraactividad;

/**
 * Servlet implementation class doctoradoController
 */
@WebServlet("/doctoradoController")
public class doctoradoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctoradoController() {
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
		HttpSession session = request.getSession(true);
		String nombreProyecto = request.getParameter("nombreProyecto");		
		String nombreEstudiante = request.getParameter("nombreEstudiante");		
		String nombreDirector = request.getParameter("nombreDirector");
		String Programa = request.getParameter("Programa");
		String Institucion = request.getParameter("Institucion");
		String pogreso = request.getParameter("pogreso");
		Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
		DireccionproDao dDao=new DireccionproDao();
		Direccionpro direccion = new Direccionpro();
		direccion.setDirector(nombreDirector);
		direccion.setInstitucion(Institucion);
		direccion.setNombreEstudiante(nombreEstudiante);
		direccion.setPorcentaje(Integer.valueOf(pogreso));
		direccion.setProgramaAca(Programa);
		direccion.setTipoPro("Doctorado");
		direccion.setTituloPro(nombreProyecto);
		direccion.setGrupoie(aux);
		dDao.insert(direccion);
		ArrayList<Direccionpro> d = new ArrayList<>();
		
		aux=new GrupoieDao().find(aux.getIdGrupoIE());
		List<Direccionpro> dr = (aux.getDireccionpros());
		for (int i = 0; i < dr.size(); i++) {
			if (dr.get(i).getTipoPro().equalsIgnoreCase("Doctorado")) {
				d.add(dr.get(i));
			}
		}
		request.getSession().setAttribute("direccionDoctorado",aux.getDireccionpros());
		request.getSession().setAttribute("grupoIE", aux);

		response.sendRedirect(request.getContextPath() + "/plan_de_accion_act.jsp");
		}

}
