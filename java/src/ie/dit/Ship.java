package ie.dit;

import processing.core.PVector;

public class Ship extends GameObject
{
    private float size;
    public Ship(YASC yasc, float x, float y, float speed, float size)
    {
        super(yasc, x, y, 0, speed);
        this.size = size;

    }

    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        
        float halfSize = size / 2;
        yasc.stroke(0);
        yasc.line(- halfSize, halfSize, 0, - halfSize);
        yasc.line(0, - halfSize
        , halfSize, halfSize);

        yasc.line(halfSize, halfSize
            ,0, 0);
        yasc.line(0, 0, -halfSize, halfSize);
        yasc.popMatrix();
    }

    public void update()
    {
        forward.x = (float) Math.sin(rotation);
        forward.y = - (float) Math.cos(rotation);
        if (yasc.checkKey('w'))
        {
            pos.add(forward);
        }

        if (yasc.checkKey('s'))
        {
            pos.x -= forward.x;
            pos.y -= forward.y;
        }

        if (yasc.checkKey('a'))
        {
            rotation -= 0.1f;
        }

        if (yasc.checkKey('d'))
        {
            rotation += 0.1f;
        }

        if (yasc.checkKey(' '))
        {
            Bullet b = new Bullet(yasc, pos.x, pos.y, rotation);
            yasc.gameObjects.add(b);
        }
    }

    public void setSize(float size) {
        this.size = size;
    }

    
}