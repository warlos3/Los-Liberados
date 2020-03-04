package testNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datos.DAOCruzRoja;
import negocio.dominio.Consulta;
import negocio1.ServicioConsulta;
import negocio1.ServicioConsultaimp;
import test.DAOCRUZROJAMock;

class servicioConsultaimpTest {

static ServicioConsulta servicioConsulta;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DAOCruzRoja dao=new DAOCRUZROJAMock();
		servicioConsulta=new ServicioConsultaimp(dao);
	
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void recuperaEspecialidadTest() {
		boolean esperado=true;
		String especialidad = "Consulta General";
		assertEquals(esperado,servicioConsulta.verificaServicio(especialidad));
		//assertEquals("Devuelve True si se encontró la especialidad en la BD", esperado,servicioConsulta.verificaServicio(especialidad));
	}

}


