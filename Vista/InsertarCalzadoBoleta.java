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
import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

public class InsertarCalzadoBoleta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseMail;
	private JTextField textField;
	private JTextField txtZm;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static InsertarCalzadoBoleta instancia;
	
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
		setBounds(100, 100, 461, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		txtIngreseMail = new JTextField();
		txtIngreseMail.setBounds(74, 107, 161, 20);
		contentPane.add(txtIngreseMail);
		txtIngreseMail.setColumns(10);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(329, 106, 106, 23);
		contentPane.add(btnNuevoCliente);
		
		JLabel lblEnvoADomicilio = new JLabel("Env\u00EDo a Domicilio:");
		lblEnvoADomicilio.setBounds(10, 149, 111, 14);
		contentPane.add(lblEnvoADomicilio);
		
		JRadioButton rdbtnS = new JRadioButton("S\u00ED");
		rdbtnS.setBounds(111, 145, 102, 23);
		contentPane.add(rdbtnS);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(217, 145, 109, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblNewLabel = new JLabel("Disponibilidad:");
		lblNewLabel.setBounds(10, 174, 92, 28);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(98, 177, 60, 23);
		contentPane.add(chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(212, 177, 68, 23);
		contentPane.add(chckbxMartes);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(329, 177, 92, 23);
		contentPane.add(chckbxMircoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(145, 203, 68, 23);
		contentPane.add(chckbxJueves);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(264, 203, 73, 23);
		contentPane.add(chckbxViernes);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 233, 46, 14);
		contentPane.add(lblHorario);
		
		JCheckBox chckbxA = new JCheckBox("10:00 a 13:00");
		chckbxA.setBounds(71, 229, 142, 23);
		contentPane.add(chckbxA);
		
		JCheckBox chckbxA_1 = new JCheckBox("16:00 a 19:00");
		chckbxA_1.setBounds(229, 229, 135, 23);
		contentPane.add(chckbxA_1);
		
		JLabel lblArreglos = new JLabel("Arreglo/s:");
		lblArreglos.setBounds(10, 273, 55, 14);
		contentPane.add(lblArreglos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 137, 415, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 259, 415, 1);
		contentPane.add(separator_1);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 320, 92, 14);
		contentPane.add(lblObservaciones);
		
		textField = new JTextField();
		textField.setBounds(111, 317, 215, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(10, 383, 68, 14);
		contentPane.add(lblEmpleado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manuel Gomez"}));
		comboBox.setBounds(111, 380, 124, 20);
		contentPane.add(comboBox);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(10, 420, 68, 14);
		contentPane.add(lblCategora);
		
		JCheckBox chckbxBota = new JCheckBox("Bota");
		chckbxBota.setBounds(96, 416, 55, 23);
		contentPane.add(chckbxBota);
		
		JCheckBox chckbxZapatilla = new JCheckBox("Zapatilla");
		chckbxZapatilla.setBounds(153, 416, 73, 23);
		contentPane.add(chckbxZapatilla);
		
		JCheckBox chckbxZapatoHombre = new JCheckBox("Zapato hombre");
		chckbxZapatoHombre.setBounds(229, 416, 108, 23);
		contentPane.add(chckbxZapatoHombre);
		
		JCheckBox chckbxZapatloMujer = new JCheckBox("Zapato mujer");
		chckbxZapatloMujer.setBounds(338, 416, 97, 23);
		contentPane.add(chckbxZapatloMujer);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO:");
		lblCdigo.setBounds(10, 476, 68, 14);
		contentPane.add(lblCdigo);
		
		txtZm = new JTextField();
		txtZm.setEditable(false);
		txtZm.setText("ZM-00001");
		txtZm.setBounds(72, 473, 92, 20);
		contentPane.add(txtZm);
		txtZm.setColumns(10);
		
		JLabel lblImporte = new JLabel("IMPORTE:");
		lblImporte.setBounds(10, 512, 68, 14);
		contentPane.add(lblImporte);
		
		JLabel lblSea = new JLabel("SE\u00D1A:");
		lblSea.setBounds(225, 512, 55, 14);
		contentPane.add(lblSea);
		
		JLabel lblAPagar = new JLabel("A PAGAR:");
		lblAPagar.setBounds(10, 548, 60, 14);
		contentPane.add(lblAPagar);
		
		textField_1 = new JTextField();
		textField_1.setText("350,00");
		textField_1.setEditable(false);
		textField_1.setBounds(107, 509, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(82, 512, 20, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(282, 512, 20, 14);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("80,00");
		textField_2.setBounds(292, 509, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("270,00");
		textField_3.setBounds(107, 545, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(84, 548, 20, 14);
		contentPane.add(label_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(300, 592, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(36, 592, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(237, 107, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregarOtroCalzado = new JButton("Agregar otro calzado");
		btnAgregarOtroCalzado.setBounds(145, 592, 135, 23);
		contentPane.add(btnAgregarOtroCalzado);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 460, 411, 2);
		contentPane.add(separator_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 135, 435, 391);
		contentPane.add(panel);
	}
}
