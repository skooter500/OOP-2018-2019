package ie.dit;

import processing.core.PVector;

public class Bullet
{
    private PVector pos;
    private PVector forward;
    private float rotation;
    private float speed;
    private YASC yasc;

    public Bullet(YASC yasc, float x, float y, float rotation)
    {
        this.yasc = yasc;
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.rotation = rotation; 
        speed = 5;
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
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the forward
     */
    public PVector getForward() {
        return forward;
    }

    /**
     * @param forward the forward to set
     */
    public void setForward(PVector forward) {
        this.forward = forward;
    }

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the yasc
     */
    public YASC getYasc() {
        return yasc;
    }

    /**
     * @param yasc the yasc to set
     */
    public void setYasc(YASC yasc) {
        this.yasc = yasc;
    }
    
}