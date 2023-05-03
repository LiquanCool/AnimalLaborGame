public class Shop {
    private int multiplier;
    private Data data;//FIX THE SHOP MAKE IT USE DATA
    public Shop(int m, Data d)
    {
        data = d;
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
