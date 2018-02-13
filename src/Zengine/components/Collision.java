package Zengine.components;

import Zengine.GameObject;

public class Collision {
    Collider a, b;

    public Collision(Collider a, Collider b) {
        this.a = a;
        this.b = b;
    }


    public Collider getOther(Collider self) {
        return self == a ? b : a;
    }
}
