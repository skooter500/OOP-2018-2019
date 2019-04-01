package ie.dit;

import processing.core.PVector;

public class Ship extends GameObject
{
    private float size;

    public int fireRate;

    private float toPass;
    private float ellapsed;

    private int ammo;

    public Ship(YASC yasc, float x, float y, float speed, float size)
    {
        super(yasc, x, y, 0, speed);
        this.size = size;
        fireRate = 20;
        toPass = 1 / (float) fireRate;
        ammo = 10;

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
        yasc.text("Ammo: " + ammo, pos.x + 20, pos.y);
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

        if (yasc.checkKey(' ') && ellapsed >= toPass && ammo > 0)
        {
            PVector spawnPoint = PVector.add(pos, PVector.mult(forward, 25));
            Bullet b = new Bullet(yasc, spawnPoint.x, spawnPoint.y, rotation + yasc.random(-0.1f, 0.1f));
            yasc.gameObjects.add(b);
            ellapsed = 0;
            ammo --;
        }
        ellapsed += yasc.timeDelta;
        yasc.text("Ellapsed: "+ ellapsed, 10, 200);


    }

    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @return the fireRate
     */
    public int getFireRate() {
        return fireRate;
    }

    /**
     * @param fireRate the fireRate to set
     */
    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    /**
     * @return the toPass
     */
    public float getToPass() {
        return toPass;
    }

    /**
     * @param toPass the toPass to set
     */
    public void setToPass(float toPass) {
        this.toPass = toPass;
    }

    /**
     * @return the ellapsed
     */
    public float getEllapsed() {
        return ellapsed;
    }

    /**
     * @param ellapsed the ellapsed to set
     */
    public void setEllapsed(float ellapsed) {
        this.ellapsed = ellapsed;
    }

    /**
     * @return the ammo
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    
}