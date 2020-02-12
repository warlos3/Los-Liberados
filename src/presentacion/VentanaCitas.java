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
import negocio.dominio.Paciente;

public class VentanaCitas extends JFrame implements ActionListener , ItemListener {

	private ControlCitas control=null;
	
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JLabel label8,label9,label10,label11,label12,label13,label14;
	JButton boton1,boton2, boton3, boton4;
	JTextField text1;
	ArrayList<Consulta> citas;
	String [] id;
	
	public VentanaCitas(ControlCitas control) throws HeadlessException {
		super("Informacion de Citas");
		this.control = control;
		setSize(700,100);
		setLocationRelativeTo(null);
		int aux=100;
		int aux2=0;
		
		citas=control.recuperaAllCitas();
		id=new String[citas.size()];
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		/*etiquetas de los campos a mostrar*/
		label1=new JLabel("Citas");
		label2=new JLabel("IDCita");
		label3=new JLabel("Fecha");
		label4=new JLabel("Hora");
		label5=new JLabel("Tipo de Consulta");

		boton1=new JButton("Regresar");
		boton1.addActionListener(this);
		boton2=new JButton("Buscar cita");
		boton2.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(citas.size()+1,5));
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		
		/*Si se encontraron citas entonces se añaden al panel para mostrarlo despues*/
		if(citas.size()!=0) {
			
			for(int i=0;i<citas.size();i++) {
				aux+=100;
				id[i]=citas.get(i).getIDConsulta();
				panel2.add(new JLabel(""+citas.get(i).getIDConsulta()));
				panel2.add(new JLabel(""+citas.get(i).getFecha()));
				panel2.add(new JLabel(""+citas.get(i).getHora()));
				panel2.add(new JLabel(""+citas.get(i).getTipo_de_servicio()));
				aux2++;
				}
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			setVisible(false);
		}	
		if(e.getSource()==boton2) {
			boton3 = new JButton("Regresar");
			boton3.addActionListener(this);
			boton4 = new JButton("Buscar");
			boton4.addActionListener(this);
			panel4=new JPanel();
			panel5=new JPanel();
			label6=new JLabel("Inserta ID cita");
			text1=new JTextField();
			
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			
			panel4.setLayout(new GridLayout(1,2));
			panel4.add(label6);
			panel4.add(text1);
			
			panel5.add(boton3);
			panel5.add(boton4);
			
			add(panel4,BorderLayout.NORTH);
			add(panel5,BorderLayout.SOUTH);
			setVisible(true);
		}
		if(e.getSource()==boton3) {
			//setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			panel6.setVisible(false);
			panel7.setVisible(false);
			panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			add(panel3,BorderLayout.SOUTH);
			setVisible(true);
		}
		if(e.getSource()==boton4) {
			String idPaciente;
			idPaciente = text1.getText();
			control.verificaCita(idPaciente);
		}
	}
	
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}
	
	//Avisa que el paciente no tiene citas
	public void ventanaError(ControlCitas control) {
		this.control = control;
		JOptionPane.showMessageDialog(null, "No tiene ninguna cita");
	}
	
	//La ventana mostrara la informacion de la cita que se busco
	public void ventanaExito(ControlCitas control, Consulta cita, Paciente paciente) {
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6=new JPanel();
		panel7=new JPanel();
		label7=new JLabel("Paciente");
		label12=new JLabel("Consulta");
		label13=new JLabel("Fecha");
		label14=new JLabel("Hora");
		label8=new JLabel(cita.getIDConsulta());
		label9=new JLabel(cita.getFecha());
		label10=new JLabel(cita.getHora());
		label11=new JLabel(paciente.getNombre());
		panel6.setLayout(new GridLayout(4,2));
		panel6.add(label12);
		panel6.add(label8);
		panel6.add(label13);
		panel6.add(label9);
		panel6.add(label14);
		panel6.add(label10);
		panel6.add(label7);
		panel6.add(label11);
		panel7.add(boton3);
		
		add(panel6,BorderLayout.CENTER);
		add(panel7,BorderLayout.SOUTH);
		
	}
	
}