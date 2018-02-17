package Zario;

import Zengine.Game;
import Zengine.Level;

public class Main {
    public static void main(String[] args) {
        Level level = new Game("Zario", 1280, 720, 60).getLevel();

        level.setBounds(3000,720)
                .setCamera(new Camera())
                .add(new Static(0, 720-70, 1280, 70))
                .add(new Player(30, 500))
        .start();
    }
}
