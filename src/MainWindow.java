import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

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
    private JLabel grass;
    private JLabel turtleLabel;
    private ImageIcon turtleIcon;
    private JLabel cowLabel;
    private ImageIcon cowIcon;
    private JLabel giraffeLabel;
    private ImageIcon giraffeIcon;
    private JLabel fishLabel;
    private ImageIcon fishIcon;
    private JLabel penguinLabel;
    private ImageIcon penguinIcon;
    private JLabel whaleLabel;
    private ImageIcon whaleIcon;
    private JLabel poolLabel;
    private ImageIcon poolIcon;

    public MainWindow(Data d) throws IOException {
        this.data = d;
        this.shop = new Shop(1, data);
        this.hiring = new Hiring(data);
        File f = new File("Info.dat");

        String imageURL = "src/turtle.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        turtleIcon = new ImageIcon(image);
        turtleLabel = new JLabel(turtleIcon);
        turtleLabel.setLocation(50,250);
        turtleLabel.setSize(200,100);
        turtleLabel.setVisible(false);
        grass.add(turtleLabel);
        imageURL = "src/cow.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        cowIcon = new ImageIcon(image);
        cowLabel = new JLabel(cowIcon);
        cowLabel.setLocation(50,50);
        cowLabel.setSize(200,100);
        cowLabel.setVisible(false);
        grass.add(cowLabel);
        imageURL = "src/giraffe.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        giraffeIcon = new ImageIcon(image);
        giraffeLabel = new JLabel(giraffeIcon);
        giraffeLabel.setLocation(300,-20);
        giraffeLabel.setSize(200,400);
        giraffeLabel.setVisible(false);
        grass.add(giraffeLabel);
        imageURL = "src/fish.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        fishIcon = new ImageIcon(image);
        fishLabel = new JLabel(fishIcon);
        fishLabel.setLocation(550,50);
        fishLabel.setSize(200,100);
        fishLabel.setVisible(false);
        grass.add(fishLabel);
        imageURL = "src/penguin.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        penguinIcon = new ImageIcon(image);
        penguinLabel = new JLabel(penguinIcon);
        penguinLabel.setLocation(800,50);
        penguinLabel.setSize(200,100);
        penguinLabel.setVisible(false);
        grass.add(penguinLabel);
        imageURL = "src/whale.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        whaleIcon = new ImageIcon(image);
        whaleLabel = new JLabel(whaleIcon);
        whaleLabel.setLocation(500,175);
        whaleLabel.setSize(550,200);
        whaleLabel.setVisible(false);
        grass.add(whaleLabel);
        imageURL = "src/pool.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        poolIcon = new ImageIcon(image);
        poolLabel = new JLabel(poolIcon);
        poolLabel.setLocation(520,5);
        poolLabel.setSize(550,390);
        poolLabel.setVisible(false);
        grass.add(poolLabel);


        setContentPane(mainPanel);
        setTitle("Window Test");
        setSize(1100,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);




        //grass.setText("");

        textArea1.setEditable(false);
        textArea1.setFont(new Font("Arial", Font.PLAIN, 20));
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
        update();

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
                update();
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
                update();
            }
        });
    }

    public void update()
    {
        if(data.isPool())
        {
            poolLabel.setVisible(true);
        }
        for (int i = 0 ;i<data.getOwnedAnimalList().size();i++)
        {
            Animal current = data.getOwnedAnimalList().get(i);
            if (current.getType().equals("turtle"))
            {
                turtleLabel.setVisible(true);
            }
            if (current.getType().equals("cow"))
            {
                cowLabel.setVisible(true);
            }
            if (current.getType().equals("giraffe"))
            {
                giraffeLabel.setVisible(true);
            }
            if (current.getType().equals("fish"))
            {
                fishLabel.setVisible(true);
            }
            if (current.getType().equals("penguin"))
            {
                penguinLabel.setVisible(true);
            }
            if (current.getType().equals("whale"))
            {
                whaleLabel.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
