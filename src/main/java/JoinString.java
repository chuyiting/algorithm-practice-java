import java.io.*;

/**
 * @see <a href="http://google.com">Question</a>
 */
public class JoinString {
    public static class MyLinkedList {
        private Node head;
        private MyLinkedList last;
        private MyLinkedList tail;

        class Node {
            String content;

            Node(String str) {
                this.content = str;
            }

            @Override
            public String toString() {
                return this.content;
            }
        }

        MyLinkedList(String initStr) {
            this.head = new Node(initStr);
            this.last = this;
            this.tail = null;
        }

        public MyLinkedList getLast() {
            return this.last;
        }

        public void setTail(MyLinkedList ls) {
            this.tail = ls;
        }

        public MyLinkedList append(MyLinkedList list) {
            if (this.tail == null) {
                this.tail = list;
            } else {
                this.last.setTail(list);
            }
            this.last = list.getLast();
            return this;
        }

        public void print() {
            MyLinkedList list = this;
            while (list != null) {
                System.out.print(list.head);
                list = list.tail;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num == 1) {
            System.out.println(br.readLine());
            System.out.println();
            return;
        }

        MyLinkedList[] strings = new MyLinkedList[num];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new MyLinkedList(br.readLine());
        }

        int root = 0;
        String command = br.readLine();
        for (int i = 0; i < num - 1; i++) {
            String[] stringIdx = command.split(" ");
            int headIdx = Integer.parseInt(stringIdx[0]) - 1;
            int tailIdx = Integer.parseInt(stringIdx[1]) - 1;
            strings[headIdx].append(strings[tailIdx]);
            root = headIdx;
            command = br.readLine();
        }
        strings[root].print();
    }
}
