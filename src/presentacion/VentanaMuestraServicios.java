/******************************************************************/ 

/* Programa: Cruz Roja */ 

/* Autor: Contreras Vazquez Carlos */ 

/* Descripción: Esta ventana tiene como funcion mostrar un listado de todos los servicios
 *              que se imparten en la empresa. Esa es su unica funcionalidad junto con un 
 *              boton para regresar a la ventana anterior */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public ventanaMuestraServicios(ControlMuestraServicios control)
 * 		- public void actionPerformed(ActionEvent e) 
 * 		- void abre()
 * 		- void cierra()
 */

/******************************************************************/


package presentacion;

import java.awt.BorderLayout;


import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Consulta;

public class VentanaMuestraServicios extends JFrame implements ActionListener , ItemListener {

private ControlMuestraServicios control=null;
	
	JPanel panel1,panel2,panel3;
	JLabel titulo,idServicio,servicio,costo;
	JButton botonRegresa;
	ArrayList<Consulta> servicios;
	String [] id; /*Arreglo para acomodar los elemento del servicio respecto a su ID*/
	
	public VentanaMuestraServicios(ControlMuestraServicios control) throws HeadlessException {
		super("Servicios");
		this.control = control;
		setSize(700,100);
		setLocationRelativeTo(null);
		int aux=100;
		
		servicios=control.recuperaAllServicios();
		id=new String[servicios.size()];
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		/*etiquetas de los campos a mostrar*/
		titulo=new JLabel("Servicios");
		idServicio=new JLabel("IDServicio");
		servicio=new JLabel("Servicio");
		costo=new JLabel("Costo");

		/*botones que se ocuparán durante la ejecución*/
		botonRegresa=new JButton("Regresar");
		botonRegresa.addActionListener(this);
		
		panel1.add(titulo);
		
		panel2.setLayout(new GridLayout(servicios.size()+1,4));
		panel2.add(idServicio);
		panel2.add(servicio);
		panel2.add(costo);
		
		/*Si se encontraron servicios entonces se recorre la lista para obtener los datos requeridos */
		if(servicios.size()!=0) {
			for(int i=0;i<servicios.size();i++) { //recorre el arreglo con todos los servicios obtenidos
				aux+=100;
				id[i]=servicios.get(i).getIDConsulta(); 
				panel2.add(new JLabel("     "+servicios.get(i).getIDServicio())); //añade ID de servicio a la ventana
				panel2.add(new JLabel(""+servicios.get(i).getTipoServicio())); //añade el tipo de servicio a la ventana
				panel2.add(new JLabel(""+servicios.get(i).getCosto())); //añade el costo de servicio a la ventana
				}
		}
		
		setSize(500,aux);
		panel3.add(botonRegresa);
		
		/*Se agregan los paneles de manera ordenada a la ventana creada*/
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Cuando se oprima el boton regresar, la ventana actual se cerrará y se 
		 * quedará en la ventana anterior abierta*/
		if(e.getSource()==botonRegresa) {
			setVisible(false);
		}
		
	}
	
	/*Metodo abre se encarga de mostrar la ventana cuando asi se desee*/
	public void abre() {
		setVisible(true);
	}
	/*Metodo cierra se encarga de cerrar la ventana cuando asi se desee*/
	public void cierra() {
		setVisible(false);
	}

}
