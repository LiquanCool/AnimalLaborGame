public class Shop {
    private int multiplier;
    public Shop(int m)
    {
        multiplier = m;
    }
    public int buyWater()//returns price for water
    {
        return 10*multiplier;
    }
    public int buyFood()//returns price for food
    {
        return 10*multiplier;
    }
    public int buyPool()//returns price for pool
    {
        return 100*multiplier;
    }
}
