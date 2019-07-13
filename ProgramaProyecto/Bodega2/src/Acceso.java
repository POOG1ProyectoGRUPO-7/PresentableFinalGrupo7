import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Acceso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Acceso frame = new Acceso();
					 Dimension desktopsize =  Toolkit.getDefaultToolkit().getScreenSize();
				     Dimension FrameSize = frame.getSize();
				     frame.setLocation((desktopsize.width - FrameSize.width)/2, (desktopsize.height- FrameSize.height)/2);	
				 
				     frame.setLocationRelativeTo(null);		
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
	public Acceso() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(63, 59, 429, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO :");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(83, 47, 69, 14);
		panel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("CLAVE :");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClave.setBounds(99, 89, 50, 14);
		panel.add(lblClave);
		
		JButton btnSalir = new JButton("ACEPTAR");
		btnSalir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnSalir.doClick();
					//e.setKeyCode(KeyEvent.VK_SPACE);
				}
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				String usuario;
				String clave;
				usuario=textField.getText();
				clave=passwordField.getText();
				int accesoflag=0;
				if (usuario.equals("Administrador")&&clave.equals("Administrador")) {
					
					Variables.nivel=1;
					accesoflag=1;
					//JOptionPane.showMessageDialog(null, "Bienvenido al Sistema...");
				    //Principal principal = new Principal();
				    //principal.setExtendedState(MAXIMIZED_BOTH);
				    //principal.setVisible(true);
				    AbrirPrincipal();
				    dispose();
				}
				if (usuario.equals("Supervisor")&&clave.equals("Supervisor")) {
					
					//Variables.nivel="2";
					Variables.nivel=2;
					accesoflag=1;
					//JOptionPane.showMessageDialog(null, "Bienvenido al Sistema...");
					//Principal principal = new Principal();
					//principal.setExtendedState(MAXIMIZED_BOTH);
					//principal.setVisible(true);
					AbrirPrincipal();
					dispose();
					}
				if (usuario.equals("Consulta")&&clave.equals("Consulta")) {
					Variables.nivel=3;
					accesoflag=1;
					//JOptionPane.showMessageDialog(null, "Bienvenido al Sistema...");
					//Principal principal = new Principal();
					//principal.setExtendedState(MAXIMIZED_BOTH);
					//principal.setVisible(true);
					AbrirPrincipal();
			
					dispose();
					}
				if (accesoflag==0) {
					JOptionPane.showMessageDialog(null, "Verifique el Usuario y la Clave..");
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();    	
			}
			
			}
		});
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Aceptar.png"));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(61, 142, 145, 45);
		panel.add(btnSalir);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnCancelar.doClick();
					//e.setKeyCode(KeyEvent.VK_SPACE);
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Cancelar.png"));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(270, 144, 149, 43);
		panel.add(btnCancelar);
	
		textField = new JTextField();
		
		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(162, 42, 202, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnSalir.requestFocus();
				}
			}
		});
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(161, 87, 205, 20);
		panel.add(passwordField);
		
		JLabel lblBienvenidosAlSistema = new JLabel("BIENVENIDOS AL SISTEMA DE REGISTRO DE VENTAS");
		lblBienvenidosAlSistema.setForeground(new Color(128, 0, 0));
		lblBienvenidosAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidosAlSistema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBienvenidosAlSistema.setBounds(51, 22, 450, 14);
		contentPane.add(lblBienvenidosAlSistema);
	}
	public void AbrirPrincipal() {
		JOptionPane.showMessageDialog(null, "Bienvenido al Sistema...");
		Principal principal = new Principal();
		principal.setExtendedState(MAXIMIZED_BOTH);
		principal.setVisible(true);
	}
}
