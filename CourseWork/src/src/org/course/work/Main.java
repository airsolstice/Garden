package src.org.course.work;

import java.util.Scanner;

public class Main {

    /**
     * 默认窗体宽度
     */
    private static final int DEFINE_CONTAINER_WIDTH = 500;
    /**
     * 默认窗体高度
     */
    private static final int DEFINE_CONTAINER_HEIGHT = 800;

    public static void main(String[] args) {

        int choose = 0;
        // 启动展示窗体
        Garden garden = new Garden("Garden", DEFINE_CONTAINER_WIDTH, DEFINE_CONTAINER_HEIGHT);
        garden.display();
        while (true) {
            System.out.println("|------------ GARDEN MENU -----------|");
            System.out.println("| 1.REDISPLAY                        |");
            System.out.println("| 2.ADD FLOWERBED                    |");
            System.out.println("| 3.REMOVE FLOWERBED                 |");
            System.out.println("| 4.SAVE TO FILE                     |");
            System.out.println("| 5.SAVE AND EXIT                    |");
            System.out.println("|------------ GARDEN MENU -----------|");

            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter (1-5): ");
            // 阻塞等待用户输入
            choose = sc.nextInt();
            switch (choose) {
                case 1:// redisplay
                    // 重新打开窗体，会加载配置文件，适用于在运行程序后，手动修改配置后使用
                    garden.close();
                    garden = new Garden("Garden", DEFINE_CONTAINER_WIDTH, DEFINE_CONTAINER_HEIGHT);
                    garden.display();
                    System.out.println("Redisplay garden");
                    break;

                case 2:// add
                    System.out.println("Note: the size of flower is 20, " +
                            "if the size of flowerbed is 100, suggest that plant 5 columns of flowers");
                    boolean flag = true;
                    int width = 50;
                    while (flag) {
                        // 添加一个花圃到花园中（自动刷新界面）
                        System.out.println("Please input width of flowerbed（between 20 and " + DEFINE_CONTAINER_HEIGHT + "）: ");
                        // 花圃框体宽
                        try {
                            width = sc.nextInt();
                            if (width < 20 || width > DEFINE_CONTAINER_HEIGHT) {
                                System.out.println("Invalid input!");
                            } else {
                                flag = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }
                    flag = true;
                    int height = 50;
                    while (flag) {
                        System.out.println("Please input height of flowerbed（between 20 and " + DEFINE_CONTAINER_WIDTH + "）: ");
                        // 花圃框体高
                        try {
                            height = sc.nextInt();
                            if (height < 20 || height > DEFINE_CONTAINER_HEIGHT) {
                                System.out.println("Invalid input!");
                            } else {
                                flag = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }
                    int rows = 10;
                    flag = true;
                    while (flag) {
                        System.out.println("Please input row number of flowerbed（between 1 and 10）: ");
                        // 花圃行
                        try {
                            rows = sc.nextInt();
                            if (rows <= 0 || rows > 10) {
                                System.out.println("Invalid input!");
                            } else {
                                flag = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }

                    flag = true;
                    int cols = 10;
                    while (flag) {
                        System.out.println("Please input column number of flowerbed（between 1 and 10）: ");
                        // 花圃列
                        try {
                            cols = sc.nextInt();
                            if (cols <= 0 || cols > 10) {
                                System.out.println("Invalid input!");
                            } else {
                                flag = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }

                    flag = true;
                    int plantType = 1;
                    while (flag) {
                        System.out.println("Please input how to plant flower? " +
                                "（1.simple, 2.row cross, 3.column cross, 4.cross） : ");
                        // 种植方式，1.简单模式（单色），2.行交叉模式（行交叉），3.列交叉，4.交叉模式（需要两种花）
                        try {
                            plantType = sc.nextInt();
                            if (plantType <= 0 || plantType > 4) {
                                System.out.println("Invalid input!");
                            } else {
                                flag = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }

                    flag = true;
                    int[] flowerTypes = new int[2];
                    int count = 0;
                    while (flag) {
                        System.out.println("Please input type of flower（between 1 nad 5）: ");
                        // 输入花朵样式
                        try {
                            int flowerType = sc.nextInt();
                            if (flowerType < 1 || flowerType > 4) {
                                System.out.println("Invalid input!");
                            } else {
                                flowerTypes[count] = flowerType;
                                count++;
                                if (plantType == 1) {
                                    flag = false;
                                } else {
                                    if (count == 2) {
                                        flag = false;
                                    } else {
                                        System.out.println("Need input the second flower type:");
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }

                    FlowerBed fb = new FlowerBed(width, height);
                    fb.setRows(rows).setCols(cols).setPlantType(plantType).setFlowerTypes(flowerTypes).plant();
                    garden.addFlowerBed(fb);
                    System.out.println("Add a flowerbed to garden.");
                    break;

                case 3:// remove
                    // 删除花圃
                    System.out.print("Remove which one? : ");
                    int index = sc.nextInt() - 1;
                    garden.removeFlowerBed(index);
                    break;

                case 4:// save
                    // 保存数据到文件
                    garden.save();
                    System.out.println("Save successfully.");
                    break;

                case 5:// exit
                    // 保存并退出
                    garden.save();
                    garden.close();
                    System.out.println("Save and exit.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choose！");
            }
        }
    }
}
