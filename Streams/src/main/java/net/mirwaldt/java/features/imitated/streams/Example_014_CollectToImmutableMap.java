package net.mirwaldt.java.features.imitated.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_014_CollectToImmutableMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want an immutable map with the int element as key and its binary representation as value:

        // with stream
        var streamResult = ints.stream()
                .collect(collectingAndThen(toMap(Function.identity(), i -> Integer.toString(i, 2)), Map::copyOf));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamMap = new HashMap<>();
        for (int i : ints) {
            nonStreamMap.put(i, Integer.toString(i, 2));
        }
        var nonStreamResult = Map.copyOf(nonStreamMap);
        System.out.println(nonStreamResult);
    }
}
