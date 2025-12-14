package com.yugesh.dsa.problems.streams.level_8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueWordFromSentence {
    static void main() {
        List<String> sentences = List.of(
                "I love Java",
                "Java streams are powerful"
        );

        Set<String> unique = sentences.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
        System.out.println(unique);

    }
}
