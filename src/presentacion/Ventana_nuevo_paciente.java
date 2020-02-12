package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Ventana_nuevo_paciente extends JFrame implements ItemListener, ActionListener {
	
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,aux;
	JLabel label1,label2,label3,label3_1,label4,label5,label6,label7,label8,label9,label10,label11;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
	JCheckBox check1,check2;
	JButton boton1,boton2,boton3;
	ImageIcon icon;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private ControlNuevoPpaciente control=null;
	

	
	
	 public Ventana_nuevo_paciente( ControlNuevoPpaciente control) throws HeadlessException {
		super("Nuevo Paciente");
		this.control=control;
		setSize(700, 400);
		setLocationRelativeTo(null);
		
		label2=new JLabel();
		icon=new ImageIcon(getClass().getResource("/presentacion/recep.png"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		label2.setIcon(icones);
		label2.repaint();
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		aux=new JPanel();	
		label1=new JLabel(dateFormat.format(fecha));

		
		label3=new JLabel("Nombre ");
		label3_1=new JLabel("Apellido");
		label4=new JLabel("Telefono");
		label5=new JLabel("Dirección");
		label6=new JLabel("e-mail");
		label7=new JLabel("Edad");
		label8=new JLabel("Fecha de nacimiento");
		
		label9=new JLabel("Sexo");
		
		label10=new JLabel("CURP");
		label11=new JLabel("Datos del Paciente");
		
		
		text1=new JTextField(50);
		text2=new JTextField(50);
		text3=new JTextField(50);
		text4=new JTextField(50);
		text5=new JTextField(50);
		text6=new JTextField(50);
		text7=new JTextField(50);
		text8=new JTextField(50);
		text9=new JTextField(50);
		
		 
		boton1=new JButton("Limpiar  ");
		boton2=new JButton("Cancelar ");
		boton3=new JButton("Registrar");
		
		check1=new JCheckBox("M");
		check2=new JCheckBox("F");
		
		check1.addItemListener(this);
		check2.addItemListener(this);
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		

		panel4.setLayout(new GridLayout(2,1));
		panel5.add(label11);
		
		panel1.setLayout(new GridLayout(1,3));
		panel1.add(label1);
		panel1.add(aux);
		panel1.add(label2);
		
	    panel6.setLayout(new GridLayout(1,2));
		panel6.add(check1);
		panel6.add(check2);
		
		panel2.setLayout(new GridLayout(5,5));
		
		panel2.add(label3);
		panel2.add(text1);
		
		panel2.add(label3_1);
		panel2.add(text9);
		
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
		
		panel2.add(label9);
		panel2.add(panel6);
		
		panel2.add(label10);
		panel2.add(text8);

		panel3.add(boton1);	
		panel3.add(boton2);
		panel3.add(boton3);
		
		
		panel4.add(panel1);
		panel4.add(panel5);
		add(panel4,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");
			text6.setText("");
			text7.setText("");
			text8.setText("");
			
			
			
		}
		if(e.getSource()==boton2) {
			setVisible(false);
		}
		if(e.getSource()==boton3) {
			
			
			String nombre=text1.getText();
			String telefono=text2.getText();
			String direccion=text3.getText();
			String email=text4.getText();
			String fecha_nacimiento=text6.getText();
			String curp=text8.getText();
			String sexo=null;
			String apellido=text9.getText();
			int edad=0;

			try {
				edad=Integer.parseInt(text5.getText());
				
			}
			catch(Exception r){
				String uax=JOptionPane.showInputDialog("Favor de ingresar una edad valida");
				edad=Integer.parseInt(uax);
			}
			
			
			if(check1.isSelected()==true) {
			 sexo="M";
			}
			if(check2.isSelected()==true) {
			 sexo="F";
			}
			
			
			
			control.nuevo_paciente(nombre,apellido, telefono, direccion, email, edad, fecha_nacimiento, sexo, curp);
		}
	}

	@Override
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
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}
	
	public void muestraMensaje(String mensaje){
        
		JOptionPane.showMessageDialog(this, mensaje);
	}
	public int muestraMensaje2(String mensaje){

		return JOptionPane.showConfirmDialog(this,mensaje);
	}
}
