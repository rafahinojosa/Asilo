
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
	}
	
	public int getSize() {
//		query count para el numero de elementos	
		return 0;
	}
	

	
}
