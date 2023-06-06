// 3) Реализовать простой калькулятор
// + - / *

// Введите первое число: A \n
// Введите знак: *
// Введите второе число: B
// Результат: A*B

// sc.next() -- считывает символ
// sc.nextLine() -- считывает всю строчку
// sc.nextInt() -- считывает число, но без перехода на след. строчку
import java.util.Scanner;
public class Homework111 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("введите первое число: ");
    Integer First = scanner.nextInt();
    System.out.printf("введите второе число: ");
    Integer Second = scanner.nextInt();
    System.out.println("Возможные знаки: + - / * ");
    System.out.printf("Введите знак: ");
    String Znak = scanner.next();
    Integer result = 0;
    
    if (Znak.equals("+"))
    {
      result = First + Second;
      System.out.print(First + "+" + Second + "=" + result);
    }
     else if (Znak.equals("-"))
     {
      result = First - Second;
      System.out.print(First + "-" + Second + "=" + result);
    } else if (Znak.equals("*"))
    {
      result = First * Second;
      System.out.print(First + "*" + Second + "=" + result);
    }
    else if (Znak.equals("/"))
    {
      Float FFirst = (float) First;
      Float FSecond = (float) Second;
      Float FResult = (float) result;
      FResult = FFirst / FSecond;
      System.out.print("Выводим результат: " + First + "/" + Second + "=" + FResult);
    }
  }
}
