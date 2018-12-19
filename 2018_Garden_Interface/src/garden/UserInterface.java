/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.util.Scanner;

/**
 *
 * @author joelewis
 */
public class UserInterface {
    private static Scanner kb;
    
    public static void showMenu(){
        kb = new Scanner(System.in);
        System.out.println("Welcome to my Garden!\n");
        System.out.println("Please select:");
        System.out.println("1.\tAdd flowerbed");
        System.out.println("2.\tRemove flowerbed");
        System.out.println("3.\tSave");
        System.out.println("4.\tExit");

        int command = getIntInput();
        switch(command){ 
            case 1:
                int myX;
                while (true){
                    System.out.println("Input X:");
                    myX = getIntInput();

                    if(Garden.getMyWindow().getWidth() >  myX){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                int myY;
                while (true) {
                    System.out.println("Input Y:");
                    myY = getIntInput();

                    if(Garden.getMyWindow().getHeight() >  myY){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                int myWidth;
                while (true) {
                    System.out.println("Input width:");
                    myWidth = getIntInput();
                    if(Garden.getMyWindow().getWidth() >  myWidth){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }

                }
                int myHeight;
                while (true) {
                    System.out.println("Input height:");
                    myHeight = getIntInput();

                    if(Garden.getMyWindow().getHeight() >  myHeight){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                int myRows;
                while (true) {
                    System.out.println("Input rows:");
                    myRows = getIntInput();

                    if(20 >  myRows){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                int myColumns;
                while (true) {
                    System.out.println("Input columns:");
                    myColumns = getIntInput();

                    if(20 >  myColumns){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                int myFlowerType;
                while (true) {
                    System.out.println("Input flower type:");
                    myFlowerType = getIntInput();

                    if(6 >  myFlowerType){
                        break;
                    } else {
                        System.out.println("Invalid input, please input again.");
                    }
                }

                System.out.println("Add flowerbed!");
                Flowerbed fb = new Flowerbed(myX, myY, myWidth, myHeight, myRows, myColumns, myFlowerType);
                Garden.addFlowerbed(fb);
                break;
            case 2:
                System.out.println("Removing witch one:");
                int witch = getIntInput() - 1;
                Garden.removeFlowerbed(witch);
                break;
            case 3:
                System.out.println("Save successfully!");
                Garden.save();
                break;
            case 4:
                System.out.println("Exit and bye!");
                Garden.exit();
                break;
            default:
                System.out.println("Please input a value from 1 to 4");
        }    
    }

    private static int getIntInput(){
        int input = 0;
        try{
            input = Integer.parseInt(kb.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("That is not an int; "
                                + "please try again");
            input = getIntInput();
        }
        finally{
            return input;    
        }
    }

}
