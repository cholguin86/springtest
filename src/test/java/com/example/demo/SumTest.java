package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumTest {
	
	@Test
	public void testSum() {
		SumUtils test = new SumUtils();
		assertEquals(test.sum(1,2), 3l);
		assertEquals(test.sum(0,0), 0l);
	}

}
