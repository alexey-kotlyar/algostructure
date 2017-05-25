package com.aparamonov.algostructure.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Breadth-First-Search algorithm implementation.
 *
 * Created by andrey.paramonov@sigma.software on 10.05.17.
 */
public class BFS<T> {

    public List<Node<T>> search(Node<T> node) {

        List<Node<T>> visited = new LinkedList<>();
        List<Node<T>> unvisited = new LinkedList<>();
        unvisited.add(node);

        while(!unvisited.isEmpty()) {
            Set<Node<T>> newNodes = unvisited.stream()
                    .flatMap(n -> n.getEdges().keySet().stream())
                    .filter(n -> !visited.contains(n))
                    .collect(Collectors.toSet());

            visited.addAll(unvisited);
            unvisited.clear();
            unvisited.addAll(newNodes);
        }
        return visited;
    }
}
