package src.org.course.work;

import javax.swing.*;
import java.awt.*;

class Flower extends JPanel {

    public static final int DEFINE_FLOWER_SIZE = 16;
    private String picture =  "res/";

    public Flower(int type) {
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
        }
        this.setPreferredSize(new Dimension(DEFINE_FLOWER_SIZE, DEFINE_FLOWER_SIZE));
        this.setOpaque(true);
        this.setLayout(new FlowLayout());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon icon = new ImageIcon(picture);
        g.drawImage(icon.getImage(), 0, 0, DEFINE_FLOWER_SIZE, DEFINE_FLOWER_SIZE, this);
    }
}