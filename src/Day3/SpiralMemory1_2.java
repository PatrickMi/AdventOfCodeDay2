package Day3;

import java.util.ArrayList;

public class SpiralMemory1_2 {

    public static class Node {

        int value, x, y;
        Node next = null;
        Node last = null;

        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        int getValue() {
            return value;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node n) {
            next = n;
        }

        Node getLast() {
            return last;
        }

        void setLast(Node n) {
            last = n;

        }

    }

    static ArrayList<Node> newArrayList = new ArrayList();

    public static void main(String[] args) {

    }
}
