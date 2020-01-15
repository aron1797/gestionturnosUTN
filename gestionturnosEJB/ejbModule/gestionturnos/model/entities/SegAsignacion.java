package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_asignacion database table.
 * 
 */
@Entity
@Table(name="seg_asignacion")
@NamedQuery(name="SegAsignacion.findAll", query="SELECT s FROM SegAsignacion s")
public class SegAsignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asignacion", unique=true, nullable=false)
	private Integer idAsignacion;

	//bi-directional many-to-one association to SegRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private SegRol segRol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public SegAsignacion() {
	}

	public Integer getIdAsignacion() {
		return this.idAsignacion;
	}

	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public SegRol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(SegRol segRol) {
		this.segRol = segRol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}