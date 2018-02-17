package Zengine.components;

import Zengine.GameObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public interface Controllable extends KeyListener {
    Set<Integer> keysPressed = new HashSet<>();

    @Override
    default void keyTyped(KeyEvent e) {
        //children may implement
    }

    @Override
    default void keyPressed(KeyEvent e) {
        keysPressed.add(e.getKeyCode());

    }

    @Override
    default void keyReleased(KeyEvent e) {
        keysPressed.remove(e.getKeyCode());

    }

    void onInput(int KeyCode);

    static void callInput(GameObject gameObject) {
        keysPressed.forEach(((Controllable) gameObject)::onInput);

    }
}
