
/******************************************************************************
Shortest path
- Dijkstras
Disadvantages : Does not work for Negative edges
T-C : O(E V)
- Belman ford
- Dail's algo
Works efficiently for small weights
Along with from to weight we also need max weight
- In worst case all edges may have weight maxWeight and then the distance possible in worst case is :E*maxWeight
- Create buckets from 0 to maxWeight*e
- bucket x represents that it is x kms from source
E + MW*V
Dail's Algo

- Relaxation
*******************************************************************************/
import java.util.*;

class Pair {
    int dest, weight;

    public Pair(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

}

public class DailsAlgo {
    static ArrayList<ArrayList<Pair>> adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int maxWeight = Integer.MIN_VALUE;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adj.get(from).add(new Pair(to, weight));
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.print("Enter Source : ");
        int source = sc.nextInt();

        int[] dist = dials(V, E, source, maxWeight);
        System.out.println(Arrays.toString(dist));
    }

    static int[] dials(int v, int e, int src, int maxWeight) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        List<Queue<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= maxWeight * e; i++)
            buckets.add(new LinkedList<>());

        // add source at bucket 0
        buckets.get(0).add(src);

        int index = 0;
        while (index < buckets.size()) {
            while (index < buckets.size() && buckets.get(index).isEmpty())
                index++;

            if (index == buckets.size())
                break;

            int curr = buckets.get(index).poll();

            for (Pair neigh : adj.get(curr)) {
                int dest = neigh.dest;
                int weight = neigh.weight;

                int newDist = dist[curr] + weight;

                if (newDist < dist[dest]) {
                    dist[dest] = newDist;
                    buckets.get(newDist).add(dest);
                }
            }
        }

        return dist;

    }
}
