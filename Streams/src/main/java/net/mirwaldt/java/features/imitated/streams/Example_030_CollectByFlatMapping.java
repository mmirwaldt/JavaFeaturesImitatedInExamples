/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 * </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.java.features.imitated.streams;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.toList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_030_CollectByFlatMapping {
    public static void main(String[] args) {
        var intLists = List.of(List.of(1, 3, 4), List.of(5), List.of(0, 2));

        // we want a list of ints from a list of list of ints:

        // with stream
        var streamResult = intLists.stream()
                .collect(flatMapping(List::stream, toList()));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>();
        for (var intList : intLists) {
            nonStreamResult.addAll(intList);
        }
        System.out.println(nonStreamResult);
    }
}
