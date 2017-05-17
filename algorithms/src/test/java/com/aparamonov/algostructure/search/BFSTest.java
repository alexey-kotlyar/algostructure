package com.aparamonov.algostructure.search;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AVParamonov on 05.04.17.
 */
public class BFSTest {

    private BFS bfs;
    private Map<String, Node<String>> nodes;
    private List<String> edges;

    @Before
    public void setUp() {
        GraphHelper helper = new GraphHelper();
        edges = new ArrayList<>();
        edges.add("one,two,7");
        edges.add("one,six,14");
        edges.add("three,four,11");
        edges.add("three,six,2");
        edges.add("six,five,9");
        nodes = helper.makeGraph(edges);
        bfs = new BFS<String>();
    }

    @Test
    public void testBFS() {
        Node<String> targetNode = nodes.get("six");
        List<Node<String>> ns = bfs.search(targetNode);

        for(Node<String> n : ns) {
            System.out.println("Node: " + n.getData());
        }
    }

}
