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

import model.GrupoieDao;
import model.OtraactividadDao;
import model.ProductoDao;
import model.ProyectoDao;
import negocio.Grupoie;
import negocio.Otraactividad;
import negocio.Producto;
import negocio.Proyecto;

@WebServlet("/productoController")
public class ProductoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductoController(){
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoPost = req.getParameter("tipoPostProducto");
		
		if(tipoPost.equals("add")){
			String nombre = req.getParameter("nombreProducto");
			String descripcion = req.getParameter("descripcion");
			String responsable="";
			
			String fecha1[] = (req.getParameter("fecha").split("-"));
			Date fecha = new Date(fecha1[0]+"/"+fecha1[1]+"/"+fecha1[2]);
			int id_Proyecto = Integer.parseInt(req.getParameter("id_proyecto"));
			int id_Actividad = Integer.parseInt(req.getParameter("id_actividad"));
			
			Proyecto proyecto=null;
			Otraactividad actividad=null;
			
			Producto producto =new Producto();
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setFecha(fecha);
			
			if(id_Proyecto!=0){
				proyecto = new ProyectoDao().find(id_Proyecto);
				responsable=proyecto.getResponsable();
				producto.setResponsable(responsable);
				proyecto.addProducto(producto);
			}
			if(id_Actividad!=0){
				actividad = new OtraactividadDao().find(id_Actividad);
				responsable= actividad.getResponsable();
				producto.setResponsable(responsable);
				actividad.addProducto(producto);
			}
			new ProductoDao().insert(producto);
			
			ArrayList<Producto> list=(ArrayList<Producto>) req.getSession().getAttribute("productos");
			list.add(producto);
			req.getSession().setAttribute("productos", list);
			req.getSession().setAttribute("productoActualizado", 1);
			req.getSession().setAttribute("pageJS", "informe_gestion.jsp");
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
			
			
			
		}else if(tipoPost.equals("update1")){
			Producto producto = new ProductoDao().find((Integer.parseInt(req.getParameter("id_producto"))));
			req.getSession().setAttribute("productoUpdate", producto);
			
			req.getSession().setAttribute("pageJS", "informe_gestion.jsp");
			resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
			resp.setDateHeader("Expires", 0);
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
		}else if(tipoPost.equals("update2")){
			
			String nombre = req.getParameter("nombreProducto");
			String descripcion = req.getParameter("descripcion");
			String responsable="";
			
			String fecha1[] = (req.getParameter("fecha").split("-"));
			Date fecha = new Date(fecha1[0]+"/"+fecha1[1]+"/"+fecha1[2]);
			int id_Proyecto = Integer.parseInt(req.getParameter("id_proyecto"));
			int id_Actividad = Integer.parseInt(req.getParameter("id_actividad"));
			
			Proyecto proyecto=null;
			Otraactividad actividad=null;
			
			Producto producto =(Producto) req.getSession().getAttribute("productoUpdate");
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setFecha(fecha);
			
			if(id_Proyecto!=0){
				proyecto = new ProyectoDao().find(id_Proyecto);
				responsable=proyecto.getResponsable();
				producto.setResponsable(responsable);
				proyecto.addProducto(producto);
			}
			if(id_Actividad!=0){
				actividad = new OtraactividadDao().find(id_Actividad);
				responsable= actividad.getResponsable();
				producto.setResponsable(responsable);
				actividad.addProducto(producto);
			}
			new ProductoDao().update(producto);
			//ArrayList<Producto> productos = (ArrayList<Producto>)req.getSession().getAttribute("productos");
			
			req.getSession().setAttribute("productoActualizado", 1);
			 req.getSession().setAttribute("productoUpdate", null);
			req.getSession().setAttribute("pageJS", "informe_gestion.jsp");
			resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
			
		}else{
			
			Producto producto = (Producto)req.getSession().getAttribute("productoUpdate");
			
			new ProductoDao().delete(producto);
			if(producto.getOtraactividad()!=null){
				producto.getOtraactividad().removeProducto(producto);
			}if(producto.getProyecto()!=null){
				producto.getProyecto().removeProducto(producto);
			}
			
			 req.getSession().setAttribute("productoActualizado", 1);
			 req.getSession().setAttribute("productoUpdate", null);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 resp.sendRedirect(req.getContextPath() + "/indx_director.jsp");
		
		}
		
	}
}
