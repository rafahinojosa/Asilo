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
	JTextField medicamentoText;
	JTextField cantidadText;
	JTextField entregaText;
	JTextField dosisText;
	
	public AltaMedicamentoView(JFrame f) {
		
		controllingFrame = f;
		
		//Nombre del medicamento
		JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre de medicamento: ");
		nameLabel.setLabelFor(nameText);
		
		namePane.add(nameLabel);
		namePane.add(nameText);
		
		//Cantidad(gramos)
		JPanel medicamentoPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		medicamentoText = new JTextField(20);
		JLabel medicamentoLabel = new JLabel("Cantidad(gramos): ");
		medicamentoLabel.setLabelFor(nameText);
		
		medicamentoPane.add(medicamentoLabel);
		medicamentoPane.add(medicamentoText);
		
		//Cantidad de tabletas
		JPanel cantidadPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cantidadText = new JTextField(10);
		JLabel cantidadLabel = new JLabel("Cantidad de tabletas: ");
		cantidadLabel.setLabelFor(nameText);

		cantidadPane.add(cantidadLabel);
		cantidadPane.add(cantidadText);

		//Cantidad de tabletas
		JPanel entregaPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		entregaText = new JTextField(20);
		JLabel entregaLabel = new JLabel("Entregado por: ");
		entregaLabel.setLabelFor(nameText);

		entregaPane.add(entregaLabel);
		entregaPane.add(entregaText);
		
		//Dosis
		JPanel dosisPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dosisText = new JTextField(20);
		JLabel dosisLabel = new JLabel("Dosis: ");
		dosisLabel.setLabelFor(nameText);

		dosisPane.add(dosisLabel);
		dosisPane.add(dosisText);
		
		JComponent buttonPane = createButtonPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(namePane);
		add(medicamentoPane);
		add(cantidadPane);
		add(entregaPane);
		add(dosisPane);
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
			String sMedicamento = "";
			String sCantidad = "";
			String sEntrega = "";
			String sDosis = "";

			if(nameText.getText().equals("")) {
				
				sError = sError.concat("Nombre vacío! \n");
			} 
			
			else {
				
				sNombre = nameText.getText();
			}
			
			if (medicamentoText.getText().equals("")) {
				
				sMedicamento = sMedicamento.concat("Nombre vacío! \n");
			}
			else {

				sMedicamento = medicamentoText.getText();
			}
			
			if (cantidadText.getText().equals("")) {

				sCantidad = sCantidad.concat("Nombre vacío! \n");
			}
			else {

				sCantidad = sCantidad.getText();
			}

			if (entregaText.getText().equals("")) {

				sEntrega = sEntrega.concat("Nombre vacío! \n");
			}
			else {

				sEntrega = sEntrega.getText();
			}

			if (dosisText.getText().equals("")) {

				sDosis = sDosis.concat("Nombre vacío! \n");
			}
			else {

				sDosis = sDosis.getText();
			}


			if (!error.equals("")) {
				
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
