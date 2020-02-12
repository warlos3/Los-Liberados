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
	
public class VentanaDoctor extends JFrame implements ActionListener{

		private ControlPrincipal control;
	
		JPanel panel1, panel2, panel3;
		JLabel label1,img;
		JButton boton1,boton2,boton3,boton4, boton5;
		Date fecha=new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		

		public VentanaDoctor(ControlPrincipal control) throws HeadlessException {
			super("Doctor");
			this.control=control;
			
			setSize(300, 400);
			setLocationRelativeTo(null);
			
			panel1=new JPanel();
			panel2=new JPanel();
			panel3=new JPanel();
			
			label1=new JLabel(dateFormat.format(fecha));
			img=new JLabel();
			ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/doctor.jpg"));
			Image imagen=icon.getImage();
			ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
			img.setIcon(icones);
			img.repaint();
			
			boton1=new JButton("Historial Medico");
			boton2=new JButton("Examen Medico");
			boton3=new JButton("Reporte Medico");
			boton4=new JButton("Pase de Especialidad");
			
			boton5=new JButton("Cerrar Sesion");
			
			boton1.addActionListener(this);
			boton2.addActionListener(this);
			boton3.addActionListener(this);
			boton4.addActionListener(this);
			boton5.addActionListener(this);

			panel1.setLayout(new GridLayout(1,2));
			panel1.add(label1);
			panel1.add(img);
			
			panel2.setLayout(new GridLayout(4,1));
			panel2.add(boton1);
			panel2.add(boton2);
			panel2.add(boton3);
			panel2.add(boton4);
			
			panel3.setLayout(new FlowLayout());
			panel3.add(boton5);

			
			add(panel1,BorderLayout.NORTH);
			add(panel2,BorderLayout.CENTER);
			add(panel3,BorderLayout.SOUTH);



		
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==boton1) {
				control.busquedaPaciente();
			}
			if(e.getSource()==boton2) {
				control.generaExamenMedico();
			}
			if(e.getSource()==boton4) {
				control.generaPase();
			}
			if(e.getSource()==boton5) {
				setVisible(false);
				control.inicia();
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
