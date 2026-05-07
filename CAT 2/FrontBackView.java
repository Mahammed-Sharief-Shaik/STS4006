import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}

public class FrontBackView {

    static Node root;

    public static void main(String[] args) {
        buildTree();
        printfrontView();
        printBackView();
    }

    static void printBackView() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        while (!q.isEmpty()) {
            int s = q.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                Node curr = q.poll();
                currentLevel.add(curr.data);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            levels.add(currentLevel);
        }
        Collections.reverse(levels);
        System.out.println(levels);
    }

    static void printfrontView() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        while (!q.isEmpty()) {
            int s = q.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                Node curr = q.poll();
                currentLevel.add(curr.data);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            levels.add(currentLevel);
        }
        System.out.println(levels);
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

}
