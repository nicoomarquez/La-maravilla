package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.SARA;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private static CrearCliente instancia;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField mail;
	private JTextField domicilio;
	private JTextField localidad;
	private JTextField codigoPostal;
	
	public static CrearCliente getInstancia() {
		if(instancia == null)
			instancia = new CrearCliente();
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
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
	public CrearCliente() {
		setTitle("Crear Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("(*)Nombre:");
		lblNombre.setBounds(10, 11, 63, 14);
		contentPane.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(84, 8, 285, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("(*)Apellido:");
		lblApellido.setBounds(10, 42, 63, 14);
		contentPane.add(lblApellido);
		
		apellido = new JTextField();
		apellido.setBounds(84, 39, 285, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		JLabel lblDni = new JLabel("(*)DNI:");
		lblDni.setBounds(10, 73, 46, 14);
		contentPane.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(84, 70, 115, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblMail = new JLabel("(*)Mail:");
		lblMail.setBounds(10, 107, 46, 14);
		contentPane.add(lblMail);
		
		mail = new JTextField();
		mail.setBounds(84, 104, 285, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(10, 140, 63, 14);
		contentPane.add(lblDomicilio);
		
		domicilio = new JTextField();
		domicilio.setBounds(84, 137, 285, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(10, 175, 63, 14);
		contentPane.add(lblLocalidad);
		
		localidad = new JTextField();
		localidad.setBounds(84, 172, 142, 20);
		contentPane.add(localidad);
		localidad.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setBounds(236, 175, 87, 14);
		contentPane.add(lblCdigoPostal);
		
		codigoPostal = new JTextField();
		codigoPostal.setBounds(333, 172, 86, 20);
		contentPane.add(codigoPostal);
		codigoPostal.setColumns(10);
		
		JLabel lblSinGuionesNi = new JLabel("(sin guiones ni puntos)");
		lblSinGuionesNi.setBounds(215, 73, 154, 14);
		contentPane.add(lblSinGuionesNi);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuCliente.getInstancia().setLocationRelativeTo(null);
				MenuCliente.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(110, 227, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombre.getText().isEmpty() || apellido.getText().isEmpty() || dni.getText().isEmpty() || mail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ingrese los campos obligatorios");
				}
				//Verificacion de DNI
				else if(SARA.getInstancia().dniRepetido(dni.getText())) {
					JOptionPane.showMessageDialog(null, "El DNI ingresado ya se encuentra registrado");
				}
				else if(SARA.getInstancia().mailRepetido(mail.getText())) {
					JOptionPane.showMessageDialog(null, "El mail ingresado ya se encuentra ingresado");
				}
				else {
					SARA.getInstancia().crearCliente(nombre.getText(), apellido.getText(), dni.getText(), mail.getText(),
							domicilio.getText(), localidad.getText(), codigoPostal.getText());
					JOptionPane.showMessageDialog(null, "Cliente creado con éxito");
					limpiarPantalla();
					dispose();
				}
			}

			private void limpiarPantalla() {
				nombre.setText(null);
				apellido.setText(null);
				dni.setText(null);
				mail.setText(null);
				domicilio.setText(null);
				localidad.setText(null);
				codigoPostal.setText(null);
			}
		});
		btnAceptar.setBounds(234, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("(*)Obligatorio");
		lblNewLabel.setBounds(10, 211, 89, 14);
		contentPane.add(lblNewLabel);
	}

}
