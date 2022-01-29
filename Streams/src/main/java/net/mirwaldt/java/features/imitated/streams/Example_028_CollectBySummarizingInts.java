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

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.Collectors.summarizingInt;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_028_CollectBySummarizingInts {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 3, 4, 0, 2, 5, 6);

        // we want a map with the remainder of an int divided by 3 as key and the sum of all ints with the same remainder:

        // with stream
        var streamResult = ints.stream()
                .collect(summarizingInt(i -> i));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        long count = 0L;
        long sum = 0L;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : ints) {
            count++;
            sum += i;
            min = min(min, i);
            max = max(max, i);
        }
        IntSummaryStatistics nonStreamResult = new IntSummaryStatistics(count, min, max, sum);
        System.out.println(nonStreamResult);
    }
}
