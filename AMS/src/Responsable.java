
public class Responsable {
	
	//Declaracion de atributos
	int id;
	String nombre;
	String direccion;
	String telefono;
	String email;

	//Constructor con parametros
	public Responsable(int id, String nombre, String direccion, String telefono, String email) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	//Getters
	public int getId() {
	
		return id;
	}
	
	public String getNombre() {
	
		return nombre;
	}
	
	public String getDireccion() {
		
		return direccion;
	}
	
	public String getTelefono() {
		
		return telefono;
	}
	
	public String getEmail() {
	
		return email;
	}
	
	//Setters
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}
	
	public void setTelefono(String telefono) {
		
		this.telefono = telefono;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
};