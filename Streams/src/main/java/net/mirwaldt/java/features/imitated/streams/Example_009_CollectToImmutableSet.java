package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_009_CollectToImmutableSet {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc", "Michael"};

        // we want an unmodifiable set of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Set::copyOf));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamSet = new HashSet<>();
        for (String name : names) {
            nonStreamSet.add(name);
        }
        var nonStreamResult = Set.copyOf(nonStreamSet);
        System.out.println(nonStreamResult);
    }
}
