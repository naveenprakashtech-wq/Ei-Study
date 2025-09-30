package exercise_1;

interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() { System.out.println("Drawing Circle"); }
}

class Square implements Shape {
	public void draw() { System.out.println("Drawing Square"); }
}

class ShapeFactory {
	public Shape getShape(String type) {
		if (type.equalsIgnoreCase("circle")) 
			return new Circle();
		if (type.equalsIgnoreCase("square")) 
			return new Square();
		return null;
	}
}

public class CreationalPatterns_FactoryPattern {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape1 = factory.getShape("circle");
		shape1.draw();
		Shape shape2 = factory.getShape("square");
		shape2.draw();
	}
}
