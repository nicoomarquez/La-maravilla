package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.SARA;
import Negocio.Boleta;
import Negocio.Cliente;
import Negocio.Empleado;
import Persistencia.AdmPersistenciaBoleta;
import Persistencia.AdmPersistenciaEmpleado;
import View.Boleta_View;
import javax.swing.DefaultComboBoxModel;

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
	private JComboBox<String> comboBoxBoletas;
	private Vector<Boleta_View>bv;
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
				
				// Verifico que el campo no esté vacío
				if(textFieldDni.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Ingrese un DNI para continuar");
				else { 
					// Verifico que el dni ingresado corresponda a un cliente
					Cliente cliente =  SARA.getInstancia().buscarCliente(textFieldDni.getText());
					if(cliente == null)
						JOptionPane.showMessageDialog(null, "No existe cliente con el DNI ingresado");
					else {
						// Busco las boletas
						bv=SARA.getInstancia().obtenerBoletasDeCliente(textFieldDni.getText());
				
						// Pregunto si el cliente boletas
						if(bv.size() == 0) 
							JOptionPane.showMessageDialog(null, "El cliente no tiene boletas para mostrar");
					
						DefaultComboBoxModel<String> df=new DefaultComboBoxModel<String>();
						for(Boleta_View b:bv){
							df.addElement(b.toString());
						}
						comboBoxBoletas.setModel(df);
				
						panel.setVisible(true);
						btnVerBoleta.setEnabled(true);
					}	
				}	
			}
		});
		btnNewBuscar.setBounds(304, 26, 89, 23);
		contentPane.add(btnNewBuscar);
		
		panel = new JPanel();
		panel.setBounds(10, 74, 414, 136);
		panel.setVisible(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblBoletas = new JLabel("Boletas:");
		lblBoletas.setBounds(10, 11, 59, 14);
		panel.add(lblBoletas);
		
		comboBoxBoletas = new JComboBox<String>();
		comboBoxBoletas.setBounds(72, 8, 312, 20);
		panel.add(comboBoxBoletas);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.getInstancia().setLocationRelativeTo(null);
				Menu.getInstancia().setVisible(true);
			}
		});
		btnAtras.setBounds(99, 221, 100, 23);
		contentPane.add(btnAtras);
		
		btnVerBoleta = new JButton("Ver boleta");
		btnVerBoleta.setEnabled(false);
		btnVerBoleta.setBounds(226, 221, 100, 23);
		contentPane.add(btnVerBoleta);
		btnVerBoleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Obtengo el ID de la boleta seleccionada
				String idBoleta = (String) comboBoxBoletas.getSelectedItem();
				String[] id = idBoleta.split(" ");
				
				// La busco en la base de datos
				Boleta bol = AdmPersistenciaBoleta.getInstancia().select(id[0]);
				
				// Paso la boleta para la siguiente ventana
				BoletaCliente bc = new BoletaCliente(bol);
				bc.setVisible(true);
			}
		});
	}
}
