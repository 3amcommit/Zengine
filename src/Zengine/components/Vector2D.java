package Zengine.components;

public class Vector2D extends Component {
    private float x, y;

    public Vector2D(int x, int y){
        float z = (float)Math.hypot(x,y);
        this.x = x/z;
        this.y = y/z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public final static Vector2D RIGHT = new Vector2D(1,0);
    public final static Vector2D LEFT = new Vector2D(-1,0);
    public final static Vector2D UP = new Vector2D(0,-1);
    public final static Vector2D DOWN = new Vector2D(0,1);
}
