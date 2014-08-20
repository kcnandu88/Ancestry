package Features;

import coffee.Coffee;

public class Liveliness extends AddingFeatures{

	public Liveliness(Coffee decoratedCoffee) {
		 super(decoratedCoffee);
		 }

	@Override
	public String getDescription() {
		 return decoratedCoffee.getDescription();
	}
	public String getLivelines() {
		 return decoratedCoffee.getLiveliness();
		 }
	@Override
	public double cost() {
		double cost = decoratedCoffee.cost();
		 if (getLivelines() == Coffee.Smooth) {
		 cost += .10;
		 } else if (getLivelines() == Coffee.Balanced) {
		 cost += .15;
		 } else if (getLivelines() == Coffee.Bright) {
		 cost += .20;
		 } 
		 return cost;
	}


}
