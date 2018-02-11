package Zengine;


public abstract class GameObject{
    int x, y, width, height;

    GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }




    static int normalize(int number) {
        if (number < 0) return ++number;
        if (number > 0) return --number;
        return 0;
    }


}
