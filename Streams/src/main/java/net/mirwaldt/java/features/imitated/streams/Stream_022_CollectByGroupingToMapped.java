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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_022_CollectByGroupingToMapped {
    public static void main(String[] args) {
        var names = List.of("Heinz", "Michael", "Brian", "Marc");

        // we want a map with the first letter of a name as key and a list of all names in upper case
        // with that first letter as value:

        // with stream
        Map<String, List<String>> streamResult = names.stream()
                .collect(groupingBy(name -> name.substring(0, 1), mapping(String::toUpperCase, toList())));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<String, List<String>> nonStreamResult = new HashMap<>();
        for (String name : names) {
            String firstLetter = name.substring(0, 1);
            List<String> list = nonStreamResult.get(firstLetter);
            if(list == null) {
                list = new ArrayList<>();
                nonStreamResult.put(firstLetter, list);
            }
            list.add(name.toUpperCase());
        }
        System.out.println(nonStreamResult);
    }
}
