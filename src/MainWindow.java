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
    private JLabel Grass;
    private JPanel images;
    private JLabel background;
    private ImageIcon grassIcon;

    public MainWindow(Data d) throws IOException {
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
        setLocationRelativeTo(null);
        setVisible(true);



        grassIcon = new ImageIcon(image);
        background = new JLabel(grassIcon);
        background.setLocation(100,100);
        background.setSize(200,100);
        background.setVisible(true);


        grass.setText("");

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
                mainPanel.repaint();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
