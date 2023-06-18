import java.util.*;

public class Homework4_1 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new ArrayDeque<>(Arrays.asList(3, 2, 1, -1));  
        Deque<Integer> num2 = new ArrayDeque<>(Arrays.asList(5, 4, 3));  

        Deque<Integer> sum = add(num1, num2);
        System.out.println("Sum: " + sum);
    }
    private static Pair<Deque<Integer>, Integer> handleNegative(Deque<Integer> num) {
        int sign = 1;
        if (num.contains(-1)) {
            num.remove(-1);
            sign *= -1;
        }
        return new Pair<>(num, sign);
    }

    private static Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        Pair<Deque<Integer>, Integer> p1 = handleNegative(num1);
        Pair<Deque<Integer>, Integer> p2 = handleNegative(num2);

        num1 = p1.first;
        num2 = p2.first;
        int sign = p1.second * p2.second;

        int carry = 0;
        Deque<Integer> sum = new ArrayDeque<>();
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int n1 = num1.isEmpty() ? 0 : num1.pop();
            int n2 = num2.isEmpty() ? 0 : num2.pop();
            int current = n1 + n2 + carry;
            carry = current / 10;
            sum.push(current % 10);
        }
        if (carry != 0) {
            sum.push(carry);
        }
        if (sign < 0) {
            sum.add(-1);
        }
        return sum;
    }

    static class Pair<K, V> {
        final K first;
        final V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
