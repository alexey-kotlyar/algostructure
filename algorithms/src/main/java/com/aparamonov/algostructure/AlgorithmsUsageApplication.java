package com.aparamonov.algostructure;

public class AlgorithmsUsageApplication {

    public static void main(String[] args) {
        AlgorithmsUsageBenchmark benchmark = new AlgorithmsUsageBenchmark();
        try {
            benchmark.launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
