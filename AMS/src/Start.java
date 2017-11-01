import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class Start {

	public static void main(String[] args) {
				
		JFrame frame = new JFrame("Casa de Retiro Don Pancho");
		LogInView login = new LogInView(frame);
		frame.setContentPane(login);
		frame.setSize(800, 450);
		frame.setVisible(true);
		
	}
	
		
}
