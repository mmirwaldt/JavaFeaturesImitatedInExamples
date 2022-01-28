package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_008_CollectToUnmodifiableSet {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc", "Michael"};

        // we want an unmodifiable set of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamSet = new HashSet<>();
        for (String name : names) {
            nonStreamSet.add(name);
        }
        var nonStreamResult = Collections.unmodifiableSet(nonStreamSet);
        System.out.println(nonStreamResult);
    }
}
