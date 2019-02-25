package ie.dit;

import java.util.ArrayList;

import processing.core.*;
import processing.data.*;

public class StarMap extends PApplet
{
    public void settings()
    {
        size(800, 800);
    }

    ArrayList<Star> stars = new ArrayList<Star>();

    public void setup()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows())
        {
            Star s = new Star(row);
            stars.add(s);
        }

        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    public void draw()
    {
    
    }
}