package com.jnote.algorithm;

/**
 * @author bobwang
 */
public class PrintInverse {
    public static void print(Node node) {
        if (node.next != null) {
            print(node.next);
        }
        System.out.println(node.data);

    }

    public static void main(String[] args) {

        Node four = new Node(4, null);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node first = new Node(1, two);
        PrintInverse.print(first);
    }
}


class Node {

    int data;
    Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}