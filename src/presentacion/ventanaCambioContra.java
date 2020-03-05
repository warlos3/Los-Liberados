package presentacion;

/******************************************************************/ 
/* Clase de la ventana para cambiar la contraseña
/* Autor: Ramirez Ortega Omar Daniel  
/* Descripción: Es la ventana que se mostrara para el cambio de contraseña,
 * el usuario podra ingresar su nueva contraseña para poder acceder al login
 * del programa.
/******************************************************************/ 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;
import java.awt.*;

/******************************************************************/ 
/* Contenido del Listado:
/* public void abre()
/* public void exito()
/* public void error()
/******************************************************************/ 

public class ventanaCambioContra extends JFrame implements ActionListener {
	
	private ControlPrincipal control;
	//control nos servira para crear la conexion con el control principal
	
	JPanel panel1, panel2, panel3;
	JLabel label1, label2, label3, label4;
	JTextField text1, text2, text3;
	JButton botonCancelar, botonCambiar;
	
	//Constructor de la clase VentanaCambiarContra y la que crea la ventana
	public ventanaCambioContra(ControlPrincipal control) throws HeadlessException {
		super("Cambiar contraseña");
		this.control = control;
		
		setSize(400,300);
		setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		
		botonCambiar = new JButton("Cambiar");
		botonCancelar = new JButton("Cancelar");
		
		label1 = new JLabel("ID empleado");
		label2 = new JLabel("Nueva contraseña");
		label3 = new JLabel("Repite contraseña");
		label4 = new JLabel("LLena los campos para cambiar la contraseña");
		
		panel1.add(label4);
		
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(label1);
		panel2.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel2.add(label3);
		panel2.add(text3);
		
		botonCancelar.addActionListener(this);
		botonCambiar.addActionListener(this);
		
		panel3.add(botonCancelar);
		panel3.add(botonCambiar);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonCancelar) {
			setVisible(false);
			control.inicia();
		}
		if(e.getSource() == botonCambiar) {
			if(text1.getText().equals("") || text2.getText().equals("") || text3.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Tienes Campos Vacios");
			}
			if(text2.getText().equals(text3.getText())) {
				control.cambiarContra(text1.getText(), text2.getText());
			}
			else {
				JOptionPane.showMessageDialog(this, "La contraseñas no coinciden");
			}
		}
	}
	
	/***************************************************************
	 * Esta funcion hace que la ventana aparezca en la pantalla cuando
	 * el control principal la llama
	 **************************************************************/
	public void abre() {
		setVisible(true);
	}
	
	/***************************************************************
	 * Esta funcion hace que aparezca una ventana con un mensaje de que 
	 * la contraseña se cambio correctamente y aparece la pantalla de login
	 **************************************************************/
	public void exito() {
		JOptionPane.showMessageDialog(this, "Cambio de contraseña correcto");
		control.inicia();
	}
	
	/***************************************************************
	 * Esta funcion hace que aparezca una ventana con un mensaje de error
	 * de que el usuario no se encontro o que hubo un error en la contraseña
	 **************************************************************/
	public void error() {
		JOptionPane.showMessageDialog(this, "Usuario no encontrado");
	}
}
