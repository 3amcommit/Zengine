package Zengine.components;

import Zengine.GameObject;

public abstract class Component {
    Transform transform;
    GameObject gameObject;

    public String getComponentType(){
        return getClass().getCanonicalName();
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public Transform getTransform() {
        return transform;
    }

    public final static String GRAPHICS = "Graphics";
    public final static String CAMERA = "Camera";
    public final static String COLLIDER = "Collider";
    public final static String TRANSFORM = "Transform";


}
