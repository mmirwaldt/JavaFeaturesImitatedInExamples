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

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Stream_055_Min {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        var ints = List.of(3, 2, 1, 1, 2, 2);

        // we want the minimum of all ints in an array

        // with stream
        var streamResult = ints.stream()
                .min(Comparator.naturalOrder());
        streamResult.ifPresent(System.out::println);


        System.out.println(middleLine());


        // without stream
        Optional<Integer> nonStreamResult = Optional.empty();
        for (int anInt : ints) {
            if(nonStreamResult.isEmpty()) {
                nonStreamResult = Optional.of(anInt);
            } else if(anInt < nonStreamResult.get()) {
                nonStreamResult = Optional.of(anInt);
            }
        }
        nonStreamResult.ifPresent(System.out::println);
    }
}
