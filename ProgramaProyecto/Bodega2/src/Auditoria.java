import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Auditoria extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auditoria frame = new Auditoria();
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
	public Auditoria() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 628, 466);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAuditoras = new JLabel("AUDITOR\u00CDAS");
		lblAuditoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuditoras.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuditoras.setBounds(138, 11, 315, 14);
		panel.add(lblAuditoras);

	}

}
