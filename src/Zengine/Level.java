package Zengine;

import Zengine.components.Camera;
import Zengine.components.Collider;
import Zengine.components.Controllable;

import javax.swing.JPanel;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Level extends JPanel {
    private Game game;
    private Dimension dimension;
    private Camera mainCamera;
    private List<Zengine.components.Graphics> drawables;
    private List<GameObject> gameObjects;
    private List<GameObject> controllables;
    public List<Collider> colliders;

    public Level(Game game) {
        this.game = game;
        drawables = new LinkedList<>();
        gameObjects = new LinkedList<>();
        drawables = new LinkedList<>();
        controllables = new LinkedList<>();
        colliders = new LinkedList<>();

    }

    public Level setBounds(int width, int height) {
        this.dimension = new Dimension(width, height);
        return this;
    }

    public Level add(GameObject gm) {
        gm.setLevel(this);
        gm.getComponents().forEach((key, val) -> {
            if (key == Zengine.components.Component.GRAPHICS) {
                drawables.add((Zengine.components.Graphics) val);
            }

            if(key == Zengine.components.Component.COLLIDER){
                colliders.add((Collider) val);
            }
        });
        if(gm instanceof Controllable){
            controllables.add(gm);
            game.addKeyListener((Controllable)gm);
        }

        gameObjects.add(gm);

        return this;
    }

    public Level setCamera(GameObject camera) {
        add(camera);
        mainCamera = (Camera) camera.getComponent(Zengine.components.Component.CAMERA);
        mainCamera.setViewPort(game.getDimension());
        return this;
    }


    public void start(){
        game.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        try {
            Thread.sleep(1000 / game.fps);
            if (mainCamera != null) {
                g.clearRect(0,0,(int)dimension.getWidth(),(int)dimension.getHeight());
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
