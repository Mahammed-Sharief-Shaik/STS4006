import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}

public class TreeBasics {
    static Node root;

    public static void main(String[] args) {
        // buildTree();
        // weirdBuildTree();
        // weirdBuildTree2();
        weirdBuildTree3();
        traverseInOrder();
        traversePostOrder();
        traversePreOrder();

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

    static void weirdBuildTree2() {
        Scanner sc = new Scanner(System.in);
        // 1 2 3 4 5 null 7
        String[] inp = sc.nextLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            if (inp[i].equals("null")) {
                arr[i] = -1;
            } else {
                arr[i] = Integer.parseInt(inp[i]);
            }
        }

        if (arr[0] == -1) {
            System.out.println("Root is null");
            return;
        }

        root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node current  = q.poll();

            if(arr[i]!=-1){
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            if(arr[i]!=-1){
                current.right  = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

    }

    static void weirdBuildTree() {
        // 1 2 3 4 5 null 7 null null null null null null null
        Scanner sc = new Scanner(System.in);
        String first = sc.next();

        if (first.equals("null")) {
            System.out.println("Root is null");
            return;
        }

        root = new Node(Integer.parseInt(first));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();

            String leftString = sc.next();
            if (!leftString.equals("null")) {
                current.left = new Node(Integer.parseInt(leftString));
                q.add(current.left);
            }

            String rightString = sc.next();
            if (!rightString.equals("null")) {
                current.right = new Node(Integer.parseInt(rightString));
                q.add(current.right);
            }
        }

    }

    static void weirdBuildTree3(){
        /*
            3
            1 2 3
            2 4 5
            3 -1 7
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int parent  = sc.nextInt();
            int left  = sc.nextInt();
            int right  = sc.nextInt();

            map.putIfAbsent(parent, new Node(parent));

            if(root==null){
                root = map.get(parent);
            }

            if(left!=-1){
                map.putIfAbsent(left, new Node(left));
                map.get(parent).left = map.get(left);
            }

            if(right!=1){
                map.putIfAbsent(right, new Node(right));
                map.get(parent).right = map.get(right);
            }

        }
    }
    static void traverseInOrder() {
        inOrder(root);
        System.out.println();

    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void traversePreOrder() {
        preOrder(root);
        System.out.println();

    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void traversePostOrder() {
        postOrder(root);
        System.out.println();

    }

    static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
