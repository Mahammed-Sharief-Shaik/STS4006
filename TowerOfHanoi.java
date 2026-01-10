import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    static Stack<Integer> source, auxilary, destination;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        source = new Stack<>();
        auxilary = new Stack<>();
        destination = new Stack<>();

        for (int i = n; i >= 1; i--)
            source.push(i);
        char s = 'S', a = 'A', d = 'D';

        if (n % 2 == 0) {
            a = 'D';
            d = 'A';
        }

        for (int i = 1; i <= ((int) Math.pow(2, n)) - 1; i++) {
            switch (i % 3) {
                case 1:
                    towerOfHanoi(source, destination, s, d);
                    break;
                case 2:
                    towerOfHanoi(source, auxilary, s, a);
                    break;
                case 0:
                    towerOfHanoi(auxilary, destination, a, d);
                    break;
            }
        }
    }

    static void towerOfHanoi(Stack<Integer> stack1, Stack<Integer> stack2, char c1, char c2) {
        int v1 = stack1.isEmpty() ? Integer.MIN_VALUE : stack1.pop();
        int v2 = stack2.isEmpty() ? Integer.MIN_VALUE : stack2.pop();
        if (v1 == Integer.MIN_VALUE) {
            stack1.push(v2);
            System.out.println("The Disc " + v2 + " is moved from " + c2 + " to " + c1);
        } else if (v2 == Integer.MIN_VALUE) {
            stack2.push(v1);
            System.out.println("The Disc " + v1 + " is moved from " + c1 + " to " + c2);
        } else if (v1 > v2) {
            stack1.push(v1);
            stack1.push(v2);
            System.out.println("The Disc " + v2 + " is moved from " + c2 + " to " + c1);
        } else {
            stack2.push(v2);
            stack2.push(v1);
            System.out.println("The Disc " + v2 + " is moved from " + c1 + " to " + c2);
        }
    }

}
