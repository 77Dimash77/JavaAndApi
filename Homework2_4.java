
// 4) К калькулятору из предыдущего ДЗ добавить логирование.
// 4+2=6
// 6-1=5
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homework2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простой калькулятор");
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        System.out.print("Введите оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Некорректный оператор");
                return;
        }

        System.out.println("Результат: " + result);

        logToFile(num1, num2, operator, result);
    }

    private static void logToFile(double num1, double num2, char operator, double result) {
        String logFilename = "calculator_log.txt";

        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logFilename, true), StandardCharsets.UTF_8))) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);

            printWriter.println("Действие: " + num1 + " " + operator + " " + num2);
            printWriter.println("Результат: " + result);
            printWriter.println("Дата и время: " + formattedDateTime);
            printWriter.println("---------------------------------------------");
            System.out.println("Лог сохранен в файл: " + logFilename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
