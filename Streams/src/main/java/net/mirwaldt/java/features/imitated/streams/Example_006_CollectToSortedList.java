package net.mirwaldt.java.features.imitated.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_006_CollectToSortedList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Marc", "Michael", "Brian", "Marc"};

        // we want a modifiable, sorted list of strings from a string array and remove element "Michael":

        // with stream
        var streamResult = Arrays.stream(names)
                .sorted()
                .collect(Collectors.toList());
        streamResult.remove("Michael");
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>(asList(names));
        nonStreamResult.sort(Comparator.naturalOrder());
        nonStreamResult.remove("Michael");
        System.out.println(nonStreamResult);
    }
}
