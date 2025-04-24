package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	

	public Snake() {
		//FIXME - set up the segments instance variable
		this.segments = new LinkedList<>();
		segments.add(new BodySegment(.5, .5, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.get(0);
		double moveHeadX = head.getX() + deltaX;
		double moveHeadY = head.getY() + deltaY;
		segments.addFirst(new BodySegment(moveHeadX, moveHeadY, SEGMENT_SIZE));
		segments.removeLast();
		
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.get(0);
		if (Math.abs(head.getX() - f.getX()) < (SEGMENT_SIZE/1.25) && Math.abs(head.getY() - f.getY()) < (SEGMENT_SIZE/1.25)) {
			segments.addLast(new BodySegment(head.getX(),head.getY(),SEGMENT_SIZE));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.get(0);
		double headX = head.getX();
		double headY = head.getY();
		if (headX - SEGMENT_SIZE < 0 || headX + SEGMENT_SIZE > 1 || headY - SEGMENT_SIZE < 0 || headY + SEGMENT_SIZE > 1) {
			return false;
		}
		return true;
	}
}
