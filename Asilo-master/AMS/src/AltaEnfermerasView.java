import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Arrays;


public class AltaEnfermerasView extends JPanel

implements ActionListener {

	//Declaracón de atributo
	private JFrame controllingFrame;
	
	//Text Fields
	JTextField nameText;
	JTextField dateText;
	JTextField direcText;
	
	//Combo box
	JComboBox sexBox;
	JComboBox dormitorioBox;
	
	public AltaEnfermerasView(JFrame f) {
		
		controllingFrame = f;
		
		//Nombre de la enfermera
		JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setLabelFor(nameText);
		
		namePane.add(nameLabel);
		namePane.add(nameText);
		
		//Fecha de nacimiento de la enfermera
		JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateText = new JTextField(10);
		JLabel dateLabel = new JLabel("Fecha de nacimiento");
		dateLabel.setLabelFor(dateText);
		
		datePane.add(dateLabel);
		datePane.add(dateText);
		
		//Genero de enfermera/o
		String[] gender = {"hombre", "mujer"};
		JPanel sexPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		sexBox = new JComboBox(gender);
		JLabel sexLabel = new JLabel("Sexo:");
		dateLabel.setLabelFor(dateText);
		
		sexPane.add(sexLabel);
		sexPane.add(sexBox);
		
		//Dirección
		JPanel direcPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		direcText = new JTextField(9);
		JLabel direcLabel = new JLabel("Dirección: ");
				
		direcLabel.setLabelFor(direcText);
		direcPane.add(direcLabel);
		direcPane.add(direcText);
		
		//Zona en donde se encuentra el paciente
		String[] dormitorio = {"Zona 1", "Zona 2", "Zona 3"};
		JPanel dormitorioPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dormitorioBox = new JComboBox(dormitorio);
		JLabel dormitorioLabel = new JLabel("Zona asignada:");
		
		dormitorioLabel.setLabelFor(dateText);
		dormitorioPane.add(dormitorioLabel);
		dormitorioPane.add(dormitorioBox);
		
		JComponent buttonPane = createButtonPanel();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(namePane);
		add(datePane);
		add(sexPane);
		add(direcPane);
		add(dormitorioPane);
		add(buttonPane);
	}
	
	protected JComponent createButtonPanel() {
		
		JPanel p = new JPanel(new GridLayout(0,2));
		
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.setActionCommand("save");
		acceptButton.addActionListener(this);
		
		JButton backButton = new JButton("Regresar");
		backButton.setActionCommand("back");
		backButton.addActionListener(this);
		
		p.add(acceptButton);
		p.add(backButton);
		
		return p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		
		if (cmd.equals("save")) {
			
			String error = "";
			String nombre = "";
			Date fecha = null;
			String direccion = "";
			int sexo = -1;
			int zona = -1;
			
			if(nameText.getText().equals("")) {
				
				error = error.concat("Nombre vacío! \n");
			} 
			else {
				
				nombre = nameText.getText();
			}
			
			if (dateText.getText().equals("")) {
				
				error = error.concat("Fecha incorrecta");
			} 
			else {
				int y, m, d;
				String[] date = dateText.getText().split("-");
				y = Integer.parseInt(date[0]);
				m = Integer.parseInt(date[1]);
				d = Integer.parseInt(date[2]);
				System.out.println(y +" "+m+" "+d );
				fecha = new Date(y-1900,m-1,d);
				System.out.println(fecha);
			}
			
			if (direcText.getText().equals("")) {
				error = error.concat("Direccion incorrecta \n");
			}
			else {
				direccion = direcText.getText();
			}
			
			sexo = sexBox.getSelectedIndex();
			zona = dormitorioBox.getSelectedIndex();
			
			if (!error.equals("")) 
			{
				JOptionPane.showMessageDialog(controllingFrame, error);
			}
			else {
				
				Enfermera enf = new Enfermera(nombre, fecha, direccion, sexo, zona);
				DBEnfermera eDB = new DBEnfermera();
				
				eDB.addEnfermera(enf);
//				pDB.addPaciente(p);
				
				controllingFrame.dispose();
			}
		}
		
		if (cmd.equals("back"))
			controllingFrame.dispose();
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final AltaEnfermerasView newContentPane = new AltaEnfermerasView(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		
		frame.setSize(800, 450);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
	
}
