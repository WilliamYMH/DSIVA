package model;

import java.util.ArrayList;

import negocio.Administrador;
import negocio.Director;
import util.Conexion;

public class DirectorDao extends Conexion<Director> implements GenericDao<Director> {
public DirectorDao() {
	super(Director.class);
}

public int seEncuentra(Director ad){
	if(this.list()==null)return -1;
	ArrayList<Director> arr=(ArrayList<Director>) this.list();
	for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i).getEmail().equals(ad.getEmail())){
			
			return arr.get(i).getIdDirector();
		}
	}
	return -1;
	
}
	

}
