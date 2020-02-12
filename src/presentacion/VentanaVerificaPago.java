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

public class VentanaVerificaPago extends JFrame implements ItemListener, ActionListener {

	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JLabel label1,label2,label3,label3_1,label4,label5,label6,label7,label8,label9,label10,label11;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
	JCheckBox check1,check2;
	JButton boton1,boton2,boton3;
	
	private ControlVerificacionPago control=null;
	private ControlFichaMedica control2=new ControlFichaMedica(null);
	private Pago pago = null; //Nos servira para almacenar el objeto recuperado de tipo pago
	private Paciente paciente = null; //Nos servira para almacenar el objeto recuperado de tipo paciente
	
	public VentanaVerificaPago( ControlVerificacionPago control) throws HeadlessException {
		super("Verificación de pago");
		this.control=control;
		setSize(350, 200);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		label2=new JLabel("Verificación del pago");
		
		label3=new JLabel("Ingresa el ID de pago");
		
		text1=new JTextField(50);		

		boton1=new JButton("Cancelar");
		boton2=new JButton("Verificar");
		
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		
		panel1.add(label2);
		
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(label3);
		panel2.add(text1);
		
		panel3.add(boton1);	
		panel3.add(boton2);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//Ventana que se muestra si el pago fue encontrado y decide generar la ficha medica
	public void ventanaExito(ControlVerificacionPago control, Pago pago, Paciente paciente) {
		this.control = control;
		this.pago = pago;
		this.paciente = paciente;
		//Si se desea generar la ficha medica, manda a llamar al control de ControlFichaMedica
		//para que ahora el tenga el control, pasando el objeto pago y paciente
		if(JOptionPane.showConfirmDialog(this, "¿Deseas generar la Ficha Médica?") == 0) {
			control2.inicia(pago, paciente);
		}
	}

	//Ventana que se muestra si el no pago fue encontrado
	public void ventanaError(ControlVerificacionPago control) {
		this.control = control;
		JOptionPane.showMessageDialog(null, "Pago no encontrado");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			setVisible(false);
		}
		if(e.getSource()==boton2) {
			int idPago=0;
			//Es para verificar que lo que ingrese el usuario sea entero
			try {
				idPago=Integer.parseInt(text1.getText());
			}
			catch(Exception r){
				String aux = JOptionPane.showInputDialog("Error, el id corresponde a números");
				idPago=Integer.parseInt(aux);
			}
			control.verificaPago(idPago);
			
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {

	}
}
