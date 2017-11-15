import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;


public class AltaEnfermerasView extends JPanel
							implements ActionListener {

	private JFrame controllingFrame;
	JTextField nameText;
	JTextField dateText;
	JComboBox sexBox;
	
	public AltaEnfermerasView(JFrame f) {
		controllingFrame = f;
		
		JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setLabelFor(nameText);
		
		namePane.add(nameLabel);
		namePane.add(nameText);
		
		JPanel datePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateText = new JTextField(10);
		JLabel dateLabel = new JLabel("Fecha de nacimiento");
		dateLabel.setLabelFor(dateText);
		
		datePane.add(dateLabel);
		datePane.add(dateText);
		
		String[] gender = {"hombre", "mujer"};
		JPanel sexPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		sexBox = new JComboBox(gender);
		JLabel sexLabel = new JLabel("Sexo:");
		dateLabel.setLabelFor(dateText);
		
		sexPane.add(sexLabel);
		sexPane.add(sexBox);
		
		JComponent buttonPane = createButtonPanel();
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(namePane);
		add(datePane);
		add(sexPane);
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
			} else {
				nombre = nameText.getText();
			}
			if (dateText.getText().equals("")) {
				error = error.concat("Fecha incorrecta");
			} else {
				fecha = (dateText.getText());
			}
			sexo = sexBox.getSelectedIndex();
			
			if (!error.equals("")) {
				JOptionPane.showMessageDialog(controllingFrame, error);
			} else {
				Paciente p = new Paciente(nombre, fecha, sexo);
				PacientesDB pDB = new PacientesDB();
				try {
					pDB.addPaciente(p);
				} catch (IOException e1) {
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
