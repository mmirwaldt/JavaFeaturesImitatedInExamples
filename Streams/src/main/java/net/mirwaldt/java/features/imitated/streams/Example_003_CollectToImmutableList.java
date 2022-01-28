package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_003_CollectToImmutableList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want a list of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = List.copyOf(asList(names));
        System.out.println(nonStreamResult);
    }
}
