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

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_007_CollectToModifiableSet {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc", "Michael"};

        // we want a modifiable set of strings from a string array and remove element "Marc":

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toSet());
        streamResult.remove("Marc");
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new HashSet<>();
        for (String name : names) {
            nonStreamResult.add(name);
        }
        nonStreamResult.remove("Marc");
        System.out.println(nonStreamResult);
    }
}
