package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This collector is extremely useful for turning a stream of strings into a single combined string.
 */
public class CollectorsJoiningExample_1 {

    static void main() {

        method_1();
        method_2();
        method_3();
    }

    //Collectors.joining()
    //Joins all the CharSequence (usually Strings) in the stream into one continuous string — with no delimiter.
    public static void method_1() {

        String result = Stream.of("A", "B", "C")
                .collect(Collectors.joining());

        System.out.println(result);
    }

    //Collectors.joining(CharSequence delimiter)
    //Joins elements with a delimiter (separator).
    public static void method_2() {

        String result = Stream.of("A", "B", "C")
                .collect(Collectors.joining("-"));
        System.out.println(result);

        String sentence = Stream.of("Java", "Stream", "API")
                .collect(Collectors.joining(" "));
        System.out.println(sentence);
    }

    //Collectors.joining(delimiter, prefix, suffix)
    //Joins elements with:
    //
    //delimiter between values
    //
    //prefix at the beginning
    //
    //suffix at the end
    public static void method_3() {

        String result = Stream.of("A", "B", "C")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
        String jsonArray = Stream.of("red", "green", "blue")
                .collect(Collectors.joining("\", \"", "[\"", "\"]"));

        System.out.println(jsonArray);


    }
}
