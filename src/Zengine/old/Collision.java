package Zengine.old;

import Zengine.GameObject;

public class Collision {
    public int top;
    public int bottom;
    public int left;
    public int right;

    public Collision(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public static boolean BoxCollision(GameObject rect1, GameObject rect2) {
        //from https://developer.mozilla.org/kab/docs/Games/Techniques/2D_collision_detection
        if (rect1.x < rect2.x + rect2.width &&
                rect1.x + rect1.width > rect2.x &&
                rect1.y < rect2.y + rect2.height &&
                rect1.height + rect1.y > rect2.y) {
            return true;
        }
        return false;
    }
}
