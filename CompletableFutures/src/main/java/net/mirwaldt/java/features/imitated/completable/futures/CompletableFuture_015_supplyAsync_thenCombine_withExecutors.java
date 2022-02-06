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
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_015_supplyAsync_thenCombine_withExecutors {
    private static final Supplier<String> helloSupplier = () -> "Hello ";
    private static final Supplier<String> worldSupplier = () -> "World!";
    private static final BiFunction<String, String, String> concatBiFunction = String::concat;

    private static final Executor supplyAsyncExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());
    private static final Executor supplyAsyncAndThenCombineExecutor =
            Executors.newSingleThreadExecutor(new DaemonThreadFactory());

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFutures
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(worldSupplier, supplyAsyncExecutor);
        CompletableFuture<String> combinedFuture = CompletableFuture
                .supplyAsync(helloSupplier, supplyAsyncAndThenCombineExecutor)
                .thenCombine(helloFuture, concatBiFunction);
        System.out.println(combinedFuture.get());


        System.out.println(middleLine());


        // without CompletableFutures
        BlockingQueue<String> supplyAsyncQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncExecutor.execute(() -> supplyAsyncQueue.offer(helloSupplier.get()));

        BlockingQueue<String> supplyAsyncAndThenCombineQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncAndThenCombineExecutor.execute(() -> supplyAsyncAndThenCombineQueue.offer(worldSupplier.get()));

        BlockingQueue<String> thenCombineQueue = new ArrayBlockingQueue<>(1);
        supplyAsyncAndThenCombineExecutor.execute(() -> {
            String firstResult = callUnchecked(() -> supplyAsyncQueue.take());
            String secondResult = callUnchecked(() -> supplyAsyncAndThenCombineQueue.take());
            thenCombineQueue.offer(concatBiFunction.apply(firstResult, secondResult));
        });
        System.out.println(thenCombineQueue.take());
    }
}
