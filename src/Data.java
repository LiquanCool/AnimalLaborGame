import java.util.ArrayList;

public class Data {
    private int money;
    private int food;
    private int water;
    private boolean pool;
    private ArrayList<LandAnimal> landAnimalList;
    private ArrayList<SeaAnimal> seaAnimalList;

    public Data()
    {
        money = 100;
        food = 100;
        water = 100;
        pool = false;
        landAnimalList = new ArrayList<LandAnimal>();
        seaAnimalList = new ArrayList<SeaAnimal>();
    }
    public void pay(int price)
    {
        money-=price;
    }

}
