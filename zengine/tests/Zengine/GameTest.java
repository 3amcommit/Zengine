package Zengine;

import Zengine.Game;
import Zengine.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game("Test Game", 100,100,0);
    }

    @After
    public void tearDown() throws Exception {
        game = null;
    }

    @Test
    public void getDimension() {
        assertEquals(new Dimension(100,100), game.getDimension());
    }

    @Test
    public void getLevel() {
        Level dummyLevel = new Level(game);
        game.setLevel(dummyLevel);
        assertEquals(dummyLevel, game.getLevel());
    }

}