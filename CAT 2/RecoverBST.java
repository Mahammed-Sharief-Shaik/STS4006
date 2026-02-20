import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}

public class RecoverBST {
    static Node root;

    static Node first, middle, last;
    static Node prev;

    public static void main(String[] args) {
        buildTree();
        inOrder(root);
        System.out.println();
        recover();
        inOrder(root);
        System.out.println();
    }

    static void recover() {
        prev = new Node(Integer.MIN_VALUE);
        traverseInOrder(root);
        if (first == null && middle == null && last == null) {
            System.out.println("No changes");
        } else if (last == null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        } else if (last != null) {
            int temp = last.data;
            last.data = first.data;
            first.data = temp;
        }
    }

    static void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.left);
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        traverseInOrder(root.right);
    }

    static void buildTree() {
        Scanner sc = new Scanner(System.in);
        int firstVal = sc.nextInt();
        if (firstVal == -1) {
            System.out.println("Root is null");
            return;
        }
        /*
         * root then left then right
         * 1 2 3 -1 -1 -1 -1
         */
        Queue<Node> queue = new LinkedList<>();
        // if reached here means firstVal is not null
        // so we need to create a Node with firstVal then point root to it
        root = new Node(firstVal);
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            int left = sc.nextInt();
            if (left != -1) {
                parent.left = new Node(left);
                queue.offer(parent.left);
            }
            int right = sc.nextInt();
            if (right != -1) {
                parent.right = new Node(right);
                queue.offer(parent.right);
            }
        }

    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
