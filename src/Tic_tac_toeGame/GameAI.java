package Tic_tac_toeGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameAI  {
     boolean win = true;
     int[][] ig = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    GameAI() {
        System.out.println("Ваш ход");
        for (int i = 0; win; i++) {
            if (i % 2 == 0) {
                getField(ig);
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    int a = Integer.parseInt(br.readLine()) - 1;
                    if (a > 2 || a < 0) {
                        System.out.println("Введи число ещё раз");
                        a = Integer.parseInt(br.readLine()) - 1;
                    }
                    int b = Integer.parseInt(br.readLine()) - 1;
                    if (b > 2 || b < 0) {
                        System.out.println("Введи число ещё раз");
                        b = Integer.parseInt(br.readLine()) - 1;
                    }
                    if (ig[a][b] != 0) System.out.println("Сюда сходить уже нельзя");
                    ig[a][b] = 1;
                } catch (Exception e) {
                    System.out.println("Ввели что-то не то");
                }
            } else {
                int p1=(int) (Math.random()*3);
                int p2=(int) (Math.random()*3);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("Ой!");
                } while (ig[p1][p2]!=0) {
                    p1=(int) (Math.random()*3);
                    p2=(int) (Math.random()*3);
                } ig[p1][p2]=2;
            }
                checkOnWin(ig);
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
    }