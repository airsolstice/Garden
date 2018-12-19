package src.org.course.work;

import javax.swing.*;
import java.awt.*;

/**
 * 对象采用链式编程写法
 */
public class FlowerBed extends JPanel {

    /**
     * 花圃宽
     */
    private int width;
    /**
     * 花圃高
     */
    private int height;
    /**
     * 花圃行数
     */
    private int rows;
    /**
     * 花圃列数
     */
    private int cols;
    /**
     * 种植方式
     */
    private int plantType;
    /**
     * 花的样式
     */
    private int[] flowerTypes;

    public FlowerBed(int width, int height) {
        super();
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }

    public FlowerBed setRows(int rows) {
        this.rows = rows;
        return this;
    }

    public int getRows() {
        return this.rows;
    }

    public FlowerBed setCols(int cols) {
        this.cols = cols;
        return this;
    }

    public FlowerBed setFlowerTypes(int[] flowerTypes) {
        this.flowerTypes = flowerTypes;
        return this;
    }

    public int[] getFlowerTypes() {
        return this.flowerTypes;
    }

    public FlowerBed setPlantType(int plantType) {
        this.plantType = plantType;
        return this;
    }

    public int getPlantTypes() {
        return this.plantType;
    }

    public void plant() {
        this.setLayout(new GridLayout(rows, cols));

        int[][] flowerRect = new int[rows][cols];
        switch (plantType) {
            case 1:// 纯色
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        flowerRect[r][c] = flowerTypes[0];
                    }
                }
                break;
            case 2:// 行交叉
                for (int r = 0; r < rows; r++) {
                    int type;
                    if (r % 2 == 0) {
                        type = flowerTypes[0];
                    } else {
                        type = flowerTypes[1];
                    }
                    for (int c = 0; c < cols; c++) {
                        flowerRect[r][c] = type;
                    }
                }
                break;
            case 3:// 列交叉
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        int type;
                        if (c % 2 == 0) {
                            type = flowerTypes[0];
                        } else {
                            type = flowerTypes[1];
                        }
                        flowerRect[r][c] = type;
                    }
                }
                break;
            case 4:// 行列交叉
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        int type;
                        if (c % 2 == 0 && r % 2 == 0) {
                            type = flowerTypes[0];
                        } else {
                            type = flowerTypes[1];
                        }
                        flowerRect[r][c] = type;
                    }
                }
                break;
            default:
        }

        System.out.println("start planting flowers in flowerbed....");
        int total = rows * cols;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int type = flowerRect[r][c];
                Flower flower = new Flower(type);
                this.add(flower);
            }
        }
        System.out.println(String.format("Complete plant, total %s flower(s).", total));
    }

    @Override
    public String toString() {
        return width + "," + height + "," + rows + "," + cols + "," + plantType + "," + flowerTypes[0] + "," + flowerTypes[1] + "\n";
    }
}
