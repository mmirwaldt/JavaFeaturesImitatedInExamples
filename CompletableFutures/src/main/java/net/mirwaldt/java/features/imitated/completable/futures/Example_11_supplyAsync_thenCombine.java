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

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static net.mirwaldt.java.features.imitated.completable.futures.util.Utils.callUnchecked;
import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_11_supplyAsync_thenCombine {
    private static final Supplier<String> helloSupplier = () -> "Hello ";
    private static final Supplier<String> worldSupplier = () -> "World!";
    private static final BiFunction<String, String, String> concatBiFunction = String::concat;

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFutures
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(worldSupplier);
        CompletableFuture<String> combinedFuture = CompletableFuture
                .supplyAsync(helloSupplier)
                .thenCombine(helloFuture, concatBiFunction);
        System.out.println(combinedFuture.get());


        System.out.println(middleLine());


        // without CompletableFutures
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        Future<String> supplyAsyncFuture = commonPool.submit(helloSupplier::get);
        Future<String> supplyAsyncInThenCombineFuture = commonPool.submit(worldSupplier::get);
        Future<String> thenCombineFuture = commonPool.submit(() -> {
            String firstResult = callUnchecked(() -> supplyAsyncFuture.get());
            String secondResult = callUnchecked(() -> supplyAsyncInThenCombineFuture.get());
            return concatBiFunction.apply(firstResult, secondResult);
        });
        System.out.println(thenCombineFuture.get());
    }
}
