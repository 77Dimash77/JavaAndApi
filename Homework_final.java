
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Homework_final {
  public static void main(String[] args) {
    Set<Hbooks> Sklad = new HashSet<>();
    Hbooks notebook1 = new Hbooks("note1", 5, "SSD", true, 2);
    Hbooks notebook2 = new Hbooks("note2", 7, "SSD", false, 2);
    Hbooks notebook3 = new Hbooks("note3", 10, "HD", false, 3);
    Sklad.add(notebook1);
    Sklad.add(notebook2);
    Sklad.add(notebook3);

    System.out.println("Добрый день! Мы поможем вам выбрать ноутбук!");

    Scanner scanner = new Scanner(System.in);
    System.out.printf("Введите критерий отбора: 1 - Память, 2 - накопитель, 3 - Windows 11, 4 - Чистота процессора, 5 - Админка: ");
    Integer zapros = scanner.nextInt();
    
    if (zapros == 1) {
    System.out.print("Введите необходимое количество памяти: ");
    Integer memory = scanner.nextInt();
    List<Hbooks> sortM = Sklad.stream().filter(note -> note.getPamiat().equals(memory)).collect(Collectors.toList());
    if (!sortM.isEmpty()) {
        for (Hbooks book : sortM) {
            System.out.println("Выбранный ноутбук: " + book.getName() + " / с процессором: " + book.getProc() + " / с памятью: " + book.getPamiat() + " / Накопитель: " + book.getNakopitel() + " / Встроенная Windows: " + book.getWin());
        }
    } else {
        System.out.println("Ноутбук не найден");
    }
    }
    else if (zapros == 2) {
    System.out.print("Введите вид накопителя (SSD/HD): ");
    String nakop = scanner.next();
    List<Hbooks> filteredBooks = Sklad.stream()
            .filter(note -> note.getNakopitel().equals(nakop))
            .collect(Collectors.toList());
    if (!filteredBooks.isEmpty()) {
        System.out.println("Выбранные ноутбуки:");
        for (Hbooks book : filteredBooks) {
            System.out.println("Ноутбук: " + book.getName() + " / с процессором: " + book.getProc() + " / с памятью: " + book.getPamiat() + " / Накопитель: " + book.getNakopitel() + " / Встроенная Windows: " + book.getWin());
        }
    } else {
        System.out.println("Ноутбуки не найдены");
    } 
  }
  else if (zapros == 3) {
    System.out.print("Cо встроенным Windows? true/false: ");
    boolean withWindows = scanner.nextBoolean();
 List<Hbooks> sortW = Sklad.stream()
        .filter(note -> Objects.equals(note.getWin(), withWindows))
        .collect(Collectors.toList());
    if (!sortW.isEmpty()) {
        for (Hbooks book : sortW) {
            System.out.println("Выбранный ноутбук: " + book.getName() + " / с процессором: " + book.getProc() + " / с памятью: " + book.getPamiat() + " / Накопитель: " + book.getNakopitel() + " / Встроенная Windows: " + book.getWin());
        }
    } else {
        System.out.println("Ноутбук не найден");
    }
}
    else if (zapros == 4){
      System.out.print("Введите чистоту процессора: ");
    Float memory = scanner.nextFloat();
    List<Hbooks> sortM = Sklad.stream()
        .filter(note -> Float.compare(note.getProc(), memory) == 0)
        .collect(Collectors.toList());
    if (!sortM.isEmpty()) {
        for (Hbooks book : sortM) {
            System.out.println("Выбранный ноутбук: " + book.getName() + " / с процессором: " + book.getProc() + " / с памятью: " + book.getPamiat() + " / Накопитель: " + book.getNakopitel() + " / Встроенная Windows: " + book.getWin());
        }
    } else {
        System.out.println("Ноутбук не найден");
    }
  }
  else if(zapros == 5){
    notebook1.VvodOpisania("на складе осталось 4");
    notebook1.PokazOpisania();
    notebook1.Prodano(5);

    notebook2.VvodOpisania("на складе осталось 2");
    notebook2.PokazOpisania();
    notebook2.Prodano(3);

    notebook3.VvodOpisania("на складе осталось 7");
    notebook3.PokazOpisania();
    notebook3.Prodano(2);
  }
  }
}
