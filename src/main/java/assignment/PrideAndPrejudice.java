package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrideAndPrejudice {
    public static void main(String[] args) throws IOException {

        System.out.println("************************** Running Pride and Prejudice ****************************");
        //  Open the File
        Stream<String> stream = Files.lines(Paths.get("PrideAndPrejudice.txt"));

        // Split into words

        stream.flatMap(Pattern.compile("\\W+")::splitAsStream).flatMap(Pattern.compile("\n")::splitAsStream)
                .filter(s -> !s.isEmpty())
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                // .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // You can also use Function.identity same as p -> p but a library and it is a singelton
                // .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()) // You can also use Map.Entry to specify the Key and Value Pair
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(200)
                .forEach(System.out::println);

    }
}
