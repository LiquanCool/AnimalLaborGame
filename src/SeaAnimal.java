public class SeaAnimal extends Animal{
    private String habitat;
    public SeaAnimal(int p,int rf, String h)
    {
        super(p,rf,0);//no need for extra water since they live in it
        habitat = h;
    }

}
