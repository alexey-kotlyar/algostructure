package com.aparamonov.algostructure.search;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class DijkstraTest {

    private Dijkstra dijkstra;
    private Map<String, Node<String>> nodes;
    private List<String> edges;

    @Before
    public void setUp() {
        GraphHelper helper = new GraphHelper();
        edges = new ArrayList<>();
        edges.add("one,two,7");
        edges.add("one,three,9");
        edges.add("one,six,14");
        edges.add("two,three,10");
        edges.add("two,four,15");
        edges.add("three,four,11");
        edges.add("three,six,2");
        edges.add("four,five,6");
        edges.add("six,five,9");
        nodes = helper.makeGraph(edges);
        dijkstra = new Dijkstra();
    }

    @Test
    public void testDijkstra() {
        dijkstra.search(nodes.get("six"));

        for(Node<String> n : nodes.values()) {
            System.out.println("Node " + n.getData() + " has distance: " + n.getDistance());
        }
    }
}
