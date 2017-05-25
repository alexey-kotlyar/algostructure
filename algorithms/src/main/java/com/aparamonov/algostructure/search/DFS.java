package com.aparamonov.algostructure.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Depth-First-Search algorithm implementation.
 *
 * Created by andrey.paramonov@sigma.software on 10.05.17.
 */
public class DFS<T> {

    public List<Node<T>> search(Node<T> node) {

        List<Node<T>> visited = new LinkedList<>();
        List<Node<T>> unvisited = new LinkedList<>();
        unvisited.add(node);

        while(!unvisited.isEmpty()) {
            Node<T> currentNode = unvisited.remove(0);
            visited.add(currentNode);

            List<Node<T>> newNodes = currentNode.getEdges().entrySet().stream()
                    .map(Map.Entry::getKey)
                    .filter(n -> !visited.contains(n))
                    .filter(n -> !unvisited.contains(n))
                    .collect(Collectors.toList());

            unvisited.addAll(0, newNodes);
        }
        return visited;
    }
}
