package gestionturnos.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gestionturnos.model.entities.Usuario;

/**
 * Session Bean implementation class ManagerUsuario
 */
@Stateless
@LocalBean
public class ManagerUsuario {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerUsuario() {
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> finAllUsuarios() {
		String consulta = "Select o from  Usuario o order by o.apellidos";
		Query q = em.createQuery(consulta, Usuario.class);
		return q.getResultList();

	}

}
