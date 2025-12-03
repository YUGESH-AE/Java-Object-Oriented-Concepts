package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Creates a Map<K, V> from a stream by applying:
 * <p>
 * keyMapper → extracts the key
 * <p>
 * valueMapper → extracts the value
 * <p>
 * If two elements produce the same key, this method throws:
 */
public class CollectorsToMapExample_1 {

    static void main() {

        method_1();
        method_2();

    }

    //Collectors.toMap(keyMapper, valueMapper)
    public static void method_1() {

        List<String> words = List.of("Java", "Python", "Angular");

        Map<Character, String> wordsMap =
                words.stream()
                        .collect(
                                Collectors.toMap(
                                        w -> w.charAt(0),
                                        w -> w
                                )
                        );

        System.out.println(wordsMap);


        record User(int id, String name) {
        }
        List<User> users = List.of(
                new User(1, "Arun"),
                new User(2, "Vikram")
        );

        Map<Integer, String> userMap = users.stream()
                .collect(
                        Collectors.toMap(
                                User::id,
                                User::name
                        )
                );
        System.out.println(userMap);
    }

    //Collectors.toMap(keyMapper, valueMapper, mergeFunction)
    //Same as the previous method, but allows duplicate keys.
    //If two values have the same key, the mergeFunction decides which one to keep.
    //Signature
    public static void method_2() {

        //Keep the FIRST value when keys collide
        List<String> words = List.of("apple", "ant", "axe", "bat");

        Map<Character, String> wordsMap =
                words.stream()
                        .collect(
                                Collectors.toMap(
                                        w -> w.charAt(0),
                                        w -> w,
                                        (oldValue, newValue) -> oldValue
                                )
                        );
        System.out.println(wordsMap);

        Map<Character, Integer> wordsLengthMap = words.stream()
                .collect(
                        Collectors.toMap(
                                w -> w.charAt(0),
                                String::length,
                                Integer::sum
                        )
                );
        System.out.println(wordsLengthMap);

        Map<Character, List<String>> wordList = words
                .stream()
                .collect(
                        Collectors.toMap(
                                w -> w.charAt(0),
                                w -> new ArrayList<>(List.of(w)),
                                (oldValue, newValue) -> {
                                    oldValue.addAll(newValue);
                                    return oldValue;
                                }
                        )
                );

        System.out.println(wordList);
    }
}
