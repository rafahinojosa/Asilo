import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class PacientesView extends JPanel

implements ActionListener {
	
	//Declaracion de atributos
	private static String ALTA = "alta";
	private static String VER = "ver";
	private static String SUCESO = "suceso";
	private static String NOTA = "nota";
	private static String VOLVER = "volver";

	private JFrame controllingFrame;

	
public PacientesView(JFrame f) {
		
		controllingFrame = f;
		
		JComponent buttonPane = createButtonPanel();
		
		add(buttonPane);
}
	
protected JComponent createButtonPanel() {
		
		JPanel p = new JPanel(new GridLayout(2,2));
		JButton altaButton = new JButton("Alta de paciente");
		JButton verButton = new JButton("Ver pacientes");
		JButton sucButton = new JButton("Agregar Suceso");
		JButton notaButton = new JButton("Agregar Nota");
		JButton volverButton = new JButton("volver");
		
		altaButton.setActionCommand(ALTA);
		verButton.setActionCommand(VER);
		sucButton.setActionCommand(SUCESO);
		notaButton.setActionCommand(NOTA);
		volverButton.setActionCommand(VOLVER);
		
		altaButton.addActionListener(this);
		verButton.addActionListener(this);
		sucButton.addActionListener(this);
		notaButton.addActionListener(this);
		volverButton.addActionListener(this);
		
		p.add(altaButton);
		p.add(verButton);
		p.add(sucButton);
		p.add(notaButton);
		p.add(volverButton);
		
		return p;
		
}
	
public void actionPerformed(ActionEvent e) {
	
		String cmd = e.getActionCommand();
		
		switch(cmd) {
		
		case "alta":
			
			//Codigo para abrir nuevo frame
			JFrame altaFrame = new JFrame("Paciente Nuevo");
			altaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final AltaPacientesView newAltaPContentPane = new AltaPacientesView(altaFrame);
			newAltaPContentPane.setOpaque(true);
			altaFrame.setContentPane(newAltaPContentPane);
			
			
			altaFrame.setSize(600, 600);
			altaFrame.setVisible(true);
			
			break;
			
		case "ver":
			
			//Codigo para abrir nuevo frame
			JFrame listaFrame = new JFrame("Pacientes");
			listaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final ListaPacientesView newListaPContentPane = new ListaPacientesView(listaFrame);
			newListaPContentPane.setOpaque(true);
			listaFrame.setContentPane(newListaPContentPane);
			
			listaFrame.setSize(600, 400);
			listaFrame.setVisible(true);
			
			break;
			
		case "Zonas":
			
			break;
			
		case "Enfermeras":
			
			break;
			
		case "Notificaciones":
//			Notifications n = new Notifications(1);

//			JOptionPane.showMessageDialog(controllingFrame, notif);
	        
			break;
			
		case "volver":
			
			
			MenuPrincipalView aux = new MenuPrincipalView(controllingFrame);
			controllingFrame.setContentPane(aux);
			controllingFrame.setVisible(true);
			
		default:
			break;
		}
			
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("MenuPrincipal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final PacientesView newContentPane = new PacientesView(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		
		frame.setSize(800, 450);
		frame.setVisible(true);
		
	}
	
	
	
}
