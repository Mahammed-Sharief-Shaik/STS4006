import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> original = new LinkedList<>();
        Queue<Integer> required = new LinkedList<>();
        for (int i = 0; i < n; i++)
            original.add(sc.nextInt());
        for (int i = 0; i < n; i++)
            required.add(sc.nextInt());

        boolean result = isValidStackPermutation(original, required);
        System.out.println(result ? "Valid" : "Invalid");
    }
    static boolean isValidStackPermutation(Queue<Integer> original, Queue<Integer> required) {
        Stack<Integer> stack = new Stack<>();
        while (!original.isEmpty()) {
            int temp = original.poll();
            if (temp == required.peek()) {
                required.poll();
                while (!stack.isEmpty() && stack.peek() == required.peek()) {
                    stack.pop();
                    required.poll();
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.isEmpty() && original.isEmpty();

    }
}
