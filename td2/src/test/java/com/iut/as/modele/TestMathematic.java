package com.iut.as.modele;

import static java.lang.Double.valueOf;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

/**
 * @description : Test de la classe {@link Mathematic}.
 * 
 * @author stephane.joyeux
 *
 */
public class TestMathematic {

	// Utilisation de l'interface : Je veux m'abstraire de l'implémentation réelle
	// de l'objet (-> Mock Oject)
	private IMaths maths;

	@Before
	public void setUp() {
		this.maths = new Mathematic();
	}

	@Test
	public void testAdditionAvecNombrePositif() {
		assertEquals(4, maths.addition(2d, 2d));
		assertEquals(11, maths.addition(4d, 7d));
	}

	@Test
	public void testSoustractionAvecNombrePositif() {
		assertEquals(0, maths.soustraction(2d, 2d));
		assertEquals(-3, maths.soustraction(4d, 7d));
	}

	@Test
	public void testDivisionAvecNombrePositif() {
		assertEquals(1d, maths.division(2d, 2d));
		assertEquals(2d, maths.division(8d, 4d));
	}

	@Test
	public void testMultiplicationAvecNombrePositif() {
		assertEquals(28, maths.multiplication(4d, 7d));
		assertEquals(12, maths.multiplication(3d, 4d));
	}

	@Test
	public void testMultiplicationAvecNombreNegatif() {
		assertEquals(-28, maths.multiplication(-4d, 7d));
		assertEquals(-12, maths.multiplication(-3d, 4d));
		assertEquals(-28, maths.multiplication(4d, -7d));
	}

	@Test
	public void testMultiplicationAvecNombresNegatifs() {
		assertEquals(28, maths.multiplication(-4d, -7d));
		assertEquals(14, maths.multiplication(-7d, -2d));
	}

	@Test
	public void testMultiplicationAvec0() {
		assertEquals(0, maths.multiplication(0d, -7d));
		assertEquals(0, maths.multiplication(-7d, 0d));
		assertEquals(0, maths.multiplication(0d, 0d));
	}

	@Test
	public void testDivisionAvecNombresPositifs() {
		// On reçoit du double :
		assertEquals(4d, maths.division(16d, 4d));
		assertEquals(4, valueOf(maths.division(8d, 2d)).intValue());
	}

	@Test
	public void testDivisionAvecNombresNegatifs() {
		// On reçoit du double :
		assertEquals(-4d, maths.division(-16d, 4d));
		assertEquals(4d, maths.division(-16d, -4d));
		assertEquals(-4, valueOf(maths.division(8d, -2d)).intValue());
	}

	@Test(expected = MathematicException.class)
	public void testDivisionParZero() {
		// Approche plus TDD (Test Driven development)
		// L'exception nous aide à mieux gérer ce qu'il faut faire en cas d'erreur !
		assertEquals(-4d, maths.division(-16d, 0d));
	}

	@Test(expected = MathematicException.class)
	public void testDivisionWithNull() {
		assertEquals(-4d, maths.division(null, -1d));
		assertEquals(-4d, maths.division(-16d, null));
		assertEquals(-4d, maths.division(null, null));
	}
}
