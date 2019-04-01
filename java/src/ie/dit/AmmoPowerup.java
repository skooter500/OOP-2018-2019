package ie.dit;

import processing.core.PVector;

public class AmmoPowerup extends GameObject implements Powerup
{

    public AmmoPowerup(YASC yasc)
    {
        super(yasc, yasc.random(0, yasc.width)
        ,yasc.random(0, yasc.height) 
        , 0, 2);
        forward.x = yasc.random(-1, 1);
        forward.y = yasc.random(-1, 1);
        forward.normalize();
    }
    @Override
    public void update() {
        //pos =+ forward * speed;
        pos.add(PVector.mult(forward, speed));
        rotation += 0.01f;

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
    }

    int size = 20;
    @Override
    public void render() {
        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        yasc.rect(-size / 2, -size / 2, size, size);
        yasc.popMatrix();
    }

    @Override
    public void applyTo(Ship s) {
        s.setAmmo(s.getAmmo() + 10);
        
    }
    
}