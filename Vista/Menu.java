package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JFrame {

	private JPanel contentPane;
	private static Menu instancia;
	
	public static Menu getInstancia(){
		if(instancia==null)
			instancia=new Menu();
		return instancia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Men\u00FA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BOLETAS");
		btnNewButton.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Boletas.getInstancia().setLocationRelativeTo(null);
				Boletas.getInstancia().setVisible(true);
			}
		});
		btnNewButton.setBounds(72, 57, 130, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLIENTES");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MenuCliente.getInstancia().setLocationRelativeTo(null);
				MenuCliente.getInstancia().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnNewButton_1.setBounds(225, 57, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnArreglos = new JButton("ARREGLOS");
		btnArreglos.setEnabled(false);
		btnArreglos.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnArreglos.setBounds(72, 109, 130, 23);
		contentPane.add(btnArreglos);
		
		JButton btnEmpleados = new JButton("EMPLEADOS");
		btnEmpleados.setEnabled(false);
		btnEmpleados.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnEmpleados.setBounds(225, 109, 130, 23);
		contentPane.add(btnEmpleados);
		
		JButton btnMail = new JButton("MAIL");
		btnMail.setEnabled(false);
		btnMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMail.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnMail.setBounds(72, 163, 130, 23);
		contentPane.add(btnMail);
		
		JButton btnNuevaBoleta = new JButton("NUEVA BOLETA");
		btnNuevaBoleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertarCalzadoBoleta.getInstancia().setLocationRelativeTo(null);
				InsertarCalzadoBoleta.getInstancia().setVisible(true);
			}
		});
		btnNuevaBoleta.setFont(new Font("Kalinga", Font.BOLD, 12));
		btnNuevaBoleta.setBounds(225, 163, 130, 23);
		contentPane.add(btnNuevaBoleta);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 23);
		contentPane.add(menuBar);
		
		JMenu mnCuenta = new JMenu("Cuenta");
		menuBar.add(mnCuenta);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				IniciarSesion.getInstancia().setLocationRelativeTo(null);
				IniciarSesion.getInstancia().setVisible(true);
				IniciarSesion.getInstancia().limpiar();
			}
		});
		mnCuenta.add(mntmCerrarSesion);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem);
	}
}
