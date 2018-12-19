/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 */
public class Garden {

    /**
     * Define width of window frame.
     */
    public static final int DEFINE_WINDOW_WIDTH = 800;
    /**
     * Define height of window frame.
     */
    public static final int DEFINE_WINDOW_HEIGHT = 400;
    /**
     * Define path of Flowerbed cache.
     */
    public static final String DEFINE_FLOWERBED_CACHE_FILE = "flowerbeds_cache.txt";
    /**
     * Garden window.
     */
    private static JFrame myWindow;
    /**
     * Flowerbed data cache.
     */
    private static ArrayList<Flowerbed> myFlowerbeds = new ArrayList<>();
    /**
     * Garden container.
     */
    private static Container myContainer;

    public static void main(String[] args) {
        myWindow = new JFrame("Garden");
        myContainer = myWindow.getContentPane();
        // display
        myWindow.setVisible(true);
        // set bound
        myWindow.setSize(DEFINE_WINDOW_WIDTH, DEFINE_WINDOW_HEIGHT);
        // set close strategy
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set frame locate to screen center
        myWindow.setLocationRelativeTo(null);
        // set background color
        myContainer.setBackground(Color.cyan);
        myContainer.setLayout(null);
        // load data from cache file
        List<Flowerbed> flowerbeds = loadFlowerbeds();
        for (Flowerbed fb : flowerbeds) {
            // render a flowerbed in container
            addFlowerbed(fb);
        }

        // show menu
        while (true) {
            UserInterface.showMenu();
        }
    }

    /**
     * loaf data from file
     * @return
     */
    public static List<Flowerbed> loadFlowerbeds() {
        List<String> content;
        List<Flowerbed> flowerbeds = new ArrayList<>();
        try {
            content = FileUtils.read(DEFINE_FLOWERBED_CACHE_FILE);
            flowerbeds = GardenUtils.toFlowerbeds(content);
        } catch (Exception e) {
            System.out.println("Read file error.");
        }

        return flowerbeds;
    }

    /**
     * add a flowerbed
     * @param fb
     */
    protected static void addFlowerbed(Flowerbed fb) {
        myFlowerbeds.add(fb);
        myContainer.add(fb);
//        myContainer.invalidate();
        myContainer.revalidate();
    }

    /**
     * remove a flowerbed
     * @param witch
     */
    protected static void removeFlowerbed(int witch) {
        if (witch >= myFlowerbeds.size()) {
            System.out.println("Out of flowerbed size, please input again.");
        }

        myFlowerbeds.remove(witch);
        myContainer.remove(witch);
        myContainer.repaint();
    }

    /**
     * save data to into file.
     */
    protected static void save(){
        List<String> content = GardenUtils.toString(myFlowerbeds);
        FileUtils.write(DEFINE_FLOWERBED_CACHE_FILE, content);
    }

    /**
     * exit the garden.
     */
    protected static void exit(){
        myWindow.setVisible(false);
        System.exit(0);
    }

    /**
     * windows getter.
     */
    public static JFrame getMyWindow() {
        return myWindow;
    }

    /**
     * Flowerbed data getter.
     */
    public static ArrayList<Flowerbed> getMyFlowerbeds() {
        return myFlowerbeds;
    }

}
