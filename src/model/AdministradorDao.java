package model;

import java.util.ArrayList;

import negocio.Administrador;
import util.Conexion;

public class AdministradorDao extends Conexion<Administrador> implements GenericDao<Administrador> {
public AdministradorDao() {
	super(Administrador.class);
}
public int seEncuentra(Administrador ad){
	if(this.list()==null)return -1;
	ArrayList<Administrador> arr=(ArrayList<Administrador>) this.list();
	for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i).getEmail().equals(ad.getEmail())){
			if(!arr.get(i).getPassword().equals(ad.getPassword())) return -1;
			return arr.get(i).getIdAdministrador();

		}
	}
	return -1;
	
}

}
