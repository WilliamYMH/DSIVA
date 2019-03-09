package model;

import negocio.Producto;
import util.Conexion;

public class ProductoDao extends Conexion<Producto> implements GenericDao<Producto> {
public ProductoDao() {
	super(Producto.class);
}
}
