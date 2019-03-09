package model;

import java.util.ArrayList;

import negocio.Administrador;
import negocio.Integrante;
import util.Conexion;

public class IntegranteDao extends Conexion<Integrante> implements GenericDao<Integrante> {
public IntegranteDao() {
	super(Integrante.class);
}

public int seEncuentra(Integrante ad){
	if(this.list()!=null){
	ArrayList<Integrante> arr=(ArrayList<Integrante>) this.list();
	
	for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i).getEmail().equals(ad.getEmail()))return arr.get(i).getIdIntegrante();
	}}
	return -1;
	
}
}
