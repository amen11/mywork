package Isima;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Isima_it {

	private JFrame frame;
	private JTextField name;
	private JTextField mail;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Isima_it window = new Isima_it();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Isima_it() {
		initialize();
		table_update();
	}
	
		//table 
		private void table_update() {
  			int c;
  			
  			
  			ConnexBD d=new ConnexBD();
				d.seConnecter(); 
  			try {
  				  
  			  d.executerRequete("SELECT * FROM isima.etudiant ;");
  			
  			  DefaultTableModel dft=(DefaultTableModel)table.getModel();
  			  dft.setRowCount(0);
  			   c=0;
  			  while(d.getRs().next()) {
  				  
  				  Vector<String> v=new Vector<String>();
  					  int id=d.getRs().getInt("idetudiant");
  					 String name=  d.getRs().getString("nom_&_prenom");
  					 String mail=d.getRs().getNString("Email");
  					 String fil=d.getRs().getNString("Filiere");
  					 String niv= d.getRs().getNString("Niveau");
  					dft.addRow(new Object[]{id, name, mail, fil,niv});
  					c++;
  			  }}
  			  catch (SQLException ex) {
  				  ex.printStackTrace();
  			  }}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 925, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel inscr = new JLabel("Inscription ISIMA");
		inscr.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		inscr.setHorizontalAlignment(SwingConstants.CENTER);
		inscr.setBounds(190, 13, 356, 115);
		ImageIcon img=new ImageIcon("img31382565184_logo-isima");
		inscr.setIcon(new ImageIcon("D:\\Program Files (x86)\\Java\\Projetjdbc\\img\\logo-isima150.png"));
		frame.getContentPane().add(inscr);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel.setBounds(12, 137, 450, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nouveau Etudiant ");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		lblNewLabel_1.setBounds(30, 24, 160, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNomPrnom = new JLabel("Nom & Pr\u00E9nom");
		lblNomPrnom.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 15));
		lblNomPrnom.setBounds(30, 85, 139, 16);
		panel.add(lblNomPrnom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 15));
		lblEmail.setBounds(30, 134, 71, 16);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_2 = new JLabel("fili\u00E8re");
		lblNewLabel_2.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 187, 106, 16);
		panel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Niveau");
		lblNewLabel_3.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(30, 235, 106, 16);
		panel.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(242, 82, 151, 22);
		panel.add(name);
		name.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(242, 131, 151, 22);
		panel.add(mail);
		mail.setColumns(10);
		
		JComboBox<String> txtfil = new JComboBox<String>();
		txtfil.setModel(new DefaultComboBoxModel<String>(new String[] {"","LAI", "LFI", "LARS", "LCS", "LBS"}));
		txtfil.setToolTipText("Filiere");
		txtfil.setBounds(242, 184, 151, 22);
		panel.add(txtfil);
		
		JRadioButton rdbtnme = new JRadioButton("1ére");
		rdbtnme.setBounds(177, 231, 61, 25);
		rdbtnme.setActionCommand("1ére");
		panel.add(rdbtnme);
		JRadioButton rdbtnme1 = new JRadioButton("2\u00E9me");
		rdbtnme1.setBounds(258, 231, 61, 25);
		rdbtnme1.setActionCommand("2éme");
		panel.add(rdbtnme1);
		JRadioButton rdbtnme2 = new JRadioButton("3\u00E9me");
		rdbtnme2.setBounds(332, 231, 61, 25);
		rdbtnme2.setActionCommand("3éme");
		panel.add(rdbtnme2);
		ButtonGroup radniv = new ButtonGroup();
        radniv.add(rdbtnme);
        radniv.add(rdbtnme1);
        radniv.add(rdbtnme2);
 
        
        //add____________ajout
        JButton add = new JButton("Ajouter");
        
        add.addActionListener(new ActionListener() {
        	
  		  PreparedStatement insert;
 
  		  
        	public void actionPerformed(ActionEvent arg0) {
			Etudiant etudiant=new Etudiant();
			String nom_prenom=name.getText();
			String email=mail.getText();
			String filiere=(String) txtfil.getSelectedItem();
			String niveau=radniv.getSelection().getActionCommand();
			 
			ConnexBD c=new ConnexBD();
				c.seConnecter(); 
			try {
				  
			  insert=c.getConnection().prepareStatement("INSERT INTO `isima`.`etudiant` ( `Nom_&_prenom`, `Email`, `Niveau`, `Filiere`) values(?,?,?,?)");
			  insert.setString(1, nom_prenom);
			  insert.setString(2, email);
			  insert.setString(3, niveau);
			  insert.setString(4, filiere);
			  insert.executeUpdate();
			  JOptionPane.showMessageDialog(null,"Adedd");
			  table_update();
			  name.setText("");
			  mail.setText("");
			  txtfil.setSelectedItem("");
			  radniv.clearSelection();
			  name.requestFocus();
			  
			  }
			 
			  catch (SQLException ex) {
				  Logger.getLogger(Isima_it.class.getName()).log(Level.SEVERE,null,ex);
			  }
				  
        	
        	}});
		add.setFont(new Font("Arial", Font.PLAIN, 18));
		add.setBounds(93, 297, 97, 25);
		panel.add(add);
		
		
		/* delete button______________________________*/
		
		JButton del = new JButton("Supprimer");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dft=(DefaultTableModel)table.getModel();
				int rowselected=table.getSelectedRow();
				
				
		  		PreparedStatement delete;
		 
		  				ConnexBD c=new ConnexBD();
		  				c.seConnecter();
					  try {
					 
					  int id=Integer.parseInt(dft.getValueAt(rowselected, 0).toString());
					  int result=JOptionPane.showConfirmDialog(null, "vous etes sur?","alert",JOptionPane.YES_NO_OPTION);
					  if(result==JOptionPane.YES_OPTION) {
						  delete=c.getConnection().prepareStatement("DELETE FROM `isima`.`etudiant`  WHERE `idEtudiant`="+id+";");
						  delete.executeUpdate();
					      table_update();
						  JOptionPane.showMessageDialog(null,"deleted");
						  name.setText("");
						  mail.setText("");
						  txtfil.setSelectedItem("");
						  radniv.clearSelection();
						  name.requestFocus();
						  table.clearSelection();
					  }
					  
					
				  }
				  catch (SQLException ex) {
					//  Logger.getLogger(Isima_it.class.getName()).log(Level.SEVERE,null,ex);
				  ex.printStackTrace();
				  }
				
			
		
			
			}
		});
		del.setFont(new Font("Arial", Font.PLAIN, 18));
		del.setBounds(268, 297, 116, 25);
		panel.add(del);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(484, 137, 405, 335);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dft=(DefaultTableModel)table.getModel();
				int rowselected=table.getSelectedRow();
				name.setText((String) dft.getValueAt(rowselected, 1));
				mail.setText((String) dft.getValueAt(rowselected, 2));
				int fi1=txtfil.getSelectedIndex();
				txtfil.setSelectedIndex(fi1);
				radniv.setSelected(null, true);
				
			}
			
		});
		table.setForeground(new Color(64, 64, 64));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nom & Prenom", "Email","Fili\u00E8re" ,"Niveau" 
			}
		));

		JLabel bg = new JLabel("fili\u00E8re");
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Isima_it.class.getResource("/image/jeshoots-com-pUAM5hPaCRI-unsplash.jpg")));
		lblNewLabel.setBounds(0, 0,919, 532);
		frame.getContentPane().add(lblNewLabel);
	}

	
}
	
     
