/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 * </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.java.features.imitated.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestUtils {
    public static Stream<Arguments> argumentsForPackage(String packageName, List<String> exceptions) {
        String packagePath = packageName.replace(".", "/");
        File workingDirFile = new File(""); // working dir
        String workingDirString = workingDirFile.getAbsolutePath().replace("" + File.separatorChar, "/");
        File classesDirFile = new File(workingDirString + "/target/classes/" + packagePath);
        return Arrays.stream(Objects.requireNonNull(
                classesDirFile.listFiles(pathName-> pathName.getName().endsWith(".class"))))
                .map(f -> packageName + "." + f.getName().replace(".class", ""))
                .filter(name -> !name.contains("$"))
                .map(type -> Arguments.of(type, exceptions.contains(type)));
    }

    public static void testMain(String sampleClassName, boolean isException) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream backup = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        try {
            Class<?> samplesClass = TestUtils.class.getClassLoader().loadClass(sampleClassName);
            Method mainMethod = samplesClass.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[0]);
            String output = byteArrayOutputStream.toString();
            List<String> lines = List.of(output.split("" + System.lineSeparator()));
            int indexOfMiddleLine = lines.indexOf(middleLine());
            if(0 < indexOfMiddleLine) {
                if(!isException) {
                    assertEquals(lines.subList(0, indexOfMiddleLine), lines.subList(indexOfMiddleLine + 1, lines.size()));
                }
            } else {
                fail("Cannot find middle line in output for sample class '" + sampleClassName + "'.");
            }
        } catch (NoSuchMethodException e) {
            fail("Can't find main method in sample class '" + sampleClassName + "'.");
        } catch (InvocationTargetException e) {
            fail("Can't invoke main method in sample class '" + sampleClassName + "'.");
        } catch (IllegalAccessException e) {
            fail("Can't access main method in sample class '" + sampleClassName + "'.");
        } catch (ClassNotFoundException e) {
            fail("Can't find sample class '" + sampleClassName + "'.");
        } finally {
            System.setOut(backup);
        }
    }
}
