import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class EnfermerasView extends JPanel

							implements ActionListener {
	
	private static String ALTA = "alta";
	private static String VER = "ver";
	private static String VOLVER = "volver";

	private JFrame controllingFrame;

	public EnfermerasView(JFrame f) {
		controllingFrame = f;
		
		JComponent buttonPane = createButtonPanel();
		
		add(buttonPane);
		
	}
	
	protected JComponent createButtonPanel() {
		
		JPanel p = new JPanel(new GridLayout(2,2));
		JButton altaButton = new JButton("Alta de Enfermera");
		JButton verButton = new JButton("Ver Enfermeras");
		JButton volverButton = new JButton("volver");
		
		altaButton.setActionCommand(ALTA);
		verButton.setActionCommand(VER);
		volverButton.setActionCommand(VOLVER);
		
		altaButton.addActionListener(this);
		verButton.addActionListener(this);
		volverButton.addActionListener(this);
		
		p.add(altaButton);
		p.add(verButton);
		p.add(volverButton);
		
		return p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		switch(cmd) {
		case "alta":
			//Codigo para abrir nuevo frame
			JFrame altaFrame = new JFrame("Nueva Enfermera");
			altaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final AltaEnfermerasView newAltaEContentPane = new AltaEnfermerasView(altaFrame);
			newAltaEContentPane.setOpaque(true);
			altaFrame.setContentPane(newAltaEContentPane);
			
			
			altaFrame.setSize(600, 400);
			altaFrame.setVisible(true);
			break;
		case "ver":
			//Codigo para abrir nuevo frame
			JFrame listaFrame = new JFrame("Lista de Enfermeras");
			listaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final ListaEnfermerasView newListaEContentPane = new ListaEnfermerasView(listaFrame);
			newListaEContentPane.setOpaque(true);
			listaFrame.setContentPane(newListaEContentPane);
			
			
			listaFrame.setSize(600, 400);
			listaFrame.setVisible(true);
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
		
		final EnfermerasView newContentPane = new EnfermerasView(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		
		frame.setSize(800, 450);
		frame.setVisible(true);
		
	}
	
	
	
}
