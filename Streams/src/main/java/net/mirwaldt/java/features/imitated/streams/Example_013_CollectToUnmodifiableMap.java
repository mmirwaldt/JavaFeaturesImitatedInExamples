package net.mirwaldt.java.features.imitated.streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toUnmodifiableMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_013_CollectToUnmodifiableMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want an unmodifiable map with the int element as key and its binary representation as value:

        // with stream
        var streamResult = ints.stream()
                .collect(toUnmodifiableMap(Function.identity(), i -> Integer.toString(i, 2)));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamMap = new HashMap<>();
        for (int i : ints) {
            nonStreamMap.put(i, Integer.toString(i, 2));
        }
        var nonStreamResult = Collections.unmodifiableMap(nonStreamMap);
        System.out.println(nonStreamResult);
    }
}
