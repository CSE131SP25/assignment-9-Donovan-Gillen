package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	
	
	public Food(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	
	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	
	public Food() {
		setX(Math.random());
		setY(Math.random());
	}
	
	
	public void draw() {
		StdDraw.setPenColor(ColorUtils.solidColor());
		
		StdDraw.filledCircle(getX(), getY(), FOOD_SIZE);
	}
	
}
