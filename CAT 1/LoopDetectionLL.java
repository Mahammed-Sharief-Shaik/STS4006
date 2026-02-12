import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class LoopDetectionLL {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // input 7 9 2
        for (int i = 0; i < n; i++) {
            createLinkedList(sc.nextInt());
        }

        traverseLL();
        int loopNode = sc.nextInt();
        int last = n - 1;

        createLoop(loopNode, last);
        System.out.println(detectLoop(head));
    }

    static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    static void createLoop(int loopNodeData, int last) {
        Node n1 = head; // keep at loop node
        Node n2 = head; // keep at the last node
        while (n1 != null && n1.data != loopNodeData)
            n1 = n1.next;
        if (n1 == null)
            return;
        while (n2.next != null)
            n2 = n2.next;
        n2.next = n1;
        return;

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
        }
    }

}
