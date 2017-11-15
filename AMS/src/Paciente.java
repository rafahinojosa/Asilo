import java.sql.Date;

public class Paciente {
	
	private String nombre;
	private Date birthday;
	private String direccion;
	private int estado;
	private int sexo;
	private String tipoDeSangre;
	private int zonaAsignada;
	private int camaAsignada;
	private int notas;
	
	public String getNombre() {
		
		return nombre;
	}
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	public Date getBirthday() {
		
		return birthday;
	}
	public void setBirthday(Date birthday) {
		
		this.birthday = birthday;
	}
	public String getDireccion() {
		
		return direccion;
	}
	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}
	public int getEstado() {
		
		return estado;
	}
	public void setEstado(int estado) {
		
		this.estado = estado;
	}
	
	public int getSexo() {
		
		return sexo;
	}
	
	public void setSexo(int sexo) {
		
		this.sexo = sexo;
	}
	
	public String getTipoDeSangre() {
		
		return tipoDeSangre;
	}
	
	public void setTipoDeSangre(String tipoDeSangre) {
		
		this.tipoDeSangre = tipoDeSangre;
	}
	
	public int getZonaAsignada() {
		
		return zonaAsignada;
	}
	
	public void setZonaAsignada(int zonaAsignada) {
		
		this.zonaAsignada = zonaAsignada;
	}
	
	public int getCamaAsignada() {
		
		return camaAsignada;
	}
	
	public void setCamaAsignada(int camaAsignada) {
		
		this.camaAsignada = camaAsignada;
	}
	
	public int getNotas() {
		
		return notas;
	}
	
	public void setNotas(int notas) {
		
		this.notas = notas;
	}
	
	public Paciente(String nombre, Date birthday, String direccion, int estado, int sexo, String tipoDeSangre,
			int zonaAsignada, int camaAsignada, int notas) {
		
		super();
		this.nombre = nombre;
		this.birthday = birthday;
		this.direccion = direccion;
		this.estado = estado;
		this.sexo = sexo;
		this.tipoDeSangre = tipoDeSangre;
		this.zonaAsignada = zonaAsignada;
		this.camaAsignada = camaAsignada;
		this.notas = notas;
	}

	
	
};
	
	