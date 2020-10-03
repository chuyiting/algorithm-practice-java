package TequeTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Teque.Teque;

public class TequeTest {
    @Test
    public void putFrontTest_oneElement() {
        Teque teque = new Teque(3);
        teque.putFront(1);
        Assertions.assertEquals(1, teque.get(0));
    }
    @Test
    public void putFrontTest_multipleElement() {
        Teque teque = new Teque(3);
        teque.putFront(3);
        teque.putFront(2);
        teque.putFront(1);
        Assertions.assertEquals(1, teque.get(0));
        Assertions.assertEquals(2, teque.get(1));
        Assertions.assertEquals(3, teque.get(2));
    }
    @Test
    public void putMiddleTest_oneElement() {
        Teque teque = new Teque(3);
        teque.putMiddle(1);
        teque.putMiddle(3);
        teque.putMiddle(2);
        Assertions.assertEquals(1, teque.get(0));
        Assertions.assertEquals(2, teque.get(1));
        Assertions.assertEquals(3, teque.get(2));
    }
    @Test
    public void putBackTest_oneElement() {
        Teque teque = new Teque(3);
        teque.putBack(1);
        teque.putBack(2);
        teque.putBack(3);
        Assertions.assertEquals(1, teque.get(0));
        Assertions.assertEquals(2, teque.get(1));
        Assertions.assertEquals(3, teque.get(2));
    }
}
