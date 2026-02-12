import java.util.Scanner;
import java.util.Stack;

public class MinimumStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinimumStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int data) {
        stack.push(data);
        if (!minStack.isEmpty() && minStack.peek() > data) {
            minStack.push(data);
        } else if (minStack.isEmpty()) {
            minStack.push(data);
        }
    }

    public int pop() {
        if (!stack.isEmpty()) {
            if (this.peek() == getMin()) {
                minStack.pop();
            }
            return stack.pop();
        } else {

            return Integer.MIN_VALUE;
        }
    }

    public int peek() {
        return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? Integer.MIN_VALUE : minStack.peek();
    }

    public void show() {
        System.out.println("Stack : " + stack);
        System.out.println("Minimum Stack : " + minStack);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinimumStack obj = new MinimumStack();
        for (int i = 0; i < n; i++) {
            obj.push(sc.nextInt());
        }
        // obj.show();

        System.out.println(obj.pop());
        // obj.show();
        System.out.println(obj.getMin());
        // obj.show();
        System.out.println(obj.peek());
        System.out.println(obj.getMin());

    }

}
