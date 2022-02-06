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
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_002_CollectToModifiableList {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want a modifiable list of strings from a string array and remove element "Michael":

        // with stream
        var streamResult = Arrays.stream(names)
                .collect(Collectors.toList());
        streamResult.remove("Michael");
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>(asList(names));
        nonStreamResult.remove("Michael");
        System.out.println(nonStreamResult);
    }
}
