package net.mirwaldt.java.features.imitated.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_002_CollectToModifiableList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want a modifiable list of strings from a string array and remove element "Michael":

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toList());
        streamResult.remove("Michael");
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>(asList(names));
        nonStreamResult.remove("Michael");
        System.out.println(nonStreamResult);
    }
}
