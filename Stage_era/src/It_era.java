import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.mysql.jdbc.Statement;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.repo.DataAdapterResource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class It_era extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JTextField raison;
	private JTextField mat1;
	private JTextField date_t;
	private JTextField heure_de_s;
	private JTextField serv;
	private JTable tab;
	private JTextField serch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					It_era frame = new It_era();
					frame.setTitle("Autorisation de Sortie");
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		 
		});
	}
	public It_era() {
		setAlwaysOnTop(true);
		initialize();
		setIconImage(Toolkit.getDefaultToolkit().getImage("era_contact.png"));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		table_update();
	}
	//table 
			private void table_update()  {
				int c;
	  			Connection connection1=null;
	  			PreparedStatement select;
	  			  try {
	  				  Class.forName("com.mysql.jdbc.Driver");
	  			  connection1=DriverManager.getConnection("jdbc:mysql://localhost/Isima","root","0000");
	  			  select=connection1.prepareStatement("SELECT Distinct* FROM bd_era.employe; ");
	  			  ResultSet rs=select.executeQuery();
	  			  DefaultTableModel dft=(DefaultTableModel)tab.getModel();
	  			   c=0;
	  			
				while(rs.next()){
	  				   int mat=rs.getInt("mat");
	  					String name= rs.getNString("nom_prenom");
	  					String serv=rs.getNString("service");
	  					dft.addRow(new Object[] {mat,name,serv});
	  					c++;
	  			  }}
	  			  catch (SQLException ex) {
	  			  } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			private void table_search(String src)  {
				int c;
	  			Connection connection1=null;
	  			PreparedStatement select;
	  			  try {
	  				  Class.forName("com.mysql.jdbc.Driver");
	  			  connection1=DriverManager.getConnection("jdbc:mysql://localhost/Isima","root","0000");
	  			  select=connection1.prepareStatement("select * from bd_era.employe where mat = "+src+";");
	  			  ResultSet rs=select.executeQuery();
	  			  DefaultTableModel dft=(DefaultTableModel)tab.getModel();
	  			  dft.setRowCount(0); 
	  			  c=0;
	  			
				while(rs.next()){
	  				   int mat=rs.getInt("mat");
	  					String name= rs.getNString("nom_prenom");
	  					String serv=rs.getNString("service");
	  					dft.addRow(new Object[] {mat,name,serv});
	  					c++;
	  			  }}
	  			  catch (SQLException ex) {
	  			  } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			

	/**
	 * Create the frame.
	 */
	public String getdate(){
		
	    DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy"); 
	    Date date = new Date();
	    return dateformat.format(date);
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1918, 1048);
		
		
		JLabel name = new JLabel("Nom & Prenom :\r\n\r\n");
		name.setFont(new Font("Stencil", Font.PLAIN, 15));
		
		JLabel rds = new JLabel("Raison de sortie :\r\n");
		rds.setFont(new Font("Stencil", Font.PLAIN, 15));
		
		JLabel matricule = new JLabel("Matricule :\r\n");
		matricule.setFont(new Font("Stencil", Font.PLAIN, 15));
		
		name1 = new JTextField();
		name1.setToolTipText("Entrer votre nom\r\n");
		name1.setColumns(10);
		name1.requestFocusInWindow();
		
		raison = new JTextField();
		raison.setToolTipText("donner la raison de sortie\r\n");
		raison.setColumns(10);
		
		mat1 = new JTextField();
		mat1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		mat1.setToolTipText("Matricule");
		mat1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Heure De Sortie :\r\n");
		lblNewLabel_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		
		heure_de_s = new JTextField();
		heure_de_s.setToolTipText("lheure de sortie");
		heure_de_s.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Autorisation De Sortie");
		lblNewLabel.setIcon(new ImageIcon("D:\\Program Files (x86)\\Java\\Stage_era\\era_contact.png"));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 19));
		
		
		JLabel lblNewLabel_1 = new JLabel("Service :");
		lblNewLabel_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		JLabel date = new JLabel("Date :\r\n");
		date.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		date.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		date_t = new JTextField();
		date_t.setColumns(10);
		String date1=getdate();
		date_t.setText(date1);
		
		serv = new JTextField();
		serv.setToolTipText("Service\r\n");
		serv.setColumns(10);
		serv.requestFocus();
		
		JButton add = new JButton("Fill Report ");
		add.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement insert;

				String nom_prenom=name1.getText();
				int mat=mat1.getColumns();
				String rais=raison.getText();
				String heure=heure_de_s.getText();
				String ser=serv.getText();
				Conexbd c=new Conexbd();
				c.seConnecter(); 
			try {
				  
			  insert=c.getConnection().prepareStatement("INSERT INTO `bd_era`.`employe` ( `nom_prenom`, `mat`, `raison_desortie`,`heure_sortie`,`service`) values(?,?,?,?,?)");
			  insert.setString(1, nom_prenom);
			  insert.setLong(2, mat);
			  insert.setString(3, rais);
			  insert.setString(4, heure);
			  insert.setString(5, ser);
			  insert.executeUpdate();
			  table_update();
			  
			  JOptionPane.showMessageDialog(null,"Report Adedd");
			
			  }
			 
			  catch (SQLException ex) {
				  Logger.getLogger(It_era.class.getName()).log(Level.SEVERE,null,ex);
			  }

			}
		});
		add.setBackground(Color.GREEN);
		add.setForeground(Color.BLACK);
		add.setToolTipText("Add to Dataabase");
		add.setFont(new Font("Myanmar Text", Font.PLAIN, 18));
		
		JButton print = new JButton("Print Report");
		print.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jasper_rp report=new Jasper_rp();
				report.Jasper(mat1.getColumns());
				
				  name1.setText("");
				  mat1.setText("");
				  raison.setText("");
				  heure_de_s.setText("");
				  serv.setText("");
				  serv.requestFocus();
			}
		});
		print.setToolTipText("Fill in a Report before printing");
		print.setForeground(Color.BLACK);
		print.setFont(new Font("Myanmar Text", Font.PLAIN, 18));
		print.setBackground(Color.BLUE);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.isMaximumSizeSet();
		tab = new JTable();
		tab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
						DefaultTableModel dft=(DefaultTableModel)tab.getModel();
						int rowselected=tab.getSelectedRow();
						name1.setText((String) dft.getValueAt(rowselected, 1));
						serv.setText((String) dft.getValueAt(rowselected, 2));	
					}
				});
		scrollPane.setViewportView(tab);
		tab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mat", "Service", "Nom_Prenom"
			}
		));
		serch = new JTextField();
		serch.setColumns(10);
		
		JButton bsearch = new JButton("Search");
		bsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String src=serch.getText();
				table_search(src);
				
  			
			
			
			}});
		getContentPane().setLayout(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(185)
									.addComponent(date, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(date_t, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(145)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(name, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(matricule, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
											.addComponent(rds, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(43)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(mat1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(raison, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(57)
											.addComponent(name1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(add, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(81)
							.addComponent(print, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(312)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(serv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(heure_de_s, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(serch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bsearch, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(183))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
							.addGap(173))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(635, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addGap(632))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(date, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(date_t, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(serv, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(name1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rds, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(matricule, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(mat1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(raison, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addComponent(heure_de_s, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(add, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(print, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(serch, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(bsearch, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGap(233))
		);
		getContentPane().setLayout(groupLayout);
		
		
		}	
}