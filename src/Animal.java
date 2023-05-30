import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
public class Animal implements Serializable {
    private int profit;
    private int fedness;
    private int wetness;
    private int requiredFood;
    private int requiredWater;
    private boolean sea;
    private String type;
    public Animal(int p,int rf, int rw, int x, int y, String t)
    {
        profit = p;
        fedness = 100;
        wetness = 100;
        requiredFood = rf;
        requiredWater = rw;
        sea = false;
        type = t;
    }
    public Animal(int p,int rf, int x, int y, String t)
    {
        profit = p;
        fedness = 100;
        wetness = 100;
        requiredFood = rf;
        requiredWater = 0;
        sea = true;
        type = t;
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
