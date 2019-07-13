import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;

public abstract class AbstractJasperReports {

	
	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	
	public static void createReport(Map parametros,String path)
	{
	  try {
	       report = (JasperReport) JRLoader.loadObjectFromFile(path);  
	       reportFilled = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
	  }  
	   catch(JRException ex) { 
	      ex.printStackTrace();
	  } 
	 }
	public static void showViewer()
	{
    	   try {
    		   viewer = new JasperViewer(reportFilled,false);
    		   viewer.setVisible(true);
    		   viewer.setDefaultCloseOperation(JasperViewer.HIDE_ON_CLOSE); 
 		   }
		   
	   catch(Exception ex) { 
	      ex.printStackTrace();
	  }
	}
 public static void exportToPDF(String destination)
	{
       try {
    	   JasperExportManager.exportReportToPdfFile(reportFilled,destination);
       }
       catch(JRException ex){
    	   ex.printStackTrace();
       }
	}
}
