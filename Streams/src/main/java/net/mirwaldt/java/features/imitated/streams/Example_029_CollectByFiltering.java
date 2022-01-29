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

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toList;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_029_CollectByFiltering {
    public static void main(String[] args) {
        var names = List.of("Heinz", "Michael", "Brian", "Marc");

        // we want a list with only names starting with "M":

        // with stream
        var streamResult = names.stream()
                .collect(filtering(name -> name.startsWith("M"), toList()));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamResult = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("M")) {
                nonStreamResult.add(name);
            }
        }
        System.out.println(nonStreamResult);
    }
}
