import java.util.ArrayList;

public class Hiring {
    private ArrayList<LandAnimal> landAnimalList;
    private ArrayList<SeaAnimal> seaAnimalList;
    private Data data;
    public Hiring(Data d)
    {
        landAnimalList = new ArrayList<LandAnimal>();
        seaAnimalList = new ArrayList<SeaAnimal>();
        data = d;
    }
    public void initializeAnimals()
    {
        LandAnimal turtle = new LandAnimal(5, 4, 4, 60, 200);
        LandAnimal cow = new LandAnimal(20, 15, 10, 60, 200);
        LandAnimal giraffe = new LandAnimal(100, 50, 50, 60, 200);
        landAnimalList.add(turtle);
        landAnimalList.add(cow);
        landAnimalList.add(giraffe);
        SeaAnimal fish = new SeaAnimal(25, 15, 200, 200);
        SeaAnimal penguin = new SeaAnimal(50, 25, 200, 200);
        SeaAnimal whale = new SeaAnimal(200, 50, 200, 200);
        seaAnimalList.add(fish);
        seaAnimalList.add(penguin);
        seaAnimalList.add(whale);
    }
    public String hire()
    {
        boolean hired = false;
        if(data.getMoney()>data.getTimesHired()*10)
        {
            if (data.getOwnedLandAnimalList().size()+data.getOwnedSeaAnimalList().size()<6)//MAKE IT ACCOUNT FOR THE POOL
            {
                while(!hired)
                {
                    int num = (int)(Math.random()*20+1);
                    if (num<=7)
                    {
                        if (!(data.getOwnedLandAnimalList().contains(landAnimalList.get(0))))
                        {
                            data.getOwnedLandAnimalList().add(landAnimalList.get(0));
                            hired= true;
                        }
                    }
                    else if(num==8||num==9)
                    {
                        if (!(data.getOwnedLandAnimalList().contains(landAnimalList.get(1))))
                        {
                            data.getOwnedLandAnimalList().add(landAnimalList.get(1));
                            hired= true;
                        }
                    }
                    else if(num==10)
                    {
                        if (!(data.getOwnedLandAnimalList().contains(landAnimalList.get(2))))
                        {
                            data.getOwnedLandAnimalList().add(landAnimalList.get(2));
                            hired= true;
                            return "One of your trees turned out to be a giraffe!";
                        }
                    }
                    else if(num<18)
                    {
                        if (!(data.getOwnedSeaAnimalList().contains(seaAnimalList.get(0))))
                        {
                            data.getOwnedSeaAnimalList().add(seaAnimalList.get(0));
                            hired= true;
                            return "You found a fish in your glass of water!";
                        }
                    }
                    else if(num<20)
                    {
                        if (!(data.getOwnedSeaAnimalList().contains(seaAnimalList.get(1))))
                        {
                            data.getOwnedSeaAnimalList().add(seaAnimalList.get(1));
                            hired= true;
                            return "A penguin was in your freezer.";
                        }
                    }
                    else if(num==20)
                    {
                        if (!(data.getOwnedSeaAnimalList().contains(seaAnimalList.get(2))))
                        {
                            data.getOwnedSeaAnimalList().add(seaAnimalList.get(2));
                            hired= true;
                            return "A whale appeared in your pool!";
                        }
                    }
                }
            }
        }
        return "You need "+10*data.getTimesHired()+" dollars to hire again!";
    }

}
