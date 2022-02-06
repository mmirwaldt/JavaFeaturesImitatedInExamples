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
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_011_supplyAsync_thenApplyAsync_withExecutors {
    private static final Supplier<String> stringSupplier = () -> "Hello World!";
    private static final UnaryOperator<String> stringOperator = String::toUpperCase;

    private static final Executor supplyAsyncExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());
    private static final Executor thenApplyAsyncExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(stringSupplier, supplyAsyncExecutor)
                .thenApplyAsync(stringOperator, thenApplyAsyncExecutor);
        System.out.println(completableFuture.get());


        System.out.println(middleLine());


        // without CompletableFuture
        BlockingQueue<String> supplyAsyncQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncExecutor.execute(() -> supplyAsyncQueue.offer(stringSupplier.get()));
        BlockingQueue<String> thenApplyAsyncQueue = new ArrayBlockingQueue<>(1);
        thenApplyAsyncExecutor.execute(() -> {
            final String previousResult = callUnchecked(() -> supplyAsyncQueue.take());
            final String nextResult = stringOperator.apply(previousResult);
            thenApplyAsyncQueue.offer(nextResult);
        });
        System.out.println(thenApplyAsyncQueue.take());
    }
}
