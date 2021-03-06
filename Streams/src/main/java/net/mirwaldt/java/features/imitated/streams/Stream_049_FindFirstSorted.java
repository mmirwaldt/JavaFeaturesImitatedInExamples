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

import java.util.*;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_049_FindFirstSorted {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want the first name in the alphabetical order

        // with stream
        var streamResult = Arrays.stream(names)
                .sorted()
                .findFirst();
        streamResult.ifPresent(System.out::println);


        System.out.println(middleLine());


        // without stream
        List<String> nonStreamNames = Arrays.asList(names);
        nonStreamNames.sort(Comparator.naturalOrder());
        Optional<String> nonStreamResult = Optional.empty();
        if(0 < nonStreamNames.size()) {
            nonStreamResult = Optional.of(nonStreamNames.get(0));
        }
        nonStreamResult.ifPresent(System.out::println);
    }
}
