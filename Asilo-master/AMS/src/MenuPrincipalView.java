import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class MenuPrincipalView extends JPanel

							implements ActionListener {
	
	private static String PACIENTES = "Pacientes";
	private static String MEDICAMENTOS = "Medicamentos";
	private static String ZONAS = "Zonas";
	private static String ENFERMERAS = "Enfermeras";
	private static String NOTIFICACIONES = "Notificaciones";
	private static String notif = "";

	private JFrame controllingFrame;

	public MenuPrincipalView(JFrame f) {
		
		controllingFrame = f;
		
		JComponent buttonPane = createButtonPanel();
		JButton notButton = new JButton(NOTIFICACIONES);
		notButton.setActionCommand(NOTIFICACIONES);
		notButton.addActionListener(this);
		
		
		add(buttonPane);
		add(notButton);
		
	}
	
	protected JComponent createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(4,0));
		JButton pacButton = new JButton(PACIENTES);
		JButton medButton = new JButton(MEDICAMENTOS);
		JButton zonButton = new JButton(ZONAS);
		JButton enfButton = new JButton(ENFERMERAS);
		
		pacButton.setActionCommand(PACIENTES);
		medButton.setActionCommand(MEDICAMENTOS);
		zonButton.setActionCommand(ZONAS);
		enfButton.setActionCommand(ENFERMERAS);
		pacButton.addActionListener(this);
		medButton.addActionListener(this);
		zonButton.addActionListener(this);
		enfButton.addActionListener(this);
		
		p.add(pacButton);
		p.add(medButton);
		p.add(zonButton);
		p.add(enfButton);
		
		return p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		switch(cmd) {
		case "Pacientes":
			//Codigo para ir a siguiente frame
			PacientesView pView = new PacientesView(controllingFrame);
			controllingFrame.setContentPane(pView);
			controllingFrame.setVisible(true);
			setVisible(false);
			break;
		case "Medicamentos":
			//Codigo para ir a siguiente frame
			MedicamentosView mView = new MedicamentosView(controllingFrame);
			controllingFrame.setContentPane(mView);
			controllingFrame.setVisible(true);
			setVisible(false);
			break;
		case "Zonas":
			
			break;
		case "Enfermeras":
			//Codigo para ir a siguiente frame
			EnfermerasView eView = new EnfermerasView(controllingFrame);
			controllingFrame.setContentPane(eView);
			controllingFrame.setVisible(true);
			setVisible(false);
			break;
		case "Notificaciones":
			Notifications n = new Notifications();

			
			notif = n.getAllNotifications();
			JOptionPane.showMessageDialog(controllingFrame, notif);
	        
			break;
		default:
			break;
			
		}
			
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("MenuPrincipal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final MenuPrincipalView newContentPane = new MenuPrincipalView(frame);
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
