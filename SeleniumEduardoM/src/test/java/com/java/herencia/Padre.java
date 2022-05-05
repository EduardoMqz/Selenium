package com.java.herencia;

public class Padre{
	
	private double altura;
	private String tipoSangre;
	
	
	
	
	public Padre(double altura, String tipoSangre) {
		super();
		this.altura = altura;
		this.tipoSangre = tipoSangre;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Estado
		
		
		//Los constructores no se heredan
		
	}
	
		
	//Comportamiento
	public void temperamento() {
		System.out.println("Enojon");
	}
	
	public void deporte() {
		System.out.println("Futbolista");
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public String getTipoSangre() {
		return tipoSangre;
	}



	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	
	

}
