package model;

import negocio.Solicitud;
import util.Conexion;

public class SolicitudDao extends Conexion<Solicitud> implements GenericDao<Solicitud> {
public SolicitudDao() {
  super(Solicitud.class);
}
}
