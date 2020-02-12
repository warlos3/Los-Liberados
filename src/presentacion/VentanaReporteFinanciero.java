package presentacion;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Ventana para la generacion del reporte financiero
 * @author Brianda Garcia
 *
 */
public class VentanaReporteFinanciero extends JFrame implements ActionListener {

	JPanel panel1,panel2,panel3;
	JLabel label1;
	JButton botonGenerar,botonCancelar;
	Choice listaMes,listaAno;

	private ControlReporteFinanciero control=null;
	
	String seleccionMes,seleccionAno,periodo;
	
	/**
	 * Constructor
	 * @param control su control
	 */
	public VentanaReporteFinanciero(ControlReporteFinanciero control) throws HeadlessException{
		super("Reporte Financiero");
		this.control=control;
		setSize(500, 200);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		label1=new JLabel("Selecciona el periodo: ");
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
				
		listaMes=new Choice();
		listaAno=new Choice();
		listaMes.addItem("Enero");
		listaMes.addItem("Febrero");
		listaMes.addItem("Marzo");
		listaMes.addItem("Abril");
		listaMes.addItem("Mayo");
		listaMes.addItem("Junio");
		listaMes.addItem("Julio");
		listaMes.addItem("Agosto");
		listaMes.addItem("Septiembre");
		listaMes.addItem("Octubre");
		listaMes.addItem("Noviembre");
		listaMes.addItem("Diciembre");
		listaAno.addItem("2019");
		listaAno.addItem("2020");
		
		botonGenerar=new JButton("Generar");
		botonCancelar=new JButton("Cancelar");
			
		botonGenerar.addActionListener(this);
		botonCancelar.addActionListener(this);

		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(listaAno);
		panel2.add(listaMes);

		panel3.setLayout(new GridLayout(1,2));
		panel3.add(botonCancelar);
		panel3.add(botonGenerar);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonCancelar) {
			setVisible(false);
		}
		if(e.getSource()==botonGenerar) {
			//Obtiene el periodo seleccionado
			seleccionAno=listaAno.getSelectedItem(); 
			seleccionMes=listaMes.getSelectedItem();
			periodo=seleccionMes+("/")+seleccionAno;
			//Consulta el periodo
			control.consultaServicio(periodo);
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