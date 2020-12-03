import java.awt.Color;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;


public class Jasper_rp extends JFrame  {
	private int mat;
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void Jasper(int mat) { 		
		java.sql.Connection conn =null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql://localhost/bd_era", "root", "0000");

		JasperDesign jd=JRXmlLoader.load("D:\\Program Files (x86)\\JasperSoft\\My Reports\\MyReports\\Autor.jrxml");
		JRDesignQuery query = new JRDesignQuery();
		

		query.setText("select * from bd_era.employe where mat = "+mat+";");
		jd.setQuery(query);
		JasperCompileManager.compileReport(jd);
		Map map = new HashMap();
		JasperReport jreport = JasperCompileManager.compileReport(jd); 
		JasperPrint jprint = JasperFillManager.fillReport(jreport, map,conn);
		JRViewer viewer=new JRViewer(jprint);
		viewer.setOpaque(true);
		viewer.setVisible(true);
		add(viewer);
		JasperPrintManager.printReport(jprint, false);
			} catch (JRException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}