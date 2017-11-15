import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class LogInView extends JPanel
							implements ActionListener {
	
	private static String OK = "ok";
	private static String HELP = "Ayuda";
	
	private JFrame controllingFrame; 
	private JPasswordField passwordField;
	
	public LogInView(JFrame f) {
		controllingFrame = f;
		
		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);
		
		JLabel label = new JLabel("Ingresar Contraseña: ");
		label.setLabelFor(passwordField);
		
		JComponent buttonPane = createButtonPanel();
		
		JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		textPane.add(label);
		textPane.add(passwordField);
		
		
		setLayout(new GridBagLayout());
		add(textPane, new GridBagConstraints());
		add(buttonPane);
	}
	
	protected JComponent createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(1,0));
		JButton okButton = new JButton("OK");
		JButton helpButton = new JButton("Ayuda");
		
		okButton.setActionCommand(OK);
		helpButton.setActionCommand(HELP);
		
		okButton.addActionListener(this);
		helpButton.addActionListener(this);
		
		p.add(okButton);
		//p.add(helpButton);
		
		return p;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (OK.equals(cmd)) {
			char[] input = passwordField.getPassword();
			if (isPasswordCorrect(input) ) {
				//Codigo para ir a siguiente frame si el password es correcto
				MenuPrincipalView m = new MenuPrincipalView(controllingFrame);
				controllingFrame.setContentPane(m);
				controllingFrame.setVisible(true);
				setVisible(false);
			} else {
			JOptionPane.showMessageDialog(controllingFrame, 
					"La contraseña ingresada es incorrecta.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			}
			
			Arrays.fill(input, '0');
			
			passwordField.setText("");
			resetFocus();
		} else {
			JOptionPane.showMessageDialog(controllingFrame, 
					"Debe teclear el password para accdeder al sistema");
		}
		
	}
	
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = {'a','s','d','f'};
		
		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}
		
		Arrays.fill(correctPassword, '0');
		
		return isCorrect;
	}
	
	protected void resetFocus() {
		passwordField.requestFocusInWindow();
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("LogIn");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final LogInView newContentPane = new LogInView(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				newContentPane.resetFocus();
			}
		});
		
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
	


