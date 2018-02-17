package Zengine;

import Zengine.components.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class GameObject <K extends Component> {
    protected Transform transform;
    protected Level level;
    protected boolean useGravity = false;
    protected Map<String, K> components;

    /**
     * Create a GameObject
     *
     * @param x at X
     * @param y at Y
     */
    public GameObject(int x, int y) {
        this.transform = new Transform(x, y);
        components = new HashMap<>();
    }

    protected void fullupdate() {
        components.values().forEach(k -> {
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

            if (k instanceof Updatable) {
                ((Updatable) k).update();
            }
        });

    }

    /**
     * in Case of needing to move gameObject to another level
     *
     * @param level new Level
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Get the GameObject Transform
     *
     * @return Transform
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * Add a component to the GameObject
     *
     * @param component Component to add. Must extend Component
     * @return added Component
     */
    public K addComponent(K component) {
        component.setGameObject(this);
        component.setTransform(transform);
        components.put(component.getComponentType(), component);
        return component;
    }

    /**
     * triggered when a collision occurs
     *
     * @param collision returns the Collision
     */
    public void onCollision(Collision collision) {

    }

    /**
     * Get a component based on what type of component it is
     *
     * @param type Component type
     * @return Component
     */
    public K getComponent(String type) {
        return components.get(type);
    }

    /**
     * get All Component types on GameObject
     *
     * @return set of Component Keys
     */
    public Set<String> getComponentKeys() {
        return components.keySet();
    }

    /**
     * get All Component on GameObject. Better to use getComponent
     *
     * @return Map of Component Keys and Values.
     */
    public Map<String, K> getComponents() {
        return components;
    }
}
