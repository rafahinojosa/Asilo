import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

public class AltaPacientesView extends JPanel

							implements ActionListener {

	//Declaracion de atributos
	private JFrame controllingFrame;
	
	//Text Fields
	JTextField nameText;
	JTextField dateText;
	JTextField anText;
	JTextField operacionesText;
	JTextField padeText;
	JTextField contactoText;
	JTextField telText;
	JTextField direcText;
	
	//Combo box
	JComboBox sexBox;
	JComboBox bloodBox;
	JComboBox estadoBox;
	JComboBox dormitorioBox;
	JComboBox camaBox;
	
	
	
	public AltaPacientesView(JFrame f) {
		
		controllingFrame = f;
		
		//Nombre del paciente
		JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setLabelFor(nameText);
		
		namePane.add(nameLabel);
		namePane.add(nameText);
		
		//Fecha de nacimiento del paciente
		JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateText = new JTextField(10);
		JLabel dateLabel = new JLabel("Fecha de nacimiento");
		dateLabel.setLabelFor(dateText);
		
		datePane.add(dateLabel);
		datePane.add(dateText);
		
		//Genero del paciente
		String[] gender = {"hombre", "mujer"};
		JPanel sexPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		sexBox = new JComboBox(gender);
		JLabel sexLabel = new JLabel("Sexo:");
		dateLabel.setLabelFor(dateText);
		
		sexPane.add(sexLabel);
		sexPane.add(sexBox);
		
		
		//Tipo de sangre
		String[] blood = {"O+", "O-", "A+", "A-","B+","B-", "AB+","AB-"};
		JPanel bloodPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bloodBox = new JComboBox(blood);
		JLabel bloodLabel = new JLabel("Tipo de sangre:");
		dateLabel.setLabelFor(dateText);
		
		bloodPane.add(bloodLabel);
		bloodPane.add(bloodBox);
		
		//Estado del paciente
		String[] estado = {"vivo", "muerto"};
		JPanel estadoPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		estadoBox = new JComboBox(estado);
		JLabel estadoLabel = new JLabel("Estado:");
		
		dateLabel.setLabelFor(dateText);
		estadoPane.add(estadoLabel);
		estadoPane.add(estadoBox);
		
		//Operaciones del paciente
		JPanel operacionesPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		operacionesText = new JTextField(2);
		JLabel operacionesLabel = new JLabel("Operaciones: ");
		
		operacionesLabel.setLabelFor(operacionesText);
		operacionesPane.add(operacionesLabel);
		operacionesPane.add(operacionesText);
		
		//Años de las operaciones
		JPanel anPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		anText = new JTextField(2);
		JLabel anLabel = new JLabel("Años: ");
		
		anLabel.setLabelFor(anText);
		anPane.add(anLabel);
		anPane.add(anText);
		
		//Padecimientos del paciente
		JPanel padePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		padeText = new JTextField(30);
		JLabel padeLabel = new JLabel("Padecimientos: ");
		
		padeLabel.setLabelFor(padeText);
		padePane.add(padeLabel);
		padePane.add(padeText);
		
		//Nombre del contacto
		JPanel contactoPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contactoText = new JTextField(20);
		JLabel contactoLabel = new JLabel("Nombre de contacto: ");
		
		contactoLabel.setLabelFor(contactoText);
		contactoPane.add(contactoLabel);
		contactoPane.add(contactoText);
		
		//Teléfono del contacto
		JPanel telPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		telText = new JTextField(9);
		JLabel telLabel = new JLabel("Teléfono de contacto: ");
		
		telLabel.setLabelFor(telText);
		telPane.add(telLabel);
		telPane.add(telText);
		
		//Zona en donde se encuentra el paciente
		String[] dormitorio = {"Hospital", "Dormitorio 1", "Dormitorio 2"};
		JPanel dormitorioPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dormitorioBox = new JComboBox(dormitorio);
		JLabel dormitorioLabel = new JLabel("Zona:");
		
		dormitorioLabel.setLabelFor(dateText);
		dormitorioPane.add(dormitorioLabel);
		dormitorioPane.add(dormitorioBox);
		
		//Cama del paciente
		String[] cama = {"Hospital", "Dormitorio 1", "Dormitorio 2"};
		JPanel camaPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		camaBox = new JComboBox(cama);
		JLabel camaLabel = new JLabel("Cama:");
		
		dormitorioLabel.setLabelFor(dateText);
		dormitorioPane.add(camaLabel);
		dormitorioPane.add(camaBox);
		
		//Dirección
		JPanel direcPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		direcText = new JTextField(9);
		JLabel direcLabel = new JLabel("Direccion: ");
		
		direcLabel.setLabelFor(direcText);
		direcPane.add(direcLabel);
		direcPane.add(direcText);
		
		
		JComponent buttonPane = createButtonPanel();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(namePane);
		add(datePane);
		add(sexPane);
		add(bloodPane);
		add(estadoPane);
		add(operacionesPane);
		add(anPane);
		add(padePane);
		add(contactoPane);
		add(telPane);
		add(dormitorioPane);
		add(camaPane);
		add(direcPane);
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
			
			if (!error.equals("")) {
				
				JOptionPane.showMessageDialog(controllingFrame, error);
				
			} 
			else {
				
				Paciente p = new Paciente(nombre, fecha, sexo);
				DBPacientes pDB = new DBPacientes();
				pDB.addPaciente(p);
				
				controllingFrame.dispose();
			}
		}
		
		if (cmd.equals("back"))
			controllingFrame.dispose();
			
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final AltaPacientesView newContentPane = new AltaPacientesView(frame);
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
