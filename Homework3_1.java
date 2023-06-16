// Задание
// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework3_1 {
  public static void main(String[] args) {
    List<Integer> Chisla = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    Chetnie(Chisla);
    Minimun(Chisla);
    Maximum(Chisla);
    Srednee(Chisla);
  }
  public static void Chetnie(List<Integer> Chisla){
  List<Integer> ResultList = new ArrayList<Integer>(Arrays.asList());
    for (int Chislo : Chisla) {
      if (Chislo % 2 == 0){
        ResultList.add(Chislo);
      }
    }
    System.out.println("Список четных чисел: "+ ResultList);
  }
  public static void Minimun(List<Integer> Chisla){
  Integer min = Chisla.get(0);
  for (int Chislo: Chisla){
    if (Chislo < min){
      min = Chislo;
    }
  }
  System.out.println("Минимальное число:" + min);
}
public static void Maximum(List<Integer> Chisla){
  Integer max = Chisla.get(0);
  for (int Chislo: Chisla){
    if (Chislo > max){
      max = Chislo;
    }
  }
  System.out.println("Максимальное число:" + max);
}
public static void Srednee(List<Integer> Chisla){
Integer result = 0;
for (int Chislo: Chisla){
result = result + Chislo;
}
double av = (double)result/Chisla.size();
System.out.println("Среднее значение: " + av);
}
}
