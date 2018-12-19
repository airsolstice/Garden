/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * @author joelewis
 * A utility class to perform common file read, write, and other I/O
 */
public class FileUtils {

    /**
     * get file instance and check file whether or not exists
     * @param path
     * @return
     */
    public static java.io.File getFile(String path) {
        java.io.File file = new File(path);
        return file.exists() ? file : null;
    }

    /**
     * write content into file row by row.
     * @param path
     * @param content
     */
    public static void write(String path, List<String> content) {
        FileOutputStream fos = null;
        try {
            java.io.File file = getFile(path);
            if (file == null) {
                System.out.println("Write content into file error.");
                return;
            }
            fos = new FileOutputStream(path);
            for (String line : content) {
                fos.write((line + System.lineSeparator()).getBytes());
            }
            fos.flush();

        } catch (FileNotFoundException e) {
            System.out.println("Write content into file error.");
        } catch (IOException e) {
            System.out.println("Write content into file error.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Write content into file error.");
            }
        }


    }

    /**
     * read content from file row by row.
     * @param path
     * @return
     */
    public static List<String> read(String path) {
        FileInputStream fis = null;
        BufferedReader reader = null;
        List<String> content = new ArrayList<>();
        try {
            java.io.File file = getFile(path);
            if (file == null) {
                System.out.println("Read content from file error.");
                return content;
            }

            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (Exception e) {
            System.out.println("Read content from file error.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Read content from file error.");
            }
        }

        return content;
    }

    /**
     * get a image instance from file.
     * @param path
     * @return
     */
    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Problem loading image: " + path);
        }
        return image;
    }

}
