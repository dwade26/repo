package application;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description:  This class creates a plot
 * all contained in one plot
 * Due: 11/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/

public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(int x,int y,int width,int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	
	public boolean overlaps(Plot plot) {
		if(plot.x<=x && plot.y<=y) {
			if(plot.x +  width >x && plot.y + depth >y) {
				return true;
			}
			return false;
		} else if(plot.x<=x && plot.y>=y) {
			if(plot.x + plot.width >x && y + depth > plot.y) {
				return true;
			}
			return false;
		} else if(plot.x>=x && plot.y<=y) {
			if(x+ width > plot.x && plot.y + plot.depth > y) {
				return true;
			}
			return false;
		} else {
			if(x+ width > plot.x && y + depth > plot.y) {
				return true;
			}
			return false;
		}
	}
	
	public boolean encompass(Plot plot) {
		if(x<=plot.x && y<=plot.y && x+width >= plot.x+plot.width && y + depth >=plot.y+plot.depth) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return x+","+y+","+width+","+depth;
	}
	
	
	
}

