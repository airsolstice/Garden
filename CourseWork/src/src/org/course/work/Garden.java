package src.org.course.work;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Garden extends JFrame {

    /**
     *  花园容器
     */
    private Container container;
    /**
     *  花圃数据
     */
    private List<FlowerBed> flowerBeds = new ArrayList<>();

    public Garden(String name, int width, int height) {
        super(name);
        this.setSize(height, width);
        this.setBackground(Color.GREEN);
        this.setLocationRelativeTo(null);//设置窗体的显示位置
        this.container = this.getContentPane();
        this.container.setLayout(new FlowLayout());
        this.container.setBackground(Color.GREEN);
        this.load();
    }

    /**
     * 从文件中加载配置
     */
    private void load() {
        // TODO load file setup
        File setup = getSetupFile();
        FileInputStream fis  = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream(setup);
            reader = new BufferedReader(new InputStreamReader(fis));
            String row;
            while ((row = reader.readLine()) != null){
                String[] splits = row.split(",");
                FlowerBed fb = new FlowerBed(Integer.valueOf(splits[0]), Integer.valueOf(splits[1]));
                int rows =  Integer.valueOf(splits[2]);
                int cols =  Integer.valueOf(splits[3]);
                int plantType =  Integer.valueOf(splits[4]);
                int[] flowerTypes =  new int[2];
                flowerTypes[0] =  Integer.valueOf(splits[5]);
                flowerTypes[1] =  Integer.valueOf(splits[6]);
                fb.setRows(rows).setCols(cols).setPlantType(plantType).setFlowerTypes(flowerTypes).plant();
                this.container.add(fb);
                this.flowerBeds.add(fb);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Close file error.");
            }
        }
    }

    /**
     * 展示花园
     */
    public void display(){
        this.setContentPane(container);
        this.validate();
        this.setVisible(true);//让组建显示
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * 添加花圃
     */
    public void addFlowerBed(FlowerBed fb){
        if(fb == null){
            System.out.println("flowerbed is NULL.");
            return;
        }
        this.flowerBeds.add(fb);
        this.container.add(fb);
        this.validate();
    }

    /**
     * 移除花圃
     */
    public void removeFlowerBed(int index){
        if(index >= flowerBeds.size()){
            System.out.println("out of garden.");
        }
        final FlowerBed fb = flowerBeds.get(index);
        flowerBeds.removeIf(new Predicate<FlowerBed>() {
            @Override
            public boolean test(FlowerBed flowerBed) {
                return fb == flowerBed;
            }
        });
        this.container.remove(fb);
        this.validate();
        System.out.println("Delete a flowerbed");
    }

    /**
     * 保存花圃到文件
     */
    public void save(){
        FileOutputStream fos = null;
        try {
            File setup = getSetupFile();
            fos = new FileOutputStream(setup);

            for(FlowerBed fb : flowerBeds){
                fos.write(fb.toString().getBytes());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not be found.");
        } catch (IOException e) {
            System.out.println("Save file error.");
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
     * 获取配置文件对象
     */
    public File getSetupFile(){
        File setup = new File("setup.txt");
        if(setup.exists()){
            System.out.println("exists");
        } else {
            System.out.println("no such file");
        }
        return setup;
    }

    /**
     * 关闭退出
     */
    public void close(){
        this.setVisible(false);
    }
}
