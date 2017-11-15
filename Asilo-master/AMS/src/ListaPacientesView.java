import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;


public class ListaPacientesView extends JPanel
							implements ActionListener {

	private JFrame controllingFrame;
	DBPacientes pdb = new DBPacientes();
	int numPacientes = pdb.getSize();
	Vector<Paciente> pacientVector = new Vector<>();
	
	
	public ListaPacientesView(JFrame f) {
		controllingFrame = f;
		
		JPanel titlePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel nameLabel = new JLabel("Lista de Pacientes");
		titlePane.add(nameLabel);
		
		
		String[] columnNames = {"Nombre",
                "Fecha",
                "Sexo"};
		
		Object[][] data = new Object[numPacientes][3];
			
		int i = 0;
		
		for (Paciente p : pacientVector) {
			data[i][0] = p.getNombre();
			data[i][1] = p.getFecha();
			data[i][2] = p.getSexo() == 0 ? "hombre" : "mujer";
			i++;
		}
		
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titlePane);
		add(scrollPane);
		
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
		
			
	}
	
	
	private static void createAndShowGUI() {
		
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final ListaPacientesView newContentPane = new ListaPacientesView(frame);
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
