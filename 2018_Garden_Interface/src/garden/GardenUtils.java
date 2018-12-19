package garden;

import java.util.ArrayList;
import java.util.List;

public class GardenUtils {

    /**
     * parse string to numeric value
     * @param value
     * @return
     */
    public static int getInteger(String value) {
        return Integer.valueOf(value);
    }

    /**
     * convert string array to flowerbed array
     * @param content
     * @return
     */
    public static List<Flowerbed> toFlowerbeds(List<String> content) {
        List<Flowerbed> flowerbeds = new ArrayList<>();
        for (String line : content) {
            if (line == null || line.equals("")) {
                continue;
            }
            String[] fields = line.split(",");

            try {
                int myX = getInteger(fields[0]);
                int myY = getInteger(fields[1]);
                int myWidth = getInteger(fields[2]);
                int myHeight = getInteger(fields[3]);
                int myRows = getInteger(fields[4]);
                int myColumns = getInteger(fields[5]);
                int myFlowerType = getInteger(fields[6]);
                Flowerbed fb = new Flowerbed(myX, myY, myWidth, myHeight, myRows, myColumns, myFlowerType);
                flowerbeds.add(fb);
            } catch (Exception e) {
                System.out.println("Convert error, skip a line.");
            }
        }


        return flowerbeds;
    }

    /**
     * convert flowerbed array to string array
     * @param flowerbeds
     * @return
     */
    public static List<String> toString(List<Flowerbed> flowerbeds) {
        List<String> content = new ArrayList<>();

        for (Flowerbed fb : flowerbeds) {
            content.add(fb.toString());
        }

        return content;
    }

}
