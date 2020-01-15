package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tur_estado database table.
 * 
 */
@Entity
@Table(name="tur_estado")
@NamedQuery(name="TurEstado.findAll", query="SELECT t FROM TurEstado t")
public class TurEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado", unique=true, nullable=false)
	private Integer idEstado;

	@Column(name="descripcion_estado", length=100)
	private String descripcionEstado;

	//bi-directional many-to-one association to TurTurno
	@OneToMany(mappedBy="turEstado")
	private List<TurTurno> turTurnos;

	public TurEstado() {
	}

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcionEstado() {
		return this.descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public List<TurTurno> getTurTurnos() {
		return this.turTurnos;
	}

	public void setTurTurnos(List<TurTurno> turTurnos) {
		this.turTurnos = turTurnos;
	}

	public TurTurno addTurTurno(TurTurno turTurno) {
		getTurTurnos().add(turTurno);
		turTurno.setTurEstado(this);

		return turTurno;
	}

	public TurTurno removeTurTurno(TurTurno turTurno) {
		getTurTurnos().remove(turTurno);
		turTurno.setTurEstado(null);

		return turTurno;
	}

}