package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRecepcionista extends JFrame implements ActionListener{

	private ControlPrincipal control;
	
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,aux,panelif;
	JLabel label1,label3,label4,label5,img;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8;
	JCheckBox check1,check2;
	JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11,boton12,boton13,boton14;
	JButton botonElimPaciente, botonServicios;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	

	public VentanaRecepcionista(ControlPrincipal control) throws HeadlessException {
		super("Recepcionista");
		this.control=control;
		
		setSize(300, 400);
		setLocationRelativeTo(null);
		
		img=new JLabel();
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/recep.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		img.setIcon(icones);
		img.repaint();
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		aux=new JPanel();
		panelif=new JPanel();
		
		label1=new JLabel(dateFormat.format(fecha));
		
		boton10=new JButton(" Pacientes");
		boton11=new JButton(" Empleados");
		boton12=new JButton(" Otros ");
		
		boton1=new JButton("    Nuevo Paciente    ");		
		boton3=new JButton("              Citas              ");
		boton4=new JButton("       Verifica Pago      ");
		botonElimPaciente=new JButton("    Elimina Paciente    ");
		
		boton6=new JButton("  Agrega Empleado  ");
		boton7=new JButton("  Elimina Empleado  ");
		boton8=new JButton("          Horarios            ");
		
		boton9=new JButton("Reporte Financiero");
		botonServicios=new JButton("         Servicios         ");
		boton13=new JButton("Regresar");
		boton14=new JButton("Cerrar Sesion");
		
		boton1.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton6.addActionListener(this);
		boton7.addActionListener(this);
		boton8.addActionListener(this);
		boton9.addActionListener(this);
		boton10.addActionListener(this);
		boton11.addActionListener(this);
		boton12.addActionListener(this);
		boton13.addActionListener(this);
		boton14.addActionListener(this);
		botonElimPaciente.addActionListener(this);
		botonServicios.addActionListener(this);
		panel1.setLayout(new GridLayout(1,3));
		panel1.add(label1);
		panel1.add(aux);
		panel1.add(img);
		
		
		//panel de pacientes
		panel3.setLayout(new FlowLayout());
		panel3.add(boton1);
		panel3.add(boton3);
		panel3.add(boton4);
		panel3.add(botonElimPaciente);
		
		//panel de empleados
		panel4.setLayout(new FlowLayout());
		panel4.add(boton6);
		panel4.add(boton7);
		panel4.add(boton8);
		
		//panel de finansas
		panel5.setLayout(new FlowLayout());
		panel5.add(boton9);
		panel5.add(botonServicios);
		
		//panel de opciondes de la recepcionista
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(boton10);
		panel2.add(boton11);
		panel2.add(boton12);

		panelif.add(boton14);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panelif,BorderLayout.SOUTH);

	}

	/*
	 *Acciones de los botones
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		//Opciones correspondientes a los pacientes
		if(e.getSource()==boton10) {
			
			panel2.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			panelif.setVisible(false);
			
			add(panel3,BorderLayout.CENTER);
			aux.add(boton13);
			add(aux,BorderLayout.SOUTH);
			panel3.setVisible(true);
			aux.setVisible(true);
		}
		//Opciones correspondientes a los empleados
		if(e.getSource()==boton11) {
			
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel5.setVisible(false);
			panelif.setVisible(false);
			
			add(panel4,BorderLayout.CENTER);
			aux.add(boton13);
			add(aux,BorderLayout.SOUTH);
			panel4.setVisible(true);
			aux.setVisible(true);
			
		}
		//Opciones correspondientes a las finazas
		if(e.getSource()==boton12) {
			
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panelif.setVisible(false);
			
			add(panel5,BorderLayout.CENTER);
			aux.add(boton13);
			add(aux,BorderLayout.SOUTH);
			panel5.setVisible(true);
			aux.setVisible(true);
	
		}
		if(e.getSource()==boton13) {
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			aux.setVisible(false);
			
			panel2.setVisible(true);
			panelif.setVisible(true);
		}
		
		//Boton nuevo pacinete que se comunica con su respectivo control
		if(e.getSource()==boton1) {
			control.nuevo_paciente();
		}
		//Boton que muestra el listado de las citas actuales
		if(e.getSource() == boton3) {
					control.muestraCitas();
		}
		//Boton para verificacion de pago que se comunica con su respectivo control
		if(e.getSource()==boton4) {
			control.verificaPago();
		}
		if(e.getSource()==botonElimPaciente) {
			control.eliminaPaciente();
		}
		//Boton nuevo empleado que se comunica con su respectivo control
		if (e.getSource()==boton6) {
			control.agrega_emplado();
		}
		
		//Boton elimina empleado que se comunica con su respectivo control
		if(e.getSource()==boton7) {
			control.eliminaEmpleado();
		}
		if(e.getSource()==boton8) {
			control.buscaHorario();
		}
		
		//Boton reporte financiero que se comunica con su respectivo control
		if(e.getSource()==boton9) {
			control.reporteFinanciero();
		}
		
		//Boton para cerra sesion y regresar a la ventana de login
		if(e.getSource()==boton14) {
			setVisible(false);
			control.inicia();
		}
		
		//boton para mostrar los servicios que se imparten
		if(e.getSource()==botonServicios) {
			control.muestraServicios();
		}

	}
	
	
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}
	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}

}
