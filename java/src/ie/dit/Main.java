package ie.dit;

import processing.core.PVector;

public class Main
{	

	public void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
	}
	
	public void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
	}

	public void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
		
	}
	
	public void arrays()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
		
	}
	
	public void starMap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
		
	}
	
	public void cafeRubis()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CafeRubis());
		
	}

	public void yasc()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YASC());
		
	}

	public void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
		
	}

	public void mandala()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Mandala());
		
	}
	
	public void audio2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
		
	}

	public static void main(String[] args)
	{
		PVector a = new PVector(10, 10);
		PVector b = new PVector(20, 20);

		b = a;
		a.x = 30;
		a.y = 30;
		System.out.println(b);

		float f = 10;
		float g = 20;

		g = f;
		f = 30;
		System.out.println(g);


		
		Main main = new Main();
		main.yasc();		
			
	}
}