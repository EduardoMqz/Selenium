package com.java;

public class JavaNotes {
	
	/*Ecosistema
	
	-JVM (Java virtual machine)
	-JRE (Java Run Enviroment)
	-JDK (Java Dev Kit)
	
	--Primitive data type
		-Byte
		-Short
		-int---->
		-Long----->
		-float
		-double---->
		-char----->String
		-boolean		
		*/
	
	 
	 public static void main(String[] args) {
	//--fases de una variable
	//	-Declaracion
		 int x;
		double y;
	//	-Inicializacion
		x = 10;
		y = 2.5;
		int a = 12;
		
	//	-Utilizacion
		double z = x+ y;
		
	//--Operadores
		//-Aritmeticos (+,-,/,*)
		int suma = (a / x) + (x * a) ;
		//-Unarios (++, --)
		suma++;
		++suma;
		//-Relacionales (==, !=, >, >+)
		if (a==x) {
			System.out.print("Exito");
		}else {
			System.out.print("Fracaso");
		}
		
		//-Condicionales (AND->&&,OR->||)
		if (a!=x && y == z) {
			System.out.print("Exito");
		}else {
			System.out.print("Fracaso");
		}
		//-Bit(&, )
		
	
		
	/*--Estructuras
		-Condicionales
			if, else, if, anidado, switch			
			loop (while, do while, for)
			*/
		while (a <= 20) {
			System.out.print("Algo");
			break;
			}
		
		
		
	 }
	

}
