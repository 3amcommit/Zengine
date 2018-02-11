import Zengine.*;

public class Main {
    public static void main(String[] args) {
        Level level = new Game("Zario", 1280, 720, 60).getLevel();

        level.setBounds(3000,720).add(new Static(0, 720-70, 3000, 70))
        .add(new Static(30, 600, 100, 100))
        .add(new Static(2800, 600, 100, 100));
    }
}
