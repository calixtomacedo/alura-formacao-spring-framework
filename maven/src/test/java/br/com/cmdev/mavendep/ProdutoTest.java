package br.com.cmdev.mavendep;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void test() {
		Produto p = new Produto("Mouse", BigDecimal.TEN);
		assertEquals("Mouse", p.getNome());
		assertEquals(BigDecimal.TEN, p.getPreco());
	}

}
