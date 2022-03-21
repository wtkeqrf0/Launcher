package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;

public class GameField extends JPanel implements ActionListener {
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private final Image DOT = new ImageIcon(OpenWindow.property+"dot.png").getImage(),
            APPLE = new ImageIcon(OpenWindow.property+"apple.png").getImage(),
            GAPPLE = new ImageIcon(OpenWindow.property+"gapple.png").getImage(),
            CHERRY = new ImageIcon(OpenWindow.property+"cherry.png").getImage(),
            GRAPE = new ImageIcon(OpenWindow.property+"grape.png").getImage(),
            STRAWBERRY = new ImageIcon(OpenWindow.property+"strawberry.png").getImage(),
            BANANA = new ImageIcon(OpenWindow.property+"banana.png").getImage(),
            WATERMELON = new ImageIcon(OpenWindow.property+"watermelon.png").getImage();
    private int appleX, appleY;
    private final int[] x = new int[ALL_DOTS], y = new int[ALL_DOTS];
    private int dots, rand;
    private boolean left = false, right = true, up = false, down = false, next = false, next1 = false, inGame=true;
    private final JFrame game;

    public GameField(JFrame g) {
        game=g;
        setOpaque(true);
        setBackground(new Color(25, 125, 25));
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(new Color(125, 55, 15), 5));
        initGame();
        Timer time=new Timer(10000,e->OpenWindow.t.stop());
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        Timer timer=new Timer(500-(OpenWindow.speedOfSnake*150),this);
        timer.start();
        createApple();
    }

    public void createApple() {
        appleX = (int) (Math.random() * 21) * DOT_SIZE;
        appleY = (int) (Math.random() * 21) * DOT_SIZE;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            if (OpenWindow.goldenApple && rand > 5) g.drawImage(GAPPLE, appleX, appleY, this);
            else switch (rand) {
                case 0, 6 -> g.drawImage(APPLE, appleX, appleY, this);
                case 1 -> g.drawImage(GRAPE, appleX, appleY, this);
                case 2 -> g.drawImage(CHERRY, appleX, appleY, this);
                case 3 -> g.drawImage(STRAWBERRY, appleX, appleY, this);
                case 4 -> g.drawImage(BANANA, appleX, appleY, this);
                case 5 -> g.drawImage(WATERMELON, appleX, appleY, this);
            }
            for (int i = 0; i < dots; i++) {
                g.drawImage(DOT, x[i], y[i], this);
            }
        } else {
            OpenWindow.inGame=false;
            game.dispose();
            JOptionPane.showMessageDialog(null, "Количество очков - " + (dots - 3),
                    "Игра окончена", JOptionPane.PLAIN_MESSAGE, new ImageIcon(OpenWindow.property+"death.png"));
        }
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            createApple();
            rand = (int) (Math.random() * 7);
            if (OpenWindow.goldenApple && next1) {
                dots += 3;
                next1 = false;
            } else dots++;
            if (OpenWindow.goldenApple && rand > 5) next = true;
            if (OpenWindow.goldenApple && next) {
                next1 = true;
                next = false;
            }
        }
    }

    public void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
                break;
            }
        }
        int SIZE = 320;
        if (x[0] > SIZE || x[0] < 0 || y[0] > SIZE || y[0] < 0) inGame = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_A && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_D && !left) {
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_W && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_S && !up) {
                right = false;
                down = true;
                left = false;
            }
        }
    }
}