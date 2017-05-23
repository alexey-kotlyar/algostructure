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

        Node<String> n1 = new Node<>("one");
        Node<String> n2 = new Node<>("two");
        Node<String> n3 = new Node<>("three");
        Node<String> n4 = new Node<>("four");
        Node<String> n5 = new Node<>("five");
        Node<String> n6 = new Node<>("six");

        n1.setDistance(11);
        n2.setDistance(12);
        n3.setDistance(2);
        n4.setDistance(13);
        n5.setDistance(9);
        n6.setDistance(0);

        List<Node<String>> expected = Arrays.asList(n1, n2, n3, n6, n4, n5);

        List<Node<String>> actual =  new ArrayList<>();
        actual.addAll(nodes.values());

        for (int i = 0; i < nodes.size(); i++) {
            Assert.assertEquals(expected.get(i).getData(), actual.get(i).getData());
            Assert.assertEquals(expected.get(i).getDistance(), actual.get(i).getDistance());
        }

        for(Node<String> n : nodes.values()) {
            System.out.println("Node " + n.getData() + " has distance: " + n.getDistance());
        }
    }
}
