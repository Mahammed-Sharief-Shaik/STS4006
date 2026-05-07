import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

}
public class LeftRightView {
    static Node root;
    public static void main(String[] args) {
        buildTree();
        printLeftView();
        printRightView();
    }

    static void printRightView(){
        List<Integer> list = new ArrayList<>();
        preorderRight(root,list,0);
        System.out.println(list);
    }

    static void preorderRight(Node root, List<Integer> list, int currentLevel){
        if(root==null) return;

        if(currentLevel==list.size()){
            list.add(root.data);
        }

        preorderRight(root.right, list, currentLevel+1);
        preorderRight(root.left, list, currentLevel+1);

    }

    static void printLeftView(){
        List<Integer> list = new ArrayList<>();
        preorderLeft(root,list,0);
        System.out.println(list);
    }

    static void preorderLeft(Node root, List<Integer> list, int currentLevel){
        if(root==null) return;

        if(currentLevel==list.size()){
            list.add(root.data);
        }

        preorderLeft(root.left, list, currentLevel+1);
        preorderLeft(root.right, list, currentLevel+1);

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
