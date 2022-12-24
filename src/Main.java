import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static long factorial(long n) {
        if (n == 0L)
            return 1L;
        else
            return (n * factorial(n - 1));
    }


    public static long similarPairs(String[] words) {
        Arrays.stream(words).map(s -> s.chars()
                        .mapToObj(chr -> (char) chr) // autoboxed to Character
                        .collect(Collectors.toSet()))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .peek(e -> e.setValue(factorial(e.getValue() - 1)))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println(e.getValue());
                    System.out.println();
                });

        Arrays.stream(words).map(s -> s.chars()
                        .mapToObj(chr -> (char) chr) // autoboxed to Character
                        .collect(Collectors.toSet()))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().forEach(e -> {
                    System.out.println(e);
                    System.out.println();
                });

        Arrays.stream(words).map(s -> s.chars()
                        .mapToObj(chr -> (char) chr) // autoboxed to Character
                        .collect(Collectors.toSet()))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().stream().map(aLong -> aLong == 1 ? 0L : factorial(aLong - 1))
                .forEach(e -> {
                    System.out.println(e);
                    System.out.println();
                });
        return Arrays.stream(words).map(s -> s.chars()
                        .mapToObj(chr -> (char) chr) // autoboxed to Character
                        .collect(Collectors.toSet()))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values().stream().map(aLong -> aLong == 1 ? 0L : factorial(aLong - 1)).reduce(Long::sum).orElse(0L).intValue();
    }

    public static void main(String[] args) {

//        String[] words = {"aabb","ab","ba"};
//        System.out.println("Result : " + similarPairs(words));
//
//        System.out.println("Hello world! ");


        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("Hello");
            }
        };

        int count = (int) Stream.of("helll owokrd", "ejef dfd,", "erweew").filter(predicate).count();


        System.out.printf("%.1f%n", 2.5245);

    }

}