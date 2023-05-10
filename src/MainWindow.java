import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements ActionListener {

    private JFrame j;
    private JPanel p;
    private Image image;
    private int x;
    private int y;
    private JButton button1;
    private JPanel mainPanel;

    public MainWindow(String display) {
        x = 100;
        y = 100;
        int frameWidth = 500;
        int frameHeight = 500;
        j = new JFrame(display);

        j.addKeyListener(new MainWindow.KeyTracker());
        j.add(new MainWindow.CustomPaintComponent());

        String imageURL = "images/whale.png";
        image = Toolkit.getDefaultToolkit().getImage(imageURL);

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(frameWidth, frameHeight);
        j.setLocation(5, 5);
        j.setVisible(true);
        setContentPane(mainPanel);
        setTitle("Window Test");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }

    public class KeyTracker extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            j.repaint();
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_A) {
                x = x - 10;
                j.repaint();
            }
            if (key == KeyEvent.VK_S) {
                y = y + 10;
                j.repaint();
            }
            if (key == KeyEvent.VK_D) {
                x = x + 10;
                j.repaint();
            }
            if (key == KeyEvent.VK_W) {
                y = y - 10;
                j.repaint();
            }
        }

    }

    public class CustomPaintComponent extends Component {

        public void paint(Graphics g) {
            System.out.println("Paint " + x + " " + y);
            Graphics2D g2d = (Graphics2D)g;
            System.out.println(image);
            g2d.drawImage(image, x, y, null);
        }

    }
}
