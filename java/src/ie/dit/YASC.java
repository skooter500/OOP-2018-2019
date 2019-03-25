package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
    Ship s;
    AIShip aiShip;
    boolean[] keys = new boolean[1024];

    public ArrayList<Bullet> bullets = new ArrayList<Bullet>(); 

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    
    public void settings()
    {
        size(500, 500);        
    }

    public void setup()
    {
        s = new Ship(this, width / 2, height / 2, 5, 50);
        aiShip = new AIShip(this, 100, 100, 5, 50);
    }

    public float timeDelta;
    private float last;
    public void draw()
    {
        float now = millis();
        timeDelta = (now - last) / 1000.0f;
        last = now;
        background(255);
        s.render();
        s.update();

        aiShip.update();
        aiShip.render();

        fill(0);
        text("Bullets: " + bullets.size(), 50, 100);
        for(Bullet b:bullets)
        {
            b.render();
            b.update();
        }
    }


}