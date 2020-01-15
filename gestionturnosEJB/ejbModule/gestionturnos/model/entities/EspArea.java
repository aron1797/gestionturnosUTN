package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the esp_area database table.
 * 
 */
@Entity
@Table(name="esp_area")
@NamedQuery(name="EspArea.findAll", query="SELECT e FROM EspArea e")
public class EspArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_area", unique=true, nullable=false)
	private Integer idArea;

	@Column(name="cant_turnos")
	private Integer cantTurnos;

	@Column(name="cod_area", nullable=false, length=50)
	private String codArea;

	@Column(name="nombre_area", nullable=false, length=100)
	private String nombreArea;

	@Column(name="tiempo_aprox")
	private Time tiempoAprox;

	//bi-directional many-to-one association to EspPersonal
	@OneToMany(mappedBy="espArea")
	private List<EspPersonal> espPersonals;

	//bi-directional many-to-one association to TurTurno
	@OneToMany(mappedBy="espArea")
	private List<TurTurno> turTurnos;

	public EspArea() {
	}

	public Integer getIdArea() {
		return this.idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public Integer getCantTurnos() {
		return this.cantTurnos;
	}

	public void setCantTurnos(Integer cantTurnos) {
		this.cantTurnos = cantTurnos;
	}

	public String getCodArea() {
		return this.codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getNombreArea() {
		return this.nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public Time getTiempoAprox() {
		return this.tiempoAprox;
	}

	public void setTiempoAprox(Time tiempoAprox) {
		this.tiempoAprox = tiempoAprox;
	}

	public List<EspPersonal> getEspPersonals() {
		return this.espPersonals;
	}

	public void setEspPersonals(List<EspPersonal> espPersonals) {
		this.espPersonals = espPersonals;
	}

	public EspPersonal addEspPersonal(EspPersonal espPersonal) {
		getEspPersonals().add(espPersonal);
		espPersonal.setEspArea(this);

		return espPersonal;
	}

	public EspPersonal removeEspPersonal(EspPersonal espPersonal) {
		getEspPersonals().remove(espPersonal);
		espPersonal.setEspArea(null);

		return espPersonal;
	}

	public List<TurTurno> getTurTurnos() {
		return this.turTurnos;
	}

	public void setTurTurnos(List<TurTurno> turTurnos) {
		this.turTurnos = turTurnos;
	}

	public TurTurno addTurTurno(TurTurno turTurno) {
		getTurTurnos().add(turTurno);
		turTurno.setEspArea(this);

		return turTurno;
	}

	public TurTurno removeTurTurno(TurTurno turTurno) {
		getTurTurnos().remove(turTurno);
		turTurno.setEspArea(null);

		return turTurno;
	}

}