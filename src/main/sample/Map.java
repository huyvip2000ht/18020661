package main.sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {

    public static int[][] map_block = new int[16][12];

    public static final String[][] MAP_SPRITES = new String[][]{
            {"024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "024", "024", "024", "024", "003", "047", "047", "047", "047", "047", "262", "262", "262", "262"},
            {"024", "024", "024", "024", "024", "024", "025", "299", "001", "001", "001", "001", "262", "262", "262", "262"},
            {"024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "003", "047", "047", "047", "048", "023", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "025", "299", "001", "001", "001", "027", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262"},
            {"024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262"},

    };

    public static void autoDrawMap() {
        //    System.out.println(map_block.length);//16
        //    System.out.println(map_block[1].length);//12
        //   System.out.println(MAP_SPRITES.length);//12
        //    System.out.println(MAP_SPRITES[0].length);//16

        for (int j = 0; j < map_block[1].length; j++) {//12
            for (int i = 0; i < map_block.length; i++) {//16
                if (MAP_SPRITES[j][i] == "024") map_block[i][j] = 0;
                else map_block[i][j] = 1;
                //  System.out.print(map_block[i][j]);
            }
            //   System.out.println();
        }
    }

    public static void draw() {
        for (int j = 0; j < map_block[1].length; j++) {
            for (int i = 0; i < map_block.length; i++) {

                System.out.print(map_block[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawMapIn(GraphicsContext gc) {
     /*   for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                Image image=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png");

                gc.drawImage(image, j * Config.scale, i * Config.scale);
            }
        }*/
        gc.drawImage(new Image("file:src/main/AssetsKit_2/BackgroundIn.png"), 0, 0);

    }

    public static void drawMapOut(GraphicsContext gc) {
        gc.drawImage(new Image("file:src/main/AssetsKit_2/BackgroundOut.png"), 12 * Config.SCALE, 0);
    }


}
