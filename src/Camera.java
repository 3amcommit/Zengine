import Zengine.GameObject;
import Zengine.components.Controllable;
import Zengine.components.EasyMovement;
import Zengine.components.Vector2D;

import java.awt.event.KeyEvent;

public class Camera extends GameObject implements Controllable{
    EasyMovement movement;
    public Camera() {
        super(0,0);
        addComponent(new Zengine.components.Camera());
        movement = (EasyMovement) addComponent(new EasyMovement());
    }

    @Override
    public void onInput(int KeyCode) {
        if (KeyCode == KeyEvent.VK_LEFT){
            movement.addForce(Vector2D.LEFT, 1);
        }
        if(KeyCode == KeyEvent.VK_RIGHT){
            movement.addForce(Vector2D.RIGHT, 1);
        }
    }

    @Override
    public void update() {
        movement.update();
    }
}
