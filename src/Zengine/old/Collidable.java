package Zengine.old;

import Zengine.GameObject;

public interface Collidable {
    void onCollision(Collision collision);

    default void collision(GameObject other){
        if(Collision.BoxCollision((GameObject)this, other)){
            onCollision(new Collision(1,0,1,10));
        }
    }
}
