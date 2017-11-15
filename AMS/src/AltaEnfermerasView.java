import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
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
		String[] dormitorio = {"Hospital", "Dormitorio 1", "Dormitorio 2"};
		JPanel dormitorioPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dormitorioBox = new JComboBox(dormitorio);
		JLabel dormitorioLabel = new JLabel("Zona:");
		
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
			String fecha = "";
			int sexo = -1;
			
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
				
				fecha = (dateText.getText());
			}
			
			sexo = sexBox.getSelectedIndex();
			
			if (!error.equals("")) 
			{
				JOptionPane.showMessageDialog(controllingFrame, error);
			}
			else {
				
				Paciente p = new Paciente(nombre, fecha, sexo);
				PacientesDB pDB = new PacientesDB();
				
				try {
					
					pDB.addPaciente(p);
				} 
				catch (IOException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
