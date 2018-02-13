import Zengine.GameObject;
import Zengine.components.Collider;
import Zengine.components.Graphics;

public class Static extends GameObject {
    public Static(int x, int y, int width, int height) {
        super(x, y);
        addComponent(new Collider(width, height));
        addComponent(new Graphics());
    }

}
