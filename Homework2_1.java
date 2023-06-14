// Задание

// 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
// Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// Дополнительные задания
// 3) Дана строка (сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// 4) К калькулятору из предыдущего ДЗ добавить логирование.
// 4+2=6
// 6-1=5

import javax.security.auth.kerberos.KerberosTicket;

import java.security.Key;
import java.util.*;

public class Homework2_1 {
  public static void main(String[] args) {
    String inputStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
    String whereClause = buildWhereClause(inputStr);
    String sqlQuery = "select * from students WHERE " + whereClause;
    System.out.println(sqlQuery);
  }
  public static String buildWhereClause(String inputStr){
    StringBuilder whereClauseBuilder = new StringBuilder();
    Map<String, String> filterData = parseJSON(inputStr);

    for (Map.Entry<String, String> entry : filterData.entrySet()){
      String key = entry.getKey();
      String value = entry.getValue();

      if (!value.equals("null")){
        whereClauseBuilder.append(key).append("=").append(value).append(" AND ");
      }
    }
    int length = whereClauseBuilder.length();
    if (length>=5){
      whereClauseBuilder.setLength(length - 5);
    }
    return whereClauseBuilder.toString();
  } 
  public static Map<String, String> parseJSON(String inputStr) {
    inputStr = inputStr.replaceAll("[{}\"]","");
    String[]pairs = inputStr.split(", ");
    Map<String, String> data = new LinkedHashMap<>();

    for (String pair : pairs){
      String[] keyValue = pair.split(":");
      String key = keyValue[0];
      String value = keyValue[1];
      data.put(key, value);
    }
    return data;
  }
}
