package com.app.garden;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Garden extends JPanel {

    private static final String SETUP_PATH = "garden.txt";
    public static final int DEFAULT_GARDEN_WIDTH = 800;
    public static final int DEFAULT_GARDEN_HEIGHT = 400;

    private List<Flowerbed> beds = new ArrayList<>();

    public Garden() {
        super();
        this.setLayout(null);
        this.setSize(DEFAULT_GARDEN_WIDTH, DEFAULT_GARDEN_HEIGHT);
        this.setBackground(Color.green);
        // load data from garden setup file.
        this.load();
    }

    /**
     * add a flowerbed into garden container.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param rows
     * @param columns
     * @param groupType 1:group by row, 2:group by column
     * @param flowers input a row or column
     */
    public void addFlowerbed(int x, int y, int width, int height, int rows, int columns, int groupType,  String[] flowers) {
        Flowerbed bed = new Flowerbed(x, y, width, height, rows, columns, groupType, flowers);
        this.beds.add(bed);
        this.add(bed);
    }

    /**
     * remove flowerbed from garden container.
     *
     * @param index
     */
    public void removeFlowerbed(int index) {
        if (index >= beds.size()) {
            System.out.println("Out of flowerbed size!");
        }
        Flowerbed bed = this.beds.get(index);
        this.beds.remove(index);
        this.remove(bed);
        this.updateUI();
        this.repaint();
    }

    public File getFile() {
        File f = new File(SETUP_PATH);
        return f.exists() ? f : null;
    }

    /**
     * save data to file.
     */
    public void save() {
        File f = getFile();
        if(f == null){
            System.out.println("File is not exist.");
            return;
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            for(Flowerbed bed : beds){
                fos.write(bed.toString().getBytes());
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Write data to file error.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Close file error.");
                }
            }
        }

    }

    /**
     * load data from file.
     */
    public void load() {
        File f = getFile();
        if(f == null){
            System.out.println("File is not exist.");
            return;
        }

        FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream(f);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line ;
            while ((line = reader.readLine()) !=  null){
                String[] split1 = line.split(",");
                int x = Integer.valueOf(split1[0]);
                int y = Integer.valueOf(split1[1]);
                int width = Integer.valueOf(split1[2]);
                int height = Integer.valueOf(split1[3]);
                int rows = Integer.valueOf(split1[4]);
                int columns = Integer.valueOf(split1[5]);
                int groupType = Integer.valueOf(split1[6]);
                String[] flowers = split1[7].split("\\|");
                Flowerbed bed = new Flowerbed(x, y, width, height, rows, columns, groupType, flowers);
                this.add(bed);
                this.beds.add(bed);
            }
        } catch (Exception ioe) {
            System.out.println("File read error.");
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Close file error.");
            }
        }

    }
}
