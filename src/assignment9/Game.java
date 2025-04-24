package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	

	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
		
	}
	
	public void play() {
		StdDraw.setPenColor(Color.black);
		StdDraw.text(.5, .75, "Game Start!");
		StdDraw.show();
		while (!StdDraw.hasNextKeyTyped()) {
			StdDraw.pause(10);
		}
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			snake.changeDirection(dir);
			snake.move();
			if (snake.eatFood(food)) {
				food = new Food();
			}
			updateDrawing();
			//Testing only: you will eventually need to do more work here
			
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		StdDraw.setPenColor(Color.black);
		StdDraw.text(.50, .75, "Game Over");
		StdDraw.show();
		
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);
		StdDraw.show();
		
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
