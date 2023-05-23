import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
public class MainWindow extends JFrame implements ActionListener, Serializable {
    private Image image;
    private Shop shop;
    private Hiring hiring;
    private Data data;
    private JButton hire;
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton water;
    private JButton feed;
    private JButton save;
    private JButton work;
    private JButton reset;
    private JButton buyFood;
    private JButton buyWater;
    private JButton buyPool;

    public MainWindow(Data d) {
        this.data = d;
        this.shop = new Shop(1, data);
        this.hiring = new Hiring(data);
        String imageURL = "images/whale.png";
        File f = new File("Info.dat");
        image = Toolkit.getDefaultToolkit().getImage(imageURL);

        setContentPane(mainPanel);
        setTitle("Window Test");
        setSize(700,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        textArea1.setEditable(false);
        buyFood.setText("Buy $20 Foods");
        buyWater.setText("Buy $20 Waters");
        feed.setText("Feed the animals");
        water.setText("Water the animals");
        work.setText("Make them work");
        hire.setText("Hire for " + hiring.getPrice());
        save.setText("Save and exit");
        reset.setText("Reset and exit");
        buyPool.setText("Unlock the pool and sea animals for $200");
        textArea1.setText(data.getStorage());

        buyFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = shop.buyFood();
                textArea1.setText(data.getStorage() + out);
            }
        });
        buyWater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = shop.buyWater();
                textArea1.setText(data.getStorage() + out);
            }
        });
        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = data.feed();
                textArea1.setText(data.getStorage() + out);//ADD FEEDING
            }
        });
        water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = data.water();
                textArea1.setText(data.getStorage() + out);//ADD WATERING
            }
        });
        work.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = data.work();
                textArea1.setText(data.getStorage() + out );//Work
            }
        });
        hire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = hiring.hire();
                textArea1.setText(data.getStorage() + out);
                hire.setText("Hire for " + hiring.getPrice());
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() + "\nData Saved!" );//save game
                try {
                    Data.save(data);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );
                f.delete();//reset game
                System.exit(0);
            }
        });
        buyPool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String out = shop.buyPool();
                textArea1.setText(data.getStorage() + out);
            }
        });
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
