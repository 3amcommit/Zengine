package Zengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public interface Controlable extends Moveable,KeyListener {
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
}
