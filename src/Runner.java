import com.sun.tools.javac.Main;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Runner implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Data data = new Data();
        File f = new File("Info.dat");
        if(f.exists() && !f.isDirectory()) {
            data = Data.useData(data);
        }
        MainWindow frame = new MainWindow(data);
    }
}
