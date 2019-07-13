import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Acercade extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acercade frame = new Acercade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acercade() {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblSistemaDeControl = new JLabel("SISTEMA DE CONTROL DE VENTAS");
		lblSistemaDeControl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSistemaDeControl.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeControl.setBounds(56, 11, 307, 14);
		getContentPane().add(lblSistemaDeControl);
		
		JTextArea txtrProgramaCreadoEn = new JTextArea();
		txtrProgramaCreadoEn.setText("Programa creado en Julio2019.\r\nVersi\u00F3n 1.0.\r\nDesarrollado por:\r\nFranco Rivadeneyra Reyes\r\nAmigos XXX\r\n\r\nUNIVERSIDAD NACIONAL MAYOR DE SAN MARCOS\r\nESCUELA DE INGENIER\u00CDA EN TELECOMUNICACIONES\r\nDerechos Reservados (c) - 2019");
		txtrProgramaCreadoEn.setBounds(12, 50, 412, 170);
		getContentPane().add(txtrProgramaCreadoEn);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(325, 228, 99, 23);
		getContentPane().add(btnAceptar);

	}
}
