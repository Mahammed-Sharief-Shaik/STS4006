import java.util.*;
public class Test{
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        String s[] = sw.nextLine().split(" ");
        node root = insert(s);
        List<Integer> l = new ArrayList<>();
        rv(root,0,l);
        for(int i=0;i<l.size();i++) System.out.print(l.get(i)+" ");
    }
    static class node{
        int data;
        node left,right;
        node(int n){
            data = n;
            left = right = null;
        }
    }
    static node insert(String s[]){
        if(s.length==0||s[0]=="-1") return null;
        Queue<node> q = new LinkedList<>();
        node root = new node(Integer.parseInt(s[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty()&&i<s.length){
            node cur = q.poll();
            if(!s[i].equals("-1")){
                cur.left = new node(Integer.parseInt(s[i]));
                q.add(cur.left);
            }
            i++;
            if(i>=s.length) break;
            if(!s[i].equals("-1")){
                cur.right = new node(Integer.parseInt(s[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }
    
    
    static void rv(node root,int level,List<Integer> l){
        if(root == null) return;
        if(l.size()==level) l.add(root.data);
        rv(root.left,level+1,l); //leftview
        rv(root.right,level+1,l);
       // rv(root.left,level+1,l); //rightview
    }
}
