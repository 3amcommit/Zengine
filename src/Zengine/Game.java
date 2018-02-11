package Zengine;

import javax.swing.*;
import java.awt.Dimension;

public class Game extends JFrame {

    private String gameTitle;
    protected int width, height, fps;
    private Level level;

    public Game(String gameTitle, int width, int height,int fps) {
        this.gameTitle = gameTitle;
        this.height = height;
        this.width = width;
        this.fps = fps;
        this.level = new Level(this);

        setContentPane(this.level);
        setTitle(gameTitle);
        setSize(new Dimension(width, height));
        setResizable(false);
        setVisible(true);
    }

    public Level getLevel() {
        return level;
    }
}
