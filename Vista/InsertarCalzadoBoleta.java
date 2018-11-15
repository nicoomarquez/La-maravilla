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
	private JTextField importe;
	private JTextField seña;
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
		setBounds(100, 100, 498, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 135, 462, 480);
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
		
		JLabel lblEnvoADomicilio = new JLabel("Env\u00EDo a Domicilio:");
		lblEnvoADomicilio.setBounds(14, 16, 111, 14);
		panel.add(lblEnvoADomicilio);
		
		JRadioButton botonSi = new JRadioButton("S\u00ED");
		buttonGroup.add(botonSi);
		botonSi.setBounds(112, 12, 86, 23);
		panel.add(botonSi);
		
		JRadioButton botonNo = new JRadioButton("No");
		buttonGroup.add(botonNo);
		botonNo.setBounds(216, 12, 109, 23);
		panel.add(botonNo);
		
		JLabel lblNewLabel = new JLabel("Disponibilidad:");
		lblNewLabel.setBounds(14, 60, 92, 28);
		panel.add(lblNewLabel);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(105, 63, 60, 23);
		panel.add(chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(212, 63, 68, 23);
		panel.add(chckbxMartes);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(322, 63, 92, 23);
		panel.add(chckbxMircoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(167, 85, 68, 23);
		panel.add(chckbxJueves);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(264, 85, 73, 23);
		panel.add(chckbxViernes);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(14, 115, 46, 14);
		panel.add(lblHorario);
		
		JCheckBox horario1 = new JCheckBox("10:00 a 13:00");
		horario1.setBounds(84, 111, 142, 23);
		panel.add(horario1);
		
		JCheckBox horario2 = new JCheckBox("16:00 a 19:00");
		horario2.setBounds(228, 111, 135, 23);
		panel.add(horario2);
		
		JLabel lblArreglos = new JLabel("Arreglo/s:");
		lblArreglos.setBounds(5, 155, 55, 14);
		panel.add(lblArreglos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 143, 415, 1);
		panel.add(separator_1);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(5, 226, 92, 14);
		panel.add(lblObservaciones);
		
		observaciones = new JTextField();
		observaciones.setEnabled(false);
		observaciones.setBounds(105, 216, 215, 34);
		panel.add(observaciones);
		observaciones.setColumns(10);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(5, 264, 68, 14);
		panel.add(lblEmpleado);
		
		JComboBox empleados = new JComboBox();
		empleados.setModel(new DefaultComboBoxModel(new String[] {"Manuel Gomez"}));
		empleados.setBounds(102, 261, 124, 20);
		panel.add(empleados);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(5, 309, 68, 14);
		panel.add(lblCategora);
		
		JCheckBox chckbxBota = new JCheckBox("Bota");
		chckbxBota.setBounds(84, 305, 55, 23);
		panel.add(chckbxBota);
		
		JCheckBox chckbxZapatilla = new JCheckBox("Zapatilla");
		chckbxZapatilla.setBounds(141, 305, 73, 23);
		panel.add(chckbxZapatilla);
		
		JCheckBox chckbxZapatoHombre = new JCheckBox("Zapato hombre");
		chckbxZapatoHombre.setBounds(212, 305, 108, 23);
		panel.add(chckbxZapatoHombre);
		
		JCheckBox chckbxZapatloMujer = new JCheckBox("Zapato mujer");
		chckbxZapatloMujer.setBounds(322, 305, 97, 23);
		panel.add(chckbxZapatloMujer);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setBounds(5, 350, 68, 14);
		panel.add(lblCdigo);
		
		codigoCalzado = new JTextField();
		codigoCalzado.setEditable(false);
		codigoCalzado.setText("ZM-00001");
		codigoCalzado.setBounds(65, 347, 92, 20);
		panel.add(codigoCalzado);
		codigoCalzado.setColumns(10);
		
		JLabel lblImporte = new JLabel("IMPORTE:");
		lblImporte.setBounds(5, 376, 68, 14);
		panel.add(lblImporte);
		
		JLabel lblSea = new JLabel("SE\u00D1A:");
		lblSea.setBounds(212, 376, 55, 14);
		panel.add(lblSea);
		
		JLabel lblAPagar = new JLabel("A PAGAR:");
		lblAPagar.setBounds(5, 404, 60, 14);
		panel.add(lblAPagar);
		
		importe = new JTextField();
		importe.setText("350,00");
		importe.setEditable(false);
		importe.setBounds(102, 401, 86, 20);
		panel.add(importe);
		importe.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(84, 404, 20, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(264, 376, 20, 14);
		panel.add(label_1);
		
		seña = new JTextField();
		seña.setText("80,00");
		seña.setBounds(282, 373, 86, 20);
		panel.add(seña);
		seña.setColumns(10);
		
		total = new JTextField();
		total.setText("270,00");
		total.setBounds(102, 373, 86, 20);
		panel.add(total);
		total.setColumns(10);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(84, 378, 20, 14);
		panel.add(label_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(304, 446, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(41, 446, 89, 23);
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
					if(botonNo.isSelected()) {
						lblNewLabel.setEnabled(false);
						chckbxLunes.setEnabled(false);
						chckbxMartes.setEnabled(false);
						chckbxMircoles.setEnabled(false);
						chckbxJueves.setEnabled(false);
						chckbxViernes.setEnabled(false);
						lblHorario.setEnabled(false);
						horario1.setEnabled(false);
						horario2.setEnabled(false);
					}
				}
				
			}
		});
		btnBuscar.setBounds(237, 107, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregarOtroCalzado = new JButton("Agregar otro calzado");
		btnAgregarOtroCalzado.setBounds(145, 446, 135, 23);
		panel.add(btnAgregarOtroCalzado);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(5, 334, 411, 2);
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
		table.setBounds(65, 155, 387, 49);
		panel.add(table);
	}
}
