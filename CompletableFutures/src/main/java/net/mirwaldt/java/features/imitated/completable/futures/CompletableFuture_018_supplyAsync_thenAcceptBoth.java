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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class CompletableFuture_018_supplyAsync_thenAcceptBoth {
    private static final Supplier<String> helloSupplier = () -> "Hello ";
    private static final Supplier<String> worldSupplier = () -> "World!";

    private static final BiConsumer<String, String> printlnConcatStringBiConsumer =
            (s1, s2) -> System.out.println(s1.concat(s2));

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(worldSupplier);
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(helloSupplier)
                .thenAcceptBoth(worldFuture, printlnConcatStringBiConsumer);
        completableFuture.get();


        System.out.println(middleLine());


        // without CompletableFuture
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        Future<String> supplyAsyncFuture = commonPool.submit(helloSupplier::get);
        Future<String> supplyAsyncInThenCombineFuture = commonPool.submit(worldSupplier::get);
        Future<?> thenCombineFuture = commonPool.submit(() -> {
            String firstResult = callUnchecked(() -> supplyAsyncFuture.get());
            String secondResult = callUnchecked(() -> supplyAsyncInThenCombineFuture.get());
            printlnConcatStringBiConsumer.accept(firstResult, secondResult);
        });
        thenCombineFuture.get();
    }
}
