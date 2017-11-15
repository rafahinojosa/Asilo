
public class Medicamento {
	
	int idPaciente;
	int idMedicamentos;
	String dosis;
	
	public Medicamento() {
		
	}

	public int getIdPaciente() {
		
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		
		this.idPaciente = idPaciente;
	}

	public int getIdMedicamentos() {
		
		return idMedicamentos;
	}

	public void setIdMedicamentos(int idMedicamentos) {
		
		this.idMedicamentos = idMedicamentos;
	}

	public String getDosis() {
		
		return dosis;
	}

	public void setDosis(String dosis) {
		
		this.dosis = dosis;
	}

	public Medicamento(int idPaciente, int idMedicamentos, String dosis) {
		
		super();
		this.idPaciente = idPaciente;
		this.idMedicamentos = idMedicamentos;
		this.dosis = dosis;
	}
	
	
	
	
}
