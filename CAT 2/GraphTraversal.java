import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphTraversal {
    static ArrayList<Integer>[] adjacencyList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices (v) : ");
        int v = sc.nextInt();
        System.out.print("Enter number of Edges (e) : ");
        int e = sc.nextInt();

        adjacencyList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);
        }
        int startToBFS = sc.nextInt();
        bfs(startToBFS);
        System.out.println();
        dfs(startToBFS, new boolean[v]);
        System.out.println();
        dfs(startToBFS);
        System.out.println();
        for(ArrayList<Integer> l:adjacencyList){
            System.out.println(l);
        }
    }

    static void bfs(int source) {
        boolean[] visited = new boolean[adjacencyList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int neighbour : adjacencyList[curr]) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    static void dfs(int source, boolean[] visited) {
        System.out.print(source + " ");
        visited[source] = true;
        for (int neighbour : adjacencyList[source]) {
            if (!visited[neighbour])
                dfs(neighbour, visited);
        }
    }

    static void dfs(int source) {
        boolean[] visited = new boolean[adjacencyList.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            System.out.print(curr + " ");
            for (int neighbour : adjacencyList[curr]) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

}
