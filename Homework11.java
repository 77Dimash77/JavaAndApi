//2) Вывести все простые числа от 1 до 1000
public class Homework11 {
  public static void main(String[] args) {
      int n = 1000;
      for (int i = 2; i <= n; i++) {
          int j;
          for (j = 2; j * j <= i; j++) {
              if (i % j == 0) {
                  break;
              }
          }
          if (j * j > i) {
              System.out.println(i);
          }
      }
  }
}