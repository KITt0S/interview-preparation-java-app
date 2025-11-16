package com.k1ts.app.personal.graph_search;

import java.util.*;

public class SearchAlgorithmBFS {

    public List<Integer> bfs(List<List<Integer>> graph, int start, int end) {
        if (graph == null || graph.isEmpty()) return List.of();
        int n = graph.size();
        if (start < 0 || start >= n || end < 0 || end >= n) return List.of();

        if (start == end) return List.of(start);

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    if (neighbor == end) {
                        return buildPath(parent, start, end);
                    }
                    queue.add(neighbor);
                }
            }
        }

        return List.of(); // no path
    }

    private List<Integer> buildPath(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != -1) {
            path.add(cur);
            if (cur == start) break;
            cur = parent[cur];
        }
        if (cur == -1) return List.of(); // didn't reach start
        Collections.reverse(path);
        return path;
    }
}
