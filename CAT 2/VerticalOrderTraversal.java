import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}

class Pair {
    Node node;
    int vertical;

    public Pair(Node node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }

}

public class VerticalOrderTraversal {
    static Node root;

    public static void main(String[] args) {
        buildTree();
        // inOrder(root);
        // System.out.println();
        verticalOrderTraversal();
    }

    static void verticalOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int vertical = 0;
        int minVertical = 0, maxVertical = 0; // can skip this if we use Tree Map

        Pair first = new Pair(root, vertical);
        queue.offer(first);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int vert = curr.vertical;
            Node node = curr.node;
            if (!map.containsKey(vert)) {
                map.put(vert, new ArrayList<>());
            }
            map.get(vert).add(node.data);

            if (node.left != null) {
                queue.add(new Pair(node.left, vert - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, vert + 1));
            }
            minVertical = Math.min(minVertical, vert);
            maxVertical = Math.max(maxVertical, vert);
        }

        for (int v = minVertical; v <= maxVertical; v++) {
            List<Integer> list = map.get(v);
            // list.forEach((System.out::print)+" ");
            System.out.print(list + " ");
        }

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
