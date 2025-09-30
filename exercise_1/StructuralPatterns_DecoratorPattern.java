package exercise_1;
interface Coffee {
	String getDescription();
	double cost();
}
class SimpleCoffee implements Coffee {
	public String getDescription() { 
		return "Simple Coffee"; 
	}
	public double cost() {
		return 5.0;
	}
}
abstract class CoffeeDecorator implements Coffee {
	protected Coffee decoratedCoffee;
	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}
}
class MilkDecorator extends CoffeeDecorator {
	public MilkDecorator(Coffee coffee) { 
		super(coffee); 
	}
	public String getDescription() { 
		return decoratedCoffee.getDescription() + ", Milk"; 
	}
	public double cost() { 
		return decoratedCoffee.cost() + 2.0; 
	}
}
class SugarDecorator extends CoffeeDecorator {
	public SugarDecorator(Coffee coffee) {
		super(coffee); 
	}
	public String getDescription() {
		return decoratedCoffee.getDescription() + ", Sugar"; 
	}
	public double cost() { 
		return decoratedCoffee.cost() + 1.0; 
	}
}
public class StructuralPatterns_DecoratorPattern {
	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
		coffee = new MilkDecorator(coffee);
		System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
     	coffee = new SugarDecorator(coffee);
     	System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
	}
}
