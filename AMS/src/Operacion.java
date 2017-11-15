import java.sql.Date;

public class Operacion {
	
	int id;
	String nombreOp;
	Date fecha;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreOp() {
		return nombreOp;
	}

	public void setNombreOp(String nombreOp) {
		this.nombreOp = nombreOp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Operacion(int id, String nombreOp, Date fecha) {
		super();
		this.id = id;
		this.nombreOp = nombreOp;
		this.fecha = fecha;
	}

	public Operacion() {
		
	}
	
	
	
	
}
