package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.acl.Group;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana_agrega_empleado extends JFrame implements ItemListener, ActionListener {
		
		JPanel panel1,panel2,panel3,panel4,panel5,panel6, panelPrincipal, panelDoc, panelRecep, panel7;
		JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11, label12,label13,label14,label15;
		JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12;
		JCheckBox check1,check2;
		JButton boton1,boton2,botonRegistraDoc,botonDoc, botonRecep, botonRegistraRecep;

		
		private Controlagregaempleado control=null;
				
		
		 public Ventana_agrega_empleado( Controlagregaempleado control) throws HeadlessException {
			super("Nuevo EMPLEADO");
			this.control=control;
			setSize(700, 300);
			setLocationRelativeTo(null);
			
			panel1=new JPanel();
			panel2=new JPanel();
			panel3=new JPanel();
			panel4=new JPanel();
			panel5=new JPanel();
			panel6=new JPanel();
			panel7=new JPanel();
			panelPrincipal=new JPanel();
			panelDoc=new JPanel();
			panelRecep=new JPanel();
			
		
			label1=new JLabel("FECHA");
			label2=new JLabel("Imagen ");
			
			label3=new JLabel("Nombre");
			label4=new JLabel("Apellido");
			label5=new JLabel("Dirección");
			label6=new JLabel("e-mail");
			label7=new JLabel("Edad");
			label8=new JLabel("Fecha de ingreso");
			
			label9=new JLabel("Sexo");
			
			label10=new JLabel("horario");
			label11=new JLabel("Datos del Empleado");
			label12=new JLabel("Telefono");
			
			label13=new JLabel("Cedula Profesional:");
			label14=new JLabel("Especidalidad:");
			
			label15=new JLabel("Escolaridad");
			
			
			text1=new JTextField(50);
			text2=new JTextField(50);
			text3=new JTextField(50);
			text4=new JTextField(50);
			text5=new JTextField(50);
			text6=new JTextField(50);
			text7=new JTextField(50);
			text8=new JTextField(50);
			text9=new JTextField(50);
			text10=new JTextField(50);
			text11=new JTextField(50);
			text12=new JTextField(50);
			
			 
			boton1=new JButton("Limpiar  ");
			boton2=new JButton("Cancelar ");
			botonRegistraDoc=new JButton("Registrar");
			botonRegistraRecep=new JButton("Registrar");
			botonDoc=new JButton("Doctor");
			botonRecep=new JButton("Recepcionista");
			
			check1=new JCheckBox("M");
			check2=new JCheckBox("F");
			
			check1.addItemListener(this);
			check2.addItemListener(this);
			
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			botonRegistraDoc.addActionListener(this);
			botonRegistraRecep.addActionListener(this);
			botonDoc.addActionListener(this);
			botonRecep.addActionListener(this);
			
			//Panel Principal
			panelPrincipal.setLayout(new GridLayout(1,2));
			panelPrincipal.add(botonDoc);
			panelPrincipal.add(botonRecep);
			
			
			
			
			
			panel4.setLayout(new GridLayout(2,1));
			panel5.add(label11);
			
			panel1.setLayout(new GridLayout(1,2));
			panel1.add(label1);
			panel1.add(label2);
			
		    panel6.setLayout(new GridLayout(1,2));
			panel6.add(check1);
			panel6.add(check2);
			
			
			
			panelRecep.setLayout(new GridLayout(5,5));
			panelRecep.add(label3);
			panelRecep.add(text1);
			
			panelRecep.add(label4);
			panelRecep.add(text2);
			
			panelRecep.add(label5);
			panelRecep.add(text3);
			
			panelRecep.add(label6);
			panelRecep.add(text4);
			
			panelRecep.add(label7);
			panelRecep.add(text5);
			
			panelRecep.add(label8);
			panelRecep.add(text6);
			
			panelRecep.add(label12);
			panelRecep.add(text9);
			
			panelRecep.add(label15);
			panelRecep.add(text12);
			
			panelRecep.add(label10);
			panelRecep.add(text8);
			
			panelRecep.add(label9);
			panelRecep.add(panel6);
			
			
			
			
			//panel para registrar a recepcionista
			panel7.add(boton1);
			panel7.add(boton2);
			panel7.add(botonRegistraRecep);
			
			panel4.add(panel1);
			panel4.add(panel5);
			
			add(panelPrincipal,BorderLayout.NORTH);
			//add(panelDoc,BorderLayout.CENTER);
			//add(panelRecep,BorderLayout.SOUTH);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==botonDoc) { //muestra ventana para registrar un doctor
				panelPrincipal.setVisible(false);
				//panel para registrar a doctor
				panel2.setLayout(new GridLayout(6,6));
				panel2.add(label3);
				panel2.add(text1);
				
				panel2.add(label4);
				panel2.add(text2);
				
				panel2.add(label5);
				panel2.add(text3);
				
				panel2.add(label6);
				panel2.add(text4);
				
				panel2.add(label7);
				panel2.add(text5);
				
				panel2.add(label8);
				panel2.add(text6);
				
				panel2.add(label12);
				panel2.add(text9);
				
				panel2.add(label13);
				panel2.add(text10);
				
				panel2.add(label10);
				panel2.add(text8);
				
				panel2.add(label9);
				panel2.add(panel6);
				
				panel2.add(label14);
				panel2.add(text11);
				panel3.add(boton1);	
				panel3.add(boton2);
				panel3.add(botonRegistraDoc);
				add(panel4,BorderLayout.NORTH);
				add(panel2,BorderLayout.CENTER);
				add(panel3,BorderLayout.SOUTH);
				panel4.setVisible(true);
				panel2.setVisible(true);
				panel3.setVisible(true);
				
			}
			if(e.getSource()==botonRecep) { //boton que muestra la ventana para agregar un recepcionista
				panelPrincipal.setVisible(false);
				add(panel4,BorderLayout.NORTH);
				add(panelRecep,BorderLayout.CENTER);
				add(panel7,BorderLayout.SOUTH);
				panel4.setVisible(true);
				panelRecep.setVisible(true);
				panel7.setVisible(true);
				
			}
			if(e.getSource()==boton1) { //boton limpiar
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text7.setText("");
				text8.setText("");
				text9.setText("");
				text10.setText("");
				text11.setText("");
				
				
			}
			if(e.getSource()==boton2) { //boton cancelar
				setVisible(false);
			}
			if(e.getSource()==botonRegistraDoc) { //boton para agregar un o una doctora
				
				
				String nombre=text1.getText();
				String apellido=text2.getText();
				String horario=text8.getText();
				String direccion=text3.getText();
				String email=text4.getText();
				String fecha_ingreso=text6.getText();
				String telefono=text9.getText();
				String sexo=null;
				String cedulaProfesional=text10.getText();
				String especialidad=text11.getText();
				int edad=0;

				try { //checa que la edad ingresada sea una edad valida (que sean numeros)
					edad=Integer.parseInt(text5.getText());
					
				}
				catch(Exception r){
					String uax=JOptionPane.showInputDialog("Favor de ingresar una edad valida");
					edad=Integer.parseInt(uax);
				}
				
				/*Revisa que uno de los chebox este seleccionado*/
				if(check1.isSelected()==true) {
				 sexo="M";
				}
				if(check2.isSelected()==true) {
				 sexo="F";
				}
				
				
				/* Llama a control para agregar al doctor
				 * con los datos pasados por el usuario */
				control.agrega_empleadoDoc(nombre, apellido, telefono, direccion, email, edad, fecha_ingreso, sexo, horario, cedulaProfesional, especialidad);
			}
			if(e.getSource()==botonRegistraRecep) { //boton que registra a un o una recepcionista
				String nombre=text1.getText();
				String apellido=text2.getText();
				String horario=text8.getText();
				String direccion=text3.getText();
				String email=text4.getText();
				String fecha_ingreso=text6.getText();
				String telefono=text9.getText();
				String sexo=null;
				String escolaridad=text12.getText();
				int edad=0;
				
				try {//checa que la edad ingresada sea una edad valida (que sean numeros)
					edad=Integer.parseInt(text5.getText());
					
				}
				catch(Exception r){
					String uax=JOptionPane.showInputDialog("Favor de ingresar una edad valida");
					edad=Integer.parseInt(uax);
				}
				
				/*Revisa que uno de los chebox este seleccionado*/
				if(check1.isSelected()==true) {
				 sexo="M";
				}
				if(check2.isSelected()==true) {
				 sexo="F";
				}
				
				/* Llama a control para agregar a la/el recepcionista 
				 * con los datos pasados por el usuario */
				control.agrega_empleadoRecep(nombre, apellido, telefono, direccion, email, edad, fecha_ingreso, sexo, horario, escolaridad);
			}
		}

		@Override // revisa que los echebox no esten vacios
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==check1) {
			if(check1.isSelected()==true) {
				check2.setEnabled(false);
				
			}
			else {
				check2.setEnabled(true);
				
			}
			}
			if(e.getSource()==check2) {
				if(check2.isSelected()==true) {
					check1.setEnabled(false);
					
				}
				else {
					check1.setEnabled(true);
					
				}
				}
			
		}
		
		//metodo para mostrar un mensaje
		public void muestraMensaje(String mensaje){ //mensaje de alerta
			JOptionPane.showMessageDialog(this, mensaje);
		}

	}
