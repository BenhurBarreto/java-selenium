package br.com.alura.tdd.service;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Iniciando Suite \n");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Finalizando Suite");
	}
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Início de um Teste");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Gilberto", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim do teste. \n");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		
		service.concederReajuste(funcionario, Desempenho.OTIMO);		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
