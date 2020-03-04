/* Programa: VentanaGeneraEspecialidad */ 
/* Autor: Ximena */ 
/* Descripción:  en esta clase se programa el diseño de la interfaz, como darle acciones a los botones, tamaño y posicion en la que 
 * cada parte de la interfaz debe de estar
 *  */

/* Contenido del Listado: 
 * VentanaGeneraEspecialidad()
 * paint()
 * actionPerformed()
 * muestraMensaje()
 * abre()
 * cierra()
 */


package presentacion;
import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;

public class VentanaGeneraEspecialidad extends JFrame implements ActionListener{
	
	//se declaran las variables
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JTextField text1,text2,text3,text4,text5;
	private JButton boton1, boton2, boton3;
	private JPanel panel1, panel2, panel3;
	
	private ControlGeneraEspecialidad control=null;
	
	//metodo que se encarga del diseño de la interfaz Genera Especialidad
	public VentanaGeneraEspecialidad(ControlGeneraEspecialidad control) throws HeadlessException {
		super("Generacion de Pase de Especialidad");
		this.control=control;
		setSize(450,450);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		label1 = new JLabel("Pase de Especialidad");
		
		label2 = new JLabel("No. de Paciente: ");
		label3 = new JLabel("Nombre de Paciente: ");
		label4 = new JLabel("CURP: ");
		label5 = new JLabel("Especialidad: ");
		label6 = new JLabel("Nombre Doctor: ");
		label7 = new JLabel("Firma del doctor: ");
		
		label1.setBounds(150, 10, 150, 50); 
		label2.setBounds(10, 20, 200, 150);
		label3.setBounds(10, 23, 200, 200);
		label4.setBounds(10, 29, 200, 250);
		label5.setBounds(10, 34, 200, 300);
		label6.setBounds(10, 38, 200, 350);
		label7.setBounds(10, 100, 200, 400);
		
		text1=new JTextField(50);
		text2=new JTextField(50);
		text3=new JTextField(50);
		text4=new JTextField(50);
		text5=new JTextField(50);
		
		text1.setBounds(170,85,200,20);
		text2.setBounds(170,115,200,20);
		text3.setBounds(170,145,200,20);
		text4.setBounds(170,175,200,20);
		text5.setBounds(170,205,200,20);
		
		boton1 = new JButton("Cancelar");
		boton2 = new JButton("Imprimir");
		boton3 = new JButton("Auto-Llenar");
		boton1.setBounds(180,350,100,30);
		boton1.addActionListener(this);
		boton2.setBounds(310,350,100,30);
		boton2.addActionListener(this);
		boton3.setBounds(50,350,100,30);
		boton3.addActionListener(this);
		
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(label1);
		
		add(text1);
		add(text2);
		add(text3);
		add(text4);
		add(text5);
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		
		
		
		
		
		
		
		panel3.setLayout(new GridLayout(1,3));
		panel3.add(boton1);
		panel3.add(boton2);
		panel3.add(boton3);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
    public void paint(Graphics g){
       super.paint(g);
       g.drawLine(380, 340, 150, 340);
       g.dispose();
    }
       
	@Override
	public void actionPerformed(ActionEvent e) { //metodo que en el que se le dan acciones a los botones
		if(e.getSource() == boton1) {
			setVisible(false);
		}
		
		if(e.getSource()==boton2) {
			String idPaciente=text1.getText();
			String nombre=text2.getText();
			String CURP=text3.getText();
			String especialidad=text4.getText();
			String nombreDoc=text5.getText();	
			control.verificaImprime(idPaciente, nombre, CURP, especialidad, nombreDoc);
		}
		
		if(e.getSource() == boton3) {
			String idPaciente=text1.getText();
			String nombre=null;
			String CURP=null;

			if (control.verificaID(idPaciente)) {
				nombre = control.dameNombrePaciente(idPaciente);
				CURP = control.dameCURPPaciente(idPaciente);
				text2.setText(nombre);
				text3.setText(CURP);
			}
		}
	}
	
	public void muestraMensaje(String mensaje){ //metodo que muestra mensaje de alerta
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public void abre() {
		setVisible(true);		
	}
	public void cierra() {
		setVisible(false);
	}
}


