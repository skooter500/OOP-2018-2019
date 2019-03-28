package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class AIShip extends GameObject
{
    float size;
    private int health = 10;
    private ArrayList<PVector> waypoints = new ArrayList<PVector>(); 

    public AIShip(YASC yasc, float x, float y, float speed, float size)
    {
       super(yasc, x, y, 0, 5);
       this.size = size;

        for(int i = 0 ; i < 5 ; i ++)
        {
            waypoints.add(new PVector(yasc.random(0, yasc.width), yasc.random(0, yasc.height)));
        }

    }

    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        yasc.stroke(0, 0, 255);
        float halfSize = size / 2;
        yasc.line(- halfSize, halfSize, 0, - halfSize);
        yasc.line(0, - halfSize
        , halfSize, halfSize);

        yasc.line(halfSize, halfSize
            ,0, 0);
        yasc.line(0, 0, -halfSize, halfSize);
        yasc.popMatrix();

        for(int i = 1 ; i <= waypoints.size() ; i ++)
        {
            PVector a = waypoints.get(i - 1);
            PVector b = waypoints.get(i % waypoints.size());
            yasc.stroke(255, 0, 0);
            yasc.line(a.x, a.y, b.x, b.y);
        }
        yasc.fill(0);    
        yasc.text("Health:" + health, pos.x + 25, pos.y);
    }

    int current = 0;

    public void update()
    {
        PVector toNext = PVector.sub(waypoints.get(current), pos);
        float dist = toNext.mag();
        toNext.normalize();
        pos.add(toNext);
        rotation = (float) Math.atan2(toNext.y, toNext.x) + PApplet.HALF_PI;
        if (dist < 1)
        {
            current = (current + 1) % waypoints.size();
        }
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the waypoints
     */
    public ArrayList<PVector> getWaypoints() {
        return waypoints;
    }

    /**
     * @param waypoints the waypoints to set
     */
    public void setWaypoints(ArrayList<PVector> waypoints) {
        this.waypoints = waypoints;
    }

    /**
     * @return the current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(int current) {
        this.current = current;
    }
}