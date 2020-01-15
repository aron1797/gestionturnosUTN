package gestionturnos.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import gestionturnos.model.entities.Usuario;
import gestionturnos.model.manager.ManagerUsuario;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerUsuario managerUsuario;
	private List<Usuario> listaUsuarios;
	
	@PostConstruct
	public void inicializar() {
		listaUsuarios=managerUsuario.finAllUsuarios();
		
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
}
