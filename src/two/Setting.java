package two;

import Games.OpenWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class Setting extends RecursiveAction implements ActionListener {

    private final Font f = new Font(Font.SANS_SERIF, Font.BOLD, 35);
    private final Font F = new Font(Font.SANS_SERIF, Font.BOLD, 25);
    private final JRadioButton rb1 = new JRadioButton("Против ИИ"), rb2 = new JRadioButton("Против друга");
    private final JButton save = new JButton("Сохранить"), autoSave = new JButton("Сброс настроек");
    private JSpinner s1, s2;
    private final JLabel Tic_Tac = new JLabel(), Snake = new JLabel(),
            speedText = new JLabel("Скорость змейки:"),
            difText = new JLabel("Сложность бота:");
    private final Color c = new Color(180, 180, 180);
    private final JCheckBox bonus = new JCheckBox("Золотое яблоко");
    private final JFrame stng = new JFrame("Настройки");
    private final ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();

    @Override
    protected void compute() {
        stng.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        stng.setIconImage(new ImageIcon("OpenWindow.property" + "Setting.png").getImage());
        stng.setResizable(false);
        stng.setLocationRelativeTo(null);
        stng.setSize(550, 450);
        stng.getContentPane().setBackground(c);
        Dimension d = stng.getSize();
        Point p = stng.getLocation();
        stng.setLocation((int) (p.getX() - d.width / 2), (int) (p.getY() - d.height / 2));
        stng.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        list1.add("Случайно");
        list1.add("Легко");
        list1.add("Приемлимо");
        list1.add("Сложно");
        list1.add("Безумно");
        list1.add("Невозможно");
        s1 = new JSpinner(new SpinnerListModel(list1));
        s1.setValue(list1.get(0));

        list2.add("Ультра");
        list2.add("Быстро");
        list2.add("Обычно");
        list2.add("Медленно");
        s2 = new JSpinner(new SpinnerListModel(list2));
        s2.setValue(list2.get(0));

        JLabel Title1 = new JLabel("Крестики-нолики");
        JLabel Title2 = new JLabel("Змейка");

        speedText.setFont(F);
        difText.setFont(F);
        Title1.setFont(f);
        Title2.setFont(f);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        rb1.setBackground(c);
        rb1.setFont(F);
        rb1.addActionListener(this);
        rb2.setBackground(c);
        rb2.setFont(F);
        rb2.addActionListener(this);
        s2.setBackground(c);
        s2.setFont(F);
        s1.setBackground(c);
        s1.setFont(F);
        save.addActionListener(this);
        save.setFont(f);
        autoSave.addActionListener(this);
        autoSave.setFont(f);
        bonus.addActionListener(this);
        bonus.setBackground(c);
        bonus.setSelected(true);
        bonus.setFont(F);

        Tic_Tac.setLayout(new GridBagLayout());
        Tic_Tac.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        Snake.setLayout(new GridBagLayout());
        Snake.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        g.fill = GridBagConstraints.BOTH;
        g.gridheight = 3;
        g.ipadx = 70;
        g.ipady = 10;
        g.insets = new Insets(0, 110, 0, 0);
        g.gridwidth = GridBagConstraints.REMAINDER;
        Tic_Tac.add(Title1, g);
        g.gridwidth = 2;
        g.insets = new Insets(0, 10, 0, 0);
        Tic_Tac.add(rb1, g);
        g.gridwidth = GridBagConstraints.REMAINDER;
        g.insets = new Insets(0, 0, 0, 0);
        Tic_Tac.add(rb2, g);
        g.gridwidth = 2;
        g.insets = new Insets(0, 10, 0, 0);
        Tic_Tac.add(difText, g);
        g.weightx = 1.0;
        g.insets = new Insets(0, 0, 0, 70);
        g.gridwidth = GridBagConstraints.REMAINDER;
        g.ipadx = 30;
        Tic_Tac.add(s1, g);
        g.ipadx = 70;
        g.weightx = 0.0;
        g.insets = new Insets(0, 200, 0, 0);
        Snake.add(Title2, g);
        g.insets = new Insets(0, 10, 0, 0);
        g.gridwidth = 2;
        Snake.add(speedText, g);
        g.insets = new Insets(0, 0, 0, 70);
        g.gridwidth = GridBagConstraints.REMAINDER;
        g.ipadx = 30;
        Snake.add(s2, g);
        g.weightx = 1.0;
        g.ipadx = 100;
        g.insets = new Insets(0, 10, 0, 0);
        Snake.add(bonus, g);
        g.insets = new Insets(0, 0, 0, 0);
        g.ipadx = 150;
        g.ipady = 165;

        stng.add(Tic_Tac, g);
        stng.add(Snake, g);
        g.gridwidth = 2;
        g.ipadx = 50;
        g.ipady = 20;
        stng.add(save, g);
        stng.add(autoSave, g);

        if (true) rb1.setSelected(true);
        else rb2.setSelected(true);

        stng.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Сохранить" -> {
            }
        }
    }
}