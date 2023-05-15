import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
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

    public MainWindow(Data data) {
        this.data = data;
        this.shop = new Shop(1, data);
        this.hiring = new Hiring(data);
        String imageURL = "images/whale.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);

        setContentPane(mainPanel);
        setTitle("Window Test");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        textArea1.setEditable(false);
        buyFood.setText("Buy 10 Foods");
        buyWater.setText("Buy 10 Waters");
        feed.setText("Feed the animals");
        water.setText("Water the animals");
        work.setText("Make them work");
        hire.setText("Hire for " + hiring.getPrice());
        save.setText("Save and exit");
        reset.setText("Reset and exit");


        buyFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() + shop.buyFood());
            }
        });
        buyWater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() + shop.buyWater());
            }
        });
        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );//ADD FEEDING
            }
        });
        water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );//ADD WATERING
            }
        });
        work.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );//Work
            }
        });
        hire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() + hiring.hire());
                hire.setText("Hire for " + hiring.getPrice());
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );//save game
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(data.getStorage() );//reset game
            }
        });
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
