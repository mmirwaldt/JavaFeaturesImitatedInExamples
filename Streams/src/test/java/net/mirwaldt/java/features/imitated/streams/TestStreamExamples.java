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

import net.mirwaldt.java.features.imitated.util.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static net.mirwaldt.java.features.imitated.util.TestUtils.argumentsForPackage;


@SuppressWarnings("unused")
public class TestStreamExamples {
    public static Stream<Arguments> streamExamples() {
        return argumentsForPackage(TestStreamExamples.class.getPackageName(), List.of());
    }

    @ParameterizedTest(name = "{index}: {0}, isException={1}")
    @MethodSource("streamExamples")
    void testStreamExample(String sampleClassName, boolean isException) {
        TestUtils.testMain(sampleClassName, isException);
    }
}
