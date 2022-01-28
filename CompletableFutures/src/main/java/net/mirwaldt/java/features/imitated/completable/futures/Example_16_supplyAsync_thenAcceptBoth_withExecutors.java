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
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_16_supplyAsync_thenAcceptBoth_withExecutors {
    private static final Supplier<String> helloSupplier = () -> "Hello ";
    private static final Supplier<String> worldSupplier = () -> "World!";

    private static final BiConsumer<String, String> printlnConcatStringBiConsumer =
            (s1, s2) -> System.out.println(s1.concat(s2));

    private static final Executor supplyAsyncExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());
    private static final Executor supplyAsyncAndThenAcceptBothExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(worldSupplier, supplyAsyncExecutor);
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(helloSupplier, supplyAsyncAndThenAcceptBothExecutor)
                .thenAcceptBoth(worldFuture, printlnConcatStringBiConsumer);
        completableFuture.get();


        System.out.println(middleLine());


        // without CompletableFuture
        BlockingQueue<String> supplyAsyncQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncExecutor.execute(() -> supplyAsyncQueue.offer(helloSupplier.get()));

        BlockingQueue<String> supplyAsyncAndThenAcceptBothQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncAndThenAcceptBothExecutor.execute(() -> supplyAsyncAndThenAcceptBothQueue.offer(worldSupplier.get()));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        supplyAsyncAndThenAcceptBothExecutor.execute(() -> {
            String firstResult = callUnchecked(() -> supplyAsyncQueue.take());
            String secondResult = callUnchecked(() -> supplyAsyncAndThenAcceptBothQueue.take());
            printlnConcatStringBiConsumer.accept(firstResult, secondResult);
            countDownLatch.countDown();
        });
        countDownLatch.await();
    }
}
