package com.iut.as.test;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.modele.metier.Compte;

public class CompteTest {

	private Compte compte;
	
	@Before
	public void setUp() {
		Compte compte = new Compte("1");
	}

	@Test
	public void testCrediter() {
		compte.crediter(500);
		Assert.assertEquals(1000, compte.crediter(500));
	}

	@Test
	public void testDebiter() {
		compte.crediter(500);
		Assert.assertEquals(0, compte.debiter(500));
	}

}