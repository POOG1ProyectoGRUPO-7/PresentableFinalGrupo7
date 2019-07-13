import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Clientes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 667, 471);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRegistroDeClientes = new JLabel("REGISTRO DE CLIENTES");
		lblRegistroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeClientes.setBounds(163, 11, 302, 14);
		panel.add(lblRegistroDeClientes);

	}

}
