package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;
import java.awt.*;

public class VentanaCambiarContra extends JFrame implements ActionListener {
	
	private ControlPrincipal control;
	
	JPanel panel1, panel2, panel3;
	JLabel label1, label2, label3, label4;
	JTextField text1, text2, text3;
	JButton botonCancelar, botonCambiar;
	
	public VentanaCambiarContra(ControlPrincipal control) throws HeadlessException {
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
	
	public void abre() {
		setVisible(true);
	}
	
	public void exito() {
		JOptionPane.showMessageDialog(this, "Cambio de contraseña correcto");
	}
	
	public void error() {
		JOptionPane.showMessageDialog(this, "Usuario no encontrado");
	}
}