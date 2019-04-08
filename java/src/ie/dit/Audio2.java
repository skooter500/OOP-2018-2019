package ie.dit;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    public static int SAMPLE_RATE = 44100;
    public static int RESOLUTION = 16;
    public static int FRAME_SIZE = 1024;

    Minim minim;
    AudioInput ai;
    
    public void settings()
    {
        size(FRAME_SIZE, 800);
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, RESOLUTION);

    }

    public void draw()
    {
        background(0);
        stroke(255);
        float halfH = height / 2;
        for(int i = 0 ; i < ai.bufferSize() ; i ++)
        {
            line(i, halfH, i, halfH + ai.left.get(i) * halfH);
        }
    }
}