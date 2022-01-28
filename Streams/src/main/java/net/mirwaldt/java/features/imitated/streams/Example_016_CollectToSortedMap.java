package net.mirwaldt.java.features.imitated.streams;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_016_CollectToSortedMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want a sorted map with the int element as key and its binary representation as value:

        // with stream
        var streamResult = ints.stream()
                .collect(toMap(Function.identity(), i -> Integer.toString(i, 2), (v1, v2) -> null, TreeMap::new));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new TreeMap<>();
        for (int i : ints) {
            nonStreamResult.put(i, Integer.toString(i, 2));
        }
        System.out.println(nonStreamResult);
    }
}
