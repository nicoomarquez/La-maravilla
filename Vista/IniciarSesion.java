package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.SARA;
import javax.swing.JPasswordField;

public class IniciarSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IniciarSesion instancia;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	
	public static IniciarSesion getInstancia(){
		if(instancia==null)
			instancia=new IniciarSesion();
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		//setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setForeground(new Color(0, 0, 51));
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 295);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(255, 255, 255));
		textFieldUsuario.setBounds(140, 85, 254, 20);
		textFieldUsuario.setColumns(10);
		contentPane.add(textFieldUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setFont(lblContrasenia.getFont().deriveFont(lblContrasenia.getFont().getStyle() | Font.BOLD, 12f));
		lblContrasenia.setForeground(new Color(0, 0, 51));
		lblContrasenia.setBounds(47, 135, 90, 14);
		contentPane.add(lblContrasenia);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(lblUsuario.getFont().deriveFont(lblUsuario.getFont().getStyle() | Font.BOLD, 12f));
		lblUsuario.setForeground(new Color(0, 0, 51));
		lblUsuario.setBounds(47, 90, 75, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblTitulo = new JLabel("S.A.R.A. - La Maravilla");
		lblTitulo.setForeground(new Color(0, 0, 51));
		lblTitulo.setBounds(116, 29, 263, 32);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblTitulo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setForeground(new Color(0, 0, 51));
		btnSalir.setBounds(140, 183, 124, 32);
		contentPane.add(btnSalir);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				SARA s = 
				SARA.getInstancia(textFieldUsuario.getText(), passwordField.getText());
				if(s == null)
					JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto/a");
				else {
					dispose();
					Menu.getInstancia().setLocationRelativeTo(null);
					Menu.getInstancia().setVisible(true);
				}
			}
		});
		btnIniciarSesion.setForeground(new Color(0, 0, 51));
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setBounds(270, 183, 124, 32);
		contentPane.add(btnIniciarSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 130, 254, 20);
		contentPane.add(passwordField);
	}
}
