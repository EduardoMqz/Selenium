package com.java;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Humano eduardo = new Humano();
		eduardo.altura = 1.75;
		eduardo.colorCabello = "Obscuro";
		eduardo.colorOjos = "Cafe";
		eduardo.numManos = 4;
		eduardo.numOjos = 3;
		eduardo.numPiernas = 8;
		System.out.println("Cuanto mide Eduardo: "+ eduardo.altura);
		
		
		
		
		// Utilizando un constructor		
		Humano lalo = new Humano("Obscuro", "Cafe", 1.75); 
		System.out.println("Cuanto mide Lalo: "+ lalo.altura);
		System.out.println("Cuantas piernas tiene Lalo: "+lalo.numPiernas);
		
		
		//
		Humano lal = lalo;
		System.out.println("De que color tiene el cabello lal: "+ lal.colorCabello);
		
		

	}

}
