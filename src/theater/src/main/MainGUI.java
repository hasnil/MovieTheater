package main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {
	
	private JFrame frame;
	
	public MainGUI() {
		frame = new JFrame();
		frame.setBounds(100, 140, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		
		JButton btnNewButton = new JButton("Browse Theaters");
		btnNewButton.setBounds(98, 32, 130, 47);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Browse Showtimes");
		btnNewButton_1.setBounds(98, 111, 130, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(102, 180, 126, 40);
		frame.getContentPane().add(btnNewButton_2);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}


