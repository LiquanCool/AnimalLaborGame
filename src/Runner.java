import com.sun.tools.javac.Main;

public class Runner {
    public static void main(String[] args) {
        Data data = new Data();
        Shop shop = new Shop(1, data);//MAYBE MAKE MENU TO CHOOSE DIFFICULTY
        Hiring hire = new Hiring(data);
        //GameWindow frame = new GameWindow("Welcome to my game!");
        MainWindow frame = new MainWindow("Welcome to my game!");
    }
}
