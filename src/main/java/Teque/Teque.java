package Teque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tokenizer tokenizer = new Tokenizer();
        int numOfCommands = Integer.parseInt(br.readLine());
        Teque teque = new Teque(numOfCommands);
        for (int i = 0; i < numOfCommands; i++) {
            Command command = tokenizer.tokenize(br.readLine().trim());
            switch (command.getCommandType()) {
            case GET:
                System.out.println( teque.get(command.getIdxOrValue()));
                break;
            case PUSH_BACK:
                teque.putBack(command.getIdxOrValue());
                break;
            case PUSH_MIDDLE:
                teque.putMiddle(command.getIdxOrValue());
                break;
            case PUSH_FRONT:
                teque.putFront(command.getIdxOrValue());
                break;
            }
        }


    }


}


