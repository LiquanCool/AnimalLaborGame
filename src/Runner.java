import com.sun.tools.javac.Main;

public class Runner {
    public static void main(String[] args) {
        Data data = new Data();

        //GameWindow frame = new GameWindow("Welcome to my game!");
        MainWindow frame = new MainWindow(data);
    }
}
