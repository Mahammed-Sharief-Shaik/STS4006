import java.util.Scanner;

class Node{
    int data;
    Node next, prev;
    Node(int data){
        this.data = data;
    }
}

public class DLL {
    static Node head, tail;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            addNode(sc.nextInt());
        }

        traverseDLL();
    }

    static void traverseDLL(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void addNode(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
}