import java.util.*;

public class test {
public static void main(String[] args) {
Map<String,List<String>> book = new HashMap<>();
addNumber(book,"Madison","11111");
addNumber(book,"Madison","22222");
addNumber(book,"Madison","33333");
addNumber(book,"Kira","44444");
addNumber(book,"Kira","55555");

TreeMap<String,List<String>> SortBook = new TreeMap<>((kluch1,kluch2) -> {
int diff = book.get(kluch2).size() - book.get(kluch1).size();
if (diff != 0){
  return diff;
}
else{
  return kluch1.compareTo(kluch2);
}});
SortBook.putAll(book);
for(Map.Entry<String,List<String>> entry: SortBook.entrySet()){
  String name = entry.getKey();
  for(String number: entry.getValue()){
    System.out.println(name + " " + number);
  }
}
}
public static void addNumber(Map<String, List<String>> book, String name, String number) {
  List<String> numbers = book.getOrDefault(name, new ArrayList<>());
numbers.add(number);
book.put(name,numbers);
}
}
