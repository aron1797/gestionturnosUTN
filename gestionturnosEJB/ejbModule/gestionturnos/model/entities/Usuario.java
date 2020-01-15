package gestionturnos.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario", unique=true, nullable=false)
	private Integer idUsuario;

	@Column(nullable=false, length=50)
	private String apellidos;

	@Column(nullable=false, length=10)
	private String cedula;

	@Column(length=50)
	private String clave;

	@Column(length=50)
	private String direccion;

	@Column(length=30)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(nullable=false, length=50)
	private String nombres;

	//bi-directional many-to-one association to AudBitacora
	@OneToMany(mappedBy="usuario")
	private List<AudBitacora> audBitacoras;

	//bi-directional many-to-one association to EspPersonal
	@OneToMany(mappedBy="usuario")
	private List<EspPersonal> espPersonals;

	//bi-directional many-to-one association to SegAsignacion
	@OneToMany(mappedBy="usuario")
	private List<SegAsignacion> segAsignacions;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<AudBitacora> getAudBitacoras() {
		return this.audBitacoras;
	}

	public void setAudBitacoras(List<AudBitacora> audBitacoras) {
		this.audBitacoras = audBitacoras;
	}

	public AudBitacora addAudBitacora(AudBitacora audBitacora) {
		getAudBitacoras().add(audBitacora);
		audBitacora.setUsuario(this);

		return audBitacora;
	}

	public AudBitacora removeAudBitacora(AudBitacora audBitacora) {
		getAudBitacoras().remove(audBitacora);
		audBitacora.setUsuario(null);

		return audBitacora;
	}

	public List<EspPersonal> getEspPersonals() {
		return this.espPersonals;
	}

	public void setEspPersonals(List<EspPersonal> espPersonals) {
		this.espPersonals = espPersonals;
	}

	public EspPersonal addEspPersonal(EspPersonal espPersonal) {
		getEspPersonals().add(espPersonal);
		espPersonal.setUsuario(this);

		return espPersonal;
	}

	public EspPersonal removeEspPersonal(EspPersonal espPersonal) {
		getEspPersonals().remove(espPersonal);
		espPersonal.setUsuario(null);

		return espPersonal;
	}

	public List<SegAsignacion> getSegAsignacions() {
		return this.segAsignacions;
	}

	public void setSegAsignacions(List<SegAsignacion> segAsignacions) {
		this.segAsignacions = segAsignacions;
	}

	public SegAsignacion addSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().add(segAsignacion);
		segAsignacion.setUsuario(this);

		return segAsignacion;
	}

	public SegAsignacion removeSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().remove(segAsignacion);
		segAsignacion.setUsuario(null);

		return segAsignacion;
	}

}