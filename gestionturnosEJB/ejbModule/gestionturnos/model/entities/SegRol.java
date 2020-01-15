package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_rol database table.
 * 
 */
@Entity
@Table(name="seg_rol")
@NamedQuery(name="SegRol.findAll", query="SELECT s FROM SegRol s")
public class SegRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rol", unique=true, nullable=false)
	private Integer idRol;

	@Column(name="nombre_rol", length=50)
	private String nombreRol;

	//bi-directional many-to-one association to SegAsignacion
	@OneToMany(mappedBy="segRol")
	private List<SegAsignacion> segAsignacions;

	//bi-directional many-to-one association to TurTurno
	@OneToMany(mappedBy="segRol")
	private List<TurTurno> turTurnos;

	public SegRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<SegAsignacion> getSegAsignacions() {
		return this.segAsignacions;
	}

	public void setSegAsignacions(List<SegAsignacion> segAsignacions) {
		this.segAsignacions = segAsignacions;
	}

	public SegAsignacion addSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().add(segAsignacion);
		segAsignacion.setSegRol(this);

		return segAsignacion;
	}

	public SegAsignacion removeSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().remove(segAsignacion);
		segAsignacion.setSegRol(null);

		return segAsignacion;
	}

	public List<TurTurno> getTurTurnos() {
		return this.turTurnos;
	}

	public void setTurTurnos(List<TurTurno> turTurnos) {
		this.turTurnos = turTurnos;
	}

	public TurTurno addTurTurno(TurTurno turTurno) {
		getTurTurnos().add(turTurno);
		turTurno.setSegRol(this);

		return turTurno;
	}

	public TurTurno removeTurTurno(TurTurno turTurno) {
		getTurTurnos().remove(turTurno);
		turTurno.setSegRol(null);

		return turTurno;
	}

}