package Zengine.old;

import Zengine.GameObject;

import java.awt.event.KeyEvent;

public class Camera extends GameObject implements Controllable {

    private int velX, velY, speed = 3;
    private Level level;

    Camera(int width, int height, Level level) {
        super();
        this.width = width;
        this.height = height;
        velX = 0;
        velY = 0;
        this.level = level;

    }

    public void update() {
        this.x += velX;
        this.y += velY;
        velX = normalize(velX);
        velY = normalize(velY);
        checkBounds();
    }

    private void checkBounds() {
        if (level.width > 0) {
            if (this.x + this.width > level.width) {
                this.x = level.width - this.width;
                velX = 0;

            }
            if (this.x < 0) {
                this.x = 0;
                velX = 0;

            }
        }
        if (level.height > 0) {
            if (this.y + this.height > level.height) {
                this.y = level.height - this.height;
                velY = 0;

            }
            if (this.y < 0) {
                this.y = 0;
                velY = 0;

            }

        }
    }

    @Override
    public void onInput(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            velX -= speed;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            velX += speed;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            velY += speed;
        }
        if (keyCode == KeyEvent.VK_UP) {
            velY -= speed;
        }
    }
}

