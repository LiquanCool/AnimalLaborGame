import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
import java.awt.*;
public class Data implements Serializable {
    private int money;
    private int food;
    private int water;
    private boolean pool;
    private int timesHired;
    private ArrayList<Animal> ownedAnimalList;

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

    public void setOwnedAnimalList(ArrayList<Animal> ownedAnimalList) {
        this.ownedAnimalList = ownedAnimalList;
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
        ownedAnimalList = new ArrayList<Animal>();
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
    public String getStorage()
    {
        return "Food: "+ food + "\nWater: " + water + "\nMoney: " + money + "\n";
    }

    public boolean isPool() {
        return pool;
    }

    public ArrayList<Animal> getOwnedAnimalList() {
        return ownedAnimalList;
    }


    public String feed()
    {
        int count = 0;
        for(int i = 0;i<ownedAnimalList.size();i++){
            Animal current = ownedAnimalList.get(i);
            if(current.getFedness()<100&&food>=10)
            {
                food-=current.feed();
                count++;
            }
        }
        return "You fed " + count + " animals and made lost " + count*10 + " food.";
    }
    public String water()
    {
        int count = 0;
        for(int i = 0;i<ownedAnimalList.size();i++){
            Animal current = ownedAnimalList.get(i);
            if(current.getWetness()<100&&water>=10)
            {
                water-=current.water();
                count++;
            }
        }
        return "You watered " + count + " animals and lost " + count*10 + " water.";
    }
    public String work()
    {
        int count = 0;
        int total = 0;
        for(int i = 0;i<ownedAnimalList.size();i++){
            Animal current = ownedAnimalList.get(i);
            if(current.getRequiredFood()< current.getFedness()&&current.getRequiredWater()<current.getWetness())
            {
                current.subtractFedness(current.getRequiredFood());
                current.subtractWetness(current.getRequiredWater());
                count++;
                total+=current.getProfit();
                System.out.println(current.getFedness());
            }
        }
        money+=total;
        return "You worked " + count + " animals and made $" + total;
    }
    public static void save(Data data) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Info.dat"));
        oos.writeObject(data);
        oos.close();
        System.out.println("Saved Data.");
    }

    public static Data useData(Data data) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Info.dat"));
        data = (Data) input.readObject();
        input.close();
        System.out.println("Data loaded.");
        return data;
    }
}
