package Gioco;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Pannello {
	
	public Pannello () {
		
	JFrame frame = new JFrame();
	 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(900,900);
	ImageIcon image = new ImageIcon("src/images/CODEX_Rulebook_IT/Rulebook (1).png");
	JLabel label = new JLabel();
	label.setText("Codex");
	label.setIcon(image);
	
	frame.add(label);
	frame.setVisible(true);

	}
	

	
}
