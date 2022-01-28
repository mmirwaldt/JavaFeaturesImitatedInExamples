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

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_020_CollectByGroupingToCounts {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        List<Integer> ints = List.of(0, 2, 1, 1, 2, 2);

        // we want a map with the int element as key and its frequency in the int list as value:

        // with stream
        Map<Integer, Long> streamResult = ints.stream()
                .collect(groupingBy(i -> i, counting()));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<Integer, Long> nonStreamResult = new HashMap<>();
        for (int i : ints) {
            long count = nonStreamResult.getOrDefault(i, 0L);
            nonStreamResult.put(i, count + 1);
        }
        System.out.println(nonStreamResult);
    }
}
