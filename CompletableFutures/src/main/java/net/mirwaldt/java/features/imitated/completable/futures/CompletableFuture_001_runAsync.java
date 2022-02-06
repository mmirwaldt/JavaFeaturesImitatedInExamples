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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_001_runAsync {
    private static final Runnable printHelloWorld = () -> System.out.println("Hello World!");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
//        CompletableFuture.runAsync(printHelloWorld)
//                .get();

        System.out.println(CompletableFuture
                .runAsync(() -> System.out.println("x"))
                .thenApply(x -> x.equals(""))
                .get()
        );

//        System.out.println(middleLine());


        // without CompletableFuture
//        ForkJoinPool commonPool = ForkJoinPool.commonPool();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        commonPool.execute(() -> {
//            printHelloWorld.run();
//            countDownLatch.countDown();
//        });
//        countDownLatch.await();
    }
}
