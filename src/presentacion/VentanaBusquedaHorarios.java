/*
 Programa: Ventana Busqueda De Horarios 
 Autor: Ramirez Cordero Joselyn
 Descripción: Crea la venta en la que se muestra lo que puedo hacer el programa*/ 

/* Contenido en listado (Metodos)
 * public VentanaBusquedaHorarios(ControlBuquedaHorarios control) throws HeadlessException
 * public void itemStateChanged(ItemEvent arg0)
 * public void actionPerformed(ActionEvent e)
 * public void abre()
 * public void cierra() 
 * public void muestraMensaje(String mensaje){
 */
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
import negocio.dominio.Recepcionista;

public class VentanaBusquedaHorarios extends JFrame implements ActionListener, ItemListener {
	
	private ControlBuquedaHorarios control=null;
		
	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
	JCheckBox check1,check2,check3,check4,check5,check6,check7,check8,check9,check10;
	JButton boton1,boton2,boton3;
		
	//Lista del Doctor y Recepcionista
	
	ArrayList<Doctor> doc;
	ArrayList<Recepcionista> recp;
	String [] id;
		
	
		//Diseño de la Ventana de Busqueda Horarios
	
		public VentanaBusquedaHorarios(ControlBuquedaHorarios control) throws HeadlessException {
				super("Busca horarios ");
				this.control=control;
				setSize(700,100);
				setLocationRelativeTo(null);
				int aux=100;
				int aux2 = 0;
				
			    // Recupera un Listado de empleados
				doc=control.recuperaAllEmpleadosDoc();
				recp=control.recuperaAllEmpleadosRec();
			
				ArrayList<JCheckBox> check=new ArrayList<JCheckBox>();
				
				// el indentificador del doctor y recpcionista
				id=new String[doc.size()+recp.size()];
			
				// Se crrean las etiquedas de los datos solocitados 
				panel1=new JPanel();
				panel2=new JPanel();
				panel3=new JPanel();
				panel4=new JPanel();
			
				label1=new JLabel("Busqueda Horarios");
				label2=new JLabel("ID");
				label3=new JLabel("Nombre");
				label4=new JLabel("Horario");
				label5=new JLabel("Tipo");

				// Botones para regresar a la ventana, del recepcionista 
				boton1=new JButton("Regresar");
				boton1.addActionListener(this);
						
				panel1.add(label1);
			
			   //Etiquetas que corresponden a las campos a mostrar en la pantalla
				panel2.setLayout(new GridLayout(doc.size()+recp.size()+1,4));
				panel2.add(label2);
				panel2.add(label3);
				panel2.add(label4);
				panel2.add(label5);
			
				/*Se llenan los datos de los empleados a mostrar en pantalla de acuerdo a la cantidad de empleados recuperados 
				  y verifica que los campos no esten vacios */
				if(doc.size()!=0) {
				
					for(int i=0;i<doc.size();i++) {
						aux+=100;
						id[i]=doc.get(i).getId_empleado();
						panel2.add(new JLabel(""+doc.get(i).getId_empleado()));
						panel2.add(new JLabel(""+doc.get(i).nombre+" "+doc.get(i).apellido));
						panel2.add(new JLabel(""+doc.get(i).getHorario()));
						panel2.add(new JLabel("Doctor"));
						aux2++;
					}
			
					for(int j=0;j<recp.size();j++) {
						aux+=100;
						id[aux2]=recp.get(j).getId_empleado();
						panel2.add(new JLabel(""+recp.get(j).getId_empleado()));
						panel2.add(new JLabel(""+recp.get(j).nombre+" "+recp.get(j).apellido));
						panel2.add(new JLabel(""+doc.get(j).getHorario()));
						panel2.add(new JLabel("Recepcionista"));
						aux2++;
					}
			
			
			
				}
				
				else {
					
					for(int j=0;j<recp.size();j++) {
						aux+=100;
						id[j]=recp.get(j).getId_empleado();
						panel2.add(new JLabel(""+recp.get(j).getId_empleado()));
						panel2.add(new JLabel(""+recp.get(j).nombre+" "+recp.get(j).apellido));
						panel2.add(new JLabel(""));
						panel2.add(new JLabel("Recepcionista"));
				
					}
				}
			
				setSize(500,aux);
				panel3.add(boton1);
				
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
