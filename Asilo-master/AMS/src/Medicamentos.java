
public class Medicamentos {
	
	int id;
	String nombre;
	int cantidad;
	String provedor;

	public Medicamentos() {
		
	}

	public Medicamentos(int id, String nombre, int cantidad, String provedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.provedor = provedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProvedor() {
		return provedor;
	}

	public void setProvedor(String provedor) {
		this.provedor = provedor;
	}
	
	
	
	
}
