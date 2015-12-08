package map;

import javax.swing.*;

import game.Board;

import java.awt.*;
import java.util.Random;

public class Map extends JPanel {
	
	
	public static TileMap tile = new TileMap();

    public static final Color CITY = new Color(214,217,223);
    public static final Color DESERT = new Color(255,204,102);
    public static final Color DIRT_ROAD = new Color(153,102,0);
    public static final Color FOREST = new Color(0,102,0);
    public static final Color HILLS = new Color(51,153,0);
    public static final Color LAKE = new Color(0,153,153);
    public static final Color MOUNTAINS = new Color(102,102,255);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color PAVED_ROAD = new Color(51,51,0);
    public static final Color PLAINS = new Color(102,153,0);

    public static final Color[] TERRAIN = {
        CITY,
        DESERT,
        DIRT_ROAD,
        FOREST,
        HILLS,
        LAKE,
        MOUNTAINS,
        OCEAN,
        PAVED_ROAD,
        PLAINS
    };
    
   

    public static final int NUM_ROWS = 40;
    public static final int NUM_COLS = 40;

    public static final int PREFERRED_GRID_SIZE_PIXELS = 2;

   
    public Color[][] terrainGrid;

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Wizard Kingdom");
                
              
                frame.add(new Board().add(tile));
                //.add(tile);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(800,1000);
                frame.setResizable(false);;
            }
        });
    }
}