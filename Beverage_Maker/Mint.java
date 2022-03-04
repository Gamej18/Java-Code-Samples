public class Mint extends CondimentDecorator {
    Beverage beverage;

    public Mint(Beverage beverage)
    {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mint";

    }

    public double cost() {
        return .15 + beverage.cost();
    }
}
