package Zengine.components;

public class Transform extends Component {
    int x, y;

    public Transform(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Transform(){
        this.x = 0;
        this.y = 0;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }



    public void moveX(int x){
        this.x +=x;
    }
    public void moveY(int y){
        this.y +=y;
    }

    @Override
    public String getComponentType() {
        return TRANSFORM;
    }
}
