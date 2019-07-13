import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Proveedores extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores frame = new Proveedores();
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
	public Proveedores() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 680, 442);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRegistroDeProveedores = new JLabel("REGISTRO DE PROVEEDORES");
		lblRegistroDeProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeProveedores.setBounds(199, 11, 285, 14);
		panel.add(lblRegistroDeProveedores);

	}

}
