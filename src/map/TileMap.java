package map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class TileMap extends Map {
	
	public static final int NUM_ROWS = 40;
    public static final int NUM_COLS = 40;
	
	 private Map color;
	int[][] map =
		{
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
		    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
		    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1}
		 };
	
	public TileMap(){
		
		repaint();
		
	}
	
	
	@Override
	public void paint(Graphics g){

		int w = getWidth() / 15;
	    int h = getHeight() / 15;
	    			
	    			for (int x = 0; x < map.length; x++) {
	    		        for (int y = 0; y < map[x].length-10; y++) {
	    		            if(map[x][y] == 1) {
	    		                g.setColor(color.FOREST);
	    		                g.fillRect(y * w, x * h, 300, 300);
	    		            } else {
	    		            	g.setColor(color.OCEAN);
	    		            	g.fillRect(y * w, x * h, 300, 300);
	    		        	}
	    		        	System.out.print(x);
	    		        	System.out.println(", " + y);
	    		        	System.out.println(map.length);
	    		        	System.out.println(map[x][y]);
	    		        }
	    			}
    }
	
	
	 
	
	
	
}



// after first nested for loops in paint

//g.clearRect(0, 0, getWidth(), getHeight());
//// Draw the grid
//int rectWidth = getWidth() / NUM_COLS;
//int rectHeight = getHeight() / NUM_ROWS;
//
//for (int i = 0; i < NUM_ROWS; i++) {
//  for (int j = 0; j < NUM_COLS; j++) {
//      int x = i * rectWidth;
//      int y = j * rectHeight;
//      for (int k = 0; k < map.length; k++) {
//	        for (int l = 0; l < map[k].length; l++) {
//	        	g.setColor(terrainGrid[k][l]);
//	        }
//      }
//      g.fillRect(x, y, rectWidth, rectHeight);
//  }
//}
