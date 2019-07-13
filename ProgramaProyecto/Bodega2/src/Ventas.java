import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Ventas extends JInternalFrame {
	public static JTable table;
	private static JTextField textField;
	private static JTable table_1;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	ListSelectionModel listSelectionModel;
	public static DefaultTableModel modelo;
	private static String [][] Producto;
	
	int filas=0;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
					
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
	public Ventas() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		
		setTitle("REGISTRO DE VENTAS");
		setBounds(100, 100, 931, 668);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 261, 897, 246);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 897, 246);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setRowSelectionAllowed(false);
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"CodProducto", "TipoProducto", "MarcaProducto", "Descripci\u00F3n", "Presentaci\u00F3n", "Precio", "Cantidad", "SubTotal"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 95, 897, 153);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				modelo =(DefaultTableModel) table.getModel();
				modelo.removeRow(table.getSelectedRow());
			}
		});
		scrollPane.setBounds(0, 52, 897, 101);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char car=(char) e.getKeyCode();
				if (car==e.VK_ENTER) {
					float numf;
	        		Locale spanish = new Locale("es", "ES");
	        		NumberFormat nf= NumberFormat.getInstance(spanish);
	        		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
					 int filaseleccionada;

				     try{
				     
				         filaseleccionada= table.getSelectedRow();
				         
				         if (filaseleccionada==-1){
				         
				             JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

				         }else{

				             DefaultTableModel modelotabla2=(DefaultTableModel) table.getModel();
				             DefaultTableModel modelo2 = (DefaultTableModel) table_1.getModel();
				             Object[] fila = new Object[8];
								
						        fila[0]=(String) modelotabla2.getValueAt(filaseleccionada, 0);//Codigo
						        fila[1]=(String) modelotabla2.getValueAt(filaseleccionada, 1);//Tipo
						        fila[2]=(String) modelotabla2.getValueAt(filaseleccionada, 2);//Marca
						        fila[3]=(String) modelotabla2.getValueAt(filaseleccionada, 3);//Descripción
						        fila[4]=(String) modelotabla2.getValueAt(filaseleccionada, 4);//Presentación
						        fila[5]=(String) modelotabla2.getValueAt(filaseleccionada, 5);//PrecioUnitario
						        String cantidad = JOptionPane.showInputDialog("Cantidad");//Cantidad
						        
						        fila[6]= cantidad; //Cantidad
						        String stockst = modelotabla2.getValueAt(filaseleccionada, 6).toString(); //Obtiene el Stock en String
						        int stock1 = Integer.parseInt(stockst); //convierte el Stock en Numero
						        int cantidadx =Integer.parseInt(cantidad); //Convierte la cantidad en numero
						        int stock =  stock1 - cantidadx; //Dsecuenta la cantidad adquirida del Stock
						        table.setValueAt(stock, filaseleccionada, 6); //Registra el nuevo stock
						        //double cantidad2 = Integer.parseInt(cantidad); //
						        
						        double preciounitario = Float.parseFloat((String)modelotabla2.getValueAt(filaseleccionada, 5));
						        
						        double SubTotal =  cantidadx * preciounitario ;//determina el SubTotal de la compra : el precio del producto por la cantidad comprada
						        simbolos.setDecimalSeparator('.');
						        DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
						        fila[7]=formateador.format(SubTotal); //SubTotal transformado en decimal español
					              
					            modelo2.addRow(fila); //adiciona la fila con las 7 columnas
					            double Total;
					            
					            if (textField_4.getText().isEmpty()) {
					            	
						        	String valorFormateado = formateador.format(SubTotal);
					            	Total =	Double.parseDouble(valorFormateado);
					            }else {
					                Double TotalAnt= Double.parseDouble(textField_4.getText());
					            	Total =	TotalAnt + SubTotal;
					            }
					            
					            
					            
					            String valorFormateado2 = formateador.format(Total / 1.18); //Determina el SubTotal
					            
					            Double SubTotal2 = Double.parseDouble(valorFormateado2); //formatea el SubTotal
					            
					             String valorFormateado3 = formateador.format(Total - SubTotal2); //Formatea el Igv
					            
					            textField_1.setText(String.valueOf(valorFormateado2)); //SubTotal
					            textField_2.setText(String.valueOf(valorFormateado3)); //Igv
					            textField_3.setText(""); //Descuento
					            
					            String valorFormateado4 = formateador.format(Total);
					            //textField_4.setText(String.valueOf(Total));
					            textField_4.setText(String.valueOf(valorFormateado4));
					            CentrarTabla2(table_1);
				          }

				       }catch (HeadlessException ex){
				             JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
				       }
				}
			}
		});
		//table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		//table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
		table.setModel(new DefaultTableModel(CargarProductos(),
			new String[] {
				"CodProducto", "TipoProducto", "MarcaProducto", "DescripcionProducto", "Presentaci\u00F3n", "Precio", "Stock"
			}
		));
		CentrarTabla(table);
		scrollPane.setViewportView(table);
		
		JLabel lblProducto = new JLabel("PRODUCTO :");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProducto.setBounds(10, 23, 83, 14);
		panel.add(lblProducto);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					 DefaultTableModel modelotabla=(DefaultTableModel) table.getModel();
					 String ele = textField.getText();
					 
					    for (int i = 0; i < table.getRowCount(); i++) {
					    	   String valor =((String)modelotabla.getValueAt(i, 1)).trim();
					           //if (table.getValueAt(i, 1).equals(ele)) {     
					    	   //(valor.contains(ele))
					    	   //if (valor.equals(ele)) {
					           if (valor.equals(ele)) {     	   
					        	   table.changeSelection(i, 1, false, false);
					                  break;
					           }
					    }
					 
				 }
			}
		});
		textField.setBounds(89, 11, 425, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("CARGAR PRODUCTOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String classpath = System.getProperty("java.class.path"); 
					String[] classpathEntries = classpath.split(File.pathSeparator);
                    String ruta = System.getProperty("user.dir"); 
					
					
		            //String rutaArchivoExcel = ruta + "\\Productos.xlsx";
		            //FileInputStream file = new FileInputStream(new File("C:\\prueb_excel.xls"));
		            
		            //FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
                    String ruta2 = System.getProperty("user.dir") + "\\archivos\\Productos.xlsx";
		            //FileInputStream inputStream = new FileInputStream(new File("C:\\FRANCO\\Productos.xlsx"));
                    FileInputStream inputStream = new FileInputStream(new File(ruta2));
		            Workbook workbook = new XSSFWorkbook(inputStream);
		            Sheet firstSheet = workbook.getSheetAt(0);
		            Iterator<Row> iterator = firstSheet.iterator();
		            
		            DataFormatter formatter = new DataFormatter();
		            
		            int numcol = table.getColumnCount();
          
		            int Cont =0;
		           
		            while (iterator.hasNext()) {
		                Row nextRow = iterator.next();
		                Iterator<Cell> cellIterator = nextRow.cellIterator();
		                modelo = (DefaultTableModel) table.getModel();
			            //modelo.addRow(new Object[filas]);
		                Object[] fila = new Object[7];
			            Cont++;
			            int Cont1=0;
			            int Cont2=0;
			            if (Cont>1) {
		                   while(cellIterator.hasNext()) {
		                	   Cont1++;
		                        Cell cell = cellIterator.next();
		                        String contenidoCelda = formatter.formatCellValue(cell);
		                        //System.out.println("celda: " + contenidoCelda);
	                              
		                        if (Cont1>1 && Cont1!=7) {
		                           //modelo.setValueAt(contenidoCelda,filas,Cont);
		                        	if (Cont1==8) {
		                        	    //DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
							            //simbolos.setDecimalSeparator('.');
							            //DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
		                        		//String valorFormateado = formato.format(Double.parseDouble(contenidoCelda));
		                        		//String nuevocontenido=valorFormateado.replace(",", ".");
		                        		//fila[Cont2]= nuevocontenido;
		                        		
		                        		float numf;
		                        		Locale spanish = new Locale("es", "ES");
		                        		NumberFormat nf= NumberFormat.getInstance(spanish);
		                        		numf= nf.parse(contenidoCelda).floatValue();
		                        		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
							            simbolos.setDecimalSeparator('.');
							            DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
							            String valorFormateado = formateador.format(numf);
		                        		//fila[Cont2]= numf;
							            fila[Cont2]= valorFormateado;
		                        	}else {
		                        		
		                        		fila[Cont2]=contenidoCelda;   
		                        	}
		                        	Cont2++;
	                            }
		                    }
		                   modelo.addRow(fila);
			              }
		               
			        }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			    CentrarTabla(table);	
     		}
			
		});
		btnNewButton.setBounds(608, 11, 188, 30);
		//panel.add(btnNewButton);
		
		JButton btnCarga = new JButton("Carga");
		btnCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  //Object[] fila = new Object[7];
				  //table = new JTable();
		          //**DefaultTableModel model = (DefaultTableModel) table.getModel();
		          //DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		          //fila[0]="001";
		          //fila[1]="";
		          //fila[2]="";
		          //fila[3]="";
		          //fila[4]="";
		          //fila[5]="";
		          //fila[6]="";
	              
	              //modelo.addRow(fila);	
	              //table.setModel(modelo);
		          
				modelo =(DefaultTableModel) table.getModel();
				modelo.addRow(new Object[filas]);
				for (int x=0;x<table.getColumnCount()-1;x++) {
					modelo.setValueAt("001",filas,0);
					modelo.setValueAt("",filas,1);
					modelo.setValueAt("",filas,2);
					modelo.setValueAt("",filas,3);
					modelo.setValueAt("",filas,4);
					modelo.setValueAt("",filas,5);
					modelo.setValueAt("",filas,6);
				}
				filas++;
			}
		});
		btnCarga.setBounds(806, 0, 91, 23);
		//panel.add(btnCarga);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo =(DefaultTableModel) table.getModel();
				modelo.removeRow(table.getSelectedRow());
				filas--;
			}
		});
		btnQuitar.setBounds(806, 27, 91, 23);
		//panel.add(btnQuitar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel modelotabla=(DefaultTableModel) table.getModel();
				 String ele = textField.getText();
				 
				    for (int i = 0; i < table.getRowCount(); i++) {
				    	   String valor =((String)modelotabla.getValueAt(i, 1)).trim();
				           //if (table.getValueAt(i, 1).equals(ele)) {     
				           if (valor.equals(ele)) {     	   
				        	   table.changeSelection(i, 1, false, false);
				                  break;
				           }
				    }
			}
		});
		btnBuscar.setBounds(524, 13, 70, 37);
		//panel.add(btnBuscar);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(821, 512, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(821, 535, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setBounds(821, 557, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setBounds(805, 588, 102, 31);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SubTotal :");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubtotal.setBounds(749, 515, 62, 14);
		getContentPane().add(lblSubtotal);
		
		JLabel lblIgv = new JLabel("Igv 18% :");
		lblIgv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIgv.setBounds(749, 538, 56, 14);
		getContentPane().add(lblIgv);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescuento.setBounds(742, 560, 69, 14);
		getContentPane().add(lblDescuento);
		
		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(739, 595, 56, 14);
		getContentPane().add(lblTotal);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnSalir.doClick();
					//e.setKeyCode(KeyEvent.VK_SPACE);
				}
			}
		});
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Salir.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(63, 556, 105, 63);
		getContentPane().add(btnSalir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEliminar.doClick();
					//e.setKeyCode(KeyEvent.VK_SPACE);
				}
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Eliminar.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int FilaSeleccionada = table_1.getSelectedRow();
			if (FilaSeleccionada==-1) {
				
				JOptionPane.showMessageDialog(null, "No se seleccionó ningun registro" );
				
			  }else {
				   
				   int a1=Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
					DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
					
					try {
					    	
						modelo.removeRow(table_1.getSelectedRow());    
					    JOptionPane.showMessageDialog(null, "Se elimino correctamente los datos");
					}
					catch(Exception e) {
					     JOptionPane.showMessageDialog(null, e.getMessage());
					}
			  } 
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(219, 557, 117, 63);
		getContentPane().add(btnEliminar);
		
		//AbstractJasperReports.creareReport("C:\\FRANCO\\Bodega\\src\\Boleta.jrxml");
		
		JButton btnImprimit = new JButton("Imprimir");
		btnImprimit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnImprimit.doClick();
					//e.setKeyCode(KeyEvent.VK_SPACE);
				}
			}
		});
		btnImprimit.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Imprimir.png"));
		btnImprimit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ruta = System.getProperty("user.dir") + "\\reportes\\Boleta.jasper";
				
				AbstractJasperReports.createReport(ObtenerParametros(), ruta);
				AbstractJasperReports.showViewer();
				
			}
		});
		btnImprimit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnImprimit.setBounds(366, 557, 121, 63);
		getContentPane().add(btnImprimit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos de Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 2, 897, 94);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k=(int)e.getKeyChar();
				if (k >= 97 && k <= 122 || k>=65 && k<=90){
				e.setKeyChar((char)KeyEvent.VK_CLEAR);
				JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
				}
				if(k==241 || k==209){
				e.setKeyChar((char)KeyEvent.VK_CLEAR);
				JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
				}
				if(k==10){
					textField_5.transferFocus();
				}
			}
			
		});
		textField_5.setBounds(253, 11, 158, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreCliente.setBounds(156, 39, 99, 14);
		panel_2.add(lblNombreCliente);
		
		JLabel lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDniCliente.setBounds(178, 14, 65, 14);
		panel_2.add(lblDniCliente);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//char c = arg0.getKeyChar();
		        //System.out.println(c);
		        //String aux = textField_6.getText();
		        //textField_6.setText("");
		        //if(!aux.isEmpty())
		            //aux=aux.substring(0,aux.length()-1);
		        //aux+=String.valueOf(c).toUpperCase();
		        //textField_6.setText(aux);
		        
		        int pos = textField_6.getCaretPosition();
		        convertiraMayusculasEnJtextfield(textField_6, pos);
			}
		});
		textField_6.setBounds(253, 39, 395, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ruc Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(421, 14, 72, 14);
		panel_2.add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k=(int)e.getKeyChar();
				if (k >= 97 && k <= 122 || k>=65 && k<=90){
				e.setKeyChar((char)KeyEvent.VK_CLEAR);
				JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
				}
				if(k==241 || k==209){
				e.setKeyChar((char)KeyEvent.VK_CLEAR);
				JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
				}
				if(k==10){
					textField_7.transferFocus();
				}
			}
		});
		textField_7.setBounds(490, 11, 158, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(192, 64, 55, 14);
		panel_2.add(lblDireccin);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int pos = textField_6.getCaretPosition();
		        convertiraMayusculasEnJtextfield(textField_8, pos);
			}
		});
		textField_8.setBounds(253, 64, 395, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(799, 11, 88, 83);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\icono-carrito-compras.png"));
		lblNewLabel_1.setBounds(0, 0, 88, 83);
		panel_3.add(lblNewLabel_1);
		
		JButton btnNuevaBoleta = new JButton("Nueva Boleta");
		btnNuevaBoleta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNuevaBoleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel tb = (DefaultTableModel) table_1.getModel();
			        int a = table_1.getRowCount()-1;
			        for (int i = a; i >= 0; i--) {           
			           tb.removeRow(tb.getRowCount()-1);
			           } 
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        textField_4.setText("");
			}
		});
		btnNuevaBoleta.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\Nuevo.png"));
		btnNuevaBoleta.setBounds(534, 557, 152, 62);
		getContentPane().add(btnNuevaBoleta);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//exportarExcel(table);
					ExportaExcell(table);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(10, 518, 91, 23);
		//getContentPane().add(btnGuardar);
		  /////////
	
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] fila = new Object[7];
				//table = new JTable();
		          //**DefaultTableModel model = (DefaultTableModel) table.getModel();
		        modelo = (DefaultTableModel) table.getModel();
		        fila[0]="001";
		        fila[1]="";
		        fila[2]="";
		        fila[3]="";
		        fila[4]="";
		        fila[5]="";
		        fila[6]="";
	              
	            modelo.addRow(fila);	
				
			}
		});
		btnNewButton_1.setBounds(588, 464, 91, 23);
		//getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pasar Valor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float numf;
        		Locale spanish = new Locale("es", "ES");
        		NumberFormat nf= NumberFormat.getInstance(spanish);
        		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
				 int filaseleccionada;
				 
			     try{
			     
			         filaseleccionada= table.getSelectedRow();
			         
			         if (filaseleccionada==-1){
			         
			             JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

			         }else{
			        	 DefaultTableModel modelotabla=(DefaultTableModel) table.getModel();
						 modelo = (DefaultTableModel) table_1.getModel();     
			             
			           
			             Object[] fila = new Object[8];
											        
					        fila[0]=(String)modelotabla.getValueAt(filaseleccionada, 0);
					        fila[1]=(String)modelotabla.getValueAt(filaseleccionada, 1);
					        fila[2]=(String)modelotabla.getValueAt(filaseleccionada, 2);
					        fila[3]=(String)modelotabla.getValueAt(filaseleccionada, 3);
					        fila[4]=(String)modelotabla.getValueAt(filaseleccionada, 4);
					        fila[5]=(String)modelotabla.getValueAt(filaseleccionada, 5);
					        String cantidad = JOptionPane.showInputDialog("Cantidad");
					        
					        fila[6]= cantidad; //Cantidad
					         
					        double cantidad2 = Integer.parseInt(cantidad);
					        
					        double cantidad3 = Float.parseFloat((String)modelotabla.getValueAt(filaseleccionada, 5));
					        double SubTotal =  cantidad2 * cantidad3 ;
					        fila[7]= SubTotal; //SubTotal
				              
				            modelo.addRow(fila);
				            double Total;

				            if (textField_4.getText().isEmpty()) {
				            	
					        	simbolos.setDecimalSeparator('.');
						        DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
						        String valorFormateado = formateador.format(SubTotal);
				            	
				            	Total =	Double.parseDouble(valorFormateado);
				            }else {
				            	Total =	Integer.parseInt(textField_4.getText()) + SubTotal;
				            }
				            //double Total =	Integer.parseInt(textField_4.getText()) + SubTotal;
				            
				            simbolos.setDecimalSeparator('.');
					        DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
				            String valorFormateado2 = formateador.format(Total / 1.18);
				            //double SubTotal2 = formateador.format(Total * 1.18);
				            Double SubTotal2 = Double.parseDouble(valorFormateado2);
				             //double Igv = Total - SubTotal;
				             String valorFormateado3 = formateador.format(Total - SubTotal2);
				            //textField_1.setText(String.valueOf(SubTotal));
				            textField_1.setText(String.valueOf(valorFormateado2));
				            textField_2.setText(String.valueOf(valorFormateado3));
				            textField_3.setText("");
				            
				            String valorFormateado4 = formateador.format(Total);
				            //textField_4.setText(String.valueOf(Total));
				            textField_4.setText(String.valueOf(valorFormateado4));
				            CentrarTabla2(table_1);
			          }

			       }catch (HeadlessException ex){
			             JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
			       }     
			}
		});
		btnNewButton_2.setBounds(588, 505, 91, 23);
		//getContentPane().add(btnNewButton_2);

	}
	public static void CentrarTabla(JTable tabla) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
		tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
		
	}
	public static void CentrarTabla2(JTable tabla) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
		tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
		tabla.getColumnModel().getColumn(7).setCellRenderer(tcr);
		
	}
	@SuppressWarnings("null")
	public static Object[][] CargarProductos() {
       //Objeto de conexión a Base datos
	   //Objeto de Recordset de acceso a Tablas
		Object[][] modelo2= new Object[23][7];
		
		//String ruta = abrirArchivo();
		
		
		
		try {
			Object[][] defaultListModel = new Object[23][7]; 
			//String classpath = System.getProperty("java.class.path"); 
			//String[] classpathEntries = classpath.split(File.pathSeparator);
            //String ruta = System.getProperty("user.dir"); 
            String ruta2 = System.getProperty("user.dir") + "\\archivos\\Productos.xlsx";
			//JFileChooser jf=new JFileChooser();
			//jf.showOpenDialog(null);
			//File archivo = jf.getSelectedFile();
			//if (archivo != null){
			   // ruta.setText(archivo.get)
			//}
			//String ruta = abrirArchivo();
            FileInputStream inputStream = new FileInputStream(ruta2);
            
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            DataFormatter formatter = new DataFormatter();
            
          
            int Cont =0;
            int FilaProducto=0;
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                //modelo = (DefaultTableModel) table.getModel();
	            //modelo.addRow(new Object[filas]);
                Object[] fila = new Object[7];
	            Cont++;
	            int Cont1=0;
	            int Cont2=0;
	            
	            if (Cont>1) {
                   while(cellIterator.hasNext()) {
                	   Cont1++;
                        Cell cell = cellIterator.next();
                        String contenidoCelda = formatter.formatCellValue(cell);
                       
                          
                        if (Cont1>1 && Cont1!=7) {
                           
                        	if (Cont1==8) {
                        	                            		
                        		float numf;
                        		Locale spanish = new Locale("es", "ES");
                        		NumberFormat nf= NumberFormat.getInstance(spanish);
                        		numf= nf.parse(contenidoCelda).floatValue();
                        		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
					            simbolos.setDecimalSeparator('.');
					            DecimalFormat formateador = new DecimalFormat("####.00",simbolos);
					            String valorFormateado = formateador.format(numf);
                        		//fila[Cont2]= numf;
					            //fila[Cont2]= valorFormateado;
					            defaultListModel[FilaProducto][Cont2]= valorFormateado;
                        	}else {
                        		
                        		//fila[Cont2]=contenidoCelda;
                        		defaultListModel[FilaProducto][Cont2]= contenidoCelda;
                        	}
                        	
                        	Cont2++;
                        }
                    }
                   //modelo.addRow(fila);
                   //defaultListModel[FilaProducto][Cont2]= fila;
                   FilaProducto++;
	              }
               
	        }
            //defaultListModel = Productos;
            
            return defaultListModel;
        } catch (Exception e) {
            e.printStackTrace();
            return modelo2;
        }
	   
	}
	public static Map<String, Object> ObtenerParametros() {
	    Map<String, Object> parametros= new HashMap();
		parametros.put("NombreCliente",textField_6.getText());
		parametros.put("Direccion",textField_8.getText());
		parametros.put("Ruc",textField_7.getText());
		
		   DefaultTableModel modelotabla=(DefaultTableModel) table_1.getModel();
           int NumCol = table_1.getRowCount();
           String Item;
           for (int i=1;i<=10;i++) {
           //Object[] fila = new Object[8];
        	if (i<=NumCol) {   
			Item = "0" + (String)modelotabla.getValueAt(i-1, 6) + " - " +(String)modelotabla.getValueAt(i-1, 3) + "-" + (String)modelotabla.getValueAt(i-1, 2) + "-" + (String)modelotabla.getValueAt(i-1, 4);  
			
		    parametros.put("Item" + String.valueOf(i),String.valueOf(i));
		    parametros.put("Desc" + String.valueOf(i),Item);
		    parametros.put("PU"+ String.valueOf(i),(String)modelotabla.getValueAt(i-1, 5));
		    parametros.put("ST" + String.valueOf(i),(String)modelotabla.getValueAt(i-1, 7));
		    
        	}else {
        		parametros.put("Item" + String.valueOf(i),"");
    		    parametros.put("Desc" + String.valueOf(i),"");
    		    parametros.put("PU"+ String.valueOf(i),"");
    		    parametros.put("ST" + String.valueOf(i),"");
        	}
           }
		parametros.put("SubTotal", textField_1.getText());
		parametros.put("Igv",textField_2.getText());
		parametros.put("Descuento",textField_3.getText());
		parametros.put("Total",textField_4.getText());
		return parametros;
	}
	public void convertiraMayusculasEnJtextfield(javax.swing.JTextField jTextfieldS, int pos) {
		String cadena = (jTextfieldS.getText()).toUpperCase();
		jTextfieldS.setText(cadena);
		jTextfieldS.setCaretPosition(pos);
		}
	public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileFilter(new FileNameExtensionFilter("Libro de Excel (.xlsx)", "xlsx")); 
        chooser.setAcceptAllFileFilterUsed(false);
        
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xlsx");
        //chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
       
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        	
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx");
            try {
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
                archivoXLSX.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLSX);
                
                Date ahora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
                                
                Sheet hoja = libro.createSheet("Productos_" + formateador.format(ahora) );
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLSX);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
	public static void ExportaExcell(JTable jTable1) throws FileNotFoundException, IOException {
       
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileFilter(new FileNameExtensionFilter("Libro de Excel (.xlsx)", "xlsx")); 
        chooser.setAcceptAllFileFilterUsed(false);
        
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xlsx");
        //chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
       
        chooser.setAcceptAllFileFilterUsed(false);
        String ruta = null;
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        	
            ruta = chooser.getSelectedFile().toString().concat(".xlsx");
            
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
        }    
        HSSFWorkbook fWorkbook = new HSSFWorkbook();
        HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
        HSSFFont sheetTitleFont = fWorkbook.createFont();
        HSSFCellStyle cellStyle = fWorkbook.createCellStyle();
        sheetTitleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //sheetTitleFont.setColor();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        //Get Header
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)table.getColumnModel();
        HSSFRow hRow = fSheet.createRow((short) 0);
        for(int j = 0; j < tcm.getColumnCount(); j++) {                       
           HSSFCell cell = hRow.createCell((short) j);
           cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
           cell.setCellStyle(cellStyle);
        }

        //Get Other details
        for (int i = 0; i < model.getRowCount(); i++) {
            HSSFRow fRow = fSheet.createRow((short) i+1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                HSSFCell cell = fRow.createCell((short) j);
                cell.setCellValue(model.getValueAt(i, j).toString());
                cell.setCellStyle(cellStyle);
            }
        }
        FileOutputStream fileOutputStream;
    
       fileOutputStream = new FileOutputStream(ruta);
        try (BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
            fWorkbook.write(bos);
         }
            fileOutputStream.close();
        }
}