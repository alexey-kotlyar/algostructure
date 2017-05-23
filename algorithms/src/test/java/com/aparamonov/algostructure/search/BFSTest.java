package com.aparamonov.algostructure.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class BFSTest {

    private BFS<String> bfs;
    private Map<String, Node<String>> nodes;
    private List<String> edges;

    @Before
    public void setUp() {
        GraphHelper helper = new GraphHelper();
        edges = new ArrayList<>();
        edges.add("one,two,0");
        edges.add("one,three,0");
        edges.add("one,four,0");
        edges.add("two,five,0");
        edges.add("three,six,0");
        edges.add("three,seven,0");
        edges.add("four,eight,0");
        edges.add("seven,nine,0");
        edges.add("eight,ten,0");
        nodes = helper.makeGraph(edges);
        bfs = new BFS<>();
    }

    @Test
    public void testBFS() {
        Node<String> targetNode = nodes.get("one");
        List<Node<String>> ns = bfs.search(targetNode);

        List<String> expected =
                Arrays.asList("one", "three", "four", "two", "five", "six", "eight", "seven", "ten", "nine");

        for (int i = 0; i < ns.size(); i++) {
            Assert.assertEquals(expected.get(i), ns.get(i).getData());
        }
    }

}
