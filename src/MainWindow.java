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
    private JPanel images;
    private JLabel background;

    public MainWindow(Data d) throws IOException {
        this.data = d;
        this.shop = new Shop(1, data);
        this.hiring = new Hiring(data);
        String imageURL = "images/whale.png";
        File f = new File("Info.dat");
        image = Toolkit.getDefaultToolkit().getImage(imageURL);
        background = new JLabel(new ImageIcon("images/grass.jpg"));
        background.setVisible(true);
        background.setSize(650,450);
        add(background);

        setContentPane(mainPanel);
        setTitle("Window Test");
        setSize(700,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

    class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
    public class CustomPaintComponent extends Component {

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            System.out.println(image);
            g2d.drawImage(image, 100, 100, null);
        }

    }
    public void paintComponent(Graphics g)
    {
        Graphics2D graphic = (Graphics2D) g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
