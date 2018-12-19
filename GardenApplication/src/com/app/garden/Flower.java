package com.app.garden;

import javax.swing.*;
import java.awt.*;

/**
 * flower entity
 */
class Flower extends JPanel {

    private String picture = "res/";
    private int width;
    private int height;

    public Flower(int width, int height, int type) {
        this.width = width;
        this.height = height;
        switch (type) {
            case 1:
                picture += "flower1.png";
                break;
            case 2:
                picture += "flower2.png";
                break;
            case 3:
                picture += "flower3.png";
                break;
            case 4:
                picture += "flower4.png";
                break;
            case 5:
                picture += "flower5.png";
                break;
            default:
                picture += "flower.png";
        }

        this.setPreferredSize(new Dimension(width, width));
        this.setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // write flower picture
        ImageIcon icon = new ImageIcon(picture);
        g.drawImage(icon.getImage(), 0, 0, width, height, this);
    }
}