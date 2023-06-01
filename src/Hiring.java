import java.util.ArrayList;

public class Hiring {
    private ArrayList<Animal> AnimalList;
    private Data data;
    private int price;
    public Hiring(Data d)
    {
        AnimalList = new ArrayList<Animal>();
        data = d;
        updatePrice();
        initializeAnimals();
    }
    public void updatePrice()
    {
        price = 20*(int)Math.pow(2,data.getTimesHired());
    }
    public void initializeAnimals()
    {
        Animal turtle = new Animal(10, 4, 4, 60, 200, "turtle");
        Animal cow = new Animal(30, 15, 10, 60, 200, "cow");
        Animal giraffe = new Animal(110, 50, 50, 60, 200, "giraffe");
        AnimalList.add(turtle);
        AnimalList.add(cow);
        AnimalList.add(giraffe);
        Animal fish = new Animal(25, 15, 200, 200, "fish");
        Animal penguin = new Animal(50, 25, 200, 200, "penguin");
        Animal whale = new Animal(200, 50, 200, 200, "whale");
        AnimalList.add(fish);
        AnimalList.add(penguin);
        AnimalList.add(whale);
    }
    public String hire()
    {
        if(data.getMoney()>=price)
        {
            if (data.getTimesHired()<6&&(data.getTimesHired()<3||data.isPool()))
            {
                while(true)
                {
                    int num = (int)(Math.random()*20+1);
                    if (num<=7)
                    {
                        if (!(contains(0)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(0));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "There was turtle in your shoe!";
                        }
                    }
                    else if(num==8||num==9)
                    {
                        if (!(contains(1)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(1));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "There was a cow in your walls";
                        }
                    }
                    else if(num==10)
                    {
                        if (!(contains(2)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(2));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "One of your trees turned out to be a giraffe!";
                        }
                    }
                    else if(num<18&&data.isPool())
                    {
                        if (!(contains(3)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(3));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "You found a fish in your glass of water!";
                        }
                    }
                    else if(num<20&&data.isPool())
                    {
                        if (!(contains(4)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(4));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "A penguin was in your freezer.";
                        }
                    }
                    else if(num==20&&data.isPool())
                    {
                        if (!(contains(5)))
                        {
                            data.getOwnedAnimalList().add(AnimalList.get(5));
                            data.addTimesHired();
                            data.pay(price);
                            updatePrice();
                            return "A whale appeared in your pool!";
                        }
                    }

                }
            }
            return "You have hired too many times already!";
        }
        return "You need "+price+" dollars to hire again!";
    }

    public boolean contains(int ani)
    {
        boolean ans =false;
        for (int i = 0;i<data.getOwnedAnimalList().size();i++)
        {
            if (data.getOwnedAnimalList().get(i).toString().equals(AnimalList.get(ani).toString()))
            {
                ans = true;
            }
        }
        return ans;
    }
    public int getPrice() {
        return price;
    }
}
