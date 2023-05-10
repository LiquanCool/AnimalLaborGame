import java.util.ArrayList;

public class Data {
    private int money;
    private int food;
    private int water;
    private boolean pool;
    private int timesHired;
    private ArrayList<LandAnimal> ownedLandAnimalList;
    private ArrayList<SeaAnimal> ownedSeaAnimalList;

    public void setMoney(int money) {
        this.money = money;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void addWater(int water){
        this.water+=water;
    }
    public void addFood(int food){
        this.food+=food;
    }
    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void addTimesHired() {
        timesHired++;
    }

    public void setOwnedLandAnimalList(ArrayList<LandAnimal> ownedLandAnimalList) {
        this.ownedLandAnimalList = ownedLandAnimalList;
    }

    public void setOwnedSeaAnimalList(ArrayList<SeaAnimal> ownedSeaAnimalList) {
        this.ownedSeaAnimalList = ownedSeaAnimalList;
    }

    public int getTimesHired() {
        return timesHired;
    }

    public Data()
    {
        money = 100;
        food = 100;
        water = 100;
        pool = false;
        ownedLandAnimalList = new ArrayList<LandAnimal>();
        ownedSeaAnimalList = new ArrayList<SeaAnimal>();
        timesHired = 0;
    }
    public void pay(int price)
    {
        money-=price;
    }

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getWater() {
        return water;
    }

    public boolean isPool() {
        return pool;
    }

    public ArrayList<LandAnimal> getOwnedLandAnimalList() {
        return ownedLandAnimalList;
    }

    public ArrayList<SeaAnimal> getOwnedSeaAnimalList() {
        return ownedSeaAnimalList;
    }
}
