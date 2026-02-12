import java.util.Scanner;

class Node {
    Node prev, next;
    int data, priority;

    public Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}

public class PriorityQueueDLL {
    Node front, rear;

    public void offer(int data, int priority) {
        Node newNode = new Node(data, priority);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else if (priority < front.priority) {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }

            if (temp.next == null) { // it is must be inserted at last
                temp.next = newNode;
                newNode.prev = temp;
                rear = newNode;
            } else {
                newNode.next = temp.next;
                newNode.next.prev = newNode;
                temp.next = newNode;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueueDLL pq = new PriorityQueueDLL();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            pq.offer(sc.nextInt(), sc.nextInt());
        }

        pq.traverse();

    }

    public void traverse(){
        Node temp = front;
        while(temp!=null){
            System.out.printf("%d(%d)<-->",temp.data, temp.priority);
            temp=temp.next;
        }
        System.out.println("null");
    }

}
