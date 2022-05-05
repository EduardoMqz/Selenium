package com.java.herencia;

import com.modifiers.Hello;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Herencia->Definir una calse apartir de otra ya existente
		/*
		 * Comparten metodos, instancias
		 * Nos permite tener super clases y subclases
		 * 
		 * */
		
		Padre pedro = new Padre(1.75, "O+");
		pedro.temperamento();
		//pedro.altura = 6;
		System.out.println("Cuanto imde el abuelo? " + pedro.getAltura());
		
		Hijo pedroJr = new Hijo(1.75, "O-");
		pedroJr.deporte();
		pedroJr.hobbies();
		
		Nieto pedroIII = new Nieto(1.80, "A+");
		pedroIII.deporte();
		pedroIII.hobbies();
		
		
		Hello hola = new Hello();
		hola.sayHello();
		//hola.sayHello2();

	}

}
