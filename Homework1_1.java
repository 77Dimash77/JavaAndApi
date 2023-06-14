//1) Вычислить n-ое треугольного число
// (сумма чисел от 1 до n), n! 
// (произведение чисел от 1 до n)
import java.util.Scanner;
public class Homework1_1 {
  public static void main(String[] args) {
    Scanner n = new Scanner(System.in);
    System.out.printf("введите число n: ");
    Integer N = n.nextInt();
    int TREUG = N * (N + 1) / 2;
    System.out.printf("Треугольное число: %d\n", TREUG);
    int result = 1;
    for (int index = 1; index < N + 1; index++) {
      result = index * result; 
    }
    System.out.printf("Факториал: %d\n", result);
  }
}
