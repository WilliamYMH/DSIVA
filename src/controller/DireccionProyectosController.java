package controller;

import java.io.IOException; 


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartamentoDao;
import model.DireccionproDao;
import model.GrupoieDao;
import negocio.Departamento;
import negocio.Direccionpro;
import negocio.Grupoie;
import negocio.NivelAcademicoEnum;

@WebServlet("/direccionProyectosController")
public class DireccionProyectosController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DireccionProyectosController(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoPost=req.getParameter("tipoPostDireccionProyectos");
		System.out.println(tipoPost+"---------------------");
		
		if(tipoPost.equals("add")){
			
			String nombreProyecto = req.getParameter("nombreProyecto");		
			String nombreEstudiante = req.getParameter("nombreEstudiante");		
			String nombreDirector = req.getParameter("nombreDirector");
			Departamento departamento= new DepartamentoDao().find(Integer.parseInt(req.getParameter("id_departamento")));			
			String progreso = req.getParameter("progreso");
			String nivelAcademicoString = req.getParameter("id_nivelAcademico");// 1: Pregrado, 2: Especializacion, 3:Maestria, 4: Doctorado
			NivelAcademicoEnum nivel;
			if(nivelAcademicoString.equals("Pregrado")){
				nivel=NivelAcademicoEnum.PREGRADO;
			}else if(nivelAcademicoString.equals("Especializacion")){
				nivel=NivelAcademicoEnum.ESPECIALIZACION;
			}else if(nivelAcademicoString.equals("Maestria")){
				nivel = NivelAcademicoEnum.MAESTRIA;
			}else {
				nivel = NivelAcademicoEnum.DOCTORADO;
			}
			 
			Grupoie aux =  (Grupoie) req.getSession().getAttribute("grupoIE");
			DireccionproDao dDao=new DireccionproDao();
			Direccionpro direccion = new Direccionpro();
			
			direccion.setDirector(nombreDirector);
			direccion.setNombreEstudiante(nombreEstudiante);
			direccion.setPorcentaje(Integer.valueOf(progreso));
			direccion.setDepartamento(departamento);
			direccion.setNivelAcademico(nivel);
			direccion.setTituloPro(nombreProyecto);
			
			direccion.setGrupoie(aux);
			dDao.insert(direccion);
			aux.addDireccionpro(direccion);
			
			
			req.getSession().setAttribute("grupoIE", aux);	
			req.getSession().setAttribute("direccionProyectos", aux.getDireccionpros());		
		
			req.getSession().setAttribute("direccionProyectosActualizada", 1);
			req.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
		}else if(tipoPost.equals("update1")){
			
			int idDireccion = Integer.parseInt(req.getParameter("Id_direccion_proyecto"));
			DireccionproDao direccionProDao = new DireccionproDao();
			Direccionpro direccionProyecto = direccionProDao.find(idDireccion);
			req.getSession().setAttribute("DireccionProyectoUpdate", direccionProyecto);
			req.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
		}else if(tipoPost.equals("update2")){
			String nombreProyecto = req.getParameter("nombreProyecto");		
			String nombreEstudiante = req.getParameter("nombreEstudiante");		
			String nombreDirector = req.getParameter("nombreDirector");
			Departamento departamento= new DepartamentoDao().find(Integer.parseInt(req.getParameter("id_departamento")));
			String pogreso = req.getParameter("progreso");
			String nivelAcademicoString = req.getParameter("id_nivelAcademico");// 1: Pregrado, 2: Especializacion, 3:Maestria, 4: Doctorado
			NivelAcademicoEnum nivel;
			if(nivelAcademicoString.equals("Pregrado")){
				nivel=NivelAcademicoEnum.PREGRADO;
			}else if(nivelAcademicoString.equals("Especializacion")){
				nivel=NivelAcademicoEnum.ESPECIALIZACION;
			}else if(nivelAcademicoString.equals("Maestria")){
				nivel = NivelAcademicoEnum.MAESTRIA;
			}else {
				nivel = NivelAcademicoEnum.DOCTORADO;
			}
			
			DireccionproDao dDao=new DireccionproDao();
			Direccionpro direccion = (Direccionpro) req.getSession().getAttribute("DireccionProyectoUpdate");
			
			direccion.setDirector(nombreDirector);
			direccion.setNombreEstudiante(nombreEstudiante);
			direccion.setPorcentaje(Integer.valueOf(pogreso));
			direccion.setDepartamento(departamento);
			direccion.setNivelAcademico(nivel);
			direccion.setTituloPro(nombreProyecto);
			
			dDao.update(direccion);
			
			req.getSession().setAttribute("DireccionProyectoUpdate", null);			
			req.getSession().setAttribute("direccionProyectosActualizada", 1);
			Grupoie aux = (Grupoie) req.getSession().getAttribute("grupoIE");
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			
			req.getSession().setAttribute("direccionProyectos", aux.getDireccionpros());
			req.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");					
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
			resp.setDateHeader("Expires", 0);
			
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
		}else {
			Direccionpro linea=(Direccionpro)req.getSession().getAttribute("DireccionProyectoUpdate");
			DireccionproDao lineaDao=new DireccionproDao();
			lineaDao.delete(linea);
			
			Grupoie aux = (Grupoie) req.getSession().getAttribute("grupoIE");
			
			GrupoieDao n = new GrupoieDao();
			Grupoie aux2 = n.find(aux.getIdGrupoIE());
			
			aux2.removeDireccionpro(linea);
			req.getSession().setAttribute("grupoIE", aux2);	
			req.getSession().setAttribute("DireccionProyectoUpdate", null);
		
			req.getSession().setAttribute("direccionProyectos", aux2.getDireccionpros());
			req.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			 req.getSession().setAttribute("direccionProyectosActualizada", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
				resp.setDateHeader("Expires", 0);
			 resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
		}
	}
}
