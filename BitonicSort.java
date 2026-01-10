import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
    }
}

public class BitonicSort {
    static Node head, tail;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            addNode(sc.nextInt());
        }
        traverse();
        // biotonic sort either increasing decreasing or increase then decrease
        // splitting reversing merging
        bitonicSort();
        traverse();
    }

    static void bitonicSort(){
        Node resultHead = null, resultTail = null;
        Node first = head, last = tail;

        while (first!=last) {
            if(first.data <= last.data){
                if(resultHead==null){
                    resultHead = first;
                    resultTail = first;
                    first = first.next;

                }else{
                    resultTail.next = first;
                    first.prev = resultTail;
                    resultTail = resultTail.next;
                    first = first.next;
                }
            }else{
                if(resultHead==null){
                    resultHead = last;
                    resultTail = last;
                    last = last.prev;
                }else{
                    Node temp = last.prev;
                    resultTail.next = last;
                    last.prev = resultTail;
                    resultTail = resultTail.next;
                    last = temp;
                }
            }
        }
        resultTail.next = first;
        first.prev = resultTail;
        first.next = null;
        resultTail = resultTail.next;

        head = resultHead;
        tail = resultTail;
    }

    static void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

}

