package Day3;

import java.util.ArrayList;

public class SpiralMemory1 {

    public static class Node {

        int value, x, y;
        Node next = null;
        Node last = null;

        Node(int value, int x, int y, Node last) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.last = last;
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

        public String toString() {
            return "Value: " + value + ", X: " + x + ", y: " + y;
        }

    }

    static ArrayList<Node> newArrayList = new ArrayList();

    public static Node currentGlobal = null;

    public static void main(String... args) {
        Node one = new Node(1,0, 0, null);
        newArrayList.add(one);
        Node two = new Node(2, 1, 0, one);
        newArrayList.add(two);
        one.setNext(two);
        Node beginNode = newArrayList.get(1);
        System.out.println(two.getValue());
        currentGlobal = two;

        while(currentGlobal.getValue() < 299000) {
            goUp(currentGlobal);
            goLeft(currentGlobal);
            goDown(currentGlobal);
            goRight(currentGlobal);
        }



    }

    public static void goRight(Node current) {

        if (getUp(current) != null) {

            int currentValue = current.getValue();
            int currentX = current.getX();
            int currentY = current.getY();

            Node newNode = new Node(currentValue + 1, currentX + 1, currentY, current);
            current.setNext(newNode);
            newArrayList.add(newNode);
            currentGlobal = newNode;
            System.out.println(newNode.toString());
            goRight(newNode);


        } /*else {
            if (current.getValue() < 290000) {
                goUp(current);
            }

        }
        */

    }

    public static void goLeft(Node current) {
        if (getDown(current) != null) {

            int currentValue = current.getValue();
            int currentX = current.getX();
            int currentY = current.getY();

            Node newNode = new Node(currentValue + 1, currentX - 1, currentY, current);
            current.setNext(newNode);
            newArrayList.add(newNode);
            currentGlobal = newNode;
            System.out.println(newNode.toString());
            goLeft(newNode);

        } /*else {
            goDown(current);
        }
        */
    }

    public static void goUp(Node current) {
        if (getLeft(current) != null) {

            int currentValue = current.getValue();
            int currentX = current.getX();
            int currentY = current.getY();

            Node newNode = new Node(currentValue + 1, currentX, currentY + 1, current);
            current.setNext(newNode);
            newArrayList.add(newNode);
            currentGlobal = newNode;
            System.out.println(newNode.toString());
            goUp(newNode);

        } /*else {
            goLeft(current);
        }
        */

    }

    public static void goDown(Node current) {
        if (getRight(current) != null) {

            int currentValue = current.getValue();
            int currentX = current.getX();
            int currentY = current.getY();

            Node newNode = new Node(currentValue + 1, currentX, currentY - 1, current);
            current.setNext(newNode);
            newArrayList.add(newNode);
            currentGlobal = newNode;
            System.out.println(newNode.toString());
            goDown(newNode);

        } /*else {
            goRight(current);
        }
        */
    }

    public static Node getLeft(Node compare) {


        boolean gotLeft = false;
        Node buffer = newArrayList.get(0);
        while (gotLeft == false) {
            if (buffer.getX() == compare.getX() - 1) {
                if (buffer.getY() == compare.getY()) {
                    gotLeft = true;
                    break;
                }
            }
            buffer = buffer.getNext();
            if (buffer == null) {
                return null;
            }
        }

        return buffer;
    }

    public static Node getRight(Node compare) {

        boolean gotRight = false;
        Node buffer = newArrayList.get(0);
        while (gotRight == false) {
            if (buffer.getX() == compare.getX() + 1) {
                if (buffer.getY() == compare.getY()) {
                    gotRight = true;
                    break;
                }
            }
            buffer = buffer.getNext();
            if (buffer == null) {
                return null;
            }
        }

        return buffer;

    }

    public static Node getUp(Node compare) {

        boolean gotUp = false;
        Node buffer = newArrayList.get(0);
        while (gotUp == false) {
            if (buffer.getX() == compare.getX()) {
                if (buffer.getY() == compare.getY() + 1) {
                    gotUp = true;
                    break;
                }
            }
            buffer = buffer.getNext();
            if (buffer == null) {
                return null;
            }
        }

        return buffer;

    }

    public static Node getDown(Node compare) {

        boolean gotDown = false;
        Node buffer = newArrayList.get(0);
        while (gotDown == false) {
            if (buffer.getX() == compare.getX()) {
                if (buffer.getY() == compare.getY() - 1) {
                    gotDown = true;
                    break;
                }
            }
            buffer = buffer.getNext();
            if (buffer == null) {
                return null;
            }
        }

        return buffer;

    }


}