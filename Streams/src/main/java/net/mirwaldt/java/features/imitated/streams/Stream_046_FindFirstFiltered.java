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
import java.util.Optional;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_046_FindFirstFiltered {
    public static void main(String[] args) {
        var names = new String[]{"Heinz", "Michael", "Brian", "Marc"};

        // we want the first name which starts with the letter "M"

        // with stream
        var streamResult = Arrays.stream(names)
                .filter(s -> s.startsWith("M"))
                .findFirst();
        streamResult.ifPresent(System.out::println);


        System.out.println(middleLine());


        // without stream
        Optional<String> nonStreamResult = Optional.empty();
        for (String name : names) {
            if(name.startsWith("M")) {
                nonStreamResult = Optional.of(name);
                break;
            }
        }
        nonStreamResult.ifPresent(System.out::println);
    }
}
