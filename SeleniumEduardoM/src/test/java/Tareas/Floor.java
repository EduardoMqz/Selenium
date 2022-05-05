package Tareas;

public class Floor {
	double width, height;

	public Floor(double width, double height) {
		if(height < 0) {
			this.height = 0;
		}else {
			this.height = height;
		}
						
		if(width < 0) {
			this.width = 0;
		}else {
			this.width = width;
		}
	}
	
	public double getArea() {
		return width * height;
	}
	
	
	
	
}
