package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private ControlPrincipal control;
	JPanel panel1, panel2, panel3,aux;
	JLabel label1, label2, label3, img;
	JTextField text1,text2;
	JButton botonInicia, botonLimpia, botonSalir, botonCambioContra;
	Choice lista;
	JPasswordField pasw;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	

	public VentanaPrincipal(ControlPrincipal control) throws HeadlessException {
		super("Login");
		this.control=control;
		
		setSize(400,300);
		setLocationRelativeTo(null);
		
		img=new JLabel();
		ImageIcon icon=new ImageIcon(getClass().getResource("/presentacion/login.jpg"));
		Image imagen=icon.getImage();
		ImageIcon icones=new ImageIcon(imagen.getScaledInstance(100,100,imagen.SCALE_SMOOTH));
		img.setIcon(icones);
		img.repaint();
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		aux=new JPanel();
		
		
		label1=new JLabel(dateFormat.format(fecha));
		label2=new JLabel("Usuario");
		label3=new JLabel("Contraseña");

		botonInicia=new JButton("Iniciar Sesion");		
		botonLimpia=new JButton("Limpiar");
		botonSalir=new JButton("Salir");
		botonCambioContra=new JButton("Cambiar contrasena");
		
		text1=new JTextField(50);
		pasw=new JPasswordField(50);
		
		botonInicia.addActionListener(this);
		botonLimpia.addActionListener(this);
		botonSalir.addActionListener(this);
		botonCambioContra.addActionListener(this);
		
		lista = new Choice();
		lista.add("Doctor");
		lista.add("Recepcionista");
		
		panel1.setLayout(new GridLayout(1,3));
		panel1.add(label1);
		panel1.add(aux);
		panel1.add(img);
		
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(label2);
		panel2.add(text1);
		panel2.add(label3);
		panel2.add(pasw);
		panel2.add(botonCambioContra);
		
		//panel3.setLayout(new GridLayout(1,3));
		
		panel3.add(botonLimpia);
		panel3.add(botonInicia);
		panel3.add(botonSalir);
		
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton para inicar la sesión
		if(e.getSource()==botonInicia) {
			//Valida que no alla campos vacios
			if (text1.getText().equals("")||pasw.getPassword().equals("")) {
				JOptionPane.showMessageDialog(this,"Tienes Campos Vacios" );
			}
			else {
				//Se comunica con el respectivo control y verifica de quien se trata un doctor o recepcionista
				String pass=new String(pasw.getPassword());
				String opt=control.login(text1.getText(),pass);
				System.out.println(opt);
				
				if(opt.equals("Doctor")) {
					System.out.println("Entre en doctor");
					setVisible(false);
					control.ventanaDoc();
				}
			
				if(opt.equals("Recepcionista")) {
					setVisible(false);
					control.ventanaRec();
				}
				
				//En caso de ingresar valores no validos se mostrata un mensaje de error
				if(opt.equals("ninguno"))
					JOptionPane.showMessageDialog(this,"Datos Invalidos");
				}
			
			}
		if(e.getSource()==botonLimpia) {
			text1.setText("");
			pasw.setText("");
		}
		if(e.getSource()==botonSalir) {
			control.termina();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		if(e.getSource()==botonCambioContra) {
			setVisible(false);
			control.muestraCambiarContra();
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
