package Vista;

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

public class Boletas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDni;
	private JButton btnNewBuscar;
	private JPanel panel;
	private JLabel lblBoletas;
	private JButton btnVerBoleta;
	private JButton btnAtras;
	private static Boletas instancia;
	/**
	 * Launch the application.
	 */
	public static Boletas getInstancia(){
		if(instancia==null)
			instancia=new Boletas();
		return instancia;
	}
	/**
	 * Create the frame.
	 */
	private Boletas() {
		setType(Type.UTILITY);
		setTitle("BOLETAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 30, 46, 14);
		contentPane.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(83, 27, 186, 19);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		btnNewBuscar = new JButton("Buscar");
		btnNewBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				
			}
		});
		btnNewBuscar.setBounds(300, 26, 89, 23);
		contentPane.add(btnNewBuscar);
		
		panel = new JPanel();
		panel.setBounds(10, 74, 414, 161);
		panel.setVisible(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblBoletas = new JLabel("Boletas:");
		lblBoletas.setBounds(10, 11, 59, 14);
		panel.add(lblBoletas);
		
		JComboBox<String> comboBoxBoletas = new JComboBox<String>();
		comboBoxBoletas.setBounds(72, 8, 186, 20);
		panel.add(comboBoxBoletas);
		
		btnVerBoleta = new JButton("Ver boleta");
		btnVerBoleta.setBounds(223, 117, 117, 33);
		panel.add(btnVerBoleta);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(72, 117, 117, 33);
		panel.add(btnAtras);
	}
}
