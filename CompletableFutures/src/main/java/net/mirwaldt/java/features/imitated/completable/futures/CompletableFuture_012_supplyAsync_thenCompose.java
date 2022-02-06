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

import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_012_supplyAsync_thenCompose {
    private static final Supplier<String> stringSupplier = () -> "Hello World!";
    private static final UnaryOperator<String> stringOperator = String::toUpperCase;

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(stringSupplier)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> stringOperator.apply(result)));
        System.out.println(completableFuture.get());


        System.out.println(middleLine());


        // without CompletableFuture
        if (ForkJoinPool.getCommonPoolParallelism() > 1) {
            ForkJoinPool commonPool = ForkJoinPool.commonPool();
            Future<String> supplyAsyncFuture = commonPool.submit(stringSupplier::get);
            Future<String> thenComposeFuture = commonPool.submit(() -> stringOperator.apply(supplyAsyncFuture.get()));
            System.out.println(thenComposeFuture.get());
        } else {
            BlockingQueue<String> supplyAsyncQueue = new ArrayBlockingQueue<>(1);
            Thread supplyAsyncThread = new Thread(() -> supplyAsyncQueue.offer(stringSupplier.get()));
            supplyAsyncThread.start();
            BlockingQueue<String> thenComposeQueue = new ArrayBlockingQueue<>(1);
            Thread thenComposeThread = new Thread(() -> {
                String previousResult = callUnchecked(() -> supplyAsyncQueue.take());
                thenComposeQueue.offer(stringOperator.apply(previousResult));
            });
            thenComposeThread.start();
            thenComposeThread.join();
            System.out.println(thenComposeQueue.take());
        }
    }
}
