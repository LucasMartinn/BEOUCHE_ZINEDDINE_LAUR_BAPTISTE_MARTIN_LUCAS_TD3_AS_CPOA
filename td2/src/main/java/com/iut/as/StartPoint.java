package com.iut.as;

import com.iut.as.modele.Mathematic;

public class StartPoint {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World TD3");
		Mathematic maths = new Mathematic();
		System.out.println("Le resultat de 2 + 4 est " + maths.addition(2d, 4d));
		try {
			System.out.println("Le resultat de 4 / 2 est " + maths.division(4d, 2d));
			System.out.println("Le resultat de 4 / null est " + maths.division(4d, null));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
