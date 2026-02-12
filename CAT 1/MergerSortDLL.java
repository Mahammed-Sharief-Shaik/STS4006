import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
    }
}

public class MergerSortDLL {
    static Node head = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            create(sc.nextInt());
        }
        display();
        System.out.println();
        head = MergerSort(head);
        System.out.println("After sorting:");
        display();

    }

    static Node MergerSort(Node first) {
        // we stop when n=0 or n1
        if (first == null || first.next == null)
            return first;

        // splitting
        // Node first=head;
        Node second = split(first);
        // sorting before merging
        first = MergerSort(first);
        second = MergerSort(second);

        return merge_comparing(first, second);

    }

    static Node split(Node first) {
        Node slow = first;
        Node fast = first;

        while (fast.next != null&&fast.next.next != null  ) {
            slow = slow.next;
            fast = fast.next.next;

        }
        Node temp = slow.next;
        // removing link to split
        slow.next = null;
        return temp;

    }

    static Node merge_comparing(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;
        if (first.data < second.data) {
            // recheck if any other may place in btw
            first.next = merge_comparing(first.next, second);
            // connect it to prev
            first.next.prev = first;
            // for dll first node again point to null
            first.prev = null;
            return first;
        } else {
            // if(2,3 to place btw 1,4)
            second.next = merge_comparing(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }

    }

    static void create(int value) {
        Node nn = new Node(value);
        if (head == null) {
            head = nn;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = nn;

        }

    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");

    }
}
