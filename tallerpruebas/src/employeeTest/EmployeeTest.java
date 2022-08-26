package employeeTest;

import static org.junit.Assert.*;


import org.junit.Test;

import tallerpruebas.Employee;
import tallerpruebas.EmployeeType;

public class EmployeeTest {
	
	@Test
	public void employeeNotNull() {		
		assertNotNull(new Employee(500.0F,"USD",0.0F,EmployeeType.Worker));
	}

	@Test
	public void testCS() {
		Employee worker = new Employee(500.0F,"USD",0.0F,EmployeeType.Worker);
		Employee supervisor = new Employee(500.0F,"USD",0.05F,EmployeeType.Supervisor);
		Employee manager = new Employee(500.0F,"USD",0.1F,EmployeeType.Manager);
		
		//Prueba para cada tipo de trabajador con moneda USD
		assertEquals(500.0F,worker.cs(),0.0F);
		assertEquals(500.0175F,supervisor.cs(),0.0F);
		assertEquals(500.07F,manager.cs(),0.0F);
		
		//Prueba para un tipo de trabajador con otro tipo de moneda
		Employee worker1 = new Employee(500.0F,"EUR",0.0F,EmployeeType.Worker);
		assertEquals(475.0F,worker1.cs(),0.0F);
		
		
	}
	
	@Test
	public void testCYB() {
		Employee worker = new Employee(500.0F,"EUR",0.0F,EmployeeType.Worker);
		Employee supervisor = new Employee(500.0F,"EUR",0.05F,EmployeeType.Supervisor);
		Employee manager = new Employee(500.0F,"EUR",0.10F,EmployeeType.Manager);
		
		//Prueba del metodo CalculateYearBonus con otro tipo de moneda que no sea el dolar
		assertEquals(386.0F,worker.CalculateYearBonus(),0.0F);
		assertEquals(668.0F,supervisor.CalculateYearBonus(),0.0F);
		assertEquals(861.0F,manager.CalculateYearBonus(),0.0F);
		
	}
	
}
