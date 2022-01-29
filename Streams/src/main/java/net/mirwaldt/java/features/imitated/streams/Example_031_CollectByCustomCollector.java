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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_031_CollectByCustomCollector {
    public static void main(String[] args) {
        Map<String, List<Integer>> multiMap = Map.of(
                "M", List.of(1, 2, 3),
                "S", List.of(2, 4),
                "A", List.of(2, 3, 5)
        );

        // we want to inverse keys and values:

        // with stream
        Map<Integer, List<String>> streamResult =
                multiMap.entrySet().stream()
                        .collect(Collector.of(supplier(), accumulator(), combiner(), finisher(),
                                Characteristics.UNORDERED));
        System.out.println(streamResult);


        System.out.println(middleLine());


        // without stream
        Map<Integer, List<String>> nonStreamResult = new LinkedHashMap<>();
        for (Map.Entry<String, List<Integer>> entry : multiMap.entrySet()) {
            for (Integer element : entry.getValue()) {
                nonStreamResult.computeIfAbsent(element, (j) -> new ArrayList<>()).add(entry.getKey());
            }
        }
        System.out.println(nonStreamResult);
    }

    static Supplier<Map<Integer, List<String>>> supplier() {
        return LinkedHashMap::new;
    }

    static BiConsumer<Map<Integer, List<String>>, Map.Entry<String, List<Integer>>> accumulator() {
        return (Map<Integer, List<String>> map, Map.Entry<String, List<Integer>> entry) ->
                entry.getValue().forEach(
                        i -> map.computeIfAbsent(i, j -> new ArrayList<>())
                                .add(entry.getKey()));
    }

    static BinaryOperator<Map<Integer, List<String>>> combiner() {
        return (a, b) -> null; // we don't implement the combiner because our stream does not run in parallel
    }

    static Function<Map<Integer, List<String>>, Map<Integer, List<String>>> finisher() {
        return Function.identity();
    }
}
