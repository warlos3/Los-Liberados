package presentacion;

import negocio.dominio.Paciente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaExamenMedico extends JFrame implements ItemListener, ActionListener {

	ControlExamenMedico control;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
	JTextField text1, text2, text3, text4, text5, text6, text7;
	JButton boton1, boton2, boton3, boton4;
	JCheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9, check10;
	JCheckBox check11, check12, check13, check14, check15, check16, check17, check18, check19, check20;
	JCheckBox check21, check22, check23, check24, check25, check26, check27;
	
	public VentanaExamenMedico(ControlExamenMedico control) throws HeadlessException {
		super("Examen Médico");
		this.control=control;
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		
		label1=new JLabel("Examen Médico");
		
		label3=new JLabel("Nombre de paciente");
		label4=new JLabel("Fecha");
		label5=new JLabel("ID paciente");
		label6=new JLabel("Edad");
		label7=new JLabel("Sexo");
		label9=new JLabel("Nombre de doctor");
		label10=new JLabel("Firma: ______________________");
		
		text1=new JTextField(50);
		text2=new JTextField(50);		
		text3=new JTextField(50);		
		text4=new JTextField(50);		
		text5=new JTextField(50);		
		text6=new JTextField("Escribe aquí las discapacidades físicas");		
		text7=new JTextField("Escribe aquí notas importantes");		

		boton1=new JButton("Cancelar");
		boton2=new JButton("Limpiar");
		boton3=new JButton("Imprimir");
		boton4=new JButton("Autollenar");
		
		check1=new JCheckBox("M");
		check2=new JCheckBox("F");
		check7=new JCheckBox("Dolores de cabeza");
		check8=new JCheckBox("Problemas del corazón");
		check9=new JCheckBox("Indigestión Frecuente");
		check10=new JCheckBox("Infección de oído");
		check11=new JCheckBox("Presión Alta");
		check12=new JCheckBox("Hepatitis");
		check13=new JCheckBox("Enfermedad Venéra");
		check14=new JCheckBox("Falta de aire");
		check15=new JCheckBox("Enfermedad de los riñones");
		check16=new JCheckBox("Mareos/Desmayos");
		check17=new JCheckBox("Neumonía");
		check18=new JCheckBox("Limitación Motriz");
		check19=new JCheckBox("Ataques de epilepsia");
		check20=new JCheckBox("Tos crónica");
		check21=new JCheckBox("Tuberculosis");
		check22=new JCheckBox("Falta de visión");
		check23=new JCheckBox("Enfermedad pulmonar");
		check24=new JCheckBox("Diabetes");
		check25=new JCheckBox("Anemia");
		check26=new JCheckBox("Cáncer");
		check27=new JCheckBox("Colesterol alto");
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		
		check1.addItemListener(this);
		check2.addItemListener(this);
		
		panel1.add(label1);

		panel2.setLayout(new GridLayout(4,2));
		panel2.add(label3);
		panel2.add(text1);
		panel2.add(label4);
		panel2.add(text2);
		panel2.add(label5);
		panel2.add(text3);
		panel2.add(label6);
		panel2.add(text4);
		
		panel3.setLayout(new GridLayout(7,3));
		panel3.add(check7);
		panel3.add(check8);
		panel3.add(check9);
		panel3.add(check10);
		panel3.add(check11);
		panel3.add(check12);
		panel3.add(check13);
		panel3.add(check14);
		panel3.add(check15);
		panel3.add(check16);
		panel3.add(check17);
		panel3.add(check18);
		panel3.add(check19);
		panel3.add(check20);
		panel3.add(check21);
		panel3.add(check22);
		panel3.add(check23);
		panel3.add(check24);
		panel3.add(check25);
		panel3.add(check26);
		panel3.add(check27);
		
		panel4.setLayout(new GridLayout(1,3));
		panel4.add(label7);
		panel4.add(check1);
		panel4.add(check2);
		
		panel5.setLayout(new GridLayout(2,1));
		panel5.add(text6);
		panel5.add(text7);
		
		panel6.setLayout(new GridLayout(4,1));
		panel6.add(panel2);
		panel6.add(panel4);
		panel6.add(panel3);
		panel6.add(panel5);
		
		panel7.setLayout(new GridLayout(3,4));
		panel7.add(label9);
		panel7.add(text5);
		panel7.add(label10);
		panel7.add(boton4);
		panel7.add(boton1);
		panel7.add(boton2);
		panel7.add(boton3,3,3);
		
		
		add(panel1,BorderLayout.NORTH);
		add(panel6,BorderLayout.CENTER);
		add(panel7,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void llenaCampos(Paciente paciente) {
		text1.setText(paciente.getNombre() + paciente.getApellido());
		text2.setText(dateFormat.format(fecha));
		text3.setText(paciente.getId_paciente());
		text4.setText(String.valueOf(paciente.getEdad()));
		if("M" == paciente.getSexo()) {
			check1.isSelected();
		}
		else {
			check2.isSelected();
		}
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			setVisible(false);
		}
		if(e.getSource()==boton2) {
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text6.setText("");
			text7.setText("");
		}
		if(e.getSource()==boton3) {
			JOptionPane.showConfirmDialog(null, "Imprimiendo", "Imprimir", 2);
		}
		if(e.getSource()==boton4) {
			String idPaciente;
			idPaciente = JOptionPane.showInputDialog(null, "Ingresa el ID del paciente");
			control.ObtenPaciente(idPaciente);
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
}
