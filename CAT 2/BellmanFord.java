import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < V; i++)
        // adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            adj.add(Arrays.asList(src, dest, weight));

        }
        int source = sc.nextInt();
        bellman(adj, V, source);

    }

    static void bellman(List<List<Integer>> adj, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        for (int i = 1; i < V; i++) {
            for (List<Integer> a : adj) {
                int src = a.get(0);
                int dest = a.get(1);
                int weight = a.get(2);

                if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
                    distance[dest] = distance[src] + weight;
                }
            }

        }
        for (List<Integer> a : adj) {
            int src = a.get(0);
            int dest = a.get(1);
            int weight = a.get(2);

            if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
                System.out.println("Graph has a cycle");
                return;
            }
        }

        System.out.println(Arrays.toString(distance));
    }

}
