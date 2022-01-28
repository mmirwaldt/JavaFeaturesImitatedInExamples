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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_018_CollectByPartitioning {
    @SuppressWarnings({"Java8MapApi", "SpellCheckingInspection"})
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5);

        // we want a map where the values are primes if the key is true and no primes if the key is false:

        // with stream
        Map<Boolean, List<Integer>> streamResult = ints.stream()
                .collect(partitioningBy(Example_018_CollectByPartitioning::isPrime, Collectors.toList()));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<Boolean, List<Integer>> nonStreamResult = new HashMap<>();
        for (int i : ints) {
            boolean isPrime = isPrime(i);
            List<Integer> list = nonStreamResult.get(isPrime);
            if(list == null) {
                list = new ArrayList<>();
                nonStreamResult.put(isPrime, list);
            }
            list.add(i);
        }
        System.out.println(nonStreamResult);
    }

    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
