package net.mirwaldt.java.features.imitated.streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_004_CollectToLinkedList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want a modifiable linked list of strings from a string array and remove element "Michael":

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toCollection(LinkedList::new));
        streamResult.remove("Michael");
        System.out.println(streamResult.getClass());
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new LinkedList<>(asList(names));
        nonStreamResult.remove("Michael");
        System.out.println(nonStreamResult.getClass());
        System.out.println(nonStreamResult);
    }
}
