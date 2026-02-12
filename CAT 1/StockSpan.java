import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[] ans = stockSpan(nums);
        System.out.println(Arrays.toString(ans));

    }

    static int[] stockSpan(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()])
                stack.pop();

            if (stack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

}
