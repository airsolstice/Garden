package com.app.garden;

import java.util.Scanner;

/**
 * garden menu implement
 */
public class Menu {

    private int choose;

    public Menu(int choose) {
        this.choose = choose;
    }

    public void active(App context) throws Exception{
        Scanner sc = new Scanner(System.in);
        switch (choose) {
            case 1:
                boolean flag = true;
                int x = 0;
                while (flag) {
                    System.out.println(String.format("Input x, no greater than %s:", context.getWidth()));
                    x = sc.nextInt();
                    if (context.getWidth() >= x) {
                        flag = false;
                    } else {
                        System.out.println("Invalid x!");
                    }
                }
                flag = true;
                int y = 0;
                while (flag) {
                    System.out.println(String.format("Input y, no greater than %s:", context.getHeight()));
                    y = sc.nextInt();
                    if (context.getHeight() >= y) {
                        flag = false;
                    } else {
                        System.out.println("Invalid y!");
                    }
                }

                flag = true;
                int width = 0;
                while (flag) {
                    System.out.println(String.format("Input width, no greater than %s:", context.getWidth()));
                    width = sc.nextInt();
                    if (width > 0 && width <= context.getWidth()) {
                        flag = false;
                    } else {
                        System.out.println("Invalid width!");
                    }
                }

                flag = true;
                int height = 0;
                while (flag) {
                    System.out.println(String.format("Input height, no greater than %s:", context.getWidth()));
                    height = sc.nextInt();
                    if (height > 0 && height <= context.getHeight()) {
                        flag = false;
                    } else {
                        System.out.println("Invalid height!");
                    }
                }

                flag = true;
                int groupType = 0;
                while (flag) {
                    System.out.println("Input flowerbed type(1:group by row, 2: group by column):");
                    groupType = sc.nextInt();
                    if (groupType == 1 || groupType == 2) {
                        flag = false;
                    } else {
                        System.out.println("Invalid input");
                    }
                }

                flag = true;
                int rows = 0;
                while (flag) {
                    System.out.println("Input flowerbed rows:");
                    rows = sc.nextInt();
                    flag = false;
                }

                flag = true;
                int columns = 0;
                while (flag) {
                    System.out.println("Input flowerbed columns:");
                    columns = sc.nextInt();
                    flag = false;
                }

                flag = true;
                String[] strs = null;
                int size = groupType == 1 ? rows : columns;
                while (flag) {
                    System.out.println("According to group type, input flower type, enter a row or column at a time: ");
                    strs = new String[size];

                    for (int i = 0; i < size; i++) {
                        strs[i] = sc.next();
                    }
                    flag = false;
                }

                context.add(x, y, width, height, rows, columns, groupType, strs);
                System.out.println("Add successfully!");
                break;
            case 2:
                System.out.println("Remove witch one:");
                int witch = sc.nextInt() -1;
                context.remove(witch);
                System.out.println("Remove successfully!");
                break;
            case 3:
                context.save();
                System.out.println("Save successfully!");
                break;
            case 4:
                System.out.println("Bye!");
                context.exit();
                break;

            default:
                System.out.println("Choose repeat!");
        }
    }
}
