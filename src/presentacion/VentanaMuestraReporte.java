package presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.dominio.Reporte;

/**
 * Ventana que despliega el reporte financiero generado
 * @author Brianda Garcia
 *
 */
public class VentanaMuestraReporte extends JFrame implements ActionListener{

	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	JButton botonImprimir;
	Date fecha=new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	int total=0;

	private ControlReporteFinanciero control=null;
	
	/**
	 * Constructor
	 * @param control su control
	 * @param reporte reporte a desplegar
	 * @param periodo periodo del reporte generado
	 * @throws HeadlessException
	 */
	public VentanaMuestraReporte(ControlReporteFinanciero control, ArrayList<Reporte> reporte, String periodo) throws HeadlessException {
		super("Reporte Generado");
		this.control=control;
		setSize(400, 500);
		setLocationRelativeTo(null);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		
		label8=new JLabel(dateFormat.format(fecha));
		label8.setFont(new Font("Arial Black", Font.BOLD, 13));
		label1=new JLabel("Informe Cruz Roja");
		label1.setFont(new Font("Arial Black", Font.BOLD, 25));
		label2=new JLabel("Periodo:  "+periodo);
		label2.setFont(new Font("Arial Black", Font.BOLD, 15));
		label3=new JLabel("Numero de acciones:  "+reporte.size());
		label3.setFont(new Font("Arial Black", Font.BOLD, 15));
		label4=new JLabel("Servicios:");
		label4.setFont(new Font("Arial Black", Font.BOLD, 15));
		label6=new JLabel("Tipo");
		label6.setFont(new Font("Arial Black", Font.BOLD, 15));
		label7=new JLabel("Costo");
		label7.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		botonImprimir=new JButton("Imprimir");
	
		botonImprimir.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.setLayout(new GridLayout(4,1));
		panel2.add(label8);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		
		panel3.setLayout(new GridLayout(reporte.size()+1,2));
		panel3.add(label6);
		panel3.add(label7);
		//Despliega el reporte financiero
		for(int i=0;i<reporte.size();i++) {
			panel3.add(new JLabel(""+reporte.get(i).getServicio()));
			panel3.add(new JLabel(""+reporte.get(i).getTotal()));
			total=total+reporte.get(i).getTotal();
		}
		label5=new JLabel("Total:  $"+total+".00 M/N");
		label5.setFont(new Font("Arial Black", Font.BOLD, 15));

		panel4.setLayout(new GridLayout(3,1));
		panel4.add(panel2);
		panel4.add(panel3);
		panel4.add(label5);
		
		panel5.add(botonImprimir);
		
		add(panel1,BorderLayout.NORTH);
		add(panel4,BorderLayout.CENTER);
		add(panel5,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonImprimir) {
			muestraMensaje();
			cierra();
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
	public void muestraMensaje() {
		JOptionPane.showConfirmDialog(null,"imprimiendo","Imprimir",2);
	}

	/**
	 * Cierra la ventana
	 */
	public void cierra() {
		setVisible(false);
	}
}