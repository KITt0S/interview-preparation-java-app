package com.k1ts.app.personal.graph_search;

import com.k1ts.app.personal.sorting.SortingAlgorithmTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchAlgorithmDFSTest {

    @Test
    public void test() {
        SearchAlgorithmDFS algorithm = new SearchAlgorithmDFS();
        int start = 0;
        int end = 4;
        List<List<Integer>> graph = generateGraph();
        List<Integer> expected = List.of(0, 1, 2, 4);
        List<Integer> path = algorithm.dfs(graph, start, end);
        Assert.assertEquals(expected, path);
    }

    private List<List<Integer>> generateGraph() {
        List<List<Integer>> graph = new ArrayList<>();

        int nodes = 5; // 0..4
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Создадим граф без пути 0 → 4
        //
        // 0 → 1
        // 1 → 2
        // 2 → 3
        // 2 -> 4
        //
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(2).add(4);

        return graph;
    }
}
