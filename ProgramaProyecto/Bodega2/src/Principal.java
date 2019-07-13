import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public Principal() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("SISTEMA DE CONTROL DE VENTAS (Versi\u00F3n 1.0 Julio 2019)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 458);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnInicio.add(mntmSalir);
		
		JMenu mnVentas = new JMenu("Ventas");
		if (Variables.nivel ==3) {
		   mnVentas.enable(false);
		   }
		menuBar.add(mnVentas);
		JMenuItem mntmRegistroDeVentas = new JMenuItem("Registro de Ventas");
		mntmRegistroDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas ventas = new Ventas();
				centrarventana(ventas);
				ventas.setVisible(true);
				desktopPane.add(ventas);
			
			}
		});
		mnVentas.add(mntmRegistroDeVentas);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistroClientes = new JMenuItem("Registro Clientes");
		mntmRegistroClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				centrarventana(clientes);
				clientes.setVisible(true);
				desktopPane.add(clientes);
			}
		});
		mnClientes.add(mntmRegistroClientes);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenuItem mntmRegistroProductos = new JMenuItem("Registro Productos");
		mntmRegistroProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos productos = new Productos();
				centrarventana(productos);
				productos.setVisible(true);
				desktopPane.add(productos);
			}
		});
		mnProductos.add(mntmRegistroProductos);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		menuBar.add(mnProveedores);
		
		JMenuItem mntmRegistroProveedores = new JMenuItem("Registro Proveedores");
		mntmRegistroProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedores proveedores = new Proveedores();
				centrarventana(proveedores);
				proveedores.setVisible(true);
				desktopPane.add(proveedores);
			}
		});
		mnProveedores.add(mntmRegistroProveedores);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmRegistroEmpleados = new JMenuItem("Registro Empleados");
		mntmRegistroEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados empleados = new Empleados();
				centrarventana(empleados);
				empleados.setVisible(true);
				desktopPane.add(empleados);
			}
		});
		mnEmpleados.add(mntmRegistroEmpleados);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				centrarventana(usuarios);
				usuarios.setVisible(true);
				desktopPane.add(usuarios);
			}
		});
		mnMantenimiento.add(mntmUsuarios);
		
		JMenuItem mntmAuditoria = new JMenuItem("Auditoria");
		mntmAuditoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auditoria auditoria = new Auditoria();
				centrarventana(auditoria);
				auditoria.setVisible(true);
				desktopPane.add(auditoria);
			}
		});
		mnMantenimiento.add(mntmAuditoria);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de..");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Acercade JIAcerca = new Acercade();
				centrarventana(JIAcerca);
				JIAcerca.setVisible(true);
				desktopPane.add(JIAcerca);
				
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		JMenuItem mntmManualUsuario = new JMenuItem("Manual Usuario");
		mnAyuda.add(mntmManualUsuario);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
	}
	public void centrarventana(JInternalFrame frame) {
		
		  Dimension desktopSize = desktopPane.getSize();
	      Dimension FrameSize = frame.getSize();
	      frame.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
	      frame.setVisible(true);
	      JDesktopPane escritorio = new JDesktopPane();
	      this.getContentPane().add(escritorio);
	      escritorio.add(frame);
	      
		
		
	}
}
