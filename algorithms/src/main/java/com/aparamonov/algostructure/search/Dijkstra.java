package com.aparamonov.algostructure.search;

import java.util.*;

/**
 * Dijkstra search algorithm implementation.
 *
 * Created by andrey.paramonov@sigma.software on 10.05.17.
 */
public class Dijkstra<T> {

    public void search(Node<T> start) {
        PriorityQueue<Node<T>> pq = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        start.setDistance(0);
        pq.offer(start);

        while(pq.size() > 0) {
            Node<T> currentNode = pq.poll();
            currentNode.getEdges().forEach( (neighbor, distance) -> {
                if( currentNode.getDistance() + distance < neighbor.getDistance()) {
                    neighbor.setDistance(currentNode.getDistance() + distance);
                    pq.add(neighbor);
                }});
        }
    }
}
