import java.sql.Date;

public class Nota {
	
	String sId;
	String sAutor;
	String sInfo;
	Date sFecha;
	String sInvolucrados;
	
	public Nota() {
		
	}
	
	public Nota(String id,	String autor, String info, Date fecha, String invol) {
		sId = id;
		sAutor = autor;
		sInfo = info;
		sFecha = fecha;
		sInvolucrados = invol;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsAutor() {
		return sAutor;
	}

	public void setsAutor(String sAutor) {
		this.sAutor = sAutor;
	}

	public String getsInfo() {
		return sInfo;
	}

	public void setsInfo(String sInfo) {
		this.sInfo = sInfo;
	}

	public Date getsFecha() {
		return sFecha;
	}

	public void setsFecha(Date sFecha) {
		this.sFecha = sFecha;
	}

	public String getsInvolucrados() {
		return sInvolucrados;
	}

	public void setsInvolucrados(String sInvolucrados) {
		this.sInvolucrados = sInvolucrados;
	}
	
	
	
}
