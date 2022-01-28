package net.mirwaldt.java.features.imitated.streams;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_012_CollectToModifiableMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want a modifiable map with the int element as key and its binary representation as value and
        // remove the entry for the key 5:

        // with stream
        var streamResult = ints.stream()
                .collect(toMap(Function.identity(), i -> Integer.toString(i, 2)));
        streamResult.remove(5);
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new HashMap<>();
        for (int i : ints) {
            nonStreamResult.put(i, Integer.toString(i, 2));
        }
        nonStreamResult.remove(5);
        System.out.println(nonStreamResult);
    }
}
