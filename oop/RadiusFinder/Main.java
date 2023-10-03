package RadiusFinder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Cylinder newCircle = new Cylinder();
		
		newCircle.setDiameter(scanner.nextDouble());
		newCircle.setCircumference(scanner.nextDouble());
		newCircle.setArea(scanner.nextDouble());
		
		System.out.println("Radius using diameter: " + String.format("%.2f", newCircle.diameter_radius()));
		System.out.println("Radius using circumference: " + String.format("%.2f", newCircle.circumference_radius()));
		System.out.println("Radius using area: " + String.format("%.2f", newCircle.area_radius()));
		
		newCircle.setHeight(5.5);
		
		System.out.println("Volume: " + String.format("%.2f", newCircle.volume()));
		System.out.println("Diameter: " + String.format("%.2f", newCircle.diameter()));
		System.out.println("Surface area: " + String.format("%.2f", newCircle.surface_area()));
		
	}

}
