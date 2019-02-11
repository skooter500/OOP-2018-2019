package ie.dit;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		dx = 0;
		dy = 0;
		cx = width / 2;
		cy = height / 2;

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

	int x = 0; // 4 bytes
	int xx = 2;
	float f = 0.0f; // 4 bytes
	char c = 'h'; // Unicode
	String s = "Hello";
	boolean b = (1 == 0);
	double d = 0; // 8 bytes

	public void drawFace(float x, float y, float w)
	{
		ellipse(x, y, w, w);
		ellipse(x - 10, y - 10, 10, 10);
		ellipse(x + 10, y - 10, 10, 10);
		line(x, y - 5, x, y + 5);
		line(x - 10, y + 20, x + 10, y + 20);
		line(x - 10, y + 20, x - 15, y + 15);
		line(x + 10, y + 20, x + 15, y + 15);		
	}



	float dx, dy;
	float cx, cy;

	public void loops()
	{
		/*
		int lines = 0;
		float gap = height / 10;
		while(lines < 10)
		{
			float y = gap * lines;
			line(0, y, width, y);
			lines ++;
		}
		*/

		/*
		float y = 0;
		float gap = height / 10;
		while (y < height)
		{
			line(0, y, width , y);
			y += gap;
		}
		*/

		float gap = height / 10;
		for(int lines = 0; lines < 10 ; lines++)
		{
			line(0, lines * gap, width, lines * gap);
		}
	}

	void loops1()
	{
		int numLines = 20;
		float gap = width / numLines;

		for(int l = 0 ; l < numLines; l ++)
		{
			float x = l * gap;
			line(x, 0, width - x, height);
		}
	}


	public void draw()
	{			
		background(0);
		stroke(255);
		noFill();	
		drawFace(cx + dx, cy + dy, 70);
		drawFace(cx + dx, cy -dy, 70);
		drawFace(cx - dx, cy + dy, 70);
		drawFace(cx - dx, cy -dy, 70);

		dx ++;
		dy ++;
		loops();
		loops1();
	}
}
