import java.util.*;

public class Homework4_2 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new ArrayDeque<>(Arrays.asList(3, 2, 1, -1)); 
        Deque<Integer> num2 = new ArrayDeque<>(Arrays.asList(5, 4, 3)); 

        Deque<Integer> product = multiply(num1, num2);
        System.out.println("Product: " + product);
    }

    private static Pair<Deque<Integer>, Integer> handleNegative(Deque<Integer> num) {
        int sign = 1;
        if (num.contains(-1)) {
            num.remove(-1);
            sign *= -1;
        }
        return new Pair<>(num, sign);
    }

    private static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        Pair<Deque<Integer>, Integer> p1 = handleNegative(num1);
        Pair<Deque<Integer>, Integer> p2 = handleNegative(num2);

        num1 = p1.first;
        num2 = p2.first;
        int sign = p1.second * p2.second;

        int[] res = new int[num1.size() + num2.size()];
        Deque<Integer> product = new ArrayDeque<>();

        for (int i = 0; !num1.isEmpty(); i++) {
            int n1 = num1.pop();
            Deque<Integer> num2Copy = new ArrayDeque<>(num2); 
            for (int j = 0; !num2Copy.isEmpty(); j++) {
                res[i + j] += n1 * num2Copy.pop();
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] > 9) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
        }

        int start = res.length - 1;
        while (start > 0 && res[start] == 0) {
            start--;
        }
        for (int i = start; i >= 0; i--) {
            product.push(res[i]);
        }

        if (sign < 0) {
            product.add(-1);
        }

        return product;
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
