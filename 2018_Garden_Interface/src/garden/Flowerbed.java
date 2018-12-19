/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import javax.swing.*;
import java.awt.*;

/**
 * @author 11949
 */
public class Flowerbed extends JPanel {

    private int myX;
    private int myY;
    private int myWidth;
    private int myHeight;
    private int myRows;
    private int myColumns;
    private int myFlowerType;

    public Flowerbed(int myX, int myY, int myWidth, int myHeight, int myRows, int myColumns, int myFlowerType){
        super();
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myRows = myRows;
        this.myColumns = myColumns;
        this.myFlowerType = myFlowerType;

        this.setLayout(new GridLayout(myRows, myColumns));
        this.setBounds(myX, myY, myWidth, myHeight);
        this.setBackground(Color.gray);
        this.plant();
    }

    private int computer(int totalLength, int blockSize){
        return totalLength/blockSize;
    }

    private Image getImage(){
        String path = "res/";
        switch (myFlowerType) {
            case 1:
                path += "flower-1.png";
                break;
            case 2:
                path += "flower-2.png";
                break;
            case 3:
                path += "flower-3.png";
                break;
            case 4:
                path += "flower-4.png";
                break;
            case 5:
                path += "flower-5.png";
                break;
            default:
                path += "flower-default.png";
        }
        return FileUtils.loadImage(path);
    }

    private void plant(){
        int flowerWidth = computer(myWidth, myRows);
        int flowerHeight = computer(myHeight, myColumns);

        for(int i = 0; i < myRows; i ++){
            for(int j = 0; j < myColumns; j++){
                Flower flower = new Flower(getImage(), flowerWidth, flowerHeight);
                this.add(flower);
            }
        }
    }

    public int getMyX() {
        return myX;
    }

    public void setMyX(int myX) {
        this.myX = myX;
    }

    public int getMyY() {
        return myY;
    }

    public void setMyY(int myY) {
        this.myY = myY;
    }

    public int getMyWidth() {
        return myWidth;
    }

    public void setMyWidth(int myWidth) {
        this.myWidth = myWidth;
    }

    public int getMyHeight() {
        return myHeight;
    }

    public void setMyHeight(int myHeight) {
        this.myHeight = myHeight;
    }

    public int getMyRows() {
        return myRows;
    }

    public void setMyRows(int myRows) {
        this.myRows = myRows;
    }

    public int getMyColumns() {
        return myColumns;
    }

    public void setMyColumns(int myColumns) {
        this.myColumns = myColumns;
    }

    @Override
    public String toString() {
        return myX +"," +myY +"," +myWidth +"," +myHeight +"," +myRows +"," +myColumns +"," + myFlowerType;
    }
}
