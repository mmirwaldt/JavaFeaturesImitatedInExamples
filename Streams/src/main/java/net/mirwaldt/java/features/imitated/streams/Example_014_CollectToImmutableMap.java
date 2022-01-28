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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_014_CollectToImmutableMap {
    public static void main(String[] args) {
        var ints = List.of(0, 5, 8, 12);

        // we want an immutable map with the int element as key and its binary representation as value:

        // with stream
        var streamResult = ints.stream()
                .collect(collectingAndThen(toMap(Function.identity(), i -> Integer.toString(i, 2)), Map::copyOf));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        var nonStreamMap = new HashMap<>();
        for (int i : ints) {
            nonStreamMap.put(i, Integer.toString(i, 2));
        }
        var nonStreamResult = Map.copyOf(nonStreamMap);
        System.out.println(nonStreamResult);
    }
}
