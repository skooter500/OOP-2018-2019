package ie.dit;

import processing.core.PApplet;

public class BugZap extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {

	}

	/*
	public void draw() {
		background(0, 0, 255);
		stroke(255, 0, 0);
		fill(255, 255, 0);
		line(10, 10, 100, 100);		// x1, y1, x2, y2
		point(50, 50); // x, y
		ellipse(100, 200, 50, 150); // cx, cy, w, h
		fill(0, 255, 0);
		rect(50, 10, 100, 200); // tlx, tly, w, h
		triangle(10, 10, 100, 90, 200, 200); // vertices	
	}	
	*/

	float playerX = 250, playerY = 400;
	float playerWidth = 40;

	void drawPlayer(float x, float y, float w)
	{
		stroke(255);
		float playerHeight = w / 2;
		line(playerX, playerY + playerHeight, playerX + playerWidth, playerY + playerHeight);
		line(playerX, playerY + playerHeight, playerX, playerY + playerHeight * 0.5f);
		line(playerX + playerWidth, playerY + playerHeight, playerX + playerWidth, playerY + playerHeight * 0.5f);
		
		line(playerX, playerY + playerHeight * 0.5f, playerX + playerWidth * 0.2f, playerY + playerHeight * 0.3f);
		line(playerX + playerWidth, playerY + playerHeight * 0.5f, playerX + playerWidth * 0.8f, playerY + playerHeight * 0.3f);
		line(playerX + playerWidth * 0.2f, playerY + playerHeight * 0.3f, playerX + playerWidth * 0.8f, playerY + playerHeight * 0.3f);
		line(playerX + playerWidth * 0.5f, playerY, playerX + playerWidth * 0.5f, playerY + playerHeight * 0.3f); 
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
	}	

	public void draw()
	{	
		background(0);		
		fill(255);
		drawPlayer(playerX, playerY, playerWidth);
	}
}
