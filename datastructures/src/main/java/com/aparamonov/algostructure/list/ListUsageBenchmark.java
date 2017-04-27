package com.aparamonov.algostructure.list;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by AVParamonov on 21.04.17.
 */
public class ListUsageBenchmark {

    private final static int SIZE = 100_000;

    public void launch() throws Exception {

        Options opt = new OptionsBuilder()
                .include(this.getClass().getName())
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(2)
                .timeout(TimeValue.minutes(5))
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class BenchmarkState {
        List<String> arrayList;
        List<String> linkedList;

        @Setup(Level.Trial)
        public void initialize() {
            arrayList = new ArrayList<>();
            linkedList = new LinkedList<>();

            for(int i = 0; i < SIZE; i++) {
                String uuid = UUID.randomUUID().toString();
                arrayList.add(uuid);
                linkedList.add(uuid);
            }
        }
    }

    /**
     * # Benchmark to measure append of lines to the end of ArrayList
     *
     */
    @Benchmark
    public void appendToEndOfArrayList () {
        List<String> arrayList = new ArrayList<>();

        for(int i = 0; i < SIZE; i++) {
            String uuid = UUID.randomUUID().toString();
            arrayList.add(uuid);
        }
    }

    /**
     * # Benchmark to measure append of lines to the end of LinkedList
     *
     */
    @Benchmark
    public void appendToEndOfLinkedList () {
        List<String> linkedList = new LinkedList<>();

        for(int i = 0; i < SIZE; i++) {
            String uuid = UUID.randomUUID().toString();
            linkedList.add(uuid);
        }
    }

    /**
     * # Benchmark to measure append of lines to the middle of ArrayList
     *
     */
    @Benchmark
    public void appendToMiddleOfArrayList (BenchmarkState state) {
        List<String> arrayList = state.arrayList;

        for(int i = 0; i < SIZE/2; i++) {
            String uuid = UUID.randomUUID().toString();
            arrayList.add(arrayList.size()/2, uuid);
        }
    }

    /**
     * # Benchmark to measure append of lines to the middle of LinkedList
     *
     */
    @Benchmark
    public void appendToMiddleOfLinkedList (BenchmarkState state) {
        List<String> linkedList = state.linkedList;

        for(int i = 0; i < SIZE/2; i++) {
            String uuid = UUID.randomUUID().toString();
            linkedList.add(linkedList.size()/2, uuid);
        }
    }

    /**
     * # Benchmark to measure getting lines by index from ArrayList
     *
     */
    @Benchmark
    public void getFromArrayList (BenchmarkState state, Blackhole bh) {
        List<String> arrayList = state.arrayList;

        for (int i = 0; i < SIZE; i++) {
            bh.consume(arrayList.get(i));
        }
    }

    /**
     * # Benchmark to measure getting lines by index LinkedList
     *
     */
    @Benchmark
    public void getFromLinkedList (BenchmarkState state, Blackhole bh) {
        List<String> linkedList = state.linkedList;

        for (int i = 0; i < SIZE; i++) {
            bh.consume(linkedList.get(i));
        }
    }

    /**
     * # Benchmark to measure removal of lines from ArrayList
     *
     */
    @Benchmark
    public void removeFromArrayList (BenchmarkState state) {
        List<String> arrayList = state.arrayList;

        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /**
     * # Benchmark to measure removal of lines from LinkedList
     *
     */
    @Benchmark
    public void removeFromLinkedList (BenchmarkState state) {
        List<String> linkedList = state.linkedList;

        Iterator<String> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

}
