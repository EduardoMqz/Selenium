package Tareas;

public class Tarea1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printNumberInWord(2);
		System.out.println(toMilesPerHour(1.5));
		printConversion(25.42);
		System.out.println(shouldWakeUp(true,-1));

	}
	
	
	public static void printNumberInWord(int number) {
			switch(number) {
			case 0:
				System.out.println("Zero");
				break;
			case 1:
				System.out.println("One");
				break;
			case 2:
				System.out.println("Two");
				break;
			case 3:
				System.out.println("Three");
				break;
			case 4:
				System.out.println("Four");
				break;
			case 5:
				System.out.println("Five");
				break;
			case 6:
				System.out.println("Six");
				break;
			case 7:
				System.out.println("Seven");
				break;
			case 8:
				System.out.println("Eight");
				break;
			case 9:
				System.out.println("Nine");
				break;
			default:
				System.out.println("Other");
				break;
			}	
	}

	public static long toMilesPerHour(double kilometersPerHour) {
		if(kilometersPerHour < 0) {
			return -1;
		}else {
			double mph = kilometersPerHour * 0.621371;
			
			return Math.round(mph);
		}
	}
	
	public static void printConversion(double kilometersPerHour) {
		if (kilometersPerHour < 0) {
			System.out.println("Invalid Value");
		}else {
			double mph = kilometersPerHour * 0.621371;
			
			System.out.println(kilometersPerHour + " km/h = "+Math.round(mph)+" mi/h");
		}
		
	}
	
	public static boolean shouldWakeUp(boolean barking, int hourDay) {
		if (hourDay < 0) {
			return false;
		}else if (barking && (hourDay < 8 || hourDay > 22)) {
			return true;
		}else {
			return false;
		}
	}
	
}
