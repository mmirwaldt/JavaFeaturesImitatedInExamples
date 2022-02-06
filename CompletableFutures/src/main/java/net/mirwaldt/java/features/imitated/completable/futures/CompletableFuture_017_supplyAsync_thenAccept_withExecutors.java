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
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_017_supplyAsync_thenAccept_withExecutors {
    private static final Supplier<String> stringSupplier = () -> "Hello World!";
    private static final Consumer<String> printlnConsumer = System.out::println;

    private static final Executor supplyAsyncAndThenAcceptExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(stringSupplier, supplyAsyncAndThenAcceptExecutor)
                .thenAccept(printlnConsumer);
        completableFuture.get();


        System.out.println(middleLine());


        // without CompletableFuture
        CountDownLatch countDownLatch = new CountDownLatch(1);
        supplyAsyncAndThenAcceptExecutor.execute(() -> {
            String result = stringSupplier.get();
            printlnConsumer.accept(result);
            countDownLatch.countDown();
        });
        countDownLatch.await();
    }
}
