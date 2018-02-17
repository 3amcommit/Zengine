package Zengine;

import Zengine.components.Camera;
import Zengine.components.Collider;
import Zengine.components.Controllable;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

//TODO tests for this file
public class Level extends JPanel {
    public List<Collider> colliders;
    private Game game;
    private Dimension dimension;
    private Camera mainCamera;
    private List<Zengine.components.Graphics> drawables;
    private List<GameObject> gameObjects;
    private List<GameObject> controllables;

    /**
     * Creates a new Level
     *
     * @param game current game
     */
    public Level(Game game) {
        this.game = game;
        drawables = new LinkedList<>();
        gameObjects = new LinkedList<>();
        drawables = new LinkedList<>();
        controllables = new LinkedList<>();
        colliders = new LinkedList<>();

    }

    /**
     * level's width. Game width and level width can be different
     *
     * @param width  width
     * @param height height
     * @return Level
     */
    public Level setBounds(int width, int height) {
        this.dimension = new Dimension(width, height);
        return this;
    }

    /**
     * Add a GameObject to the level
     *
     * @param gm GameObject
     * @return Level
     */
    public Level add(GameObject gm) {
        gm.setLevel(this);
        gm.getComponents().forEach((key, val) -> {
            if (key == Zengine.components.Component.GRAPHICS) {
                drawables.add((Zengine.components.Graphics) val);
            }

            if (key == Zengine.components.Component.COLLIDER) {
                colliders.add((Collider) val);
            }
        });
        if (gm instanceof Controllable) {
            controllables.add(gm);
            game.addKeyListener((Controllable) gm);
        }

        gameObjects.add(gm);

        return this;
    }

    /**
     * Set the main camera of the level
     *
     * @param camera GameObject that has Camera Component
     * @return Level
     */
    public Level setCamera(GameObject camera) {
        add(camera);
        mainCamera = (Camera) camera.getComponent(Zengine.components.Component.CAMERA);
        mainCamera.setViewPort(game.getDimension());
        return this;
    }

    /**
     * Starts the level/game
     */
    public void start() {
        game.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            Thread.sleep(1000 / game.fps);
            if (mainCamera != null) {
                g.clearRect(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());
                mainLoop(g);
                repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void mainLoop(Graphics g) {
        controllables.forEach(Controllable::callInput);
        gameObjects.forEach(GameObject::fullupdate);
        drawables.forEach(d -> d.draw(g, mainCamera));
    }
}
