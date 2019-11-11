package main.sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.sample.Config;

public class Map {

    public static int[][] map_block=new int[12][16];

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "024", "024", "024", "024", "003", "047", "047", "047", "047", "047", "262", "262", "262", "262" },
            { "024", "024", "024", "024", "024", "024", "025", "299", "001", "001", "001", "001", "262", "262", "262", "262" },
            { "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "024", "024", "024", "024", "025", "023", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "003", "047", "047", "047", "048", "023", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "025", "299", "001", "001", "001", "027", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262" },
            { "024", "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "262", "262", "262", "262" },

    };

    public static void autoDrawMap(){
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                if(MAP_SPRITES[i][j]=="024") map_block[i][j]=0;
                else map_block[i][j]=1;
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
       gc.drawImage(new Image("file:src/main/AssetsKit_2/BackgroundIn.png"),0,0);

    }
    public static void drawMapOut(GraphicsContext gc){
        gc.drawImage(new Image("file:src/main/AssetsKit_2/BackgroundOut.png"),12*Config.scale,0);
    }


}
