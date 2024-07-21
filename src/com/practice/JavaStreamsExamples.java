import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsExamples {

  public static void main(String[] args) {
//    filterEvenNumbers();
//    concatenateWords();
//    secondHighestSalary();
//    secondHighestSalaryWithDuplicates();
//    convertListToUpperCase();
//    removeDuplicates();
//    firstEvenNumber();
//    groupEmployeesByDepartment();
//    findAverage();
//    findSumOfSquares();
//    concatenateLists();
//    flattenNestedLists();
//    wordsStartingWithLetter();
//    matchExamples();
//    numberOfWordsWithSameStartingLetter();
//    findDuplicates();
//    filterAndPrintPalindromes();
    sortStringsWithLength();
  }

  private static void concatenateWords() {
    List<String> words = Arrays.asList("Hello! ", " ", "How", " ", " are", " you?");
    System.out.println(words.stream().collect(Collectors.joining()));
    String appended = words.stream()
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
  }

  private static void matchExamples() {
    List<Integer> list1 = Arrays.asList(0, 2, 4, 6, 8);
    boolean isEvenNumbersList = list1.stream().allMatch(n -> n % 2 == 0);
    System.out.println("isEvenNumbersList:" + isEvenNumbersList);

    List<Integer> list2 = Arrays.asList(0, 2, 4, 6, 8, 9);
    boolean containsAnyOddNumber = list2.stream().anyMatch(n -> n % 2 == 1);
    System.out.println("containsAnyOddNumber:" + containsAnyOddNumber);

  }

  private static void filterEvenNumbers() {
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    List<Integer> even = list.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());

    even.stream().forEach(n -> System.out.println(n));
  }

  public static void secondHighestSalary() {

    Map<String, Integer> employees = new HashMap<>();
    employees.put("E1", 10000);
    employees.put("E2", 5000);
    employees.put("E3", 4000);
    employees.put("E4", 7000);
    employees.put("E5", 5000);
    employees.put("E6", 1000);
    employees.put("E7", 3000);

    Map.Entry<String, Integer> secondHighest = employees.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toList())
        .get(1);

    System.out.println(secondHighest);
  }

  public static void secondHighestSalaryWithDuplicates() {

    Map<String, Integer> employees = new HashMap<>();
    employees.put("E1", 10000);
    employees.put("E2", 5000);
    employees.put("E3", 7000);
    employees.put("E4", 7000);
    employees.put("E5", 5000);
    employees.put("E6", 1000);
    employees.put("E7", 3000);

    employees.entrySet().stream()
        .collect(Collectors.groupingBy(Map.Entry::getValue))
        .entrySet()
        .stream()
        .forEach(e -> System.out.println(e));

    Map.Entry<Integer, List<String>> list = employees.entrySet().stream()
        .collect(Collectors.groupingBy(Map.Entry::getValue,
            Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
        .entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList())
        .get(1);

    System.out.println(list);
  }

  public static void convertListToUpperCase() {
    List<String> words = Arrays.asList("Hello! ", "How", " are", " you?");
    List<String> upperCaseWords = words.stream().map(s -> s.toUpperCase())
        .collect(Collectors.toList());
    System.out.println(upperCaseWords);
  }

  public static void wordsStartingWithLetter() {
    List<String> words = Arrays.asList("Hello! ", "How", " are", " you?");
    List<String> wordsStartingWithH = words.stream()
        .map(String::toLowerCase)
        .filter(s -> s.startsWith("h"))
        .collect(Collectors.toList());
    System.out.println(wordsStartingWithH);
  }

  public static void removeDuplicates() {
    List<String> words = Arrays.asList("Cat", "Dog", " Man", "cat");
    List<String> uniqueWords = words.stream()
        .map(String::toLowerCase)
        .distinct().collect(Collectors.toList());
    System.out.println(uniqueWords);
  }

  public static void firstEvenNumber() {
    List<Integer> list = Arrays.asList(99, 89, 66, 79, 88);

    Integer firstEventNumber = list.stream()
        .filter(n -> n % 2 == 0)
        .findFirst().get();

    System.out.println(firstEventNumber);

  }

  static class Employee {

    private String name;
    private String department;

    public Employee(String name, String department) {
      this.name = name;
      this.department = department;
    }

    public String getName() {
      return this.name;
    }

    public String getDepartment() {
      return this.department;
    }
  }

  public static void groupEmployeesByDepartment() {

    List<Employee> employees = Arrays.asList(new Employee("John", "IT"),
        new Employee("Doe", "Dev"),
        new Employee("Modi", "BJP"),
        new Employee("Shah", "BJP"),
        new Employee("Gandhi", "INC"),
        new Employee("Pawar", "INC"));

    employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.mapping(Employee::getName, Collectors.toList())))
        .entrySet().stream().forEach(e -> System.out.println(e));
  }

  public static void findAverage() {
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    System.out.println(list.stream()
        .mapToInt(Integer::intValue)
        .average().getAsDouble());

    int sum = list.stream()
        .reduce((x, y) -> x + y)
        .get();

  }

  public static void findSumOfSquares() {
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    int sumOfSquares = list.stream()
        .map(x -> x * x)
        .reduce((x, y) -> x + y)
        .get();

    sumOfSquares = list.stream()
        .mapToInt(x -> x * x)
        .sum();
    System.out.println(sumOfSquares);

  }

  public static void concatenateLists() {
    List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(5, 6, 7, 8, 9);

    List<Integer> concatenated = Stream.of(list1, list2)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

    System.out.println(concatenated);

  }

  public static void flattenNestedLists() {
    List<List<String>> nestedList = Arrays.asList(
        Arrays.asList("a", "b", "c"),
        Arrays.asList("d", "e", "f"),
        Arrays.asList("g", "h", "i")
    );

    List<String> flattened = nestedList.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

    System.out.println(flattened);
  }

  public static void numberOfWordsWithSameStartingLetter() {

    List<String> names = Arrays
        .asList("Sanvid", "Pranamya", "Suvedh", "Prisha", "Sharvil", "Padmanabh", "Rudra");

    Map<Character, Long> counts = names.stream()
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));

    System.out.println(counts);

  }

  public static void findDuplicates() {
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 1, 7, 5, 7, 2);
    List<Integer> duplicates = list.stream()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
        .entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
    System.out.println(duplicates);
  }

  public static void filterAndPrintPalindromes() {
    List<String> words = Arrays.asList("level", "hello", "radar", "world", "dead");

    List<String> palindromes = words.stream()
        .filter(e -> e.equals(new StringBuilder(e).reverse().toString()))
        .collect(Collectors.toList());

    System.out.println(palindromes);
  }

  public static void sortStringsWithLength() {
    List<String> words = Arrays.asList("Mango", "Apple", "Banana", "Kiwi", "Watermelon");
    words.stream()
        .sorted(Comparator.comparingInt(s -> s.length()))
        .forEach(System.out::println);
  }

}
