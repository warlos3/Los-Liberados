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
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
	JLabel label1,label2,label3,label4,label6,label7;
	JLabel label8,label9,label10,label11,label12,label13,label14;
	JButton botonRegresa;
	JTextField text1;
	ArrayList<Consulta> servicios;
	String [] id;
	
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
		label1=new JLabel("Servicios");
		label2=new JLabel("IDServicio");
		label3=new JLabel("Servicio");
		label4=new JLabel("Costo");


		botonRegresa=new JButton("Regresar");
		botonRegresa.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(servicios.size()+1,4));
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		
		/*Si se encontraron citas entonces se añaden al panel para mostrarlo despues*/
		if(servicios.size()!=0) {
			
			for(int i=0;i<servicios.size();i++) {
				aux+=100;
				id[i]=servicios.get(i).getIDConsulta();
				panel2.add(new JLabel("     "+servicios.get(i).getIDServicio()));
				panel2.add(new JLabel(""+servicios.get(i).getTipoServicio()));
				panel2.add(new JLabel(""+servicios.get(i).getCosto()));
				}
		}
		
		setSize(500,aux);
		panel3.add(botonRegresa);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==botonRegresa) {
			setVisible(false);
		}
		
	}
	
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}

}
