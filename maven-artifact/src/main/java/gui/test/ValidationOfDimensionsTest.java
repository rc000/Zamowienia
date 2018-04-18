package gui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.ControllAddOrder;

public class ValidationOfDimensionsTest {

	@Test
	public void test() {
		ControllAddOrder cao=new ControllAddOrder();
		boolean result =cao.valid_dimensions("22x220x1111");
		assertTrue(result);
	}

}
