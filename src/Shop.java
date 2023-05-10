public class Shop {
    private int multiplier;
    private Data data;
    public Shop(int m, Data d)
    {
        data = d;
        multiplier = m;
    }
    public String buyWater()
    {
        if(data.getMoney()>10)
        {

            data.addWater(10);
            data.pay(10);
            return "Bought 10 water";
        }
        return "You cannot buy more water";
    }
    public String buyFood()
    {
        if(data.getMoney()>10)
        {
            data.addFood(10);
            data.pay(10);
            return "Bought 10 food";
        }
        return "You cannot buy more food";
    }
    public String buyPool()
    {
        if((!data.isPool())&&data.getMoney()>100)
        {
            data.setPool(true);
            data.pay(10);
            return "Bought pool. Now you can hire sea animals";
        }
        return "You cannot buy the pool";
    }
}
