package net.mirwaldt.java.features.imitated.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_005_CollectToDistinctList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Marc", "Michael", "Brian", "Marc"};

        // we want a modifiable, distinct list of strings from a string array:

        // with stream
        var streamResult = Arrays.stream(names)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>();
        for (String name : names) {
            if(!nonStreamResult.contains(name)) {
                nonStreamResult.add(name);
            }
        }
        System.out.println(nonStreamResult);
    }
}
