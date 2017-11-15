import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.jdbc.Statement;

public class DBEnfermera {
	
	
	public DBEnfermera() {
		//hacer el enlace a la base de datos
		
	}
	
	public void addEnfermera(Enfermera enf) {
	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		//insert into
		try
		{
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/asilo";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "What an amazing password!");

			// create the java statement
			java.sql.Statement st = conn.createStatement();

			// our SQL SELECT query. 
			// if you only need a few columns, specify them by name instead of using "*"
			st.executeUpdate (

					"insert INTO enfermera (nombre, fechaNacimiento, direccion, sexo, zonaAsignada) "
							+ "Values ('" +enf.getNombre() +"', '" + enf.getBirthdate() +"', '"
							+ enf.getDireccion() + "', '" + enf.getSexo() + "', '" + enf.getZonaAsignada() +"')");
			//		+ "VALUES ('Dora Dominguez', '19880720', 'Privada X 193', 1, 2)");
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public void deleteEnfermera(int id) {
		//Query para borrar algo
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		//delete method
		try
		{
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/asilo";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "What an amazing password!");

			java.sql.Statement st = conn.createStatement();
			// our SQL SELECT query. 
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "delete from enfermera where id_empleado = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);

			// execute the preparedstatement
			preparedStmt.execute();

			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public int getSize() {
//		query count para el numero de elementos	
		return 0;
	}
	

	
}
