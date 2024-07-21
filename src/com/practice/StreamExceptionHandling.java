import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface CheckedFunction<T, R> {
  R apply(T t) throws Exception;
}

public class StreamExceptionHandling {

  private static <T, R> Function<T, R> handleException(Function<T, R> function) {
    return t -> {
      try {
        return function.apply(t);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

  public static void main(String[] args) {
    List<String> filePaths = List.of("file1.txt", "file2.txt", "invalidFile.txt", "file3.txt");

    filePaths.stream()
        .map(handleException(StreamExceptionHandling::parseInt))
        .collect(Collectors.toList());

    List<String> data = Arrays.asList("1", "2", "a", "4");
    data.stream()
        .mapToInt(StreamExceptionHandling::parse)
        .sum();
  }


  public static Integer parseInt(String s) {
    return Integer.parseInt(s);
  }

  private static Integer parse(String s) {
    try {
      return Integer.parseInt(s);
    } catch (Exception e) {
      throw new RuntimeException("Failed to parse integer: " + s);
    }
  }


}
