package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.Paciente;
import negocio.dominio.Pago;

public class VentanaFichaMedica extends JFrame implements ItemListener, ActionListener {

	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JLabel label1,label2,label3,label3_1,label4,label5,label6,label7,label8,label9,label10;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
	JCheckBox check1,check2;
	JButton boton1,boton2,boton3;
	
	private ControlFichaMedica control=null;
	ControlVerificacionPago control2;
	private Pago pago = null;
	private Paciente paciente = null;
	
	public VentanaFichaMedica( ControlFichaMedica control, Pago pago, Paciente paciente) throws HeadlessException {
		super("Ficha Medica");
		this.pago = pago;
		this.paciente = paciente;
		this.control=control;
		setSize(500, 350);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		label1=new JLabel("Ficha Médica");
		
		label3=new JLabel("ID paciente");
		label4=new JLabel("Edad");
		label5=new JLabel("Nombre");
		label6=new JLabel("Sexo");
		label7=new JLabel("CURP");
		label8=new JLabel("Fecha de cita");
		label9=new JLabel("Servicio solicitado");
		
		text1=new JTextField(paciente.getId_paciente());
		text2=new JTextField(String.valueOf(paciente.getEdad()));		
		text3=new JTextField(paciente.getNombre() + paciente.getApellido());		
		text4=new JTextField(paciente.getSexo());		
		text5=new JTextField(paciente.getCURP());		
		text6=new JTextField(25);		
		text7=new JTextField(pago.getServicio());

		boton1=new JButton("Cancelar");
		boton2=new JButton("Imprimir");
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(4,4));
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
		panel2.add(label9);
		panel2.add(text7);
		
		panel3.add(boton1);	
		panel3.add(boton2);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			setVisible(false);
		}
		if(e.getSource()==boton2) {
			JOptionPane.showConfirmDialog(null, "Imprimiendo", "Imprimir", 2);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {

	}

}
