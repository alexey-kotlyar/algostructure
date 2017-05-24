package com.aparamonov.algostructure;

import com.aparamonov.algostructure.search.*;
import com.aparamonov.algostructure.sorting.Mergesort;
import com.aparamonov.algostructure.sorting.Quicksort;
import org.junit.Assert;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Used for benchmarking algorithms.
 *
 * Created by AVParamonov on 21.04.17.
 */
public class AlgorithmsUsageBenchmark {

    private final static int SIZE = 1_000_000;
    private final static int MAX = 100;

    public void launch() throws Exception {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName())
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(3)
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
        BFS<String> bfs;
        DFS<String> dfs;
        Dijkstra<String> dijkstra;
        Map<String, Node<String>> nodes;
        List<String> edges;
        GraphHelper helper;
        int[] numbers;
        Mergesort mergesort;
        Quicksort quicksort;

        @Setup(Level.Trial)
        public void initialize() {
            bfs = new BFS<>();
            dfs = new DFS<>();
            dijkstra = new Dijkstra<>();
            helper = new GraphHelper();
            edges = new ArrayList<>();
            mergesort = new Mergesort();
            quicksort = new Quicksort();
            numbers = new int[SIZE];

            edges.add("one,two,7");
            edges.add("one,three,9");
            edges.add("one,four,14");
            edges.add("two,five,2");
            edges.add("three,six,4");
            edges.add("three,seven,12");
            edges.add("four,eight,3");
            edges.add("seven,nine,8");
            edges.add("eight,ten,5");
            edges.add("nine,eleven,6");
            edges.add("nine,twelve,3");
            edges.add("nine,thirteen,11");
            edges.add("ten,fourteen,9");
            edges.add("ten,fifteen,1");
            edges.add("eleven,sixteen,3");
            edges.add("eleven,seventeen,13");
            edges.add("twelve,eighteen,7");
            edges.add("thirteen,nineteen,7");
            edges.add("fifteen,twenty,10");

            nodes = helper.makeGraph(edges);

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = new Random().nextInt(MAX);
            }
        }
    }

    /**
     * # Benchmark to measure BFS search
     *
     */
    @Benchmark
    public void bfs(BenchmarkState state) {
        Node<String> targetNode = state.nodes.get("one");
        state.bfs.search(targetNode);
    }

    /**
     * # Benchmark to measure DFS search
     *
     */
    @Benchmark
    public void dfs(BenchmarkState state) {
        Node<String> targetNode = state.nodes.get("one");
        state.bfs.search(targetNode);
    }

    /**
     * # Benchmark to measure Dijkstra shortest path search
     *
     */
    @Benchmark
    public void dijkstra(BenchmarkState state) {
        Node<String> targetNode = state.nodes.get("nine");
        state.dijkstra.search(targetNode);
    }

    /**
     * # Benchmark to measure Mergesort
     *
     */
    @Benchmark
    public void mergesort(BenchmarkState state) {
        state.mergesort.sort(state.numbers);
    }

    /**
     * # Benchmark to measure Quicksort
     *
     */
    @Benchmark
    public void quicksort(BenchmarkState state) {
        state.quicksort.sort(state.numbers);
    }

}
