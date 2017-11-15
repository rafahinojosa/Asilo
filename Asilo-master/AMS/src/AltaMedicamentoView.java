import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;


public class AltaMedicamentoView extends JPanel

implements ActionListener {
	
	//Declaración de atributos
	private JFrame controllingFrame;
	
	//Text Field
	JTextField nameText;
	JTextField cantidadText;
	JTextField provedorText;
	
	public AltaMedicamentoView(JFrame frame_input) {
		
		controllingFrame = frame_input;
		
		//Nombre del medicamento
		JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre de medicamento: ");
		nameLabel.setLabelFor(nameText);
		
		namePane.add(nameLabel);
		namePane.add(nameText);
		
		//Cantidad del medicamento
		JPanel cantidadPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cantidadText = new JTextField(20);
		JLabel cantidadLabel = new JLabel("Numero de tabletas");
		cantidadLabel.setLabelFor(cantidadText);
		
		cantidadPane.add(cantidadLabel);
		cantidadPane.add(cantidadText);
		
		//Provedor del medicamento
		JPanel provedorPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		provedorText = new JTextField(20);
		JLabel provedorLabel = new JLabel("Numero de tabletas");
		provedorLabel.setLabelFor(provedorText);
				
		provedorPane.add(provedorLabel);
		provedorPane.add(provedorText);
		
		JComponent buttonPane = createButtonPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(namePane);
		add(cantidadPane);
		add(provedorPane);
		add(buttonPane);
	}
	
	protected JComponent createButtonPanel() {

		JPanel Jreturn = new JPanel(new GridLayout(0,2));
		
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.setActionCommand("save");
		acceptButton.addActionListener(this);
		
		JButton backButton = new JButton("Regresar");
		backButton.setActionCommand("back");
		backButton.addActionListener(this);
		
		Jreturn.add(acceptButton);
		Jreturn.add(backButton);
		
		return Jreturn;
	}
	
	public void actionPerformed(ActionEvent action) {
		
		String cmd = action.getActionCommand();
		
		if (cmd.equals("save")) {
			
			String sError = "";
			String sNombre = "";
			int iD = 0;
			int iCantidad = 0;
			String sProvedor = "";
			
			if(nameText.getText().equals("")) {
				
				sError = sError.concat("Nombre vacío! \n");
			} 
			
			else {
				
				sNombre = nameText.getText();
			}
			
			if (cantidadText.getText().equals("")) {

				iCantidad = 0;
			}
			else {

				iCantidad = Integer.parseInt(cantidadText.getText());
			}
			
			if(provedorText.getText().equals("")) {
				
				sProvedor = sProvedor.concat("Provedor vacío! \n");
			}
			else {
				
				sProvedor = provedorText.getText();
			}
			

			if (!sError.equals("")) {
				
				JOptionPane.showMessageDialog(controllingFrame, sError);
			} 
		}

			/*else {
				
				//Medicamentos medicamento_1 = new Medicamentos(iD, sNombre, iCantidad, sProvedor);
				//PacientesDB pDB = new PacientesDB();
				
				/*try {
					
					//pDB.addPaciente(medicamento_1);
				} 
				/*catch (IOException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				controllingFrame.dispose();
			}
			*/
		}
		
		
		/*
		if (cmd.equals("back"))
			controllingFrame.dispose();
		}
		 */
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final AltaMedicamentoView newContentPane = new AltaMedicamentoView(frame);
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