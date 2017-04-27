package com.aparamonov.algostructure.list;

public class ListUsageApplication {

    public static void main(String[] args) {
        ListUsageBenchmark benchmark = new ListUsageBenchmark();
        try {
            benchmark.launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
