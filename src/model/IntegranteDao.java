package model;

import java.util.ArrayList;

import negocio.Administrador;
import negocio.Integrante;
import util.BcryptPassword;
import util.Conexion;

public class IntegranteDao extends Conexion<Integrante> implements GenericDao<Integrante> {
public IntegranteDao() {
	super(Integrante.class);
}

	public int seEncuentra(Integrante ad){
	if(this.list()!=null){
	ArrayList<Integrante> arr=(ArrayList<Integrante>) this.list();
	
	for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i).getEmail().equals(ad.getEmail())){
			boolean password= new BcryptPassword().checkPassword(ad.getPassword(), arr.get(i).getPassword());
			if(!password) return -1;
			return arr.get(i).getIdIntegrante();
		}
	}}
	return -1;
	
}
}
