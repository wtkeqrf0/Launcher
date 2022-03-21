package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.RecursiveAction;

public class Waiting extends RecursiveAction implements ActionListener, MouseMotionListener {
    private int x = 5,y = 30,xa = (int) (Math.random() * 4) + 2,ya = (int) (Math.random() * 4) + 2,sum=0;
    private final int WIDTH = 800,HEIGHT = 700;
    private final ImageIcon im = new ImageIcon(OpenWindow.property+"note.png");
    private final JLabel l = new JLabel(im);
    private final Image i = im.getImage();
    protected static Timer t;
    protected static JFrame frame=new JFrame();

    @Override
    protected void compute() {
        starting();
        frame.addMouseMotionListener(this);
    }

    protected void starting() {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setIconImage(i);
        frame.setSize(new Dimension(WIDTH + 10, HEIGHT + 10));
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setAutoRequestFocus(true);
        frame.toFront();
        frame.setResizable(false);
        frame.setLayout(null);

        l.setBounds(x, y, i.getWidth(null), i.getHeight(null));
        frame.add(l);

        t = new Timer(10, this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= (WIDTH - l.getWidth() - 3)) xa = -xa;
        if (y >= (HEIGHT - l.getHeight() - 25)) ya = -ya;
        if (x < -3) xa = -xa;
        if (y < -3) ya = -ya;

        x += xa;
        y += ya;
        l.setLocation(x, y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (sum>10) {
            frame.setVisible(false);
            t.stop();
            sum=0;
        }
        sum++;
    }
}