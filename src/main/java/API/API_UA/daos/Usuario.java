package API.API_UA.daos;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="Usuarios", schema="gbp_operacional")
public class Usuario {
	@Column(name="id_usuario", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
	
	@Column(name="dni_usuario", nullable=false)
    private String dni_usuario;
	
	@Column(name="nombre_usuario")
    private String nombre_usuario;
	
	@Column(name="apellidos_usuario")
    private String apellidos_usuario;
	
	@Column(name="tlf_usuario")
    private String tlf_usuario;
	
	
	@Column(name="email_usuario")
    private String email_usuario;
	
	@Column(name="clave_usuario")
    private String clave_usuario;
	
	@Column(name="establoqueado_usuario")
    private Boolean establoqueado_usuario;
	
	@Column(name="fch_fin_bloqueo_usuario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_fin_bloqueo_usuario;
	
	@Column(name="fch_alta__usuario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_alta__usuario;
	
	@Column(name="fch_baja_usuario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_baja_usuario;

	
	 
	@JsonIgnore    
	@ManyToOne  							// Mapea la relación muchos a uno con la clase Accesos
	@JoinColumn(name="id_acceso")			// Nombre de la columna FK en la tabla Usuarios
	private Acceso acceso;							//El JoinColum es oslo para especificar el nombre que quieres que tenga

  //  @OneToMany(mappedBy="usuario") // Mapea la relación uno a muchos con la propiedad "usuario" en la clase Prestamos
   // private List<Prestamo> listausuariosConPrestamos;
	
    
    
	
	//Constructores
	
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}

	public void setTlf_usuario(String tlf_usuario) {
		this.tlf_usuario = tlf_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}

	public void setEstabloqueado_usuario(Boolean estaBloqueado_usuario) {
		this.establoqueado_usuario = estaBloqueado_usuario;
	}

	public void setFch_fin_bloqueo_usuario(Calendar fch_fin_bloqueo_usuario) {
		this.fch_fin_bloqueo_usuario = fch_fin_bloqueo_usuario;
	}

	public void setFch_alta__usuario(Calendar fch_alta__usuario) {
		this.fch_alta__usuario = fch_alta__usuario;
	}

	public void setFch_baja_usuario(Calendar fch_baja_usuario) {
		this.fch_baja_usuario = fch_baja_usuario;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public String getApellidos_usuario() {
		return apellidos_usuario;
	}

	public String getTlf_usuario() {
		return tlf_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public Boolean getEstabloqueado_usuario() {
		return establoqueado_usuario;
	}

	public Calendar getFch_fin_bloqueo_usuario() {
		return fch_fin_bloqueo_usuario;
	}

	public Calendar getFch_alta__usuario() {
		return fch_alta__usuario;
	}

	public Calendar getFch_baja_usuario() {
		return fch_baja_usuario;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	//public List<Prestamo> getListausuariosConPrestamos() {
	//	return listausuariosConPrestamos;
//	}

	public Usuario() {
		super();
	}

	public Usuario(Long id_usuario, String dni_usuario, String nombre_usuario, String apellidos_usuario,
			String tlf_usuario, String email_usuario, String clave_usuario, Boolean establoqueado_usuario,
			Calendar fch_fin_bloqueo_usuario, Calendar fch_alta__usuario, Calendar fch_baja_usuario, Acceso acceso) {
		super();
		this.id_usuario = id_usuario;
		this.dni_usuario = dni_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellidos_usuario = apellidos_usuario;
		this.tlf_usuario = tlf_usuario;
		this.email_usuario = email_usuario;
		this.clave_usuario = clave_usuario;
		this.establoqueado_usuario = establoqueado_usuario;
		this.fch_fin_bloqueo_usuario = fch_fin_bloqueo_usuario;
		this.fch_alta__usuario = fch_alta__usuario;
		this.fch_baja_usuario = fch_baja_usuario;
		this.acceso = acceso;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
