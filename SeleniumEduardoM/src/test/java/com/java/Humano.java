package com.java;

public class Humano {
	int numOjos, numManos, numPiernas;
	String colorOjos, colorCabello;
	double altura;
	
	public Humano() {
		//Si se tiene constructores el se debe crear el vacio de forma manual
	}
	
	public Humano(int numOjos, int numManos, int numPiernas, String colorOjos, String colorCabello, double altura) {
		super();
		this.numOjos = numOjos;
		this.numManos = numManos;
		this.numPiernas = numPiernas;
		this.colorOjos = colorOjos;
		this.colorCabello = colorCabello;
		this.altura = altura;
	}
	
	public Humano( String colorOjos, String colorCabello, double altura) {
		super();
		this.numOjos = 2;
		this.numManos = 2;
		this.numPiernas = 2;
		this.colorOjos = colorOjos;
		this.colorCabello = colorCabello;
		this.altura = altura;
	}
	
	
/*
 * Constructores no se heredan
 * No devuelven ningun valor
 * Mismo nombre de la clase
 * Puede sobrecargarse
 */
	
 
}
