package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    JButton b = new JButton("Я согласен с тем, что я лох");
    JTextField tf = new JTextField("Ты лох)))", 1);
    JLabel l = new JLabel("Напиши, что ты лох");
    JRadioButton rb1 = new JRadioButton("Я обещаю оставаться лохом");
    JRadioButton rb2 = new JRadioButton("Пошел нахуй");
    Checkbox ch = new Checkbox("Хочу быть лохом всегда");

    public static void main(String[] args) {
        new Window();
    }

    Window() {
        setTitle("Тест на лоха");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setSize(500, 150);
        Container c = this.getContentPane();
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        c.setLayout(new GridLayout(3, 2, 10, 10));
        c.add(l);
        c.add(tf);
        c.add(rb1);
        rb2.addActionListener(new NotSelected());
        rb1.setSelected(true);
        c.add(rb2);
        c.add(ch);
        b.addActionListener(new EndAct());
        c.add(b);
        setVisible(true);
    }

    class NotSelected implements ActionListener {
        int count;

        @Override
        public void actionPerformed(ActionEvent e) {
            rb1.setSelected(true);
            JOptionPane.showMessageDialog(null, "Сам пошел", "Охуел?", JOptionPane.PLAIN_MESSAGE);
            count++;
            if (count >= 9) {
                JOptionPane.showMessageDialog(null, "Да ты заебал...", "Фу таким быть(", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

        }
    }

    class EndAct implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!tf.getText().contains("лох"))
                JOptionPane.showMessageDialog(null, "Пиздишь как дышишь", "Наёб", JOptionPane.PLAIN_MESSAGE);
            else {
                if (ch.getState())
                    JOptionPane.showMessageDialog(null, "Ультрасупердупермега лошара", "Вечный", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Вот он - настоящий лошара", "Харош)", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}