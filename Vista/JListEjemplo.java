package vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Controlador.SARA;
import Negocio.Arreglo;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JListEjemplo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListEjemplo frame = new JListEjemplo();
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
	private Vector<Arreglo>arreglos=SARA.getInstancia().getArreglos();
	
	private Vector<Arreglo>arreglosSeleccionados=new Vector<Arreglo>();
	
	private DefaultListModel<String> modelList,modelList_1;
	
	
	public JListEjemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Vector<Arreglo> arreglos=SARA.getInstancia().getArreglos();
		JList<String> list = new JList<String>();
		 modelList = new DefaultListModel<String>();
		//agrego los arreglos a la lista
		for(int i = 0; i < arreglos.size(); i++) {
			modelList.addElement(arreglos.elementAt(i).getNombre());
		}
		list.setModel(modelList);
		list.setBounds(10, 26, 129, 195);
		contentPane.add(list);
		
		JList<String> list_1 = new JList<String>();
		list_1.setBounds(263, 26, 129, 195);
		modelList_1=new DefaultListModel<String>();
		list_1.setModel(modelList_1);
		contentPane.add(list_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos=list.getSelectedIndex();
				if( pos != -1){ //Si se selecciono algo
					Arreglo r=arreglos.get(pos);
					if(!arreglosSeleccionados.contains(r)){
						arreglosSeleccionados.addElement(r);
						modelList_1.addElement(list.getSelectedValue());
					}
				}
			}
		});
		btnAgregar.setBounds(164, 82, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos=list_1.getSelectedIndex();
				if(pos != -1){
					arreglosSeleccionados.remove(pos);
					modelList_1.remove(pos);
				}
			}
		});
		btnQuitar.setBounds(164, 145, 89, 23);
		contentPane.add(btnQuitar);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 21, 129, 200);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(list_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(263, 26, 129, 195);
		contentPane.add(scrollPane_1);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarCalzadoBoleta.setArreglos(arreglosSeleccionados);
				dispose();
			}
		});
		btnTerminar.setBounds(161, 227, 89, 23);
		contentPane.add(btnTerminar);
		
		
	}
}
