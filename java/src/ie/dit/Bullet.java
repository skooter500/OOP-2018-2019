package ie.dit;

import processing.core.PVector;

public class Bullet extends GameObject
{
    public Bullet(YASC yasc, float x, float y, float rotation)
    {
        super(yasc, x, y, rotation, 5);
    }  

    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        yasc.line(0, -5, 0, 5);
        yasc.popMatrix();
    }

    public void update()
    {
        // static methods on the Math class
        forward.x = (float)Math.sin(rotation);
        forward.y = - (float)Math.cos(rotation);

        // pos += forward * speed
        pos.add(PVector.mult(forward, speed));

        if (pos.x < 0)
        {
            pos.x = yasc.width;
        }
        if (pos.x > yasc.width)
        {
            pos.x = 0;
        }
        if (pos.y < 0)
        {
            pos.y = yasc.height;
        }
        if (pos.y > yasc.height)
        {
            pos.y = 0;
        }
        alive += yasc.timeDelta;
        if (alive >= 5.0)
        {
            yasc.gameObjects.remove(this);
        }
    }

    float alive;

}