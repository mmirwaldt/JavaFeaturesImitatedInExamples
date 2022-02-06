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
import static java.util.stream.Collectors.summingInt;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_023_CollectByGroupingToSums {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 3, 4, 0, 2, 5, 6);

        // we want a map with the remainder of an int divided by 3 as key and the sum of all ints with the same remainder:

        // with stream
        Map<Integer, Integer> streamResult = ints.stream()
                .collect(groupingBy(i -> i % 3, summingInt(i -> i)));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<Integer, Integer> nonStreamResult = new HashMap<>();
        for (int i : ints) {
            int remainder = i % 3;
            int sum = nonStreamResult.getOrDefault(remainder, 0);
            nonStreamResult.put(remainder, sum + i);
        }
        System.out.println(nonStreamResult);
    }
}
