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

import java.util.List;

import static java.util.stream.Collectors.averagingInt;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_027_CollectByAverage {
    public static void main(String[] args) {
        var names = List.of("Heinz", "Michael", "Brian", "Marc");

        // we want the longest name:

        // with stream
        var streamResult = names.stream()
                .collect(averagingInt(String::length));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var average = 0d;
        var count = 0;
        var sum = 0;
        for (String name : names) {
            count++;
            sum+=name.length();
        }
        var nonStreamResult = (double) sum / count;
        System.out.println(nonStreamResult);
    }
}
