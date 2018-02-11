package Zengine;

import java.awt.*;

public class Static extends GameObject implements Drawable {

    public Static(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g, Camera camera) {
        g.fillRect(x - camera.x, y - camera.y, width, height);
    }
}
