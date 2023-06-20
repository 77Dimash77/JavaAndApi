import java.util.*;

public class Homework5_1 {

    public static void main(String[] args) {
        Map<String, List<String>> book = new HashMap<>();
        addNumber(book, "Иванов", "1231234");
        addNumber(book, "Иванов", "3456345");
        addNumber(book, "Петров", "5676585");
        addNumber(book, "Иванов", "12345");
        addNumber(book, "Петров", "82332");
        addNumber(book, "ПитерПаркер", "82332");
        addNumber(book, "ПитерПаркер", "82332");
        addNumber(book, "ПитерПаркер", "82332");
        addNumber(book, "ПитерПаркер", "82332");

        TreeMap<String, List<String>> sortedBook = new TreeMap<>((k1, k2) -> {
            int diff = book.get(k2).size() - book.get(k1).size();
            if (diff != 0) {
                return diff;
            } else {
                return k1.compareTo(k2);
            }
        });
        sortedBook.putAll(book);

        for (Map.Entry<String, List<String>> entry : sortedBook.entrySet()) {
            String name = entry.getKey();
            for (String number : entry.getValue()) {
                System.out.println(name + " " + number);
            }
        }
    }

    public static void addNumber(Map<String, List<String>> book, String name, String number) {
        List<String> numbers = book.getOrDefault(name, new ArrayList<>());
        numbers.add(number);
        book.put(name, numbers);
    }
}