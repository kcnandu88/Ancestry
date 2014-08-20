package Features;

import coffee.Coffee;

public class Size extends AddingFeatures  {
	
 public Size(Coffee decoratedCoffee) {
	 super(decoratedCoffee);
	 }
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		 return decoratedCoffee.getDescription();
	}
	public String getSize() {
		 return decoratedCoffee.getSize();
		 }
	
	@Override
	public double cost() {
		double cost = decoratedCoffee.cost();
		 if (getSize() == Coffee.Small) {
		 cost += .10;
		 } else if (getSize() == Coffee.Medium) {
		 cost += .15;
		 } else if (getSize() == Coffee.Large) {
		 cost += .20;
		 } 
		 return cost;
	}

}
