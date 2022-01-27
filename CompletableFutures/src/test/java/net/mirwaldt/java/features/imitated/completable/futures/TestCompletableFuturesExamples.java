/*
 * Copyright (c) 2021, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 * </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.java.features.imitated.completable.futures;

import net.mirwaldt.java.features.imitated.util.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static net.mirwaldt.java.features.imitated.util.TestUtils.argumentsForPackage;

@SuppressWarnings("unused")
public class TestCompletableFuturesExamples {
    public static Stream<Arguments> futureExamples() {
        return argumentsForPackage(TestCompletableFuturesExamples.class.getPackageName());
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("futureExamples")
    void testCompletableFuturesExample(String sampleClassName) {
        TestUtils.testMain(sampleClassName);
    }
}
