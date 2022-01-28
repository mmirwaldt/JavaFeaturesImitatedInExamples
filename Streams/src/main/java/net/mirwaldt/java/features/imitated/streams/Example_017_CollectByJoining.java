/*
 * Copyright (c) 2021, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 * </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.java.features.imitated.streams;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_017_CollectByJoining {
    public static void main(String[] args) {
        List<String> lines = List.of("First line", "Second line", "Third line", "Last line");

        // we want a text in which all lines were joined by the system line separator (e.g. '\n' in linux):

        // with stream
        String streamResult = lines.stream()
                .collect(joining(System.lineSeparator()));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        StringBuilder nonStreamResultBuilder = new StringBuilder();
        boolean isFirstLine = true;
        for (String line : lines) {
            if(isFirstLine) {
                isFirstLine = false;
            } else {
                nonStreamResultBuilder.append(System.lineSeparator());
            }
            nonStreamResultBuilder.append(line);
        }
        String nonStreamResult = nonStreamResultBuilder.toString();
        System.out.println(nonStreamResult);
    }
}
