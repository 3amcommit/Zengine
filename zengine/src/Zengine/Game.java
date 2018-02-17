package Zengine;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    protected int fps;
    protected Dimension dimension;
    private Level level;

    /**
     * Create a game
     * @param gameTitle Title of the game
     * @param width the application width
     * @param height the application height
     * @param fps frames per second
     */
    public Game(String gameTitle, int width, int height,int fps) {
        this.dimension = new Dimension(width, height);
        this.fps = fps;
        this.level = new Level(this);

        setContentPane(this.level);
        setTitle(gameTitle);
        setSize(new Dimension(width, height));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * gets the dimension of the application
     * @return Dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * get the current level
     * @return the current level
     */
    public Level getLevel() {
        return level;
    }

    public Level setLevel(Level level){
        this.level = level;
        return this.level;
    }
}
