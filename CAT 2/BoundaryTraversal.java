import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}
public class BoundaryTraversal {
    static Node root;
    public static void main(String[] args) {
        buildTree();
        boundaryTraversal();
    }

    static void boundaryTraversal(){
        if (root==null){
            System.out.println("Tree is empty");
            return;
        }
        System.out.print(root.data+" ");
        leftBoundary(root.left);
        leaf(root);
        rightBoundary(root.right);
    }

    static void leftBoundary(Node root){
        if(root==null) return;
        if(root.left!=null){
            System.out.print(root.data+" ");
            leftBoundary(root.left);
        }else if(root.right!=null){
            System.out.print(root.data+" ");
            leftBoundary(root.right);
        }
    }

    static void leaf(Node root){
        if(root==null) return;
        leaf(root.left);
        if(root.left==null && root.right==null){
            System.out.print(root.data+" ");
            return;
        }
        leaf(root.right);
    }

    static void rightBoundary(Node root){
        if(root==null) return;
        if(root.right!=null){
            rightBoundary(root.right);
            System.out.print(root.data+" ");
        }else if(root.left!=null){
            rightBoundary(root.left);
            System.out.print(root.data+" ");
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
