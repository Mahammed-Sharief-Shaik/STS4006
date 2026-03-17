
// VIEWS OF TREE
// RIGHT LEFT
//   5
//   /  \
//   3   6
//      /  \
//      9   8
     
//   OP: 5 3 9
//   5
//   /  \
//   3   6
//  / \   /  \
//  7  4  9   8
//  OP:5 3 7
// BOTTOM TOP
// FRONT BACK
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class Views {
    // Modified to return the root Node so main can use it
    static Node buildTree() {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        if (first == -1) return null;

        Node rootnode = new Node(first);
        Queue<Node> q = new LinkedList<>();
        q.add(rootnode);

        while (!q.isEmpty()) {
            Node parent = q.poll();
           
            // Left Child
            int l = sc.nextInt();
            if (l != -1) {
                parent.left = new Node(l);
                q.add(parent.left);
            }
           
            // Right Child
            int r = sc.nextInt();
            if (r != -1) {
                parent.right = new Node(r);
                q.add(parent.right);
            }
        }
        return rootnode;
    }

    static void PrintTree(Node root){
        PrintTree(root.left);
        System.out.println(root);
        PrintTree(root.right);
       
       
    }
    static void view_left(Node root,List<Integer> views,int level){
        if(root==null)return;
        if(views.size()==level){
            views.add(root.data);
          System.out.println(root.data+" ");
        }
        if(root.left!=null)view_left(root.left,views,level+1);
        if(root.right!=null)view_left(root.right,views,level+1);
       
    }
    static void frontView(Node root){
        Queue<Node> Fview=new LinkedList<>();
        if(root==null)return;
        Fview.add(root);
        while(!Fview.isEmpty()){
            Node parent=Fview.poll();
            System.out.println(parent.data+" ");
             if(parent.left!=null)Fview.add(root.left);
            if(parent.right!=null)Fview.add(root.right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter tree data (Level-Order, -1 for null):");
        Node root = buildTree();
        List<Integer> views = new ArrayList<>();
       view_left(root, views, 0);
        PrintTree(root);

        // System.out.println("\n--- Traversals ---");
       
        // System.out.print("Pre-order:  ");
        // preOrder(root);
       
        // System.out.print("\nIn-order:   ");
        // inOrder(root);
       
        // System.out.print("\nPost-order: ");
        // postOrder(root);
    }
}
// }LEVEL ORDER TAKE QUEUEU
// ?FRONT VIEW SAME AS LEVEL ORDER ROOT LEFT right  
// BACK VIEW ROOT RIGHT LEFT