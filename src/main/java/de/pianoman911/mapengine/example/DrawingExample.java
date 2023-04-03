package de.pianoman911.mapengine.example;

import de.pianoman911.mapengine.api.drawing.IDrawingSpace;

public class DrawingExample {

    public void drawRandomStuff(IDrawingSpace space) {
        // draw a line from x=0, y=0 to x=128, y=128 and cyan
        space.line(0, 0, 128, 128, 0x00FFFF);

        // draw a rectangle at x=0, y=0 with width=128, height=128 and red
        space.rect(0, 0, 128, 128, 0xFF0000);

        // draw a triangle at x=0, y=0, x=128, y=128, x=0, y=128 and blue
        space.triangle(0, 0, 128, 128, 0, 128, 0x0000FF);

        // draw a circle at x=64, y=64 with radius=64 and yellow
        space.circle(64, 64, 64, 0xFFFF00);
    }
}