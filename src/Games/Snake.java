package Games;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.RecursiveAction;

public class MainWindow extends RecursiveAction {

    @Override
    protected void compute() {
        JFrame game=new JFrame("Змейка");
        GameField g=new GameField(game);
        game.add(g);
        game.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                OpenWindow.inGame=false;
            }});
        game.setIconImage(new ImageIcon(OpenWindow.property+"appleIcon.png").getImage());
        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        game.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                OpenWindow.inGame=false;
            }});
        game.setSize(355, 378);
        game.setLocationRelativeTo(null);
        game.setResizable(false);
        game.setVisible(true);
    }
}
