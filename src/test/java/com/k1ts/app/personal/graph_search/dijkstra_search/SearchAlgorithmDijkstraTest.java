package com.k1ts.app.personal.graph_search.dijkstra_search;

import com.k1ts.app.personal.sorting.SortingAlgorithmTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SearchAlgorithmDijkstraTest {

    @Test
    public void test() {
        int[] prev = new int[5];
        SearchAlgorithmDijkstra algorithm = new SearchAlgorithmDijkstra();
        int[] dijkstra = algorithm.dijkstra(buildGraphDirected(), 0, 5, prev);
        Assert.assertEquals(List.of(0, 1, 3, 4), algorithm.reconstructPath(prev, 4));
    }

    private Map<Integer, List<SearchAlgorithmDijkstra.Edge>> buildGraphDirected() {
        Map<Integer, List<SearchAlgorithmDijkstra.Edge>> g = new HashMap<>();
        for (int i = 0; i < 5; i++) g.put(i, new ArrayList<>());

        // vertices mapping: 0=A, 1=B, 2=C, 3=D, 4=E
        g.get(0).add(new SearchAlgorithmDijkstra.Edge(1, 4));  // A -> B (4)
        g.get(0).add(new SearchAlgorithmDijkstra.Edge(2, 2));  // A -> C (2)
        g.get(1).add(new SearchAlgorithmDijkstra.Edge(2, 1));  // B -> C (1)
        g.get(1).add(new SearchAlgorithmDijkstra.Edge(3, 5));  // B -> D (5)
        g.get(2).add(new SearchAlgorithmDijkstra.Edge(3, 8));  // C -> D (8)
        g.get(2).add(new SearchAlgorithmDijkstra.Edge(4, 10)); // C -> E (10)
        g.get(3).add(new SearchAlgorithmDijkstra.Edge(4, 2));  // D -> E (2)
        g.get(4).add(new SearchAlgorithmDijkstra.Edge(3, 2));  // E -> D (2)
        return g;
    }
}