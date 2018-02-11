package Zengine;

import com.sun.istack.internal.Nullable;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Level extends JPanel {

    private Camera mainCamera;
    private Game game;
    private List<Moveable> movers;
    private List<Drawable> drawables;
    int height = 0, width = 0;

    Level(Game game) {
        this.game = game;
        this.mainCamera = new Camera(game.width, game.height, this);
        movers = new ArrayList<>();
        drawables = new ArrayList<>();
        movers.add(mainCamera);
        game.addKeyListener(mainCamera);

    }

    public Level setBounds( int width, int height) {
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
        if(gm instanceof Moveable) {
            movers.add((Moveable) gm);
        }
        if(gm instanceof Controlable){
            game.addKeyListener((Controlable) gm);
        }
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            Thread.sleep(1000 / game.fps * 2);
            g.clearRect(0, 0, game.width, game.height);
            movers.forEach(Moveable::update);
            drawAll(g);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void drawAll(Graphics g) {
        drawables.forEach(aStatic -> aStatic.draw(g, mainCamera));

    }
}
