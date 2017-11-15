import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class MedicamentosView extends JPanel

							implements ActionListener {
	
	private static String ALTA = "alta";
	private static String VER = "ver";
	private static String VOLVER = "volver";

	private JFrame controllingFrame;

	public MedicamentosView(JFrame f) {
		controllingFrame = f;
		
		JComponent buttonPane = createButtonPanel();
		
		add(buttonPane);
		
	}
	
	protected JComponent createButtonPanel() {
		
		JPanel p = new JPanel(new GridLayout(2,2));
		JButton altaButton = new JButton("Alta de medicamento");
		JButton verButton = new JButton("Ver Inventario");
		JButton volverButton = new JButton("volver");
		
		altaButton.setActionCommand(ALTA);
		verButton.setActionCommand(VER);
		
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
			JFrame altaFrame = new JFrame("Medicamento Recibido");
			altaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final AltaMedicamentoView newAltaMContentPane = new AltaMedicamentoView(altaFrame);
			newAltaMContentPane.setOpaque(true);
			altaFrame.setContentPane(newAltaMContentPane);
			
			
			altaFrame.setSize(600, 400);
			altaFrame.setVisible(true);
			break;
		case "ver":
			//Codigo para abrir nuevo frame
			JFrame listaFrame = new JFrame("Inventario de Medicamento");
			listaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			final InventarioMedicamentosView newListaMContentPane = new InventarioMedicamentosView(listaFrame);
			newListaMContentPane.setOpaque(true);
			listaFrame.setContentPane(newListaMContentPane);
			
			
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
		
		final MedicamentosView newContentPane = new MedicamentosView(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		
		frame.setSize(800, 450);
		frame.setVisible(true);
		
	}
	
	
	
}
