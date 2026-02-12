import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class SegreateEvenOdd {
    static Node head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // input in form 7 9 2
        for (int i = 0; i < n; i++) {
            createLinkedList(sc.nextInt());
        }

        traverseLL();
        segregate();
        traverseLL();

    }

    static void segregate() {
        Node curr = head;
        Node evenHead = null;
        Node oddHead = null;
        Node evenTail = null;
        Node oddTail = null;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
           
        }

        if (evenHead == null) {
            head = oddHead;
        } else if (oddHead == null) {
            // evenTail.next = null;
            head = evenHead;
        } else {

            // odd then even
            // head = oddHead;
            // oddTail.next = evenHead;
            // evenTail.next = null;

            // even then odd
            head = evenHead;
            evenTail.next = oddHead;
            oddTail.next = null;
        }
        

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
