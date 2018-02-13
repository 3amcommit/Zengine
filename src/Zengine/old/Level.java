package Zengine.old;

import Zengine.Game;
import Zengine.GameObject;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Level extends JPanel {

    private Camera mainCamera;
    private Game game;
    private List<Moveable> movers;
    private List<Drawable> drawables;
    private List<Collidable> collidables;
    private List<Controllable> controllables;
    int height = 0, width = 0;

    Level(Game game) {
        this.game = game;
        this.mainCamera = new Camera(game.width, game.height, this);
        movers = new ArrayList<>();
        drawables = new ArrayList<>();
        collidables = new ArrayList<>();
        controllables = new ArrayList<>();
        movers.add(mainCamera);
        controllables.add(mainCamera);
        game.addKeyListener(mainCamera);

    }

    public Level setBounds(int width, int height) {
        this.height = height;
        this.width = width;
        return this;
    }

    public Camera getMainCamera() {
        return mainCamera;
    }

    public Level add(GameObject gm) {
        if (gm instanceof Drawable) {
            drawables.add((Drawable) gm);
        }
        if (gm instanceof Moveable) {
            movers.add((Moveable) gm);
        }
        if (gm instanceof Controllable) {
            controllables.add((Controllable) gm);
            game.addKeyListener((Controllable) gm);
        }
        if (gm instanceof Collidable) {
            collidables.add((Collidable) gm);
        }
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            Thread.sleep(1000 / game.fps);
            g.clearRect(0, 0, game.width, game.height);
            controllables.forEach(Controllable::callInput);
            movers.forEach(Moveable::update);
            checkCollisions();
            drawables.forEach(drawable -> drawable.draw(g, mainCamera));
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void checkCollisions() {
        collidables.forEach(collidable -> collidables.forEach(collidable1 -> {
            if (collidable != collidable1)
                collidable.collision((GameObject) collidable1);
        }));
    }
}
