package Zengine.components;

public class EasyMovement extends Component implements Updatable {
    private static float TERMINALVELOCITY = 30;
    private static float RESISTANCE = 0.2f;
    private float velX, velY;

    public static void setTERMINALVELOCITY(float TERMINALVELOCITY) {
        EasyMovement.TERMINALVELOCITY = TERMINALVELOCITY;
    }

    public static void setRESISTANCE(float RESISTANCE) {
        EasyMovement.RESISTANCE = RESISTANCE;
    }

    public void addForce(Vector2D vector, float force) {
        this.velX += vector.getX() * force;
        this.velY += vector.getY() * force;
    }

    @Override
    public void update() {
        if (velX != 0 || velY != 0) {
            terminalVelocityCheck();
            transform.move((int) velX, (int) velY);
            slowDown();
        }
    }

    private void slowDown() {
        if (this.velX > 0) {
            this.velX -= RESISTANCE;
        }
        if (this.velX < 0) {
            this.velX += RESISTANCE;
        }
        if (this.velY > 0) {
            this.velY -= RESISTANCE;
        }
        if (this.velY < 0) {
            this.velY += RESISTANCE;
        }

        if (Math.abs(velX) < RESISTANCE) velX = 0;
        if (Math.abs(velY) < RESISTANCE) velY = 0;


    }

    private void terminalVelocityCheck() {
        if (this.velX > TERMINALVELOCITY) velX = TERMINALVELOCITY;
        if (this.velX < -TERMINALVELOCITY) velX = -TERMINALVELOCITY;
        if (this.velY > TERMINALVELOCITY) velY = TERMINALVELOCITY;
        if (this.velY < -TERMINALVELOCITY) velY = -TERMINALVELOCITY;
    }
}
