import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        int celebrity = findCelebrity(matrix);
        System.out.println(celebrity == -1 ? "No Celebrity" : "Celebrity : " + celebrity);

    }

    static int findCelebrity(int[][] matrix) {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            stack.push(i);
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (matrix[a][b] == 1)
                stack.push(b);
            else
                stack.push(a);
        }
        if (stack.isEmpty())
            return -1;
        int celebrity = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != celebrity && (matrix[celebrity][i] == 1 || matrix[i][celebrity] == 0))
                return -1;
        }
        return celebrity;
    }
}
