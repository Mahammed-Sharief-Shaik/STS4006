import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SortWithoutSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        System.out.println(queue);
        sortWithoutSpace(queue);
        System.out.println(queue);
    }

    static void sortWithoutSpace(Queue<Integer> queue) {
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            // System.out.println(queue);
            int minimumIndex = findMinimumIndex(queue, n - i);
            int minimumValue = -1;
            for (int j = 0; j < n; j++) {
                int current = queue.poll();
                if (j == minimumIndex)
                    minimumValue = current;
                else
                    queue.offer(current);
            }
            queue.offer(minimumValue);
        }
    }

    static int findMinimumIndex(Queue<Integer> queue, int limit) {
        int minimumIndex = -1;
        int minimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int current = queue.poll();
            if (current < minimumValue && i < limit) {
                minimumValue = current;
                minimumIndex = i;
            }
            queue.offer(current);
        }
        System.out.println(queue);
        return minimumIndex;
    }
}
