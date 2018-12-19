package com.app.garden;

import javax.swing.*;
import java.util.Scanner;

/**
 * window implement
 */
public class App extends JFrame {

    private static final String DEFAULT_GARDEN_NAME = "Secret Garden";
    private Garden garden;

    public App() {
        super(DEFAULT_GARDEN_NAME);
        this.setSize(Garden.DEFAULT_GARDEN_WIDTH, Garden.DEFAULT_GARDEN_HEIGHT);
        this.setLocationRelativeTo(null);//设置窗体的显示位置
        garden = new Garden();
        this.setContentPane(garden);
        this.setVisible(true);
    }

    public void remove(int witch) {
        this.garden.removeFlowerbed(witch);
    }

    public void add(int x, int y, int width, int height, int rows, int columns, int groupType,  String[] flowers) {
        this.garden.addFlowerbed(x, y, width, height, rows, columns, groupType,  flowers);
        this.validate();
    }

    public void save() {
        this.garden.save();
    }

    public void exit() {
        this.setVisible(false);
        System.exit(0);
    }

    public static void main(String[] args) {
        App app = new App();
        while (true) {
            try {
                System.out.println("**************** MENU ****************");
                System.out.println("* 1.ADD                              *");
                System.out.println("* 2.REMOVE                           *");
                System.out.println("* 3.SAVE                             *");
                System.out.println("* 4.EXIT                             *");
                System.out.println("**************** MENU ****************");

                Scanner sc = new Scanner(System.in);
                System.out.print("Please choose: ");
                int choose = sc.nextInt();
                Menu menu = new Menu(choose);
                menu.active(app);
            } catch (Exception e) {
                System.out.println("Input invalid.");
            }
        }
    }
}
