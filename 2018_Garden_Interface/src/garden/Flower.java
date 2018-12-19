/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * @author joelewis
 */
public class Flower extends JPanel {
    private final int myWidth, myHeight;
    private final Image myImage;

    public Flower(Image image,
                  int myWidth,
                  int myHeight) {
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myImage = image;
    }

    /**
     * paint image on panel
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, myWidth, myHeight, this);
    }

    @Override
    public int getWidth() {
        return myWidth;
    }

    @Override
    public int getHeight() {
        return myHeight;
    }

}
