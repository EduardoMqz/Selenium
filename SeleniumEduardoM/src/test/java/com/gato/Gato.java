package com.gato;

public class Gato {
	
	String color, tamCola;
	int numPatas;

	
	
	public Gato(String color, String tamCola, int numPatas) {
		super();
		this.color = color;
		this.tamCola = tamCola;
		this.numPatas = numPatas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void temperamento() {
		System.out.println("Jugueton");
	}

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamCola() {
		return tamCola;
	}

	public void setTamCola(String tamCola) {
		this.tamCola = tamCola;
	}

	public int getNumPatas() {
		return numPatas;
	}

	public void setNumPatas(int numPatas) {
		if(numPatas > 10) {
			this.numPatas = -1;
		}else {
		this.numPatas = numPatas;
		}
	}

	
	
	
	
	
}
