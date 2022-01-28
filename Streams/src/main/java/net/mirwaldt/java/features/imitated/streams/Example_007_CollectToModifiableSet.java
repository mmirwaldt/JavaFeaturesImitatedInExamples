package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_007_CollectToModifiableSet {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc", "Michael"};

        // we want a modifiable set of strings from a string array and remove element "Marc":

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toSet());
        streamResult.remove("Marc");
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new HashSet<>();
        for (String name : names) {
            nonStreamResult.add(name);
        }
        nonStreamResult.remove("Marc");
        System.out.println(nonStreamResult);
    }
}
