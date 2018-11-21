package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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
import Negocio.Cliente;

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
	private JTextField observaciones;
	private JTextField codigoCalzado;
	private JTextField total;
	private static InsertarCalzadoBoleta instancia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	
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
		panel.setBounds(10, 135, 462, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblZapateraLaMaravilla = new JLabel("Zapater\u00EDa La Maravilla ");
		lblZapateraLaMaravilla.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblZapateraLaMaravilla.setBounds(111, 11, 215, 33);
		contentPane.add(lblZapateraLaMaravilla);
		
		JLabel lblComposturaDeCalzados = new JLabel("Compostura de Calzados");
		lblComposturaDeCalzados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComposturaDeCalzados.setBounds(111, 40, 213, 28);
		contentPane.add(lblComposturaDeCalzados);
		
		JLabel lblLavalle = new JLabel("Lavalle 587 - Quilmes");
		lblLavalle.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblLavalle.setBounds(121, 68, 177, 28);
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
		lblArreglos.setBounds(5, 19, 55, 14);
		panel.add(lblArreglos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(5, 186, 436, 1);
		panel.add(separator_1);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(5, 126, 92, 14);
		panel.add(lblObservaciones);
		
		observaciones = new JTextField();
		observaciones.setBounds(105, 126, 263, 49);
		panel.add(observaciones);
		observaciones.setColumns(10);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(5, 208, 68, 14);
		panel.add(lblEmpleado);
		
		JComboBox empleados = new JComboBox();
		empleados.setModel(new DefaultComboBoxModel(new String[] {"Manuel Gomez"}));
		empleados.setBounds(105, 205, 124, 20);
		panel.add(empleados);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(5, 255, 68, 14);
		panel.add(lblCategora);
		
		JCheckBox chckbxBota = new JCheckBox("Bota");
		chckbxBota.setBounds(87, 251, 55, 23);
		panel.add(chckbxBota);
		
		JCheckBox chckbxZapatilla = new JCheckBox("Zapatilla");
		chckbxZapatilla.setBounds(141, 251, 73, 23);
		panel.add(chckbxZapatilla);
		
		JCheckBox chckbxZapatoHombre = new JCheckBox("Zapato hombre");
		chckbxZapatoHombre.setBounds(216, 251, 108, 23);
		panel.add(chckbxZapatoHombre);
		
		JCheckBox chckbxZapatloMujer = new JCheckBox("Zapato mujer");
		chckbxZapatloMujer.setBounds(326, 251, 126, 23);
		panel.add(chckbxZapatloMujer);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setBounds(223, 295, 68, 14);
		panel.add(lblCdigo);
		
		codigoCalzado = new JTextField();
		codigoCalzado.setEditable(false);
		codigoCalzado.setText("ZM-00001");
		codigoCalzado.setBounds(301, 292, 92, 20);
		panel.add(codigoCalzado);
		codigoCalzado.setColumns(10);
		
		JLabel lblImporte = new JLabel("IMPORTE:");
		lblImporte.setBounds(5, 295, 68, 14);
		panel.add(lblImporte);
		
		total = new JTextField();
		total.setText("270,00");
		total.setBounds(87, 292, 86, 20);
		panel.add(total);
		total.setColumns(10);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(77, 295, 20, 14);
		panel.add(label_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(316, 341, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(38, 341, 89, 23);
		panel.add(btnAtrs);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Primero verificamos que el dni ingresado solo tenga numeros
				if(!dni.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "El DNI debe contener solo números");
				}
				//Luego verificamos si el dni ya se encuentra registrado
				else if(!SARA.getInstancia().dniRepetido(dni.getText())) {
					JOptionPane.showMessageDialog(null, "El DNI ingresado no se encuentra registrado");
				}
				//Obtengo el cliente con el dni ingresado
				else if(SARA.getInstancia().dniRepetido(dni.getText())){
					panel.setVisible(true);
					//Cliente cliente = SARA.getInstancia().buscarCliente(dni.getText());
//					if(botonNo.isSelected()) {
//						lblNewLabel.setEnabled(false);
//						chckbxLunes.setEnabled(false);
//						chckbxMartes.setEnabled(false);
//						chckbxMircoles.setEnabled(false);
//						chckbxJueves.setEnabled(false);
//						chckbxViernes.setEnabled(false);
//						lblHorario.setEnabled(false);
//						horario1.setEnabled(false);
//						horario2.setEnabled(false);
//					}
				}
				
			}
		});
		btnBuscar.setBounds(237, 107, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregarOtroCalzado = new JButton("Guardar calzado");
		btnAgregarOtroCalzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarOtroCalzado.setBounds(156, 341, 135, 23);
		panel.add(btnAgregarOtroCalzado);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(9, 280, 443, 2);
		panel.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 7, 415, 1);
		panel.add(separator);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(65, 19, 387, 49);
		panel.add(table);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(178, 90, 89, 23);
		panel.add(btnQuitar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(282, 90, 89, 23);
		panel.add(btnAgregar);
	}
}
