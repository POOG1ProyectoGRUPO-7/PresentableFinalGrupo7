import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   try {
		       JasperReport reporte=(JasperReport)JRLoader.getClassLoaderResources("Jasper.jasper");
		       HashMap parametros = new HashMap();
		       parametros.put("","");
		     
		       JasperPrint jasperPrint= JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());

		       JasperViewer view= new JasperViewer(jasperPrint);
		       //view.SetTitle("Ejemplo Jasper Report");
		       view.setVisible(true);

		   }
		   catch(Exception e){
		     

		   }
	}

}
