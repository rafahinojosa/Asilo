
public class Zona {
	
	String id;
	int tipo;
	int capacidad;
	int camas;
	
	public Zona() {
		
	}
	
	public Zona(String id, int tipo, int capacidad, int camas) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.camas = camas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCamas() {
		return camas;
	}

	public void setCamas(int camas) {
		this.camas = camas;
	}
	
	
	
}
