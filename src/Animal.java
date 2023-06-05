import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
public class Animal implements Serializable {
    private int profit;
    private int fedness;
    private int wetness;
    private final int requiredFood;
    private final int requiredWater;
    private final boolean sea;
    private final String type;
    public Animal(int profit,int requiredFood, int requiredWater, String type)
    {
        this.profit = profit;
        fedness = 100;
        wetness = 100;
        this.requiredFood = requiredFood;
        this.requiredWater = requiredWater;
        sea = false;
        this.type = type;
    }
    public Animal(int profit,int requiredFood, String type)
    {
        this.profit = profit;
        fedness = 100;
        wetness = 100;
        this.requiredFood = requiredFood;
        requiredWater = 0;
        sea = true;
        this.type = type;
    }

    public int feed()//returns amount to subtract from food
    {
        if (fedness<100)
        {
            if(fedness+10>100)
            {
                return 0;
            }
            fedness=fedness+10;
            return 10;
        }
        else
        {
            return 0;
        }
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void subtractFedness(int fedness) {
        this.fedness -= fedness;
    }

    public void subtractWetness(int wetness) {
        this.wetness -= wetness;
    }

    public int water() //returns amount to subtract from water
    {
        if (wetness<100)
        {
            if(wetness+10>100)
            {
                return 0;
            }
            wetness=wetness+10;
            return 10;
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

    public int getProfit() {
        return profit;
    }

    public int getFedness() {
        return fedness;
    }

    public int getWetness() {
        return wetness;
    }

    public int getRequiredFood() {
        return requiredFood;
    }

    public int getRequiredWater() {
        return requiredWater;
    }

    public boolean isSea() {
        return sea;
    }

    public String toString()
    {
        return type;
    }

    public String getType() {
        return type;
    }
}
