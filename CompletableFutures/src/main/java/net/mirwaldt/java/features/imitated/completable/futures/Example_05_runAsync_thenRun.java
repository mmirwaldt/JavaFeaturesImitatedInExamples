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

import net.mirwaldt.java.features.imitated.completable.futures.util.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_05_runAsync_thenRun {
    private static final Runnable printHelloWorld = () -> System.out.println("Hello World!");
    private static final Runnable printHelloWorldAgain = () -> System.out.println("Hello World again!");

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture.runAsync(printHelloWorld)
                .thenRun(printHelloWorldAgain)
                .get();


        System.out.println(middleLine());


        // without CompletableFuture
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        Future<?> runAsyncFuture = commonPool.submit(printHelloWorld);
        Future<?> thenRunFuture = commonPool.submit(() -> {
            Utils.callUnchecked(() -> runAsyncFuture.get());
            printHelloWorldAgain.run();
        });
        thenRunFuture.get();
    }
}
