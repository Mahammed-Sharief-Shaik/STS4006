import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class LL {
    // static Node head;
    static Node head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // input 7 9 2
        for (int i = 0; i < n; i++) {
            createLinkedList(sc.nextInt());
        }

        traverseLL();

    }

    static void traverseLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    static void createLinkedList(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            // DLL newNode.prev = temp;
        }
    }


    
}