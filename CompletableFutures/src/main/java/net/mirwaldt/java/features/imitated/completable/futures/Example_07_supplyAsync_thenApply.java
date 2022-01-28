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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static net.mirwaldt.java.features.imitated.util.Utils.middleLine;

public class Example_07_supplyAsync_thenApply {
    private static final Supplier<String> stringSupplier = () -> "Hello World!";
    private static final UnaryOperator<String> stringOperator = String::toUpperCase;

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // with CompletableFuture
        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(stringSupplier)
                .thenApply(stringOperator);
        System.out.println(completableFuture.get());


        System.out.println(middleLine());


        // without CompletableFuture
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        Future<String> supplyAsyncFuture = commonPool.submit(stringSupplier::get);
        String supplySyncResult = supplyAsyncFuture.get();
        Future<String> thenComposeFuture = commonPool.submit(() -> stringOperator.apply(supplySyncResult));
        System.out.println(thenComposeFuture.get());
    }
}
