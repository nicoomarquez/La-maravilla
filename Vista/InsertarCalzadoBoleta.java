package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Controlador.SARA;
import Negocio.Arreglo;
import Negocio.Boleta;
import Negocio.Calzado;
import Negocio.Cliente;
import Negocio.Empleado;
import Persistencia.AdmPersistenciaBoleta;
import Persistencia.AdmPersistenciaCalzado;
import Persistencia.AdmPersistenciaCliente;
import Persistencia.AdmPersistenciaEmpleado;
import View.Calzado_View;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.table.DefaultTableModel;

public class InsertarCalzadoBoleta extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private JTextField codigoCalzado;
	private static JTextField importe;
	private static InsertarCalzadoBoleta instancia;
	private ButtonGroup botones = new ButtonGroup();
	private static Vector<Arreglo> arreglos;
	private static JList<String> list;
	Vector<Empleado> e;
	private String categoria;
	private static DefaultListModel<String> model;
	
	// Se crea el vector en donde se guardar�n los calzados agregados
	private Vector<Calzado_View> calzados = new Vector<Calzado_View>();
	private JTextField nombreCliente;
	
	public static InsertarCalzadoBoleta getInstancia() {
		if(instancia == null)
			instancia = new InsertarCalzadoBoleta();
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarCalzadoBoleta frame = new InsertarCalzadoBoleta();
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
	public InsertarCalzadoBoleta() {
		setTitle("Ingreso de Calzado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 135, 462, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblZapateraLaMaravilla = new JLabel("Zapater\u00EDa La Maravilla ");
		lblZapateraLaMaravilla.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblZapateraLaMaravilla.setBounds(162, 11, 215, 33);
		contentPane.add(lblZapateraLaMaravilla);
		
		JLabel lblComposturaDeCalzados = new JLabel("Compostura de Calzados");
		lblComposturaDeCalzados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComposturaDeCalzados.setBounds(153, 38, 213, 28);
		contentPane.add(lblComposturaDeCalzados);
		
		JLabel lblLavalle = new JLabel("Lavalle 587 - Quilmes");
		lblLavalle.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblLavalle.setBounds(173, 68, 177, 28);
		contentPane.add(lblLavalle);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(10, 110, 55, 14);
		contentPane.add(lblCliente);
		
		dni = new JTextField();
		dni.setBounds(74, 107, 161, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente.getInstancia().setLocationRelativeTo(null);
				CrearCliente.getInstancia().setVisible(true);
			}
		});
		btnNuevoCliente.setBounds(329, 107, 122, 23);
		contentPane.add(btnNuevoCliente);
		
		JLabel lblArreglos = new JLabel("Arreglo/s:");
		lblArreglos.setBounds(5, 88, 55, 14);
		panel.add(lblArreglos);
		
		//Le pido al controlador que me de los arreglos
		arreglos=SARA.getInstancia().getArreglos();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(5, 186, 436, 1);
		panel.add(separator_1);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(5, 208, 68, 14);
		panel.add(lblEmpleado);
		
		JComboBox<String> empleados = new JComboBox<String>();
		empleados.setBounds(105, 205, 124, 20);
		panel.add(empleados);
		
		// Agrego los empleados al comboBox
		e = SARA.getInstancia().getEmpleados();
		for(int i = 0; i < e.size(); i++) {
			empleados.addItem(e.elementAt(i).getIdEmpleado() + " - " + e.elementAt(i).getNombre()+" "+e.elementAt(i).getApellido());
		}
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(5, 255, 68, 14);
		panel.add(lblCategora);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setBounds(300, 295, 68, 14);
		panel.add(lblCdigo);
		
		codigoCalzado = new JTextField();
		codigoCalzado.setEditable(false);
		codigoCalzado.setBounds(360, 292, 92, 20);
		panel.add(codigoCalzado);
		codigoCalzado.setColumns(10);
		
		
		JLabel lblImporte = new JLabel("IMPORTE:");
		lblImporte.setBounds(5, 295, 68, 14);
		panel.add(lblImporte);
		
		importe = new JTextField();
		importe.setText("00.0");
		//importe.setText(sumarArreglos());
		importe.setBounds(87, 292, 86, 20);
		panel.add(importe);
		importe.setColumns(10);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(77, 295, 20, 14);
		panel.add(label_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Primero verificamos que el dni ingresado solo tenga numeros
				if(!dni.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "El DNI debe contener solo n�meros");
				}
				//Luego verificamos si el dni ya se encuentra registrado
				else if(!SARA.getInstancia().dniRepetido(dni.getText())) {
					JOptionPane.showMessageDialog(null, "El DNI ingresado no se encuentra registrado");
				}
				//Obtengo el cliente con el dni ingresado
				else {
						panel.setVisible(true);
						
						// Inserto nombre del cliente
						Cliente cliente = AdmPersistenciaCliente.getInstancia().buscarCliente(dni.getText());
						nombreCliente.setText(cliente.getNombre() + " " +cliente.getApellido());
				}
				
			}
		});
		btnBuscar.setBounds(237, 107, 89, 23);
		contentPane.add(btnBuscar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(9, 280, 443, 2);
		panel.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 7, 415, 1);
		panel.add(separator);
		
		
		
		JRadioButton rdbtnBota = new JRadioButton("Bota");
		//Acci�n que se realiza cuando se selecciona el bot�n
		rdbtnBota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Retomo en el �ltimo autonum�rico
				int codCalzado = AdmPersistenciaCalzado.getInstancia().getidMaximo("B");
				
				// getidMaximo me devuelve la parte num�rica (por ej. 000, 001)
				int codCalzadoNuevo = codCalzado + 1;
				
				// Agrego la letra de la categor�a
				codigoCalzado.setText("B" + Integer.toString(codCalzadoNuevo));
			}
		});
		botones.add(rdbtnBota);
		rdbtnBota.setBounds(80, 251, 74, 23);
		panel.add(rdbtnBota);
		
		JRadioButton rdbtnZapatilla = new JRadioButton("Zapatilla");
		//Acci�n que se realiza cuando se selecciona el bot�n
		rdbtnZapatilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				// Retomo en el �ltimo autonum�rico
				int codCalzado = AdmPersistenciaCalzado.getInstancia().getidMaximo("Z");
				
				// getidMaximo me devuelve la parte num�rica (por ej. 000, 001)
				int codCalzadoNuevo = codCalzado + 1;
				
				// Agrego la letra de la categor�a
				codigoCalzado.setText("Z" + Integer.toString(codCalzadoNuevo));
			}
		});
		botones.add(rdbtnZapatilla);
		rdbtnZapatilla.setBounds(156, 251, 74, 23);
		panel.add(rdbtnZapatilla);
		
		JRadioButton rdbtnZapatoHombre = new JRadioButton("Zapato Hombre");
		rdbtnZapatoHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Retomo en el �ltimo autonum�rico
				int codCalzado = AdmPersistenciaCalzado.getInstancia().getidMaximo("ZH");
				
				// getidMaximo me devuelve la parte num�rica (por ej. 000, 001)
				int codCalzadoNuevo = codCalzado + 1;
				
				// Agrego la letra de la categor�a
				codigoCalzado.setText("ZH" + Integer.toString(codCalzadoNuevo));
			}
		});
		botones.add(rdbtnZapatoHombre);
		rdbtnZapatoHombre.setBounds(238, 251, 115, 23);
		panel.add(rdbtnZapatoHombre);
		
		JRadioButton rdbtnZapatoMujer = new JRadioButton("Zapato Mujer");
		rdbtnZapatoMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Retomo en el �ltimo autonum�rico
				int codCalzado = AdmPersistenciaCalzado.getInstancia().getidMaximo("ZM");
				
				// getidMaximo me devuelve la parte num�rica (por ej. 000, 001)
				int codCalzadoNuevo = codCalzado + 1;
				
				// Agrego la letra de la categor�a
				codigoCalzado.setText("ZM" + Integer.toString(codCalzadoNuevo));
			}
		});
		botones.add(rdbtnZapatoMujer);
		rdbtnZapatoMujer.setBounds(353, 251, 109, 23);
		panel.add(rdbtnZapatoMujer);
		
		 list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(38, 62, 382, 38);
		list.setEnabled(false);
		panel.add(list);
		
		JButton btnSeleccionarArreglos = new JButton("Seleccionar arreglos");
		btnSeleccionarArreglos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JListEjemplo j=new JListEjemplo();
				j.setVisible(true);
				j.setLocationRelativeTo(null);
			}
		});
		btnSeleccionarArreglos.setBounds(68, 84, 221, 23);
		panel.add(btnSeleccionarArreglos);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(39, 123, 383, 40);
		panel.add(scrollPane);
		
		JLabel lblBoletaPara = new JLabel("Boleta para:");
		lblBoletaPara.setBounds(5, 22, 92, 14);
		panel.add(lblBoletaPara);
		
		nombreCliente = new JTextField();
		nombreCliente.setEditable(false);
		nombreCliente.setBounds(105, 19, 216, 20);
		panel.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(30, 479, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnAgregarOtroCalzado = new JButton("Agregar otro calzado");
		btnAgregarOtroCalzado.setBounds(152, 479, 169, 23);
		contentPane.add(btnAgregarOtroCalzado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(362, 479, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				
				// Obtengo el ID del empleado seleccionado
				Empleado emp = e.get(empleados.getSelectedIndex());
				
				// Creo un calzadoView porque todav�a no se inserta en la bd
				Calzado_View calzado = new Calzado_View(codigoCalzado.getText(), "",importe.getText(), 'P', emp.getIdEmpleado(), arreglos);
				
				// Agrego el calzado actual
				calzados.add(calzado);
				
				ResumenBoleta rb = new ResumenBoleta(calzados, dni.getText());
				dispose();
				rb.setVisible(true);
			}

			
		});
		btnAgregarOtroCalzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*if(!rdbtnZapatilla.isSelected() || !rdbtnZapatoMujer.isSelected() || !rdbtnZapatoHombre.isSelected() || !rdbtnBota.isSelected()) {
					JOptionPane.showMessageDialog(null, "Seleccione una categoria para continuar");
				}*/
				// Obtengo el ID del empleado seleccionado
				
				// Lo busco en la base de datos
				Empleado emp = e.get(empleados.getSelectedIndex());
				
				// Creo un calzadoView porque todav�a no se inserta en la bd
				Calzado_View calzado = new Calzado_View(codigoCalzado.getText(), "",importe.getText(), 'P', emp.getIdEmpleado(), arreglos);
				
				// Agrego el calzado actual al vector de Calzados_View
				calzados.add(calzado);
				
				// Se limpia la pantalla para agregar otro calzado
				limpiarPantalla();
			}

			
		});
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		
	}
	
	private static float sumarArreglos(){
		float total=0;
		
		for(Arreglo r:arreglos)
			total+=r.getCostoArreglo();
		
		return total;
	}

	public static void setArreglos(Vector<Arreglo> arreglosSeleccionados) {
		// TODO Auto-generated method stub
		arreglos=arreglosSeleccionados;
		float total=sumarArreglos();
		
		importe.setText(String.valueOf(total));
		
		
		model = new DefaultListModel<String>();
		Arreglo r;
		String resumen = arreglos.elementAt(0).getNombre();
		for(int i= 1;i< arreglos.size();i++) {
			r=arreglos.elementAt(i);
			
			resumen=resumen+", "+r.getNombre();
		}
		model.addElement(resumen);
		list.setModel(model);
	}
	
	private void limpiarPantalla() {
		importe.setText("");
		codigoCalzado.setText("");
		
	}
}
