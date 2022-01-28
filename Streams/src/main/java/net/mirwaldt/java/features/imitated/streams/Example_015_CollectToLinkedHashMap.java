package net.mirwaldt.java.features.imitated.streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_015_CollectToLinkedHashMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want a linked hash map with the int element as key and its binary representation as value:

        // with stream
        var streamResult = ints.stream()
                .collect(toMap(Function.identity(), i -> Integer.toString(i, 2), (v1, v2) -> null, LinkedHashMap::new));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new LinkedHashMap<>();
        for (int i : ints) {
            nonStreamResult.put(i, Integer.toString(i, 2));
        }
        System.out.println(nonStreamResult);
    }
}
