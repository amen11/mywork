package Club;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.sql.*;
public class club_it extends JFrame {
	private JFrame frame;

	private JPanel contentPane;
	private JTextField name;
	private JTextField mail;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					club_it window = new club_it();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public club_it() {
		initialize();
		
		}
		
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1069, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	ImageIcon img=new ImageIcon("micro");
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon("D:\\Program Files (x86)\\Java\\Jdbc_proj\\micro.png"));
	lblNewLabel.setBounds(0, 0,1037, 220);
	frame.getContentPane().add(lblNewLabel);
	
	JPanel panel = new JPanel();
	panel.setBounds(318, 202, 457, 67);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Inscription dans Club Microsoft ");
	lblNewLabel_1.setBounds(65, 5, 327, 29);
	lblNewLabel_1.setForeground(Color.DARK_GRAY);
	lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 22));
	panel.add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("Ajouter ");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
	  		  PreparedStatement insert;

			String nom_prenom=name.getText();
			String email=mail.getText();
			String numt=num.getText();
			Conexbd c=new Conexbd();
			c.seConnecter(); 
		try {
			  
		  insert=c.getConnection().prepareStatement("INSERT INTO `bd_microsoft`.`members` ( `name`, `email`, `mobile`) values(?,?,?)");
		  insert.setString(1, nom_prenom);
		  insert.setString(2, email);
		  insert.setString(3, numt);
		  insert.executeUpdate();
		  name.setText("");
		  mail.setText("");
		  num.setText("");
		  name.requestFocus();
		  JOptionPane.showMessageDialog(null,"Member Adedd");
		
		  }
		 
		  catch (SQLException ex) {
			  Logger.getLogger(club_it.class.getName()).log(Level.SEVERE,null,ex);
		  }
			  
    	
    	}});
	
	
	
	btnNewButton.setForeground(new Color(0, 255, 0));
	btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
	btnNewButton.setBounds(252, 459, 145, 25);
	frame.getContentPane().add(btnNewButton);
	
	name = new JTextField();
	name.setBounds(508, 298, 116, 22);
	frame.getContentPane().add(name);
	name.setColumns(10);
	
	mail = new JTextField();
	mail.setBounds(508, 350, 116, 22);
	frame.getContentPane().add(mail);
	mail.setColumns(10);
	
	num = new JTextField();
	num.setBounds(508, 408, 116, 22);
	frame.getContentPane().add(num);
	num.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Name");
	lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 20));
	lblNewLabel_2.setBounds(318, 287, 178, 36);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Email");
	lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 20));
	lblNewLabel_3.setBounds(328, 339, 154, 36);
	frame.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Num Tel");
	lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 20));
	lblNewLabel_4.setBounds(335, 404, 124, 23);
	frame.getContentPane().add(lblNewLabel_4);
}
}

