package com.aparamonov.algostructure.search;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper for graph creation.
 *
 * Created by andrey.paramonov@sigma.software on 15.05.17.
 */
public class GraphHelper {

    /**
     * Creates graph from its String representation.
     *
     * @param edges String representation of desired graph as list of elements
     *              "First node name, Second node name, Distance between nodes".
     * @return graph.
     */
    public Map<String, Node<String>> makeGraph(List<String> edges) {
        Map<String, Node<String>> graph = new LinkedHashMap<>();

        edges.forEach((edge) -> {
            String[] data = edge.split(",");
            Node<String> a = graph.computeIfAbsent(data[0], Node::new);
            Node<String> b = graph.computeIfAbsent(data[1], Node::new);
            b.getEdges().compute(a, (ak, av) -> a.getEdges().compute(b, (bk, bv) -> Integer.parseInt(data[2])));
        });
        return graph;
    }
}
