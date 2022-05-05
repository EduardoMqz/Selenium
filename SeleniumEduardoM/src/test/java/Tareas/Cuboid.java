package Tareas;

public class Cuboid extends Rectangle {
	double height ;

	public Cuboid(double length, double width, double height) {
		super(length, width);
		
		if(height < 0) {
			this.height = 0;
		}else {
			this.height = height;
		}
		
	}

	public double getHeight() {
		return height;
	}
	
	public double getVolume() {
		return getArea() * height;
	}
}
