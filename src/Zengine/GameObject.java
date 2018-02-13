package Zengine;

import Zengine.components.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class GameObject<K extends Component> {
    protected Transform transform;
    protected Level level;
    protected boolean useGravity = false;
    protected Map<String, K> components;

    public GameObject(int x, int y) {
        this.transform = new Transform(x, y);
        components = new HashMap<>();
    }

    public void fullupdate() {
        components.values().forEach(k -> {
            if (k instanceof Updatable) {
                ((Updatable) k).update();
            }

            if (useGravity && k instanceof EasyMovement) {
                ((EasyMovement) k).addForce(Vector2D.DOWN, 9.8f);
            }
            if (this instanceof Controllable && k instanceof Collider) {
                level.colliders.forEach(collider -> {
                    if (collider != k) {
                        ((Collider) k).checkCollision(collider);
                    }
                });
            }
        });


        update();
    }


    protected void update() {
        //override
    }

    public int getX() {
        return transform.getX();
    }

    public int getY() {
        return transform.getY();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Transform getTransform() {
        return transform;
    }

    public K addComponent(K component) {
        component.setGameObject(this);
        component.setTransform(transform);
        components.put(component.getComponentType(), component);
        return component;
    }

    public void onCollision(Collision collision) {

    }

    public K getComponent(String type) {
        return components.get(type);
    }

    public Set<String> getComponentKeys() {
        return components.keySet();
    }

    public Map<String, K> getComponents() {
        return components;
    }
}
