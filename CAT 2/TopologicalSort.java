import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[V];
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            adj.get(src).add(dest);
            indegree[dest]++;
        }

        bfsTopologicalSort(indegree);
        System.out.println();
        // boolean[] visited = new boolean[V];
        // topologicalSortDFS(indegree, visited);
    }

    static void bfsTopologicalSort(int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            System.out.println("No Independent Vertex");
            return;
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }
    }
    static void topologicalSortDFS(int[] indegree, boolean[] visited){
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0 && !visited[i]){
                dfsTopologicalSort(i, indegree, visited);
            }
        }
    }

    static void dfsTopologicalSort(int curr, int[] indegree, boolean[] visited){
        visited[curr]=true;
        System.out.print(curr+" ");
        for(int neigh : adj.get(curr)){
            indegree[neigh]--;
            if(indegree[neigh]==0 && !visited[neigh]){
                dfsTopologicalSort(neigh, indegree, visited);
            }
        }
    }
}
