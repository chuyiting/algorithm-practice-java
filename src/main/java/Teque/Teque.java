package Teque;

import java.io.IOException;


/**
 * @see <a href="https://rb.gy/jvr31b">Question</a>
 */

public class Teque {

    MyArrayDeque leftArray;
    MyArrayDeque rightArray;

    public Teque(int size) {
        leftArray = new MyArrayDeque(size);
        rightArray = new MyArrayDeque(size);
    }

    public void putFront(int value) {
        if (isLeftHeavy()) {
            leftArray.pushFront(value);
            rightArray.pushFront(leftArray.popBack());
            return;
        }
        leftArray.pushFront(value);
    }
    public void putMiddle(int value) {
        if (isLeftHeavy()) {
            rightArray.pushFront(value);
            return;
        }
        leftArray.pushBack(value);
    }

    public void putBack(int value) {
        if (isLeftHeavy()) {
            rightArray.pushBack(value);
            return;
        }
        rightArray.pushBack(value);
        leftArray.pushBack(rightArray.popFront());
    }

    private boolean isLeftHeavy() {
        return this.leftArray.size() > this.rightArray.size();
    }

    public int get(int idx) {
        if (idx >= leftArray.size()) {
            return rightArray.get(idx - leftArray.size());
        }
        return leftArray.get(idx);
    }


    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int n = io.nextInt();
        Tokenizer tokenizer = new Tokenizer();
        Teque teque = new Teque(n);
        for (int i = 0; i < n; i++) {
            String op = io.next();
            int idx = io.nextInt();
            if (op.equals("push_back")) {
                teque.putBack(idx);
            } else if (op.equals("push_front")) {
                teque.putFront(idx);
            } else if (op.equals("push_middle")) {
                teque.putMiddle(idx);
            } else {
                io.write(String.valueOf(teque.get(idx)));
                io.write("\n");
            }
        }
        io.flush();


    }


}


