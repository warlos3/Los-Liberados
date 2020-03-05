package datos;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import negocio.dominio.Consulta;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio.dominio.Recepcionista;
import negocio.dominio.Reporte;
import datos.ManejadorBaseDatos;

/**
 * Implementacion del dao
 * @author 
 *
 */
public class DAOCCruzRoja implements DAOCruzRoja {

	/**
	 * Constructor
	 */
	public DAOCCruzRoja() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Empleado recupera_empleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override /* Metodo para saber si el id del Paciente existe en la base de datos*/
	public boolean recuperaIDPaciente(String idPaciente) {
		int bandera = 1; //bandera para saber si el id del paciente existe (es 0 si existe, es 1 si no)
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT idPaciente FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next()) {
				if (rs.getString("idPaciente") == "NULL") { //se refiere a que no se encontro el id del paciente
					bandera=1;
				}
				else {
					bandera=0;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		if(bandera==0)
			return true;
		else
			return false;
	}

	@Override /*metodo parasaber si la especialidad existe en la base de datos*/
	public boolean recuperaEspecialidad(String especialidad) {
		int bandera = 1; //bandera, es 0 si existe la especialidad, es 1 si no.
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT tipo FROM Servicio WHERE tipo= '"+especialidad+"'");
			
			while(rs.next()) {
				if (rs.getString("tipo") == "NULL") { //si la especialidad no se encuentra
					bandera=1;
				}
				else {
					bandera=0;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		if(bandera==0)
			return true;
		else
			return false;
	}
	
	@Override /*metodo para recuperar el nombre completo del paciente relacionado con el id del paciente*/
	public String recuperaNombrePaciente(String idPaciente) {
		String nombreCompleto=null, nombre = null, apellido=null;
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT nombre,apellido FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next())
			{
				nombre=rs.getString("nombre"); //recupera el nombre del paciente
				apellido=rs.getString("apellido"); //recupera el apellido del paciente
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		nombreCompleto = nombre.concat(" "+apellido); //concatena nombre y apellido
		return nombreCompleto; //regresa el nombre completo
	}
	
	@Override /*Metodo para recuperar el CURP de un paciente relacionado con su id*/
	public String recuperaCURPPaciente(String idPaciente) {
		String curp=null;
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT curp FROM Paciente WHERE idPaciente= '"+idPaciente+"'");
			
			while(rs.next())
			{
				curp=rs.getString("curp"); //recupera curp del paciente
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return curp; //regresa el curp
	}

	@Override
	public ArrayList<Paciente> recuperaAllPaciente() {
		ArrayList <Paciente> paciente = new ArrayList<Paciente>();
		Paciente pac=null;
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT idPaciente,nombre,apellido,telefono,curp FROM Paciente");
			
			while(rs.next()) {
				pac=new Paciente();
				pac.setId_paciente(rs.getString("idPaciente"));
				pac.setNombre(rs.getString("nombre"));
				pac.setApellido(rs.getString("apellido"));
				pac.setTelefono(rs.getString("telefono"));
				pac.setCURP(rs.getString("curp"));
				paciente.add(pac);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	@Override
	public ArrayList<Consulta> recuperaAllCitas() {
		ArrayList <Consulta> cita = new ArrayList<Consulta>(); //arreglo de tipo consulta
		Consulta info=null;
		
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe resultados
			ResultSet rs = statement.executeQuery("SELECT idconsulta,Fecha,hora,tipodeconsulta FROM consulta");
			
			/*recupera los datos solicitados y son guardados en 'info' */
			while(rs.next()) {
				info=new Consulta();
				info.setIDConsulta(rs.getString("idconsulta"));
				info.setHora(rs.getString("hora"));
				info.setFecha(rs.getString("Fecha"));
				info.setTipoServicio(rs.getString("tipodeconsulta"));
				cita.add(info);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cita; //regresa el arreglo con todos los datos recabados
	}
	
	@Override
	public Consulta recuperaCita(String idPaciente) {
		Consulta cita=null;
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe resultados
			ResultSet rs = statement.executeQuery("SELECT idconsulta,Fecha,hora FROM consulta WHERE idPaciente = '"+idPaciente+"'");
			
			/*recupera los datos solicitados y son guardados en 'info' */
			while(rs.next()) {
				cita=new Consulta();
				cita.setIDConsulta(rs.getString("idconsulta"));
				cita.setHora(rs.getString("hora"));
				cita.setFecha(rs.getString("Fecha"));
			}
			return cita;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<Consulta> recuperaAllServicios() {
		ArrayList <Consulta> servicios = new ArrayList<Consulta>(); //arreglo de tipo consulta
		Consulta info=null;
		
		try{
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe resultados
			ResultSet rs = statement.executeQuery("SELECT idservicio,tipo,cantidad,costo FROM Servicio");
			
			/*recupera los datos solicitados y son guardados en 'info' */
			while(rs.next()) {
				info=new Consulta();
				info.setIDServicio(rs.getString("idservicio"));
				info.setTipoServicio(rs.getString("tipo"));
				info.setCantidad(rs.getString("cantidad"));
				info.setCosto(rs.getString("costo"));
				servicios.add(info);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return servicios; //regresa el arreglo con todos los datos recabados
	}
	
	@Override
	public ArrayList<Doctor> recuperaAllempleadosDoc() {
		ArrayList <Doctor> empleado = new ArrayList<Doctor>();
		Doctor emp=null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT iddoc,nombre,apellido,cedulaprofesional,horario FROM Doctor");

			
			while(rs.next())
			{
			
				emp=new Doctor();
				emp.setId_empleado(rs.getString("iddoc"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setCedulaProfesional(rs.getString("cedulaprofesional"));
				emp.setHorario(rs.getString("horario"));
				empleado.add(emp);
				
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return empleado;
	}
	
	public ArrayList<Recepcionista> recuperaAllempleadosRec(){
		
		ArrayList <Recepcionista> empleado = new ArrayList<Recepcionista>();
		Recepcionista emp=null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT idrecep,nombre,apellido,horario FROM Recepcionista");

			
			while(rs.next())
			{
			
				emp=new Recepcionista();
				emp.setId_empleado(rs.getString("idrecep"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setHorario(rs.getString("horario"));
				empleado.add(emp);
				
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return empleado;
		
	}

	@Override /*Metodo para crear un nuevo empleado (Doctor) en la base de datos*/
	public boolean crea_empleadoDoc(Empleado empleado) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion 
			/*Agrega al doctor a la base de datos*/
			statement.execute("INSERT INTO Doctor VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getFecha_ingreso()+"',"+empleado.getEdad()+",'"+empleado.getTelefono()+"','"+empleado.getEmail()+"','"+empleado.getSexo()+"','"+empleado.getCedulaProfesional()+"','"+empleado.getEspecialidad()+"','"+empleado.getHorario()+"','"+empleado.getDireccion()+"')");
			/*Crea su usuario y contrase�a en la base de datos */
			statement.execute("INSERT INTO login VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','Doctor')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}
	
	@Override /*Metodo para crear un nuevo empleado (Recepcionista) en la base de datos*/
	public boolean crea_empleadoRecep(Empleado empleado) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			/*agrega los datos del recepcionista a la tabla correspondiente*/
			statement.execute("INSERT INTO Recepcionista VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getFecha_ingreso()+"',"+empleado.getEdad()+",'"+empleado.getTelefono()+"','"+empleado.getEmail()+"','"+empleado.getSexo()+"','"+empleado.getEscolaridad()+"','"+empleado.getDireccion()+"','"+empleado.getHorario()+"')");
			/*Crea su usaurio y contrase�a del recepcionista*/
			statement.execute("INSERT INTO login VALUES ('"+empleado.getId_empleado()+"','"+empleado.getNombre()+"','Recepcionista')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean elimina_empleado(String ID) {
		System.out.println("Empleado a eliminar: "+ID);
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			
			statement.execute("DELETE FROM Doctor where iddoc='"+ID+"' ");
			statement.execute("DELETE FROM Recepcionista where idrecep='"+ID+"' ");
	
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		}
	
	
	
		public boolean elimina_paciente(String ID) {
			System.out.println("Paciente a eliminar: "+ID);
			
			try {
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();
				
				statement.execute("DELETE FROM Paciente where idPaciente='"+ID+"' ");
				
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		
	}

	/**
	 * Recupera un ArrayList de tipo Historial Medico
	 * @param IDPaciente El paciente del cual se recupera su historial medico
	 * @return Devuelve una lista con el historial medico del paciente
	 */
	public ArrayList<HistorialMedico> recuperaHistorialMedico(String IDPaciente) {
		
		ArrayList<HistorialMedico> historial = new ArrayList<HistorialMedico>();
		HistorialMedico hist=null;
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT Fecha,observaciones FROM historialMedico WHERE idPaciente='"+IDPaciente+"' ");
			//Guarda cada resultado en un objeto de tipo historial medico
			while(rs.next()) {
				hist= new HistorialMedico();
				hist.setFecha(rs.getString("Fecha"));
				hist.setObservaciones(rs.getString("observaciones"));
				historial.add(hist);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Devuelve el historial medico lleno
		return historial;
	}

	public boolean anadeHistorialMedico(String idPaciente, String fecha, String observaciones) {
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Anade los datos a la BD
			statement.execute("INSERT INTO historialMedico VALUES('"+idPaciente+"','"+fecha+"','"+observaciones+"')");
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Paciente recuperaPaciente(int idPago) {
		// TODO Auto-generated method stub
		try {
			Paciente paciente = null;
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del paciente que se encuentra en la base de datos
			ResultSet rs = statement.executeQuery("SELECT idPaciente, edad, nombre, apellido, sexo, curp FROM Paciente where idPaciente=(SELECT pacienteidpaciente FROM Pago WHERE idPago ="+idPago+")");
			
			//Va almacenando la informacion obtenida de la base de datos
			if(rs.next()) {
				paciente = new Paciente();
				paciente.setId_paciente(rs.getString("idPaciente"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setCURP(rs.getString("curp"));	
			}
			
			return paciente;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Paciente recuperaPaciente(String idPaciente) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Llegue al DAO " + idPaciente);
			Paciente paciente = null;
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del paciente que se encuentra en la base de datos
			ResultSet rs = statement.executeQuery("SELECT idPaciente, edad, nombre, apellido, sexo FROM Paciente where idPaciente='"+idPaciente+"'");
			
			//Va almacenando la informacion obtenida de la base de datos
			if(rs.next()) {
				paciente = new Paciente();
				paciente.setId_paciente(rs.getString("idPaciente"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setSexo(rs.getString("sexo"));
			}
			
			return paciente;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Pago recuperaPago(int idPago) {
		Pago pago = null;
		try {
			//Se conecta a la base de datos
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recupera la informacion del pago de la base de datos
			ResultSet rs = statement.executeQuery("SELECT tipo FROM Servicio where idservicio=(SELECT servicioidservicio FROM Pago WHERE idPago ="+idPago+")");

			//Obtiene solamente el tipo que es el que interesa
			if(rs.next()) {
				pago = new Pago();
				pago.setServicio(rs.getString("tipo"));
			}
			
			return pago;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Recupera un ArrayList de tipo Reporte
	 * @param periodo El periodo del cual se solicita el reporte financiero
	 * @return una lista con el reporte financiero del periodo
	 */
	public ArrayList<Reporte> recuperaServicio(String periodo) {
		
		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		Reporte report=null;
		ArrayList<Integer> id = new ArrayList<Integer>();
		
		try {
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//Recibe los resultados
			ResultSet rs = statement.executeQuery("SELECT servicioidservicio FROM Pago WHERE fecha='"+periodo+"'");
			//Guarda cada servicio prestado en ese periodo
			while(rs.next()) {
				id.add(rs.getInt("servicioidservicio"));
			}
			try {
				for(int i=0;i<id.size();i++) {
					//Recibe los resultados
					ResultSet rs2= statement.executeQuery("SELECT tipo, cantidad FROM Servicio WHERE idservicio="+id.get(i)+"");
					//Guarda cada resultado en un objeto de tipo reporte
					while(rs2.next()) {
						report= new Reporte();
						report.setServicio(rs2.getString("tipo"));
						report.setTotal(rs2.getInt("cantidad"));
						reporte.add(report);
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//Devuelve el reporte
		return reporte;
	}

	/*
	 * Crea un nuevo paciente en la base de datos
	 * @param un objeto de paciente
	 * @return true si se registro correctamente y false si no
	 */
	public boolean crea_paciente(Paciente paciente) {
		    //System.out.println("llegue a dao: "+paciente.getNombre()+" telefono: "+paciente.getTelefono()+" Direc: "+direccion+" Email: "+email+" edad: "+edad+" naci: "+fecha_nacimiento+" sexo: "+sexo+" curp: "+curp+" idpac: "+idpaciente);
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Paciente VALUES ('"+paciente.getId_paciente()+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getTelefono()+"','"+paciente.getDireccion()+"','"+paciente.getEmail()+"','"+paciente.getCURP()+"','"+paciente.getSexo()+"','"+paciente.getEdad()+"','"+paciente.getFecha_nacimiento()+"')");
			return true;
			
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
		
	
	}
	
	/*
	 * Recupera al tipo de empleado que correspondan el nombre y contrase�a
	 * @param nombre
	 * @param contra
	 * @return Doctor o Recepcionista
	 */
	public String verificaUsuario(String nombre, String contra) {
		String tipo="ninguno";
		
		try{
			
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		//Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT rol FROM login WHERE usuario = '"+nombre+"'AND contrasena = '"+contra+"' ");

		while(rs.next())
		{
			tipo=rs.getString("rol");
			
		}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return tipo;
	
	}

	@Override
	public Paciente recupera_paciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pago recupera_pago(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	

}