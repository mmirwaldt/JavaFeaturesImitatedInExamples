/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 * </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.java.features.imitated.completable.futures;

import net.mirwaldt.java.features.imitated.completable.futures.util.DaemonThreadFactory;

import java.util.concurrent.*;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_06_runAsync_thenRunAsync_withExecutors {
    private static final Runnable printHelloWorld = () -> System.out.println("Hello World!");
    private static final Runnable printHelloWorldAgain = () -> System.out.println("Hello World again!");

    private static final Executor runAsyncExecutor = Executors.newSingleThreadExecutor(new DaemonThreadFactory());
    private static final Executor thenRunAsyncExecutor = Executors.newSingleThreadExecutor(new DaemonThreadFactory());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture.runAsync(printHelloWorld, runAsyncExecutor)
                .thenRunAsync(printHelloWorldAgain, thenRunAsyncExecutor)
                .get();


        System.out.println(middleLine());


        // without CompletableFuture
        CountDownLatch runAsyncSignal = new CountDownLatch(1);
        runAsyncExecutor.execute(() -> {
            printHelloWorld.run();
            runAsyncSignal.countDown();
        });
        runAsyncSignal.await();

        CountDownLatch thenRunAsyncSignal = new CountDownLatch(1);
        thenRunAsyncExecutor.execute(() -> {
            printHelloWorldAgain.run();
            thenRunAsyncSignal.countDown();
        });
        thenRunAsyncSignal.await();
    }
}
