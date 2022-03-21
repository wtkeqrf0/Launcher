package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class OpenWindow extends JFrame implements ActionListener, MouseMotionListener {
    public static void main(String[] args) {
        new OpenWindow();
    }

    protected static int speedOfSnake, botDif;
    protected static boolean bot, goldenApple, inGame=false;
    private static final String a = String.valueOf(OpenWindow.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    protected static String property=a.substring(1,a.lastIndexOf('/'))+"/Pictures/";
    protected static final Path info = Path.of(property+"info.txt");
    protected static Timer t;
    private final ForkJoinPool fork = new ForkJoinPool();
    protected static final ImageIcon i=new ImageIcon(OpenWindow.property+"error.png");

    OpenWindow() {
        super("Launcher");
        setIconImage(new ImageIcon(property+"note.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(800, 700);
        Dimension d = getSize();
        Point p = getLocation();
        setLocation((int) (p.getX() - d.width / 2), (int) (p.getY() - d.height / 2));
        getContentPane().setBackground(new Color(50, 150, 250));
        GridBagConstraints g = new GridBagConstraints();
        setLayout(new GridBagLayout());

        try {
            ArrayList<String> list = new ArrayList<>(Files.readAllLines(info));
            bot = Boolean.parseBoolean(list.get(0));
            botDif = Integer.parseInt(list.get(1));
            speedOfSnake = Integer.parseInt(list.get(2));
            goldenApple = Boolean.parseBoolean(list.get(3));
        } catch (IOException e) {
            dispose();
            JOptionPane.showMessageDialog(null,"Папка Pictures не найдена"
                    ,"Ошибка!",JOptionPane.ERROR_MESSAGE,OpenWindow.i);
            System.exit(0);
        }

        fork.execute(new Waiting());

        JLabel l = new JLabel("Выберете игру");
        l.setFont(new Font("", Font.BOLD, 60));
        Font f = new Font("Impact", Font.PLAIN, 40);
        JButton tic_Tac = new JButton("Крестики-нолики"), snake = new JButton("Змейка"),
                settings = new JButton("Настройки"), exit = new JButton("Выход");
        tic_Tac.setFont(f);
        tic_Tac.addActionListener(this);
        snake.setFont(f);
        snake.addActionListener(this);
        settings.setFont(f);
        settings.addActionListener(this);
        exit.setFont(f);
        exit.addActionListener(this);
        addMouseMotionListener(this);
        t = new Timer(20000, ex -> {
            if (!inGame) {
                Waiting.frame.setVisible(true);
                Waiting.t.start();
            }
        });
        t.setRepeats(false);

        g.fill = GridBagConstraints.BOTH;
        g.gridwidth = GridBagConstraints.REMAINDER;
        g.insets = new Insets(50, 180, 12, 100);
        g.gridheight = 1;
        g.ipadx = 100;
        g.ipady = 30;
        add(l, g);
        g.insets = new Insets(30, 100, 12, 100);
        add(tic_Tac, g);
        g.insets = new Insets(12, 100, 12, 100);
        add(snake, g);
        add(settings, g);
        g.insets = new Insets(12, 100, 15, 100);
        add(exit, g);

        setVisible(true);
        t.start();
        Waiting.t.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!inGame) {
            inGame=true;
            switch (e.getActionCommand()) {
                case "Крестики-нолики" -> {
                    if (bot) fork.execute(new WindowGameAI());
                    else fork.execute(new WindowGame());
                }
                case "Змейка" -> fork.execute(new MainWindow());
                case "Настройки" -> fork.execute(new Settings());
            }
        } if (e.getActionCommand().equals("Выход")) System.exit(0);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (inGame) t.stop();
        else if (!t.isRunning()) t.start();
        else t.restart();
    }
}