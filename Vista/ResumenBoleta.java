package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Boleta;
import Negocio.Calzado;
import Negocio.Cliente;
import Persistencia.AdmPersistenciaBoleta;
import Persistencia.AdmPersistenciaCliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ResumenBoleta extends JFrame {

	private JPanel contentPane;
	private JTextField dniCliente;
	private JTextField nroBoleta;
	private JTextField importe;
	private JTextField montoTotal;
	private JTextField seña;
	private static ResumenBoleta instancia;
	
	public static ResumenBoleta getInstancia() {
		Vector<Calzado> calzados = new Vector<Calzado>();
		String dni = null;
		if(instancia == null)
			instancia = new ResumenBoleta(calzados, dni);
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vector<Calzado> calzados = null;
					String dni = null;
					ResumenBoleta frame = new ResumenBoleta(calzados, dni);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param calzados 
	 * @param dni 
	 */
	public ResumenBoleta(Vector<Calzado> calzados, String dni) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(10, 11, 67, 14);
		contentPane.add(lblCliente);
		
		dniCliente = new JTextField();
		dniCliente.setEditable(false);
		dniCliente.setBounds(87, 8, 160, 20);
		contentPane.add(dniCliente);
		dniCliente.setColumns(10);
		
		// Seteo el dni traído de la venta anterior
		dniCliente.setText(dni);
		
		JLabel lblNroBoleta = new JLabel("Nro. Boleta");
		lblNroBoleta.setBounds(257, 11, 67, 14);
		contentPane.add(lblNroBoleta);
		
		nroBoleta = new JTextField();
		nroBoleta.setEditable(false);
		nroBoleta.setBounds(334, 8, 86, 20);
		contentPane.add(nroBoleta);
		nroBoleta.setColumns(10);
		
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
		lblImporte.setBounds(10, 326, 67, 14);
		contentPane.add(lblImporte);
		
		JLabel lblAPagar = new JLabel("A pagar:");
		lblAPagar.setBounds(10, 351, 67, 14);
		contentPane.add(lblAPagar);
		
		importe = new JTextField();
		importe.setEditable(false);
		importe.setBounds(115, 323, 58, 20);
		contentPane.add(importe);
		importe.setColumns(10);
		
		montoTotal = new JTextField();
		montoTotal.setBounds(115, 348, 58, 20);
		contentPane.add(montoTotal);
		montoTotal.setColumns(10);
		
		// Calculo del monto total
//		int senia = Integer.parseInt(seña.getText());
//		int mtotal = Integer.parseInt(importe.getText()) - senia;
//		montoTotal.setText(Integer.toString(mtotal));
		
		JLabel label = new JLabel("$");
		label.setBounds(83, 326, 20, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(83, 351, 20, 14);
		contentPane.add(label_1);
		
		JLabel lblSea = new JLabel("Se\u00F1a:");
		lblSea.setBounds(215, 326, 46, 14);
		contentPane.add(lblSea);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(267, 326, 10, 14);
		contentPane.add(label_2);
		
		seña = new JTextField();
		seña.setBounds(284, 323, 58, 20);
		contentPane.add(seña);
		seña.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 313, 410, 2);
		contentPane.add(separator_1);
		
		JLabel lblCalzados = new JLabel("Calzados:");
		lblCalzados.setBounds(10, 191, 67, 14);
		contentPane.add(lblCalzados);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				InsertarCalzadoBoleta.getInstancia().setLocationRelativeTo(null);
				InsertarCalzadoBoleta.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(108, 379, 89, 23);
		contentPane.add(btnAtrs);
		
		// Retomo en el último autonumérico
		int idBoleta = AdmPersistenciaBoleta.getInstancia().getIdMaximo();
		Boleta.iniciarAutoNumerico(idBoleta);
		// Se muestra cual sería el nroBoleta pero todavía no se creó
		nroBoleta.setText(Integer.toString(idBoleta + 1));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Para crear un boleta, necesito el cliente, lo consigo con el dni
				Cliente cliente = AdmPersistenciaCliente.getInstancia().buscarCliente(dni);
				
				// Fecha de hoy
				
				Date fecha = Date.valueOf(LocalDate.now());
				System.out.println(fecha);
				
				// Se crea la boleta
				Boleta boleta = new Boleta(cliente, Integer.parseInt(montoTotal.getText()), Integer.parseInt(seña.getText()), fecha, calzados);
				
				JOptionPane.showMessageDialog(null, "Boleta generada con éxito");
			}
		});
		btnAceptar.setBounds(226, 379, 89, 23);
		contentPane.add(btnAceptar);
		
		
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		list.setBounds(66, 190, 326, 111);
		contentPane.add(list);
		
		int total = 0;
		for ( int i = 0; i < calzados.size(); i++ ){
		  model.addElement("Código: " + calzados.elementAt(i).getCodigoCalzado() + " - $" + calzados.elementAt(i).getCostoCalzado() + " - Cant. de arreglos: " + calzados.elementAt(i).getArreglos().size());
		  total += calzados.elementAt(i).getCostoCalzado();
		}
		importe.setText(Integer.toString(total));
		
		
	}
}
