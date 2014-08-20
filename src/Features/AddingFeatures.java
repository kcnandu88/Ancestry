package Features;

import coffee.Coffee;

public abstract class AddingFeatures extends Coffee {
	public Coffee decoratedCoffee;
	public AddingFeatures(Coffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}
	
	public double Cost() { 
        return decoratedCoffee.cost();
    }
 
	public abstract String getDescription();
}
