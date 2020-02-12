package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.dominio.HistorialMedico;

/**
 * Ventana de consulta de historial medico de un paciente
 * @author Brianda Garcia
 *
 */
public class VentanaBusquedaPaciente extends JFrame implements ActionListener{
	
	JPanel panel1,panel2,panel3,panel4;
	JLabel label1,label2,label3,label5;
	JTextField IdPaciente;
	JButton botonBuscar,botonLimpiar,botonCancelar;

	private ControlBusquedaPaciente control=null;
	
	ArrayList<HistorialMedico> historial;
	
	/**
	 * Constructor
	 * @param control control de la busqueda de historial medico
	 * @throws HeadlessException
	 */
	public VentanaBusquedaPaciente(ControlBusquedaPaciente control) throws HeadlessException {
		super("Busca Paciente");
		this.control=control;
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		
		label1=new JLabel("Busqueda de Paciente");
		label2=new JLabel("ID Paciente");
		label3=new JLabel("Fecha");
		label5=new JLabel("Observaciones");
		
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
		label2.setFont(new Font("Arial Black", Font.BOLD, 20));
		label3.setFont(new Font("Arial Black", Font.BOLD, 15));
		label5.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		IdPaciente=new JTextField(10);
		
		botonBuscar=new JButton("Buscar");
		botonLimpiar=new JButton("Limpiar");
		botonCancelar=new JButton("Cancelar");
	
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.add(label2);
		panel2.add(IdPaciente);

		panel3.add(botonBuscar);	
		panel3.add(botonLimpiar);
		panel3.add(botonCancelar);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonLimpiar) {
			IdPaciente.setText("");
			
		}
		if(e.getSource()==botonCancelar) {
			setVisible(false);
		}
		if(e.getSource()==botonBuscar) {
			String IDPaciente=IdPaciente.getText();
			//Recibe el historial medico
			historial=control.consultaHistorialMedico(IDPaciente);
			//Despliega el historial medico
			if(historial!=null) {
				panel4.setLayout(new GridLayout(historial.size()+2,3));
				panel4.add(label3);
				panel4.add(label5);
				//Agrega cada linea del historial medico 
				for(int i=0;i<historial.size();i++) {
					panel4.add(new JLabel(""+historial.get(i).getFecha()));
					panel4.add(new JLabel(""+historial.get(i).getObservaciones()));
				}
				panel2.add(panel4);
				botonBuscar.setVisible(false);
				botonLimpiar.setVisible(false);
			}
			else {
				IdPaciente.setText("");
			}
		}
	}

	/**
	 * Muestra la ventana
	 */
	public void abre() {
		setVisible(true);
	}

	/**
	 * Muestra un mensaje
	 * @param mensaje el mensaje a mostrar
	 */
	public void muestraMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		control.inicia();
	}

	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
}