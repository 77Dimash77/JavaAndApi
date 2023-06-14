// Дополнительные задания
// 3) Дана строка (сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.


import java.io.*;
import java.nio.charset.StandardCharsets;
public class Homework2_3 {
    public static void main(String[] args) {
        String jsonStr = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        saveToFile(jsonStr, "data.json");

        String jsonString = readFromFile("data.json");

        createStudentStrings(jsonString);
    }

    public static void saveToFile(String jsonStr, String fileName) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8)) {
            writer.write(jsonStr);
            System.out.println("JSON-строка сохранена в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createStudentStrings(String jsonString) {
        jsonString = jsonString.substring(1, jsonString.length() - 1); 
        String[] studentData = jsonString.split("\\},\\{"); 
        StringBuilder stringBuilder = new StringBuilder();

        for (String data : studentData) {
            String[] keyValuePairs = data.split(",");
            String фамилия = "";
            String оценка = "";
            String предмет = "";

            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].replaceAll("\"", "").trim();
                String value = keyValue[1].replaceAll("\"", "").trim();
                switch (key) {
                    case "фамилия":
                        фамилия = value;
                        break;
                    case "оценка":
                        оценка = value;
                        break;
                    case "предмет":
                        предмет = value;
                        break;
                }
            }

            stringBuilder.append("Студент ")
                    .append(фамилия)
                    .append(" получил ")
                    .append(оценка)
                    .append(" по предмету ")
                    .append(предмет)
                    .append(".")
                    .append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }
}