
public class Paciente {
	
	private String nombre;
	

	private String fecha;
	private int sexo;
	private String sangre;
	
	
	public Paciente() {
		nombre ="Fulano";
		fecha = "01/01/01";
		sexo = '0';
		sangre = "O+";
	}
	
	public Paciente(String n, String f, int sex) {
		nombre = n;
		fecha = f;
		sexo = sex;
	}
	
	public String toString() {
		return nombre + "\n" + fecha + "\n" + sexo + "\n";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
}
