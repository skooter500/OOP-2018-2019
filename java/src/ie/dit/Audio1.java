package ie.dit;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    public void settings()
    {
        size(FRAME_SIZE, 500);
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, BITS_PER_SAMPLE);
        fft = new FFT(FRAME_SIZE, SAMPLE_RATE);
    }

    public void setup()
    {
        colorMode(HSB);
    }

    AudioInput ai;
    FFT fft;
    Minim minim;
    public static final int FRAME_SIZE = 1024;
    public static final int SAMPLE_RATE = 44100;
    public static final int BITS_PER_SAMPLE = 16;

    public void draw()
    {
        background(0);
        stroke(255);
        float middle = height / 2; 
        for(int i = 0 ; i < ai.bufferSize() ; i ++)
        {
            stroke(map(i, 0, ai.bufferSize(), 0, 255), 255, 255);
            line(i, middle, i, middle + ai.left.get(i) *middle);
        }

        fft.forward(ai.left);

        for(int i = 0 ; i < fft.specSize() ; i ++)
        {
            stroke(map(i, 0, ai.bufferSize(), 0, 255), 255, 255);            
            line(i, 0, i, fft.getBand(i) * 20);
        }




    }

}