package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tur_turnos database table.
 * 
 */
@Entity
@Table(name="tur_turnos")
@NamedQuery(name="TurTurno.findAll", query="SELECT t FROM TurTurno t")
public class TurTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turnos", unique=true, nullable=false)
	private Integer idTurnos;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(name="nro_turno")
	private Integer nroTurno;

	//bi-directional many-to-one association to EspArea
	@ManyToOne
	@JoinColumn(name="id_area")
	private EspArea espArea;

	//bi-directional many-to-one association to EspPersonal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private EspPersonal espPersonal;

	//bi-directional many-to-one association to SegRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private SegRol segRol;

	//bi-directional many-to-one association to TurEstado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private TurEstado turEstado;

	public TurTurno() {
	}

	public Integer getIdTurnos() {
		return this.idTurnos;
	}

	public void setIdTurnos(Integer idTurnos) {
		this.idTurnos = idTurnos;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Integer getNroTurno() {
		return this.nroTurno;
	}

	public void setNroTurno(Integer nroTurno) {
		this.nroTurno = nroTurno;
	}

	public EspArea getEspArea() {
		return this.espArea;
	}

	public void setEspArea(EspArea espArea) {
		this.espArea = espArea;
	}

	public EspPersonal getEspPersonal() {
		return this.espPersonal;
	}

	public void setEspPersonal(EspPersonal espPersonal) {
		this.espPersonal = espPersonal;
	}

	public SegRol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(SegRol segRol) {
		this.segRol = segRol;
	}

	public TurEstado getTurEstado() {
		return this.turEstado;
	}

	public void setTurEstado(TurEstado turEstado) {
		this.turEstado = turEstado;
	}

}