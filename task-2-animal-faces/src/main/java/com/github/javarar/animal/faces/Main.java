package com.github.javarar.animal.faces;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {


    }

    static void testLoad() throws IOException {
        AnimalFacesPipeline animalFacesPipeline = new AnimalFacesPipeline();

        var t = System.currentTimeMillis();
        animalFacesPipeline.load();
        System.out.println("Время выполнения " + (System.currentTimeMillis() - t));
    }

    static void testLoadAsync() throws InterruptedException {
        AnimalFacesPipeline animalFacesPipeline = new AnimalFacesPipeline();

        var t = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        animalFacesPipeline.loadAsync(executor);
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Время выполнения " + (System.currentTimeMillis() - t));
    }


}
