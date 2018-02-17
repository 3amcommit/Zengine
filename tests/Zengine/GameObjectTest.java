package Zengine;

import Zengine.components.EasyMovement;
import Zengine.components.Transform;
import Zengine.components.Vector2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameObjectTest {

    Dummy dummy;
    Level level;

    @Before
    public void setUp() throws Exception {
        dummy = new Dummy();
        level = new Level(null);
    }

    @After
    public void tearDown() throws Exception {
        dummy = null;
        level = null;
    }

    @Test
    public void setLevel() {
        dummy.setLevel(level);
        assertEquals(level, dummy.getLevel());
    }

    @Test
    public void getTransform() {
        assertEquals(Transform.ZERO, dummy.getTransform());
    }

    @Test
    public void addComponentEasyMM() {
        EasyMovement easyMovement = new EasyMovement();
        dummy.addComponent(easyMovement);
        easyMovement.addForce(Vector2D.UP, 2);
        dummy.fullupdate();
        assertEquals(easyMovement, dummy.getComponent(easyMovement.getComponentType()));
        assertEquals(-2, dummy.getTransform().getY());
    }

    @Test
    public void hasGravity() {
        dummy.addComponent(new EasyMovement());
        dummy.useGravity();
        dummy.fullupdate();
        assertEquals(9, dummy.getTransform().getY());
    }


    class Dummy extends GameObject {
        /**
         * Create a GameObject
         *
         */
        Dummy() {
            super(0, 0);
        }

        Level getLevel() {
            return this.level;
        }

        void useGravity() {
            this.useGravity = true;
        }

        @Override
        protected void fullupdate() {
            super.fullupdate();
        }

    }

}