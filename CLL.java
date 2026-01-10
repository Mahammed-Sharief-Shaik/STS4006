import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class CLL {
    static Node head, tail;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            addNode(sc.nextInt());
        }

        traverseCLL(n);
    }

    static void traverseCLL(int n){
        Node temp = head;
        for(int i=0; i<=n; i++){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }

    }

    static void addNode(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }else{
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
        }
    }


}
