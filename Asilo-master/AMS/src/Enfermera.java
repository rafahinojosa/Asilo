import java.sql.Date;

public class Enfermera {
	
	String nombre;
	String id;
	Date birthdate;
	String direccion;
	int sexo;
	int zonaAsignada;

	
	public Enfermera() {
		
	}

	public Enfermera(String nombre,  Date birthdate, String direccion, int sexo, int zonaAsignada) {
		
		super();
		this.nombre = nombre;
		this.birthdate = birthdate;
		this.direccion = direccion;
		this.sexo = sexo;
		this.zonaAsignada = zonaAsignada;

	}

	public String getNombre() {
		
		return nombre;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}

	public String getId() {
		
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthdate() {
		
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		
		this.birthdate = birthdate;
	}

	public String getDireccion() {
		
		return direccion;
	}

	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}

	public int getSexo() {
		
		return sexo;
	}

	public void setSexo(int sexo) {
		
		this.sexo = sexo;
	}

	public int getZonaAsignada() {
		
		return zonaAsignada;
	}

	public void setZonaAsignada(int zonaAsignada) {
		
		this.zonaAsignada = zonaAsignada;
	}

	
}
