import java.awt.Dimension;

import java.awt.Toolkit;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Acceso frame = new Acceso();
		
		 Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

         // Se obtienen las dimensiones en pixels de la ventana.
         Dimension ventana = frame.getSize();

         // Una cuenta para situar la ventana en el centro de la pantalla.
         frame.setLocation((pantalla.width - ventana.width) / 2,
                         (pantalla.height - ventana.height) / 2);
	 
	      frame.setLocationRelativeTo(null);		
	      frame.setVisible(true);
		
		}

}
