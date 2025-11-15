package com.k1ts.app.personal.graph_search;

import java.util.*;

public class SearchAlgorithmDFS {

    public List<Integer> dfs(List<List<Integer>> graph, int start, int end) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;

                // Если нашли цель — восстановим путь
                if (node == end) {
                    return buildPath(parent, start, end);
                }

                // Добавляем соседей в стек
                // (можно не разворачивать — порядок не важен)
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        parent[neighbor] = node;
                        stack.push(neighbor);
                    }
                }
            }
        }

        // Путь не найден
        return Collections.emptyList();
    }

    private List<Integer> buildPath(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1) {
            path.add(current);
            if (current == start) break;
            current = parent[current];
        }

        if (current == -1) {
            return List.of(); // путь не ведёт к start
        }

        Collections.reverse(path);
        return path;
    }
}

