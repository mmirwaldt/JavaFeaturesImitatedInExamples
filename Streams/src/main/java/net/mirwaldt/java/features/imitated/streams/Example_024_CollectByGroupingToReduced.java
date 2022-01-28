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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_024_CollectByGroupingToReduced {
    public static void main(String[] args) {
        var names = List.of("Heinz", "Michael", "Brian", "Marc");

        // we want a map with the first letter of a name as key and the longest name with that first letter as value:

        // with stream
        Map<String, String> streamResult = names.stream()
                .collect(groupingBy(name -> name.substring(0, 1),
                        reducing("", Example_024_CollectByGroupingToReduced::longestName)));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<String, String> nonStreamResult = new HashMap<>();
        for (String name : names) {
            String firstLetter = name.substring(0, 1);
            String oldName = nonStreamResult.getOrDefault(firstLetter, "");
            if (oldName.isEmpty()) {
                nonStreamResult.put(firstLetter, name);
            } else {
                nonStreamResult.put(firstLetter, longestName(oldName, name));
            }
        }
        System.out.println(nonStreamResult);
    }

    private static String longestName(String left, String right) {
        return left.length() < right.length() ? right : left;
    }
}
