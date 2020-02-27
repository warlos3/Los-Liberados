package apli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import datos.DatabaseException;
import datos.ManejadorBaseDatos;



/**
 * Esta clase crea la base de datos, solo debe ser usada 
 * cuando se crea la misma
 * 
 * @author
 *
 */
public class CreadorBaseDeDatos {
	
	// El logger
	static Logger log = Logger.getRootLogger();

	
	/**
	 * Al ejecutar este metodo se crea la base de datos. NOTA: solo se puede crear una vez.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try
	    {
			log.info("Creando base de datos");
		
			Connection connection = ManejadorBaseDatos.getConnection();
	
			Statement statement = connection.createStatement();
			
			log.info("Creando tablas de DAO Cruz Roja");          
			
			
			
			/*
			statement.execute("DROP TABLE consulta");
			statement.execute("DROP TABLE Fichamedica");
			statement.execute("DROP TABLE Pago");
			statement.execute("DROP TABLE Servicio");
			statement.execute("DROP TABLE Doctor");
			statement.execute("DROP TABLE Paciente");
			statement.execute("DROP TABLE Recepcionista");
			statement.execute("DROP TABLE Login");
			statement.execute("DROP TABLE historialMedico");
			*/
			
			/*
			statement.execute("INSERT INTO Login values('456','456','Recepcionista')");
			statement.execute("INSERT INTO Login values('123','123','Doctor')");
			statement.execute("INSERT INTO doctor values ('asdsa','luis','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd','marutio')");
			statement.execute("INSERT INTO doctor values ('12345','fernando','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd','marutio')");
			statement.execute("INSERT INTO Recepcionista values ('987','raul','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd')");
			statement.execute("INSERT INTO Servicio values (01,'Consulta General',60)");
			statement.execute("INSERT INTO Servicio values (02,'Inyeccion',30)");
			statement.execute("INSERT INTO Servicio values (03,'Ortopedista',1)");
			statement.execute("INSERT INTO Servicio values (04,'Podologia',1)");
			statement.execute("INSERT INTO Servicio values (05,'Cardologia',1)");
			statement.execute("INSERT INTO Paciente values ('a24F1','Brianda','Garcia','5539145264','bosques de argentina','brianda3195garcia@gmail.com','GARF010195','F','24','1995-01-03','a1b2c3')");			
			statement.execute("INSERT INTO Fichamedica values ('3/Noviembre/2019',10,'a24F1',01)");
			statement.execute("INSERT INTO Pago  values (01,01,'a24F1','3/Noviembre/2019')");
			statement.execute("INSERT INTO Pago values (02,01,'a24F1','3/Noviembre/2019')");
			statement.execute("INSERT INTO Pago values (03,02,'a24F1','3/Noviembre/2019')");
			statement.execute("INSERT INTO consulta values ('a1b2c3','10:00-12:00',01,'a24F1','3/Noviembre/2019','asdsa','Anda con chorro xd','a24F1')");
			statement.execute("INSERT INTO consulta values ('z9y8x7','8:00-9:00',02,'a24F1','3/Noviembre/2019','asdsa','Tiene tos seca','a24F1')");
			*/
			/*
			statement.execute("CREATE TABLE Servicio("+
					"idservicio INT NOT NULL,"+
					"tipo VARCHAR(45) NOT NULL,"+ 
					"cantidad INT NOT NULL,"+
					"PRIMARY KEY (idservicio))");
			statement.execute("CREATE TABLE Recepcionista("+
					"idrecep VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(56) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"fechainicio VARCHAR(30) NOT NULL,"+
					"edad INT NOT NULL,"+					
					"telefono VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(10) NOT NULL,"+
					"escolaridad VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"horario VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (idrecep))");
			statement.execute("CREATE TABLE Doctor("+
					"iddoc VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(56) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"fechainicio VARCHAR(30) NOT NULL,"+
					"edad INT NOT NULL,"+
					"telefono VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(10) NOT NULL,"+
					"cedulaprofesional VARCHAR(45) NOT NULL,"+
					"especialidad VARCHAR(45) NOT NULL,"+
					"horario VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (iddoc))"
					);	
			statement.execute("CREATE TABLE Paciente("+
					"idPaciente VARCHAR(45) NOT NULL,"+
					"nombre VARCHAR(45) NOT NULL,"+
					"apellido VARCHAR(45) NOT NULL,"+
					"telefono VARCHAR(45) NOT NULL,"+
					"direccion VARCHAR(45) NOT NULL,"+
					"email VARCHAR(45) NOT NULL,"+
					"curp VARCHAR(45) NOT NULL,"+
					"sexo VARCHAR(45) NOT NULL,"+
					"edad VARCHAR(45) NOT NULL,"+
					"fechanacimiento VARCHAR(30) NOT NULL,"+
					"idconsulta VARCHAR(45),"+
					"PRIMARY KEY (idPaciente))"
			);
			statement.execute("CREATE TABLE Login("+
					"usuario VARCHAR(45) NOT NULL,"+
					"contrasena VARCHAR(45) NOT NULL,"+
					"rol VARCHAR(45) NOT NULL,"+
					"PRIMARY KEY (Usuario))"
					);			
			statement.execute("CREATE TABLE Pago("+
					"idPago INT NOT NULL,"+
					"servicioidservicio INT NOT NULL,"+
					"pacienteidpaciente VARCHAR(45) NOT NULL,"+
					"fecha VARCHAR(30) NOT NULL,"+
					"PRIMARY KEY (idPago,Servicioidservicio, PacienteidPaciente),"+
					"CONSTRAINT fkPagoServicio1 FOREIGN KEY (Servicioidservicio) REFERENCES Servicio (idservicio),"+
					"CONSTRAINT fkPagoPaciente1 FOREIGN KEY (pacienteidpaciente) REFERENCES Paciente (idPaciente))"
					);
			statement.execute("CREATE TABLE Fichamedica("+
					"Fecha VARCHAR(30) NOT NULL,"+
					"numeroconsultorio INT NOT NULL,"+
					"pacienteidpaciente VARCHAR(45) NOT NULL,"+
					"servicioidservicio INT NOT NULL,"+
					"PRIMARY KEY (PacienteidPaciente,Fecha),"+
					"CONSTRAINT fkFichamedicaPaciente1 FOREIGN KEY (pacienteidpaciente) REFERENCES Paciente (idPaciente),"+
					"CONSTRAINT fkFichamedicaServicio1 FOREIGN KEY (servicioidservicio) REFERENCES Servicio (idservicio))"+
					""
					);
			statement.execute("CREATE TABLE consulta("+
					"idconsulta VARCHAR(45) NOT NULL,"+
					"hora VARCHAR(45) NOT NULL,"+
					"tipodeconsulta INT NOT NULL,"+
					"Fichamedica VARCHAR(45) NOT NULL,"+
					"Fecha VARCHAR(30) NOT NULL,"+
					"doctoriddoc VARCHAR(45),"+
					"observaciones VARCHAR(250) NOT NULL,"+
					"idPaciente VARCHAR(45),"+
					"PRIMARY KEY (idconsulta),"+
					"CONSTRAINT fkconsultaFichamedica1 FOREIGN KEY (Fichamedica , Fecha) REFERENCES Fichamedica (pacienteidpaciente , Fecha),"+
					"CONSTRAINT fkconsultaServicio1 FOREIGN KEY (tipodeconsulta) REFERENCES Servicio (idservicio),"+
					"CONSTRAINT fkconsultadoctor1 FOREIGN KEY (doctoriddoc) REFERENCES doctor (iddoc),"+
					"CONSTRAINT fkpacienteidpac FOREIGN KEY (idPaciente) REFERENCES Paciente (idPaciente))"
					);
			statement.execute("CREATE TABLE historialMedico("+
					"idPaciente VARCHAR(45) NOT NULL,"+
					"fecha VARCHAR(45) NOT NULL,"+ 
					"observaciones VARCHAR(254) NOT NULL)"
					);
					
			*/
			
	        
			
	        ManejadorBaseDatos.shutdown();
	    }
	    catch(DatabaseException ex)
	    {
	            log.error("Excepcion de la base de datos",ex.getRealException());
	    }
	    catch(SQLException e){
	    	log.error("Excepcion de la base de datos",e);
	    }	
	}
}