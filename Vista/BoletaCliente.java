package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Boleta;
import Negocio.Calzado;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BoletaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nroBoleta;
	private JTextField fecha;
	private JTextField nombreCliente;
	private JTextField dniCliente;
	private JTextField se�a;
	private JTextField total;
	private static BoletaCliente instancia;
	
	public static BoletaCliente getInstancia() {
		if(instancia == null)
			instancia = new BoletaCliente(null);
		return instancia;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BoletaCliente frame = new BoletaCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param bol 
	 */
	public BoletaCliente(Boleta bol) {
		setTitle("Boleta de " + bol.getCliente().getNombre() + " " + bol.getCliente().getApellido());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNroBoleta = new JLabel("Nro. Boleta:");
		lblNroBoleta.setBounds(10, 11, 81, 14);
		contentPane.add(lblNroBoleta);
		
		nroBoleta = new JTextField();
		nroBoleta.setEditable(false);
		nroBoleta.setBounds(106, 8, 86, 20);
		contentPane.add(nroBoleta);
		nroBoleta.setColumns(10);
		nroBoleta.setText(Integer.toString(bol.getIdBoleta()));
		
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(257, 11, 61, 14);
		contentPane.add(lblFecha);
		
		fecha = new JTextField();
		fecha.setEditable(false);
		fecha.setBounds(338, 8, 86, 20);
		contentPane.add(fecha);
		fecha.setColumns(10);
		fecha.setText(bol.getFecha().toString());
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 48, 81, 14);
		contentPane.add(lblCliente);
		
		nombreCliente = new JTextField();
		nombreCliente.setEditable(false);
		nombreCliente.setBounds(106, 45, 212, 20);
		contentPane.add(nombreCliente);
		nombreCliente.setColumns(10);
		nombreCliente.setText(bol.getCliente().getNombre() + " " + bol.getCliente().getApellido());
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 79, 61, 14);
		contentPane.add(lblDni);
		
		dniCliente = new JTextField();
		dniCliente.setEditable(false);
		dniCliente.setBounds(106, 76, 109, 20);
		contentPane.add(dniCliente);
		dniCliente.setColumns(10);
		dniCliente.setText(bol.getCliente().getDni());
		
		JLabel lblArreglos = new JLabel("Calzados:");
		lblArreglos.setBounds(10, 119, 81, 14);
		contentPane.add(lblArreglos);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		list.setBounds(75, 118, 349, 165);
		contentPane.add(list);
		String dato="";
		for (int i = 0; i < bol.getCalzados().size(); i++){
			dato="C�digo: " + bol.getCalzados().elementAt(i).getCodigoCalzado() +" - $" + bol.getCalzados().elementAt(i).getCostoCalzado() +
					" - Estado: " + bol.getCalzados().elementAt(i).getEstado();
			for(int j = 0; j < bol.getCalzados().elementAt(i).getArreglos().size(); j++)
				dato= dato+"\n "+" Arreglos: " + bol.getCalzados().elementAt(i).getArreglos().elementAt(j).getNombre();
			
			model.addElement(dato);
		}
		
		
		
		JLabel lblSea = new JLabel("Se\u00F1a:");
		lblSea.setBounds(10, 297, 46, 14);
		contentPane.add(lblSea);
		
		se�a = new JTextField();
		se�a.setEditable(false);
		se�a.setBounds(77, 294, 86, 20);
		contentPane.add(se�a);
		se�a.setColumns(10);
		se�a.setText(Float.toString(bol.getSe�a()));
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(207, 297, 61, 14);
		contentPane.add(lblTotal);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(288, 294, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		total.setText(Float.toString(bol.getTotal()));
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Boletas.getInstancia().setLocationRelativeTo(null);
				Boletas.getInstancia().setVisible(true);
			}
		});
		btnAtrs.setBounds(74, 336, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnActualizarEstadoCalzado = new JButton("Actualizar estado calzado");
		btnActualizarEstadoCalzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos=list.getSelectedIndex();
				if(pos!=-1) {
					Calzado c=bol.getCalzados().get(pos);
					boolean continuar=true;
					String opcion="";
					do {
						opcion=JOptionPane.showInputDialog("Ingrese el estado a cambiar: P:pendiente, L:listo, E:entregado");
						if(!(opcion.equals("P")||opcion.equals("L")||opcion.equals("E"))){
							JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta");
						}
						else
							continuar=false;
					}while(continuar);
					c.setEstado(opcion.charAt(0));
					c.update();
					//estan todas en Listo?
					Vector<Calzado>calzados=bol.getCalzados();
					boolean actualizarBoleta=true;
					for(Calzado cal:calzados) {
						String estado=String.valueOf(cal.getEstado());
						if(estado.equals("P")) actualizarBoleta=false;
					}
					if(actualizarBoleta) { bol.setEstadoRetiro('L'); bol.update();}
				}
				
				else JOptionPane.showMessageDialog(null, "Seleccione un elemento de la lista para continuar");
			}
		});
		btnActualizarEstadoCalzado.setBounds(191, 336, 197, 23);
		contentPane.add(btnActualizarEstadoCalzado);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(69, 117, 355, 166);
		contentPane.add(scrollPane);
	}
}
