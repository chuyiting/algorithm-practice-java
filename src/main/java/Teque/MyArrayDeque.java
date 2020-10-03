package Teque;

import java.util.HashMap;
import java.util.Map;

public class MyArrayDeque {
    int[] dataArray;

    private int preSize;
    private int appendSize;
    private int maxSize;

    public MyArrayDeque(int maxSize) {
        this.maxSize = maxSize;
        this.preSize = 0;
        this.appendSize = 0;
        dataArray = new int[maxSize << 1];
    }

    public void pushFront(int value) {
        dataArray[maxSize - (++preSize)] = value;
    }
    public void pushBack(int value) {
        dataArray[maxSize + (appendSize++)] = value;
    }

    public int popFront() {
        return dataArray[maxSize - (preSize--)];
    }

    public int popBack() {
        return dataArray[maxSize + (--appendSize)];
    }

    public int size() {
        return preSize + appendSize;
    }

    public int get(int idx) {
        return dataArray[maxSize - preSize + idx];
    }


}
