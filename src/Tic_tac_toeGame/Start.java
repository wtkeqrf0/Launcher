package Tic_tac_toeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    static String string;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        System.out.println("Игра Крестики-Нолики\nНажмите ENTER, для начала игры.\nДля инструкции введите HELP или ПОМОЩЬ");
        help();
        System.out.println("Выберете режим: 1. vs ИИ  OR  2.two players\n(Введите цифру)");
        readNum();
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("Problems appears...");
            System.exit(-1);
        }
    }

    static void help() {
        try {
            String a = br.readLine();
            if (a.equalsIgnoreCase("help") || a.equalsIgnoreCase("Помощь")) {
                System.out.println("Чтобы походить, нужно ввести сначала число слева от игрового поля (нажать ENTER),\nа затем число над игровым полем (нажать ENTER)");
                Thread.sleep(1000);
                System.out.println();
                Thread.sleep(1000);
            }
            else {
                System.out.println("Введите символы ещё раз");
                help();
            }
        } catch (Exception ioException) {
            System.out.println("Problems appears...");
            System.exit(-1);
        }
    }

    static void readNum() {
        try {
            string = br.readLine();
            if (string.equalsIgnoreCase("1")) {
                new GameAI();
            } else if (string.equalsIgnoreCase("2")) {
                new Game();
            } else readNum();
        } catch (Exception e) {
            System.out.println("Введите число ещё раз");
            readNum();
        }
    }
}