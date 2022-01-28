package net.mirwaldt.java.features.imitated.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_001_CollectToUnmodifiableList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want an unmodifiable list of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .toList();
        System.out.println(streamResult);

        
        System.out.println(middleLine());


        // without stream
        var nonStreamResult = Collections.unmodifiableList(new ArrayList<>(asList(names)));
        System.out.println(nonStreamResult);
    }
}
