package ie.dit;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Mandala extends PApplet {
    float[] bands;
    float[] lerpedBands;

    public void settings() {
        size(FRAME_SIZE, 500);
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, BITS_PER_SAMPLE);
        fft = new FFT(FRAME_SIZE, SAMPLE_RATE);

        bands = new float[(int) log2(FRAME_SIZE)];
        lerpedBands = new float[bands.length];
    }

    float log2(float f) {
        return log(f) / log(2.0f);
    }

    void getFrequencyBands() {
        for (int i = 0; i < bands.length; i++) {
            int start = (int) pow(2, i) - 1;
            int w = (int) pow(2, i);
            int end = start + w;
            float average = 0;
            for (int j = start; j < end; j++) {
                average += fft.getBand(j) * (j + 1);
            }
            average /= (float) w;
            bands[i] = average * 5.0f;
            lerpedBands[i] = lerp(lerpedBands[i], bands[i], 0.05f);
        }
    }

    public void setup() {
        colorMode(HSB);
    }

    AudioInput ai;
    FFT fft;
    Minim minim;
    public static final int FRAME_SIZE = 1024;
    public static final int SAMPLE_RATE = 44100;

    float offs = 0;
    public static final int BITS_PER_SAMPLE = 16;

    public void draw() {
        background(0);
        getFrequencyBands();
        fft.forward(ai.left);
        strokeWeight(5);
        /*
        background(map(mouseX, 0, width, 0, 255));

        stroke(255);
        float middle = height / 2;
        for (int i = 0; i < ai.bufferSize(); i++) {
            stroke(map(i, 0, ai.bufferSize(), 0, 255), 255, 255);
            line(i, middle, i, middle + ai.left.get(i) * middle);
        }

        fft.forward(ai.left);

        for (int i = 0; i < fft.specSize(); i++) {
            stroke(map(i, 0, ai.bufferSize(), 0, 255), 255, 255);
            line(i, 0, i, fft.getBand(i) * 20);
        }
        */

        int segments = 500;
        float theta = TWO_PI / (float) segments;
        
        float amp = 0.5f;
        int cx = width / 2;
        int cy = height / 2;
        
        for(float i = 0 ; i < segments ; i ++)
        {
            stroke((i + offs) % 255, 255, 255);
            float x = cx + sin(i + offs * theta) * (amp * lerpedBands[(int)(i) % lerpedBands.length]);
            float y = cy - cos(i + offs * theta) * (amp * lerpedBands[(int)(i) % lerpedBands.length]);
            line(cx, cy, x, y);
            
        }
        offs += 0.1f;
        /*
        float gap = width / (float) bands.length;
        noStroke();
        float colorGap = 255 / (float) bands.length;
        for(int i = 0 ; i < bands.length ; i ++)
        {
            fill(i * colorGap, 255, 255);
            rect(i * gap, height, gap,-lerpedBands[i]); 
        }
        */

    }
    float c = 0;
}