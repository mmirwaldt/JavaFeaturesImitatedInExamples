package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_010_CollectToLinkedHashSet {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc", "Michael"};

        // we want a linked hash set of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new LinkedHashSet<>();
        for (String name : names) {
            nonStreamResult.add(name);
        }
        System.out.println(nonStreamResult);
    }
}
