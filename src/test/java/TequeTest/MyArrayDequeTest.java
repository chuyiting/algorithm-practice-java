package TequeTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Teque.MyArrayDeque;

public class MyArrayDequeTest {
    @Test
    public void putFrontTest_oneElement_popFront() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(1);
        myArrayDeque.pushFront(9);
        Assertions.assertEquals(myArrayDeque.popFront(), 9);
    }
    @Test
    public void putFrontTest_oneElement_popBack() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(1);
        myArrayDeque.pushFront(9);
        Assertions.assertEquals(myArrayDeque.popBack(), 9);
    }
    @Test
    public void putFrontTest_severalElement_popFront() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushFront(1);
        myArrayDeque.pushFront(2);
        myArrayDeque.pushFront(3);

        Assertions.assertEquals(myArrayDeque.popFront(), 3);
        Assertions.assertEquals(myArrayDeque.popFront(), 2);
        Assertions.assertEquals(myArrayDeque.popFront(), 1);
    }
    @Test
    public void putFrontTest_severalElement_popBack() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushFront(1);
        myArrayDeque.pushFront(2);
        myArrayDeque.pushFront(3);

        Assertions.assertEquals(myArrayDeque.popBack(), 1);
        Assertions.assertEquals(myArrayDeque.popBack(), 2);
        Assertions.assertEquals(myArrayDeque.popBack(), 3);
    }
    @Test
    public void putFrontTest_severalElement_mixPop() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushFront(3);
        myArrayDeque.pushFront(2);
        myArrayDeque.pushFront(1);

        Assertions.assertEquals(myArrayDeque.popBack(), 3);
        Assertions.assertEquals(myArrayDeque.popFront(), 1);
        Assertions.assertEquals(myArrayDeque.popBack(), 2);
    }


    @Test
    public void putBackTest_oneElement_popFront() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(1);
        myArrayDeque.pushBack(9);
        Assertions.assertEquals(myArrayDeque.popFront(), 9);
    }
    @Test
    public void putBackTest_oneElement_popBack() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(1);
        myArrayDeque.pushBack(9);
        Assertions.assertEquals(myArrayDeque.popBack(), 9);
    }
    @Test
    public void putBackTest_severalElement_popFront() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushBack(1);
        myArrayDeque.pushBack(2);
        myArrayDeque.pushBack(3);

        Assertions.assertEquals(myArrayDeque.popFront(), 1);
        Assertions.assertEquals(myArrayDeque.popFront(), 2);
        Assertions.assertEquals(myArrayDeque.popFront(), 3);
    }
    @Test
    public void putBackTest_severalElement_popBack() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushBack(1);
        myArrayDeque.pushBack(2);
        myArrayDeque.pushBack(3);

        Assertions.assertEquals(myArrayDeque.popBack(), 3);
        Assertions.assertEquals(myArrayDeque.popBack(), 2);
        Assertions.assertEquals(myArrayDeque.popBack(), 1);
    }
    @Test
    public void putBackTest_severalElement_mixPop() {
        MyArrayDeque myArrayDeque = new MyArrayDeque(3);
        myArrayDeque.pushBack(1);
        myArrayDeque.pushBack(2);
        myArrayDeque.pushBack(3);

        Assertions.assertEquals(myArrayDeque.popBack(), 3);
        Assertions.assertEquals(myArrayDeque.popFront(), 1);
        Assertions.assertEquals(myArrayDeque.popBack(), 2);
    }
}
