package Games;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.random;

public class WindowGameAI extends WindowGame {
    private int rand = -1;
    private final boolean[] mas=new boolean[9];
    private boolean stupid,brain=false;
    private final ArrayList<JButton> list=new ArrayList<>();

    WindowGameAI() {
        super();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(b7);
        list.add(b8);
        list.add(b9);
    }

    void botTurn(JButton b) {
       if (b.isEnabled()) {
           b.setEnabled(false);
           b.setText("O");
       }
        else botTurn(stupid?list.get((int) (random() * 9)):think());
    }

    JButton think() {
        String s1 = b1.getText().isEmpty()?"1":b1.getText(), s2 = b2.getText().isEmpty()?"2":b2.getText(),
                s3 = b3.getText().isEmpty()?"3":b3.getText(), s4 = b4.getText().isEmpty()?"4":b4.getText(),
                s5 = b5.getText().isEmpty()?"5":b5.getText(), s6 = b6.getText().isEmpty()?"6":b6.getText(),
                s7 = b7.getText().isEmpty()?"7":b7.getText(), s8 = b8.getText().isEmpty()?"8":b8.getText(),
                s9 = b9.getText().isEmpty()?"9":b9.getText();
        if (mas[0]&&(s2.equals(s3) || s5.equals(s9) || s4.equals(s7))) {
            mas[0]=false;
            return list.get(0);
        }
        else if (mas[1]&&(s1.equals(s3) || s5.equals(s8)||s3.equals(s7))) {
            Arrays.fill(mas,0,2,false);
            return list.get(1);
        }
        else if (mas[2]&&(s1.equals(s2) || s6.equals(s9) || s5.equals(s7))) {
            Arrays.fill(mas,0,3,false);
            return list.get(2);
        }
        else if (mas[3]&&(s1.equals(s7) || s5.equals(s6))) {
            Arrays.fill(mas,0,4,false);
            return list.get(3);
        }
        else if (mas[4]&&(s1.equals(s9) || s3.equals(s7) || s4.equals(s6)|| s2.equals(s8))) {
            Arrays.fill(mas,0,5,false);
            return list.get(4);
        }
        else if (mas[5]&&(s3.equals(s9) || s4.equals(s5))) {
            Arrays.fill(mas,0,6,false);
            return list.get(5);
        }
        else if (mas[6]&&(s1.equals(s4) || s8.equals(s9) || s3.equals(s5))) {
            Arrays.fill(mas,0,7,false);
            return list.get(6);
        }
        else if (mas[7]&&(s2.equals(s5) || s7.equals(s9))) {
            Arrays.fill(mas,0,8,false);
            return list.get(7);
        }
        else if (mas[8]&&(s1.equals(s5) || s7.equals(s8) || s3.equals(s6))) {
            Arrays.fill(mas,false);
            return list.get(8);
        } return some_think();
    }

    JButton some_think() {
        if (rand != -1) {
            switch ((int) (random() * 18)) {
                case 0-> {
                    if ((rand + 9) <= 8) rand += 9;
                    else return some_think();
                }
                case 1->{
                    if ((rand - 9) >= 0) rand -= 9;
                    else return some_think();
                }
                case 2 -> {
                    if ((rand + 5) <= 8&&rand!=1&&rand!=3) rand += 5;
                    else return some_think();
                }
                case 3 -> {
                    if ((rand - 5) >= 0&&rand!=7&&rand!=5) rand -= 5;
                    else return some_think();
                }
                case 4 -> {
                    if ((rand + 3) <= 8) rand += 3;
                    else return some_think();
                }
                case 5 -> {
                    if ((rand - 3) >= 0) rand -= 3;
                    else return some_think();
                }
                case 6 -> {
                    if ((rand - 1) >= 0) rand--;
                    else return some_think();
                }
                case 7 -> {
                    if ((rand + 1) <= 8) rand++;
                    else return some_think();
                }
                case 8 -> {
                    if ((rand + 7) <= 8&&rand!=1) rand+=7;
                    else return some_think();
                }
                case 9 -> {
                    if ((rand - 7) >= 0&&rand!=7) rand+=7;
                    else return some_think();
                }
                case 10 -> {
                    if ((rand - 2) >= 0&&rand%2==0) rand-=2;
                    else return some_think();
                }
                case 11 -> {
                    if ((rand + 2) <= 8 && rand % 2 == 0) rand += 2;
                    else return some_think();
                }
                case 12 -> {
                    if ((rand + 4) <= 8 && rand!=1&&rand!=3) rand += 4;
                    else return some_think();
                }
                case 13 -> {
                    if ((rand - 4) >= 0 && rand!=7&&rand!=5) rand -= 4;
                    else return some_think();
                }
                case 14 -> {
                    if ((rand + 6) <= 8) rand += 6;
                    else return some_think();
                }
                case 15 -> {
                    if ((rand - 6) >= 0) rand -= 6;
                    else return some_think();
                }
                case 16 -> {
                    if ((rand + 8) <= 8) rand += 8;
                    else return some_think();
                }
                case 17 -> {
                    if ((rand - 8) >= 0) rand -= 8;
                    else return some_think();
                }
            }
        } else {
            brain=true;
            rand=4;
            return list.get(4);
        }
        if (brain) switch ((int) (random() * 4)) {
            case 0 -> rand=1;
            case 1 -> rand=3;
            case 2 -> rand=5;
            case 3 -> rand=7;
        } brain=false;
        return list.get(rand);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (count < 9&&frame.isActive()) {
            stupid=false;
            Arrays.fill(mas,true);
            if (((int) (random() * 6)) > OpenWindow.botDif) {
                botTurn(list.get((int) (random() * 9)));
                stupid=true;
            }
            else botTurn(think());
            count++;
            checkOnWin();
        }
    }
}