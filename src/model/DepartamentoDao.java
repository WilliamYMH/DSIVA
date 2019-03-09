package model;

import java.util.ArrayList;
import java.util.List;

import negocio.Departamento;
import negocio.Facultad;
import util.Conexion;

public class DepartamentoDao extends Conexion<Departamento> implements GenericDao<Departamento> {
public DepartamentoDao() {
	super(Departamento.class);
}

public List<Departamento> listarC(Facultad f){
	ArrayList<Departamento> arr=(ArrayList<Departamento>) this.list();
	ArrayList<Departamento> aux=new ArrayList<Departamento>();
	for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i).getFacultad().getNombre().equals(f.getNombre())){
			aux.add(arr.get(i));
		}
	}
	return aux;
}
}
