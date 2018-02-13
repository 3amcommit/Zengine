package Zengine.components;

import java.awt.*;

public class Collider extends Component implements Collidable {
    public Dimension dimension;

    public Collider(int width, int height) {
        this.dimension = new Dimension(width, height);
    }

    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public String getComponentType() {
        return COLLIDER;
    }

    @Override
    public boolean checkCollision(Collider other) {

        //from https://developer.mozilla.org/kab/docs/Games/Techniques/2D_collision_detection
        if (transform.x < transform.x + other.dimension.width &&
                transform.x + dimension.width > other.transform.x &&
                transform.y < other.transform.y + other.dimension.height &&
                dimension.height + transform.y > other.transform.y) {
            Collision collision = new Collision(this, other);
            gameObject.onCollision(collision);
            other.gameObject.onCollision(collision);
            return true;
        }
        return false;
    }
}
