package Tic_tac_toeGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
     boolean win=true;
     int[][] ig={{0,0,0},{0,0,0},{0,0,0}};
     int i;
    Game() {
        for (i = 0; win; i++) {
            if (i%2==0) System.out.println("Крестики ходят");
            else System.out.println("Нолики ходят");
            getField(ig);
            readField();
            checkOnWin(ig);
        }
    }

    void readField () {
        int a=6,b=6;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            a = Integer.parseInt(br.readLine()) - 1;
            b = Integer.parseInt(br.readLine()) - 1;
        } catch (Exception e) {
            System.out.println("Problems appears...");
            System.exit(-1);
        } while (a>2||a<0||b>2||b<0) {
            System.out.println("Введи свой ход ещё раз");
            try {
                a = Integer.parseInt(br.readLine()) - 1;
                b = Integer.parseInt(br.readLine()) - 1;
            } catch (Exception e) {
                System.out.println("Problems appears...");
                System.exit(-1);
            }
        } if (ig[a][b]!=0) System.out.println("Сюда сходить уже нельзя");
            else if (i%2==0) ig[a][b]=1;
            else ig[a][b]=2;
    }

     void getField(int[][] a) {
        System.out.println("\t1\t2\t3");
        for (int i = 0; i < 3; i++) {
            System.out.print((1+i)+"\t");
            for (int j = 0; j <3; j++) {
                if (a[i][j]==0) System.out.print("☐\t");
                else if (a[i][j]==1) System.out.print("❌\t");
                else if (a[i][j]==2) System.out.print("⭕\t");
            }
            System.out.println();
        }
    }
     void checkOnWin(int[][] a) {
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j]!=0) count++;
            }
        }
        if ((a[0][0] == a[0][1] && a[0][1] == a[0][2] && a[0][1] == 1) || (a[1][0] == a[1][1] && a[1][1] == a[1][2] && a[1][1] == 1) || (a[2][0] == a[2][1] && a[2][1] == a[2][2] && a[2][1] == 1) ||
                (a[0][1] == a[1][1] && a[1][1] == a[2][1] && a[1][1] == 1) || (a[0][0] == a[1][0] && a[1][0] == a[2][0] && a[1][0] == 1) || (a[0][2] == a[1][2] && a[1][2] == a[2][2] && a[1][2] == 1) ||
                (a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[1][1] == 1) || (a[2][0] == a[1][1] && a[1][1] == a[0][2] && a[1][1] == 1)) {
            System.out.println("Крестики выйграли!");
            getField(ig);
            win = false;
        } else if ((a[0][0] == a[0][1] && a[0][1] == a[0][2] && a[0][1] == 2) || (a[1][0] == a[1][1] && a[1][1] == a[1][2] && a[1][1] == 2) || (a[2][0] == a[2][1] && a[2][1] == a[2][2] && a[2][1] == 2) ||
                (a[0][1] == a[1][1] && a[1][1] == a[2][1] && a[1][1] == 2) || (a[0][0] == a[1][0] && a[1][0] == a[2][0] && a[1][0] == 2) || (a[0][2] == a[1][2] && a[1][2] == a[2][2] && a[1][2] == 2) ||
                (a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[1][1] == 2) || (a[2][0] == a[1][1] && a[1][1] == a[0][2] && a[1][1] == 2)) {
            System.out.println("Нолики выйграли!");
            getField(ig);
            win = false;
        } else if (count==9) {
            System.out.println("Ничья!");
            getField(ig);
            win=false;
        }
    }
}
