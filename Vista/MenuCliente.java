package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.SARA;
import Negocio.Cliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCliente extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField mail;
	private JTextField domicilio;
	private JTextField localidad;
	private JTextField codigoPostal;
	private static MenuCliente instancia;
	
	public static MenuCliente getInstancia() {
		if(instancia == null)
			instancia = new MenuCliente();
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
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
	public MenuCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 34, 424, 200);
		panel.setVisible(false);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(5, 9, 40, 14);
		
		dni = new JTextField();
		dni.setBounds(49, 8, 155, 20);
		dni.setColumns(10);
		
		JButton btnAtrs_1 = new JButton("Atr\u00E1s");
		btnAtrs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		btnAtrs_1.setBounds(64, 237, 89, 23);
		contentPane.add(btnAtrs_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(163, 237, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(262, 237, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(214, 5, 88, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dni.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Ingrese un DNI para continuar");
				Cliente cliente =  SARA.getInstancia().buscarCliente(dni.getText());
				if( cliente != null) {
					panel.setVisible(true);
					nombre.setText(cliente.getNombre());
					apellido.setText(cliente.getApellido());
					mail.setText(cliente.getMail());
					domicilio.setText(cliente.getDomicilio());
					localidad.setText(cliente.getLocalidad());
					codigoPostal.setText(cliente.getCodigoPostal());
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
				}
				else
					JOptionPane.showMessageDialog(null, "No existe cliente con el DNI ingresado");
			}
		});
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(312, 5, 117, 23);
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearCliente.getInstancia().setLocationRelativeTo(null);
				CrearCliente.getInstancia().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 14, 55, 14);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(112, 11, 302, 20);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 46, 55, 14);
		
		apellido = new JTextField();
		apellido.setEditable(false);
		apellido.setBounds(112, 43, 302, 20);
		apellido.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 77, 55, 14);
		
		mail = new JTextField();
		mail.setEditable(false);
		mail.setBounds(112, 74, 302, 20);
		mail.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(10, 108, 55, 14);
		
		domicilio = new JTextField();
		domicilio.setEditable(false);
		domicilio.setBounds(112, 105, 302, 20);
		domicilio.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(10, 139, 63, 14);
		
		localidad = new JTextField();
		localidad.setEditable(false);
		localidad.setBounds(112, 136, 302, 20);
		localidad.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setBounds(10, 170, 92, 14);
		
		codigoPostal = new JTextField();
		codigoPostal.setEditable(false);
		codigoPostal.setBounds(112, 167, 302, 20);
		codigoPostal.setColumns(10);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(52, 205, 76, 23);
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setEnabled(false);
		btnEliminarCliente.setBounds(138, 205, 119, 23);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.setBounds(267, 205, 119, 23);
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(lblLocalidad);
		panel.add(lblDomicilio);
		panel.add(lblMail);
		panel.add(lblApellido);
		panel.add(lblNombre);
		panel.add(nombre);
		panel.add(apellido);
		panel.add(mail);
		panel.add(domicilio);
		panel.add(localidad);
		panel.add(lblCdigoPostal);
		panel.add(codigoPostal);
		contentPane.add(lblDni);
		contentPane.add(dni);
		contentPane.add(btnBuscar);
		contentPane.add(btnNuevoCliente);
	}
}
