package ie.dit;

import processing.core.PApplet;

public class BugZap extends PApplet
{	
	float playerX, playerY, playerWidth = 40;
	float halfW = playerWidth / 2;
	float playerSpeed = 5;
	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		playerX = width / 2;
		playerY = height - 100;
	}

	public void keyPressed()
	{
		if (keyCode == LEFT && playerX > halfW)
		{
			playerX -= playerSpeed;
		}
		else if (keyCode == RIGHT && playerX < width - halfW)
		{
			playerX += playerSpeed;
		}
	}

	void drawPlayer(float x, float y, float w)
	{
		float h = w / 2;
		float halfH = h / 2;
		float offset = w * 0.1f;
		line(x - halfW, y + halfH, x + halfW, y + halfH);
		line(x - halfW, y + halfH, x - halfW, y);
		line(x + halfW, y + halfH, x + halfW, y);
		line(x - halfW, y, x - halfW + offset, y - offset);
		line(x + halfW, y, x + halfW - offset, y - offset);
		line(x - halfW + offset, y - offset, x + halfW - offset, y - offset);
		line(x, y - offset, x, y - halfH);
		
	}

	public void draw()
	{			
		background(0);
		stroke(255);
		drawPlayer(playerX, playerY, playerWidth);
	}
}
