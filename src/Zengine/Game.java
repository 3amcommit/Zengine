package Zengine;

import javax.swing.*;
import java.awt.Dimension;

public class Game extends JFrame {

    protected int fps;
    protected Dimension dimension;
    private Level level;

    public Game(String gameTitle, int width, int height,int fps) {
        this.dimension = new Dimension(width, height);
        this.fps = fps;
        this.level = new Level(this);

        setContentPane(this.level);
        setTitle(gameTitle);
        setSize(new Dimension(width, height));
        setResizable(false);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Level getLevel() {
        return level;
    }
}
