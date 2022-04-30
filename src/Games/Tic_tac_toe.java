package Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.RecursiveAction;

public class Tic_tac_toe extends RecursiveAction implements ActionListener {
    protected final JButton b1 = new JButton(), b2 = new JButton(), b3 = new JButton(), b4 = new JButton(), b5 = new JButton(),
            b6 = new JButton(), b7 = new JButton(), b8 = new JButton(), b9 = new JButton();
    protected int count = 0;
    private final ImageIcon circle=new ImageIcon(OpenWindow.property+"circle.png"),
            cross=new ImageIcon(OpenWindow.property+"cross.png"),
            nothing=new ImageIcon(OpenWindow.property+"Nothing.png");
    protected final JFrame frame=new JFrame("Крестики нолики");

    @Override
    protected void compute() {
        Timer time=new Timer(12000,e->OpenWindow.t.stop());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container c = frame.getContentPane();
        Font f = new Font("Tic-Tac-Toe", Font.BOLD, 80);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(cross.getImage());
        frame.setSize(320, 300);
        Dimension d = frame.getSize();
        Point p = frame.getLocation();
        frame.setLocation((int) (p.getX() - d.width / 2), (int) (p.getY() - d.height / 2));
        frame.setLayout(new GridLayout(3, 3));
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                OpenWindow.inGame=false;
            }});
        b1.setFont(f);
        b1.setActionCommand("1");
        c.add(b1);
        b2.setFont(f);
        b2.setActionCommand("2");
        c.add(b2);
        b3.setFont(f);
        b3.setActionCommand("3");
        c.add(b3);
        b4.setFont(f);
        b4.setActionCommand("4");
        c.add(b4);
        b5.setFont(f);
        b5.setActionCommand("5");
        c.add(b5);
        b6.setFont(f);
        b6.setActionCommand("6");
        c.add(b6);
        b7.setFont(f);
        b7.setActionCommand("7");
        c.add(b7);
        b8.setFont(f);
        b8.setActionCommand("8");
        c.add(b8);
        b9.setFont(f);
        b9.setActionCommand("9");
        c.add(b9);
        frame.setVisible(true);
    }

    void checkOnWin() {
        String str1 = b1.getText(), str2 = b2.getText(),
                str3 = b3.getText(), str4 = b4.getText(), str5 = b5.getText(), str6 = b6.getText(),
                str7 = b7.getText(), str8 = b8.getText(), str9 = b9.getText();
        if (str1.equals(str2) && str2.equals(str3) && !str2.isBlank()) {
            b1.setBackground(Color.ORANGE);
            b2.setBackground(Color.ORANGE);
            b3.setBackground(Color.ORANGE);
            if (str2.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str4.equals(str5) && str5.equals(str6) && !str5.isBlank()) {
            b4.setBackground(Color.ORANGE);
            b5.setBackground(Color.ORANGE);
            b6.setBackground(Color.ORANGE);
            if (str5.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str7.equals(str8) && str8.equals(str9) && !str8.isBlank()) {
            b7.setBackground(Color.ORANGE);
            b8.setBackground(Color.ORANGE);
            b9.setBackground(Color.ORANGE);
            if (str8.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str1.equals(str4) && str4.equals(str7) && !str4.isBlank()) {
            b1.setBackground(Color.ORANGE);
            b4.setBackground(Color.ORANGE);
            b7.setBackground(Color.ORANGE);
            if (str4.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str2.equals(str5) && str5.equals(str8) && !str5.isBlank()) {
            b2.setBackground(Color.ORANGE);
            b5.setBackground(Color.ORANGE);
            b8.setBackground(Color.ORANGE);
            if (str5.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str3.equals(str6) && str6.equals(str9) && !str6.isBlank()) {
            b3.setBackground(Color.ORANGE);
            b6.setBackground(Color.ORANGE);
            b9.setBackground(Color.ORANGE);
            if (str6.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str1.equals(str5) && str5.equals(str9) && !str5.isBlank()) {
            b1.setBackground(Color.ORANGE);
            b5.setBackground(Color.ORANGE);
            b9.setBackground(Color.ORANGE);
            if (str5.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (str3.equals(str5) && str5.equals(str7) && !str5.isBlank()) {
            b3.setBackground(Color.ORANGE);
            b5.setBackground(Color.ORANGE);
            b7.setBackground(Color.ORANGE);
            if (str5.equals("O"))
                JOptionPane.showMessageDialog(null, "Нолики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, circle);
            else JOptionPane.showMessageDialog(null, "Крестики победили!", "Победа!", JOptionPane.PLAIN_MESSAGE, cross);
            frame.dispose();
            OpenWindow.inGame=false;
        } else if (!str1.isBlank() && !str2.isBlank() && !str3.isBlank() && !str4.isBlank() && !str5.isBlank() && !
                str6.isBlank() && !str7.isBlank() && !str8.isBlank() && !str9.isBlank()) {
            JOptionPane.showMessageDialog(null, "Ничья!", "Победила дружба)", JOptionPane.PLAIN_MESSAGE,nothing);
            frame.dispose();
            OpenWindow.inGame=false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        String str = (count % 2) == 1 ? "X" : "O";
        switch (e.getActionCommand()) {
            case "1" -> {
                b1.setText(str);
                b1.setEnabled(false);
                b1.setBackground(Color.DARK_GRAY);
            }
            case "2" -> {
                b2.setText(str);
                b2.setEnabled(false);
                b2.setBackground(Color.DARK_GRAY);
            }
            case "3" -> {
                b3.setText(str);
                b3.setEnabled(false);
                b3.setBackground(Color.DARK_GRAY);
            }
            case "4" -> {
                b4.setText(str);
                b4.setEnabled(false);
                b4.setBackground(Color.DARK_GRAY);
            }
            case "5" -> {
                b5.setText(str);
                b5.setEnabled(false);
                b5.setBackground(Color.DARK_GRAY);
            }
            case "6" -> {
                b6.setText(str);
                b6.setEnabled(false);
                b6.setBackground(Color.DARK_GRAY);
            }
            case "7" -> {
                b7.setText(str);
                b7.setEnabled(false);
                b7.setBackground(Color.DARK_GRAY);
            }
            case "8" -> {
                b8.setText(str);
                b8.setEnabled(false);
                b8.setBackground(Color.DARK_GRAY);
            }
            case "9" -> {
                b9.setText(str);
                b9.setEnabled(false);
                b9.setBackground(Color.DARK_GRAY);
            }
        }
        checkOnWin();
    }
}
