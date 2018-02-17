import Zengine.GameObject;
import Zengine.components.*;
import Zengine.components.Component;
import Zengine.components.Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject implements Controllable{

    public EasyMovement movement;

    public Player(int x, int y) {
        super(x, y);
        useGravity = true;
        addComponent(new Collider(20,20));
        movement = (EasyMovement) addComponent(new EasyMovement());
        addComponent(new Graphics(Color.RED));

    }

    @Override
    public void onInput(int KeyCode) {
        if(KeyCode == KeyEvent.VK_W){
            movement.addForce(Vector2D.UP, 200);
        }
    }

    @Override
    public void onCollision(Collision collision) {
        Collider self =  (Collider)getComponent(Component.COLLIDER);
        Transform other = collision.getOther(self).getTransform();
        transform.setY((other.getY() - 20));
    }
}
