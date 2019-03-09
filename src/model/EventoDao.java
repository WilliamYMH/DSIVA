package model;

import negocio.Evento;
import util.Conexion;

public class EventoDao extends Conexion<Evento> implements GenericDao<Evento> {
public EventoDao() {
	super(Evento.class);
}
}
