package Zengine.components;

import java.awt.*;

public class Camera extends Component {

    private Dimension viewPort;

    public Camera(int viewWidth, int viewHeight) {
        viewPort = new Dimension(viewWidth, viewHeight);
    }

    public Camera() {
    }

    public Dimension getViewPort() {
        return viewPort;
    }

    public void setViewPort(Dimension viewPort) {
        this.viewPort = viewPort;
    }

    public int getViewPortWidth() {
        return (int) viewPort.getWidth();
    }

    public int getViewPortHeight() {
        return (int) viewPort.getHeight();
    }

    @Override
    public String getComponentType() {
        return CAMERA;
    }
}
