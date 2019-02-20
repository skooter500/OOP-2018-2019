package ie.dit;

import processing.core.PApplet;

public class Arrays extends PApplet {
    float[] rainFall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    float[] fa = new float[2];
    int[] colors = new int[rainFall.length];

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        // Putting values into array elements
        fa[0] = 10;
        fa[1] = 4;

        // Getting a value from an array element
        System.out.println(fa[0]);

        // Iterating over an array
        for (int i = 0; i < rainFall.length; i++) {
            System.out.println(months[i] + "\t" + rainFall[i]);
        }

        // Using the for each loop
        for (float f : rainFall) {
            System.out.println(f);
        }

        // Calculate the total
        float total = 0;
        for (float f : rainFall) {
            total += f;
        }
        System.out.println("Total: " + total);

        // The same, but with a for loop
        total = 0;
        for (int i = 0; i < rainFall.length; i++) {
            total += rainFall[i];
        }

        float average = total / (float) rainFall.length;
        System.out.println(average);

        // Find the max element
        float max = Float.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < rainFall.length; i++) {
            if (rainFall[i] > max) {
                max = rainFall[i];
                maxIndex = i;
            }
        }

        System.out.println(months[maxIndex] + " had the highest rainfall of " + rainFall[maxIndex]);

        // Find the min element
        float min = Float.MAX_VALUE; // The biggest value a float can be
        int minIndex = -1;
        for (int i = 0; i < rainFall.length; i++) {
            if (rainFall[i] < min) {
                min = rainFall[i];
                minIndex = i;
            }
        }
        System.out.println(months[minIndex] + " had the lowest rainfall of " + rainFall[minIndex]);

        // Assign the color array
        for (int i = 0; i < rainFall.length; i++) {
            colors[i] = (int) random(0, 255);
        }
    }

    void drawBarChart() {
        colorMode(HSB);
        textAlign(LEFT, CENTER);

        float h = height / (float) rainFall.length;
        for (int i = 0; i < rainFall.length; i++) {
            noStroke();
            fill(colors[i], 255, 255);
            rect(0, map(i, 0, rainFall.length, 0, height), rainFall[i] * 2, h);
            fill(255);
            float textY = map(i, 0, rainFall.length, h * 0.5f, height + (h * 0.5f));// i * h + (h * 0.5f);
            text(months[i], 5, textY);
        }
    }

    void drawAxis(float[] data, String[] horizLabels, int verticalIntervals, float vertDataRange, float border) {
        stroke(200, 200, 200);
        fill(200, 200, 200);

        // Draw the horizontal azis
        line(border, height - border, width - border, height - border);

        float windowRange = (width - (border * 2.0f));
        float horizInterval = windowRange / (data.length - 1);
        float tickSize = border * 0.1f;

        for (int i = 0; i < data.length; i++) {
            // Draw the ticks
            float x = border + (i * horizInterval);
            line(x, height - (border - tickSize), x, (height - border));
            float textY = height - (border * 0.5f);

            // Print the text
            textAlign(CENTER, CENTER);
            text(horizLabels[i].substring(0, 3), x, textY);

        }

        // Draw the vertical axis
        line(border, border, border, height - border);

        float verticalDataGap = vertDataRange / verticalIntervals;
        float verticalWindowRange = height - (border * 2.0f);
        float verticalWindowGap = verticalWindowRange / verticalIntervals;
        for (int i = 0; i <= verticalIntervals; i++) {
            float y = (height - border) - (i * verticalWindowGap);
            line(border - tickSize, y, border, y);
            float hAxisLabel = verticalDataGap * i;

            textAlign(RIGHT, CENTER);
            text((int) hAxisLabel, border - (tickSize * 2.0f), y);
        }
    }

    void drawLineGraph() {
        float border = width * 0.1f;
        drawAxis(rainFall, months, 15, 150, border);
        stroke(0, 255, 255);

        float windowRange = (width - (border * 2.0f));
        float dataRange = 150;
        float lineWidth = windowRange / (float) (months.length - 1);

        float scale = windowRange / dataRange;
        for (int i = 1; i < rainFall.length; i++) {
            float x1 = border + ((i - 1) * lineWidth);
            float x2 = border + (i * lineWidth);
            float y1 = (height - border) - (rainFall[i - 1]) * scale;
            float y2 = (height - border) - (rainFall[i]) * scale;
            line(x1, y1, x2, y2);
        }
    }

    public void draw() {
        background(0);

        //drawBarChart();

        drawLineGraph();

        float gap = height / (float) rainFall.length;
        int m = (int) Math.floor(mouseY / gap);
        fill(255);
        text(rainFall[m], 300, height / 2);
    }
}