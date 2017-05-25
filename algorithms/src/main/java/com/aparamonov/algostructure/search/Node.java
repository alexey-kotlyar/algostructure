package com.aparamonov.algostructure.search;


import java.util.HashMap;
import java.util.Map;

/**
 * Represents node for searching algorithms purposes.
 *
 * Created by andrey.paramonov@sigma.software on 27.04.17.
 */
public class Node<T> {

    private T data;
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node<T>,Integer> edges = new HashMap<>();

    Node(T d) {
        this.data = d;
    }

    public T getData() {
        return this.data;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public Map<Node<T>, Integer> getEdges() {
        return this.edges;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setEdges(Map<Node<T>, Integer> edges) {
        this.edges = edges;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Node)) return false;
        final Node other = (Node) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        final Object this$distance = this.getDistance();
        final Object other$distance = other.getDistance();
        if (this$distance == null ? other$distance != null : !this$distance.equals(other$distance)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        final Object $distance = this.getDistance();
        result = result * PRIME + ($distance == null ? 43 : $distance.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Node;
    }

    public String toString() {
        return "Node(data=" + this.getData() + ", distance=" + this.getDistance() + ")";
    }
}
