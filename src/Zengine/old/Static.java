package Zengine.old;

import Zengine.GameObject;
import Zengine.old.Camera;
import Zengine.old.Collidable;
import Zengine.old.Collision;
import Zengine.old.Drawable;

import java.awt.*;

public class Static extends GameObject implements Drawable, Collidable {

    public Static(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g, Camera camera) {
        g.fillRect(x - camera.x, y - camera.y, width, height);
    }


    @Override
    public void onCollision(Collision collision) {

    }

}
