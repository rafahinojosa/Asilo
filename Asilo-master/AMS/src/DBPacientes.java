import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.jdbc.Statement;

public class DBPacientes {
	
	//borrar cuando cambie implementacion
//	public Vector<Paciente> pacientVector;

	
	public DBPacientes() {
		//hacer el enlace a la base de datos
		
		
		
		//pacientVector = new Vector<>();
		
		//String filename = "data/pacientes.txt";
		
		//String line = null;
		
//		String name;
//		String fecha; 
//		int sex;
		
//		try { 
//			FileReader fileReader = new FileReader(filename);
//			
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//			while((line = bufferedReader.readLine()) != null) {
//				name = line;
//				fecha = bufferedReader.readLine();
//				sex = Integer.parseInt(bufferedReader.readLine());
//				System.out.println(name + fecha + sex);
//				addPaciente(new Paciente(name, fecha, sex));
//			}
//			bufferedReader.close();
//		}
//		catch(FileNotFoundException ex) {
//			System.out.println("Unable to open file");
//		}
//		catch(IOException ex) {
//			System.out.println("Error reading file");
//		}
		
		
		
	}
	
	public void addPaciente(Paciente p) {
		//Query para agregar con parametros de paciente (usar gets para cada uno :( )
	}
	
	public void deletePaciente(int id) {
		//Query para borrar paciente
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
			String query = "delete from paciente where id_paciente = ?";
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
