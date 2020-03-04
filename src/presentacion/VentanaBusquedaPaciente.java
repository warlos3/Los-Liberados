/*
 * Programa :Es la Ventana de Busqueda de Pacientes	"HU-16"
 * Autor : Ramirez Cordero Joselyn
 * Fecha: 02/03/ 2020
 * Descripción:Creea la ventana principal de busqueda del historial medico de cierto paciente 
 *              
 */

/* Contenido de listado
 * 
 * Métodos 
 *
 *  1° Public VentanaBusquedaPaciente(ControlBusquedaPaciente control) throws HeadlessException 
 *  2° Public void actionPerformed(ActionEvent e)
 *  3° Public void abre() 
 *  4° Public void muestraMensaje(String mensaje)
 *  5° Public void cierra()
 *  
 */



 
package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.HistorialMedico;


	public class VentanaBusquedaPaciente extends JFrame implements ActionListener{
	
    // Muestra los paneles en los que esta escrita informacion o pueden escribir 
	JPanel panel1,panel2,panel3,panel4;
	JLabel label1,label2,label3,label5;
	JTextField IdPaciente;
	// Botones para dar click
	JButton botonBuscar,botonLimpiar,botonCancelar;

	private ControlBusquedaPaciente control=null;
	
	ArrayList<HistorialMedico> historial;
	
	
	/* Crea la Ventana de la busqueda Paciente, tanto como los controles y botones */
	
	public VentanaBusquedaPaciente(ControlBusquedaPaciente control) throws HeadlessException {
		super("Busca Paciente");
		this.control=control;
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		
		label1=new JLabel("Busqueda de Paciente");
		label2=new JLabel("ID Paciente");
		label3=new JLabel("Fecha");
		label5=new JLabel("Observaciones");
		
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
		label2.setFont(new Font("Arial Black", Font.BOLD, 20));
		label3.setFont(new Font("Arial Black", Font.BOLD, 15));
		label5.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		IdPaciente=new JTextField(10);
		
		botonBuscar=new JButton("Buscar");
		botonLimpiar=new JButton("Limpiar");
		botonCancelar=new JButton("Cancelar");
	
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.add(label2);
		panel2.add(IdPaciente);

		panel3.add(botonBuscar);	
		panel3.add(botonLimpiar);
		panel3.add(botonCancelar);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==botonLimpiar) {
			IdPaciente.setText("");
		}
		
		if(e.getSource()==botonCancelar) {
			setVisible(false);
		}
		
		if(e.getSource()==botonBuscar) {
			String IDPaciente=IdPaciente.getText();
			//Recibe el historial medico del paciente
			historial=control.consultaHistorialMedico(IDPaciente);
			//Despliega el historial medico del paciente
			if(historial!=null) {
				panel4.setLayout(new GridLayout(historial.size()+2,3));
				panel4.add(label3);
				panel4.add(label5);
					//Agrega cada linea del historial medico del paciente
					for(int i=0;i<historial.size();i++) {
						panel4.add(new JLabel(""+historial.get(i).getFecha()));
						panel4.add(new JLabel(""+historial.get(i).getObservaciones()));
						}
				panel2.add(panel4);
				botonBuscar.setVisible(false);
				botonLimpiar.setVisible(false);
				}
			else {
				IdPaciente.setText("");
			 }
		}
	  }

	/**
	 * Muestra la ventana de Busqueda Paciente
	 */
	
	public void abre() {
		setVisible(true);
	}

	/* 
	 * Muestra un mensaje de inicio 
	 */
	
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		control.inicia();
	 }

	/**
	 * Cierra la ventana de Busqueda de Paciente
	 */
	
	public void cierra() {
		setVisible(false);
	}
 }