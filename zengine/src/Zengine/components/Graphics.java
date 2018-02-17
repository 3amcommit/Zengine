package Zengine.components;

import java.awt.*;

public class Graphics extends Component implements Drawable {

    Color color;
    Dimension dimension;

    public Graphics(Color c){
        this.color = c;
    }
    public Graphics(){
        this.color = Color.gray;
    }

    @Override
    public void draw(java.awt.Graphics g, Camera camera) {
        Transform cTransform = camera.transform;
        g.setColor(color);
        dimension = ((Collider)gameObject.getComponent(COLLIDER)).getDimension();
        g.fillRect(transform.getX() - cTransform.getX(), transform.getY()-cTransform.getY(), (int)dimension.getWidth(), (int)dimension.getHeight());
    }

    @Override
    public String getComponentType() {
        return GRAPHICS;
    }
}
