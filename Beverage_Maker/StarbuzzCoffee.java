import java.math.RoundingMode;
import java.text.DecimalFormat;

public class StarbuzzCoffee {
	private static DecimalFormat decimal = new DecimalFormat ("#.##");
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + decimal.format(beverage.cost()));
 
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + decimal.format(beverage2.cost()));
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + decimal.format(beverage3.cost()));
		
		Beverage beverage4 = new Hazelnut();
		beverage4 = new Chocolate(beverage4);
		beverage4 = new Chocolate(beverage4);
		beverage4 = new Whip(beverage4);
		System.out.println(beverage4.getDescription() 
				+ " $" + decimal.format(beverage4.cost()));
		
		Beverage beverage5 = new Caramel();
		beverage5 = new Mint(beverage5);
		beverage5 = new Chocolate(beverage5);
		beverage5 = new Cinnamon(beverage5);
		System.out.println(beverage5.getDescription() 
				+ " $" + decimal.format(beverage5.cost()));

	}
}
