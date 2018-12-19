package com.app.garden;

import javax.swing.*;
import java.awt.*;

/**
 * flowerbed entity
 */
public class Flowerbed extends JPanel {

    private int x;
    private int y;
    private int width;
    private int height;
    private int rows;
    private int columns;
    private int groupType;
    private String[] flowers;

    public Flowerbed(int x, int y, int width, int height, int rows, int columns, int groupType, String[] flowers) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
        this.groupType = groupType;
        this.flowers = flowers;

        this.setBounds(x, y, width, height);
        this.setLayout(new GridLayout(rows, columns));
        int[][] rect = buildRect();
        this.draw(rect);
    }

    /**
     * according to user input, build a rect of flowers, it may be group by row or column,
     *
     * @return
     */
    private int[][] buildRect() {
        int[][] rect = new int[rows][columns];
        if(groupType == 1){
            for(int r = 0; r < rows; r++){
                char[] columnCharArr = flowers[r].toCharArray();
                if(columnCharArr.length == columns){
                    for(int c = 0; c < columns; c++){
                        rect[r][c] = Integer.parseInt(columnCharArr[c] + "");
                    }
                }
            }
        } else {
            for(int c = 0; c < columns; c++){
                char[] rowCharArr = flowers[c].toCharArray();
                if(rowCharArr.length == columns){
                    for(int r = 0; r < rows; r++){
                        rect[r][c] = Integer.parseInt(rowCharArr[r] + "");
                    }
                }
            }

        }
        return rect;
    }

    private void draw(int[][] rect) {
        int flowerWidth = width / rows;
        int flowerHeight = height / columns;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Flower flower = new Flower(flowerWidth, flowerHeight, rect[r][c]);
                this.add(flower);
            }
        }
    }

    @Override
    public String toString() {
        String separator = ",";
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.append(separator);
        builder.append(y);
        builder.append(separator);
        builder.append(width);
        builder.append(separator);
        builder.append(height);
        builder.append(separator);
        builder.append(rows);
        builder.append(separator);
        builder.append(columns);
        builder.append(separator);
        builder.append(groupType);
        builder.append(separator);
        for (String f : flowers) {
            builder.append(f).append("|");
        }
        return builder.substring(0, builder.length() - 1) + System.lineSeparator();
    }
}
