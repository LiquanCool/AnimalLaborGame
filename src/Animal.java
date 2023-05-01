public class Animal {
    private int profit;
    private int fedness;
    private int wetness;
    private int requiredFood;
    private int requiredWater;

    public Animal(int p,int rf, int rw)
    {
        profit = p;
        fedness = 100;
        wetness = 100;
        requiredFood = rf;
        requiredWater = rw;
    }

    public int feed()//returns amount to subtract from food
    {
        if (fedness<100)
        {
            if(fedness+requiredFood>100)
            {
                fedness=100;
                return requiredFood;
            }
            fedness=fedness+requiredFood;
            return requiredFood;
        }
        else
        {
            return 0;
        }
    }
    public int water() //returns amount to subtract from water
    {
        if (wetness<100)
        {
            if(wetness+requiredWater>100)
            {
                wetness=100;
                return requiredWater;
            }
            wetness=wetness+requiredFood;
            return requiredWater;
        }
        else
        {
            return 0;
        }
    }
    public int work() //returns profit
    {
        if (wetness>requiredWater&&fedness>requiredFood)
        {
            wetness-=requiredWater;
            fedness-=requiredFood;
            return profit;
        }
        return 0;
    }
}
