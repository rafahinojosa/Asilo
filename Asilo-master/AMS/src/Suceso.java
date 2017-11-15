
public class Suceso {
	
	int id;
	String nombre;
	boolean emergencia;
	int idPaciente;
	int idEnfermera;
	String info;
	
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

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdEnfermera() {
		return idEnfermera;
	}

	public void setIdEnfermera(int idEnfermera) {
		this.idEnfermera = idEnfermera;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Suceso(int id, String nombre, boolean emergencia, int idPaciente, int idEnfermera, String info) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.emergencia = emergencia;
		this.idPaciente = idPaciente;
		this.idEnfermera = idEnfermera;
		this.info = info;
	}

	public Suceso() {
		
	}
	
	
	
	
}
