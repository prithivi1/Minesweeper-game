package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("M INDICATES MINE");
        System.out.println("BOARD SIZE : 10 * 10");
        System.out.println("TOTAL NUMBER OF MINES : 10");

        MiniSweeper mini = new MiniSweeper();

        while (true) {
            System.out.println("enter row : ");
            int x = sc.nextInt();
            System.out.println("enter column : ");
            int y = sc.nextInt();
            if (mini.select(x,y))
            {
                return;
            }
        }
    }
}
