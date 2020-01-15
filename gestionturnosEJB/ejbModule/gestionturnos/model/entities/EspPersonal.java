package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the esp_personal database table.
 * 
 */
@Entity
@Table(name="esp_personal")
@NamedQuery(name="EspPersonal.findAll", query="SELECT e FROM EspPersonal e")
public class EspPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personal", unique=true, nullable=false)
	private Integer idPersonal;

	@Column(name="horas_laborables")
	private Integer horasLaborables;

	//bi-directional many-to-one association to EspArea
	@ManyToOne
	@JoinColumn(name="id_area")
	private EspArea espArea;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TurTurno
	@OneToMany(mappedBy="espPersonal")
	private List<TurTurno> turTurnos;

	public EspPersonal() {
	}

	public Integer getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Integer getHorasLaborables() {
		return this.horasLaborables;
	}

	public void setHorasLaborables(Integer horasLaborables) {
		this.horasLaborables = horasLaborables;
	}

	public EspArea getEspArea() {
		return this.espArea;
	}

	public void setEspArea(EspArea espArea) {
		this.espArea = espArea;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TurTurno> getTurTurnos() {
		return this.turTurnos;
	}

	public void setTurTurnos(List<TurTurno> turTurnos) {
		this.turTurnos = turTurnos;
	}

	public TurTurno addTurTurno(TurTurno turTurno) {
		getTurTurnos().add(turTurno);
		turTurno.setEspPersonal(this);

		return turTurno;
	}

	public TurTurno removeTurTurno(TurTurno turTurno) {
		getTurTurnos().remove(turTurno);
		turTurno.setEspPersonal(null);

		return turTurno;
	}

}