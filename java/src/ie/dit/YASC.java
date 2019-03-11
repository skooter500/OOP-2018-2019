package ie.dit;

import processing.core.PApplet;

public class YASC extends PApplet
{
    Ship s;

    public void settings()
    {
        size(800, 800);

    }

    public void setup()
    {
        s = new Ship(this, width / 2, height / 2, 5, 50);
    }

    public void draw()
    {
        s.render();
        s.update();
    }


}