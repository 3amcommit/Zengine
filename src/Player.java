import Zengine.*;

import java.awt.Graphics;

public class Player extends GameObject implements Controlable, Drawable{

    Player() {
        super();
    }

    @Override
    public void draw(Graphics g, Camera camera) {

    }

    @Override
    public void update() {
    keysPressed.forEach(keyCode -> {

    });
    }


}
