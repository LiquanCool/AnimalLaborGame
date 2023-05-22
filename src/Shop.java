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
        if(data.getMoney()>=20)
        {

            data.addWater(20);
            data.pay(20);
            return "Bought 20 water";
        }
        return "You cannot buy more water";
    }
    public String buyFood()
    {
        if(data.getMoney()>=20)
        {
            data.addFood(20);
            data.pay(20);
            return "Bought 20 food";
        }
        return "You cannot buy more food";
    }
    public String buyPool()
    {
        if((!data.isPool())&&data.getMoney()>=200)
        {
            data.setPool(true);
            data.pay(200);
            return "Bought pool. Now you can hire sea animals";
        }
        return "You cannot buy the pool";
    }
}
