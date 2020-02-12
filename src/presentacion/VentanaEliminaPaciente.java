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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Doctor;
import negocio.dominio.Paciente;
import negocio.dominio.Recepcionista;

public class VentanaEliminaPaciente extends JFrame implements ActionListener, ItemListener { 
	
	
		private ControlEliminaPaciente control=null;
		
		JPanel panel1,panel2,panel3,panel4,panel5,panel6;
		JLabel label1,label2,label3,label4,label5,label6,label7;
		JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
		JCheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10;
		JButton boton1,boton2,boton3;
		
		ArrayList<Paciente> pac;
		
		String [] id;
		
		public VentanaEliminaPaciente(ControlEliminaPaciente control) throws HeadlessException {
			super("Elimina Paciente");
			this.control=control;
			setSize(700,100);
			setLocationRelativeTo(null);
			int aux=100;
			int aux2 = 0;
			
			pac=control.recuperaAllEmpleadosPac();
			
			ArrayList<JCheckBox> check=new ArrayList<JCheckBox>();
			id=new String[pac.size()];
			
			
			panel1=new JPanel();
			panel2=new JPanel();
			panel3=new JPanel();
			panel4=new JPanel();
			
			label1=new JLabel("Elimina Paciente");
			label2=new JLabel("ID");
			label3=new JLabel("Telefono");
			label4=new JLabel("Nombre");
			label6=new JLabel("Curp");
			label5=new JLabel("Opción");
			label7=new JLabel("Tipo");
			

			boton1=new JButton("Cancelar");
			boton2=new JButton("Confirmar");
			
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			
			check1=new JCheckBox();
			check.add(check1);
			check2=new JCheckBox();
			check.add(check2);
			check3=new JCheckBox();
			check.add(check3);
			check4=new JCheckBox();
			check.add(check4);
			check5=new JCheckBox();
			check.add(check5);
			check6=new JCheckBox();
			check.add(check6);
			check7=new JCheckBox();
			check.add(check7);
			check8=new JCheckBox();
			check.add(check8);
			check9=new JCheckBox();
			check.add(check9);
			check10=new JCheckBox();
			check.add(check10);
			
			check1.addActionListener(this);
			check2.addActionListener(this);
			check3.addActionListener(this);
			check4.addActionListener(this);
			check5.addActionListener(this);
			check6.addActionListener(this);
			check7.addActionListener(this);
			check8.addActionListener(this);
			check9.addActionListener(this);
			check10.addActionListener(this);
			
			
			
			panel1.add(label1);
			
			//Etiquetas que corresponden a las campos a mostrar
			panel2.setLayout(new GridLayout(pac.size()+1,6));
			panel2.add(label5);
			panel2.add(label2);
			panel2.add(label4);
			panel2.add(label3);
			panel2.add(label6);
			panel2.add(label7);
			
			
			//Se llenan los datos de los pacientes a mostrar en pantalla de acuerod a la cantidad de empleados recuperados
			if(pac.size()!=0) {
				
			for(int i=0;i<pac.size();i++) {
				aux+=100;
				id[i]=pac.get(i).getId_paciente();
				panel2.add(check.get(i));
				panel2.add(new JLabel(""+pac.get(i).getId_paciente()));
				panel2.add(new JLabel(""+pac.get(i).nombre+" "+pac.get(i).apellido));
				panel2.add(new JLabel(""+pac.get(i).getTelefono()));
				panel2.add(new JLabel(""+pac.get(i).getCURP()));
				panel2.add(new JLabel("Paciente"));
				aux2++;
				}
			/*
			for(int j=0;j<recp.size();j++) {
				aux+=100;
				id[aux2]=recp.get(j).getId_empleado();
				panel2.add(check.get(aux2));
				panel2.add(new JLabel(""+recp.get(j).getId_empleado()));
				panel2.add(new JLabel(""+recp.get(j).nombre+" "+recp.get(j).apellido));
				panel2.add(new JLabel(""));
				panel2.add(new JLabel("Recepcionista"));
				aux2++;
				}
			
			
			
			}
			else {
			for(int j=0;j<recp.size();j++) {
				aux+=100;
				id[j]=recp.get(j).getId_empleado();
				panel2.add(check.get(j));
				panel2.add(new JLabel(""+recp.get(j).getId_empleado()));
				panel2.add(new JLabel(""+recp.get(j).nombre+" "+recp.get(j).apellido));
				panel2.add(new JLabel(""));
				panel2.add(new JLabel("Recepcionista"));
				
				}*/
			}
			
			setSize(500,aux);
			panel3.add(boton1);
			panel3.add(boton2);
			
			add(panel1,BorderLayout.NORTH);
			add(panel2,BorderLayout.CENTER);
			add(panel3,BorderLayout.SOUTH);

			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}




		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==boton1) {
				setVisible(false);
			}
			if(e.getSource()==boton2) {
				int opt=0;
				//En caso de no seleccionar algun empleado se muestra un mensaje de error
				if(check1.isSelected()==false && check2.isSelected()==false && check3.isSelected()==false && check4.isSelected()==false && check5.isSelected()==false && check6.isSelected()==false && check7.isSelected()==false && check8.isSelected()==false && check9.isSelected()==false && check10.isSelected()==false && check1.isSelected()==false )
					JOptionPane.showMessageDialog(this, "No has selecionado al paciente");
				else {
					//se verifica a que el paciente fue seleccionado
				if(check1.isSelected()==true )
					opt=0;
				if(check2.isSelected()==true)
					opt=1;
				if(check3.isSelected()==true)
					opt=2;
				if(check4.isSelected()==true )
					opt=3;
				if(check5.isSelected()==true )
					opt=4;
				if(check6.isSelected()==true )
					opt=5;
				if(check7.isSelected()==true )
					opt=6;
				if(check8.isSelected()==true )
					opt=7;
				if(check9.isSelected()==true )
					opt=8;
				if(check10.isSelected()==true)
					opt=9;
				//Mensaje de confirmacion de eliminar paciente
				if(JOptionPane.showConfirmDialog(this, "Seguro que quieres eliminar al paciente")==0) {
					control.eliminaPaciente(id[opt]);
				}
				else {
					setVisible(false);
				}
				}
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



