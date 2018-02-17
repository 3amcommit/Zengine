package Zengine.components;

public class Transform extends Component {
    int x, y;

    /**
     * Transform at Position
     *
     * @param x X
     * @param y Y
     */
    public Transform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * move X, Y spaces  from current position
     * @param x X
     * @param y Y
     */
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        Transform other = (Transform) obj;
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public String getComponentType() {
        return TRANSFORM;
    }


    public static final Transform ZERO = new Transform(0,0);
}
