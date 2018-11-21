package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;

public class ResumenBoleta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumenBoleta frame = new ResumenBoleta();
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
	public ResumenBoleta() {
		setTitle("Resumen Boleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(10, 11, 67, 14);
		contentPane.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(87, 8, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNroBoleta = new JLabel("Nro. Boleta");
		lblNroBoleta.setBounds(257, 11, 67, 14);
		contentPane.add(lblNroBoleta);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(334, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnvoADomicilio = new JLabel("Env\u00EDo a domicilio:");
		lblEnvoADomicilio.setBounds(10, 48, 93, 14);
		contentPane.add(lblEnvoADomicilio);
		
		JRadioButton rdbtnS = new JRadioButton("S\u00ED");
		rdbtnS.setBounds(138, 44, 109, 23);
		contentPane.add(rdbtnS);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(256, 44, 109, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setBounds(10, 84, 78, 14);
		contentPane.add(lblDisponibilidad);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setBounds(108, 80, 78, 23);
		contentPane.add(chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setBounds(199, 80, 78, 23);
		contentPane.add(chckbxMartes);
		
		JCheckBox chckbxMircoles = new JCheckBox("Mi\u00E9rcoles");
		chckbxMircoles.setBounds(298, 80, 97, 23);
		contentPane.add(chckbxMircoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setBounds(138, 106, 78, 23);
		contentPane.add(chckbxJueves);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setBounds(237, 106, 78, 23);
		contentPane.add(chckbxViernes);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 142, 46, 14);
		contentPane.add(lblHorario);
		
		JCheckBox checkBox = new JCheckBox("10:00 - 13:00");
		checkBox.setBounds(89, 138, 97, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("16:00 - 19:00");
		checkBox_1.setBounds(227, 138, 97, 23);
		contentPane.add(checkBox_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 177, 410, 2);
		contentPane.add(separator);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(10, 326, 46, 14);
		contentPane.add(lblImporte);
		
		JLabel lblAPagar = new JLabel("A pagar:");
		lblAPagar.setBounds(10, 351, 46, 14);
		contentPane.add(lblAPagar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 323, 58, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 348, 56, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setBounds(66, 326, 20, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(66, 351, 20, 14);
		contentPane.add(label_1);
		
		JLabel lblSea = new JLabel("Se\u00F1a:");
		lblSea.setBounds(176, 326, 46, 14);
		contentPane.add(lblSea);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(237, 326, 10, 14);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(257, 323, 58, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 313, 410, 2);
		contentPane.add(separator_1);
		
		table = new JTable();
		table.setBounds(10, 293, 385, -77);
		contentPane.add(table);
		
		JLabel lblCalzados = new JLabel("Calzados:");
		lblCalzados.setBounds(10, 191, 67, 14);
		contentPane.add(lblCalzados);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(108, 379, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(226, 379, 89, 23);
		contentPane.add(btnAceptar);
	}
}
